package com.target.treinamento.projeto_banco.dao;

import java.util.Calendar;
import java.util.List;
import com.target.treinamento.projeto_banco.Funcionario;

public class Principal {

	public static void main(String[] args) {

		FuncionarioDAO f = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();
		
		/*
		List<Funcionario> func = f.buscarTodos();
		
		for (Funcionario busca : func) {
			System.out.println(	"Funcionario: "  +busca.getNome()+
								"      Cargo: "  +busca.getCargo()+ 
								"      Idade: "  +busca.getIdade()+
								"      Salario: "+busca.getSalario()+
								"      Data Inclusao: "+busca.getDataInclusao());
			
		}
		
		System.out.println();
		
		Funcionario buscaId = f.buscarPorId((long) 1);
		System.out.println(	"Funcionario: "  +buscaId.getNome()+
							"      Cargo: "  +buscaId.getCargo()+ 
							"      Idade: "  +buscaId.getIdade()+
							"      Salario: "+buscaId.getSalario()+
							"      Data Inclusao: "+buscaId.getDataInclusao());
	
	
		*/
		/*
		funcionario.setNome("Exemplo DAO");
		funcionario.setCargo(1);
		funcionario.setIdade(20);
		funcionario.setSalario(1000.0);
		funcionario.setId((long) 1);
		
		//f.criar(funcionario);
		f.atualizar(funcionario);
		*/
		
		funcionario.setId((long) 1);
		f.apagar(funcionario);	
	
	
	}
}
