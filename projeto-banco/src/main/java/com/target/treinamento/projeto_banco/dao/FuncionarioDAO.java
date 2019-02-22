package com.target.treinamento.projeto_banco.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.target.treinamento.projeto_banco.FabricaDeConexao;
import com.target.treinamento.projeto_banco.Funcionario;
import com.target.treinamento.projeto_banco.LogManager;

public class FuncionarioDAO {
	
	public void criar(Funcionario funcionario) {

		FabricaDeConexao conexao = new FabricaDeConexao();
		
		try {
			conexao.setLogManager(new LogManager());
			conexao.abreConexao();
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO funcionarios");
			sb.append("(nome, cargo, idade, salario)");
			sb.append("VALUES (?, ?, ?, ?)");

			PreparedStatement ps = conexao.getPreparedStatement(sb.toString());
			ps.setString(1, funcionario.getNome());
			ps.setInt(2,    funcionario.getCargo());
			ps.setInt(3,    funcionario.getIdade());
			ps.setDouble(4, funcionario.getSalario());
			
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conexao.fecharConexao();
		}
	}

	public void apagar(Funcionario funcionario) {

		FabricaDeConexao conexao = new FabricaDeConexao();
		
		try {
			conexao.setLogManager(new LogManager());
			conexao.abreConexao();
			
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM funcionarios");
			sb.append("WHERE id = ?");
			
			PreparedStatement ps = conexao.getPreparedStatement(sb.toString());
			ps.setLong(1, funcionario.getId());
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conexao.fecharConexao();
		}
	}
	
	public void atualizar(Funcionario funcionario) {

		FabricaDeConexao conexao = new FabricaDeConexao();
		
		try {
			conexao.setLogManager(new LogManager());
			conexao.abreConexao();
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE FROM funcionarios");
			sb.append("SET nome   = ?,");
			sb.append("    cargo  = ?,");
			sb.append("    idade  = ?,");
			sb.append("    salario= ?");
			sb.append("WHERE id = ?");
			
			PreparedStatement ps = conexao.getPreparedStatement(sb.toString());
			ps.setLong(1,   funcionario.getId());
			ps.setString(2, funcionario.getNome());
			ps.setInt(3,    funcionario.getCargo());
			ps.setInt(4,    funcionario.getIdade());
			ps.setDouble(5, funcionario.getSalario());

			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conexao.fecharConexao();
		}
	}	
	
	public void buscarTodos() {
		FabricaDeConexao conexao = new FabricaDeConexao();
		List<Funcionario> funcionariosLista = new ArrayList<Funcionario>();// objeto Mutavel
		
		try {
			conexao.setLogManager(new LogManager());
			conexao.abreConexao(); // conecta com o banco de dados
			
			String sb = "SELECT id, nome, cargo, idade, salario FROM funcionarios";
			
			PreparedStatement ps = conexao.getPreparedStatement(sb.toString()); //Envia o sql para o banco de dados
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) 
			{
				Funcionario f = new Funcionario();
				f.setId(resultSet.getLong("id"));
				f.setNome(resultSet.getString("nome"));
				f.setCargo(resultSet.getInt("cargo"));
				f.setIdade(resultSet.getInt("idade"));
				f.setSalario(resultSet.getDouble("salario"));
				
				funcionariosLista.add(f);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			conexao.fecharConexao();
		}
		
	}
}