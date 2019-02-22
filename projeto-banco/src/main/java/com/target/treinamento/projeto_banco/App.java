package com.target.treinamento.projeto_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Connection connection = null;

		try {

			Class.forName("org.postgresql.Driver");

			// Criação da conexão com o banco de dados
			connection = DriverManager.getConnection(
					"jdbc:postgresql://ec2-23-21-128-35.compute-1.amazonaws.com:5432/d5k5g3oob6tn20", "kxwedtxgcfjgvt",
					"218b0dd9927d70d198d3f587b28ad32c6dd9cd00ac1c5d33803b8bc982f819e2");

			System.out.println("Java connection JDBC." + connection.toString());

			String sql = "insert into pessoas (primeiro_nome, segundo_nome, endereco, cidade) values (?, ?, ? , ?)";

			// Statement statement = connection.createStatement();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "Java");
			statement.setString(2, "Developer");
			statement.setString(3, "Av Java 88");
			statement.setString(4, "Javaland");
			int retorno = statement.executeUpdate();

			// ResultSet resultSet = statement.executeQuery("select * from pessoas");

			if (retorno == 1) {
				System.out.println("sucesso");
			} else {
				System.out.println("erro ao gravar dados");
			}

			Statement statement2 = connection.createStatement();

			ResultSet resultSet = statement2.executeQuery("select p.id, p.primeiro_nome, p.segundo_nome, p.endereco, p.cidade from pessoas p");
			while (resultSet.next()) {

				String primeiroNome = resultSet.getString("primeiro_nome");
				String segundoNome = resultSet.getString("segundo_nome");
				String endereco = resultSet.getString("endereco");
				String cidade = resultSet.getString("cidade");
				Long id = resultSet.getLong("id");

				System.out.print(primeiroNome + " ");
				System.out.print(segundoNome + " ");
				System.out.print(endereco + " ");
				System.out.print(cidade + " ");
				System.out.println(id + " ");
				System.out.println("###########################################");

			}

			statement2.close();
			// connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("fechando conexão");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}
	}
}