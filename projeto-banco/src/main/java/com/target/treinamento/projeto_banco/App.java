package com.target.treinamento.projeto_banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App 
	{
    public static void main( String[] args )
    	{
    	try {
			
    		Class.forName("org.postgresql.Driver");
    		
    		Connection connection = DriverManager.getConnection("jdbc:postgresql://"
    															+ "ec2-23-21-128-35.compute-1.amazonaws.com:5432" //host
    															+ "/"
    															+ "d5k5g3oob6tn20", 
    															"kxwedtxgcfjgvt", //user
    															"218b0dd9927d70d198d3f587b28ad32c6dd9cd00ac1c5d33803b8bc982f819e2"); //banco

			System.out.println("Java Connection JDBC." + connection.toString());
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
	}
