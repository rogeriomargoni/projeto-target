package com.target.treinamento.projeto_banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Exercicio {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		List<Funcionario> lista = new ArrayList<Funcionario>();
		Funcionario funcMenorIdadeMaiorSalario = new Funcionario();
		Funcionario funcMenorSalarioMaiorIdade = new Funcionario();
		Integer menorIdade = null;
		Integer maiorIdade = null;
		Double menorSalario = null;
		Double maiorSalario = null;

		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();

		fabricaDeConexao.getConexao();

		ResultSet resultSet = null;
		try {
			resultSet = fabricaDeConexao
					.getPreparedStatement(
							"SELECT F.ID, F.NOME, " + "F.CARGO, F.IDADE, F.SALARIO " + "FROM FUNCIONARIOS F")
					.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (resultSet.next()) {
			String nome = resultSet.getString("NOME");
			String cargo = resultSet.getString("CARGO");
			Integer idade = resultSet.getInt("IDADE");
			Double salario = resultSet.getDouble("SALARIO");
			Long id = resultSet.getLong("ID");

			lista.add(new Funcionario(nome, cargo, idade, salario, id));
			/*
			System.out.println(id);
			System.out.println(nome);
			System.out.println(cargo);
			System.out.println(idade);
			System.out.println(salario);
			System.out.println("####################################");
			*/
		}

		fabricaDeConexao.fecharConexao();

		menorIdade = lista.get(0).getIdade();
		maiorIdade = lista.get(0).getIdade();
		menorSalario = lista.get(0).getSalario();
		maiorSalario = lista.get(0).getSalario();

		for (Funcionario funcionario : lista) {
			//System.out.println(funcionario);
			if (funcionario.getIdade() <= menorIdade) {
				funcMenorIdadeMaiorSalario = funcionario;
				menorIdade = funcionario.getIdade();
				if (funcionario.getSalario() > maiorSalario) {
					funcMenorIdadeMaiorSalario = funcionario;
					menorIdade = funcionario.getIdade();
				}
			}

			if (funcionario.getIdade() > maiorIdade) {
				funcMenorSalarioMaiorIdade = funcionario;
				maiorIdade=funcionario.getIdade();
				if( funcionario.getSalario() < menorSalario ) {
					funcMenorSalarioMaiorIdade = funcionario;
					maiorIdade=funcionario.getIdade();
				}
			}

		}

		System.out.println("Menor Idade e Maior Salario " + funcMenorIdadeMaiorSalario);
		System.out.println("Maior Idade e Menor Salario  " + funcMenorSalarioMaiorIdade);

	}

}
