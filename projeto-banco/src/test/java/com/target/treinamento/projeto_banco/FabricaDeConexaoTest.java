package com.target.treinamento.projeto_banco;

import static org.junit.Assert.assertNotNull;
import java.sql.ResultSet;
import org.junit.Test;

public class FabricaDeConexaoTest {

	@Test
	public void testaSeAConexaoFoiCriada() {
		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
		assertNotNull(fabricaDeConexao.getConexao());
		fabricaDeConexao.fecharConexao();
	}

	@Test
	public void testaSeStatementPassaComandoSQL() {
		
		//@InjectMocks private DBConnection dbConnection;
		//@Mock private Connection mockConnection;
		//@Mock private Statement mockStatement;

		FabricaDeConexao fabricaDeConexao = new FabricaDeConexao();
		ResultSet resultSet = null;

		fabricaDeConexao.getConexao();
		resultSet = fabricaDeConexao.getPreparedStatement("SELECT * FROM FUNCIONARIOS").executeQuery();

	}
}