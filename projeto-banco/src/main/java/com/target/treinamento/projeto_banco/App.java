package com.target.treinamento.projeto_banco;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
    	FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
    	fabricaDeConexao.getConexao();
    	
        try 
        {
        	
        	//trocar a tabela e campos neste insert por tabela funcionarios        	
        	
        	/*String sql = "insert into pessoas(PRIMEIRO_NOME,SEGUNDO_NOME, ENDERECO, CIDADE) "
					+ "VALUES (?, ?, ?, ?)";
        					// 1, 2, 3, 3

        	PreparedStatement statement = fabricaDeConexao.getPreparedStatement(sql);
			statement.setString(1, "Pedrinho");
			statement.setString(2, "Gerente");
			statement.setString(3, "20");
			statement.setString(4, "Lajeado");
			int retorno = statement.executeUpdate();
			
			if(retorno == 1) {
				System.out.println("Sucesso!");
			} else {
				System.out.println("Erro ao gravar dados!");
			}
			*/
			
        	
        	
        	ResultSet resultSet = fabricaDeConexao.getPreparedStatement("SELECT p.id, p.nome, p.cargo, p.idade, p.salario FROM funcionarios p").executeQuery();
			
			while(resultSet.next()) 
			{
				String nome    = resultSet.getString("nome");
				String cargo   = resultSet.getString("cargo");
				String idade   = resultSet.getString("idade");
				String salario = resultSet.getString("salario");
				Long id        = resultSet.getLong("id");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        //Bloco que sempre será executado, independente de exception ou não.
        finally 
        {
        	fabricaDeConexao.fecharConexao();
		}
        		
    }
}