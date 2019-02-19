package com.target.treinamento.projeto_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FabricaDeConexao {

	private Connection connection = null;
	
	public Connection getConexao() {
		
		try {
			Class.forName("org.postgresql.Driver");
			//criação da conecção com o banco de dados

			connection = DriverManager.getConnection("jdbc:postgresql://"
																+ "ec2-23-21-128-35.compute-1.amazonaws.com:5432" //host
																+ "/"
																+ "d5k5g3oob6tn20", 
																"kxwedtxgcfjgvt", //user
																"218b0dd9927d70d198d3f587b28ad32c6dd9cd00ac1c5d33803b8bc982f819e2"); //banco

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;		
	}
	
	public PreparedStatement getPreparedStatement(String sql) {
		try {
			return connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void fecharConexao() {
		try {
			if (connection != null){
				connection.close();
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
