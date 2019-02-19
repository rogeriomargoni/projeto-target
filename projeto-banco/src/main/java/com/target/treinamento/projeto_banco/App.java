package com.target.treinamento.projeto_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
	{
    public static void main( String[] args )
    	{
    	try {
			
    		Class.forName("org.postgresql.Driver");
    		
    		//criação da conecção com o banco de dados
    		Connection connection = DriverManager.getConnection("jdbc:postgresql://"
    															+ "ec2-23-21-128-35.compute-1.amazonaws.com:5432" //host
    															+ "/"
    															+ "d5k5g3oob6tn20", 
    															"kxwedtxgcfjgvt", //user
    															"218b0dd9927d70d198d3f587b28ad32c6dd9cd00ac1c5d33803b8bc982f819e2"); //banco

			System.out.println("Java Connection JDBC." + connection.toString());
			
			//obtenho o statement para manipular a DML
			Statement statement = connection.createStatement();
			
			//passa o comando SQL
			ResultSet resultSet = statement.executeQuery("select id, primeiro_nome, segundo_nome, endereco, cidade from pessoas order by id");
			
			while (resultSet.next()) {
				String primeiro_nome = resultSet.getString("primeiro_nome");
				String segundo_nome = resultSet.getString("segundo_nome");
				String endereco = resultSet.getString("endereco");
				String cidade = resultSet.getString("cidade");
				Long id = resultSet.getLong("id");

				System.out.println(id + ", "+primeiro_nome+" , "+ segundo_nome+" , "+ endereco+" , "+ cidade);
			}

			
			//passa o comando SQL
			boolean deuCerto = statement.execute("update pessoas set primeiro_nome = 'Rogerio Update' where id = 2");

			//passa o comando SQL
			//boolean fezInsert = statement.execute("insert into pessoas (primeiro_nome, segundo_nome, endereco, cidade) values ('Oiregor', 'Oiregor', 'Protasio Alves', 'Porto Alegre')");


			// PreparedStatement
			String sql = "insert into pessoas (primeiro_nome, segundo_nome, endereco, cidade) values (? , ? , ?, ?)";
			PreparedStatement statement1 = connection.prepareStatement(sql);
			statement1.setString(1, "Pedrinho");
			statement1.setString(2, "Alfredo");
			statement1.setString(3, "Rua Bendo Rosa");
			statement1.setString(4, "Lajeado");
			
			int retorno = statement1.executeUpdate();

			System.out.println(" ");			
			
			if (retorno == 1 ) {
				System.out.println("Sucesso!");
			} else {
				System.out.println("Erro ao gravar dados!");
			}			
			
			System.out.println(" ");
			
			ResultSet resultSet2 = statement.executeQuery("select id, primeiro_nome, segundo_nome, endereco, cidade from pessoas order by id");
			
			while (resultSet2.next()) {
				String primeiro_nome = resultSet2.getString("primeiro_nome");
				String segundo_nome = resultSet2.getString("segundo_nome");
				String endereco = resultSet2.getString("endereco");
				String cidade = resultSet2.getString("cidade");
				Long id = resultSet2.getLong("id");

				System.out.println(id + ", "+primeiro_nome+" , "+ segundo_nome+" , "+ endereco+" , "+ cidade);
			}

			statement.close();
			statement1.close();
			connection.close();
			
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
	}
