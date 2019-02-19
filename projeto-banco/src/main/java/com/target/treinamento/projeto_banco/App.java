package com.target.treinamento.projeto_banco;

import java.sql.Connection;
import java.sql.DriverManager;
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
			boolean deuCerto = statement.execute("update pessoas set primeiro_nome = 'Rogerio fazendo Update' where id = 2");

			System.out.println(" ");

			if (deuCerto) {
				System.out.println("Funcionou");
			} else {
				System.out.println("Não foi");
			}

			//passa o comando SQL
			boolean fezInsert = statement.execute("insert into pessoas (primeiro_nome, segundo_nome, endereco, cidade) values ('Oiregor', 'Oiregor', 'Protasio Alves', 'Porto Alegre')");

			System.out.println(" ");

			if (fezInsert) {
				System.out.println("Funcionou o Insert");
			} else {
				System.out.println("Não foi o Insert");
			}
			

			
			System.out.println(" ");

			
			while (resultSet.next()) {
				String primeiro_nome = resultSet.getString("primeiro_nome");
				String segundo_nome = resultSet.getString("segundo_nome");
				String endereco = resultSet.getString("endereco");
				String cidade = resultSet.getString("cidade");
				Long id = resultSet.getLong("id");

				System.out.println(id + ", "+primeiro_nome+" , "+ segundo_nome+" , "+ endereco+" , "+ cidade);
			}

			statement.close();
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
