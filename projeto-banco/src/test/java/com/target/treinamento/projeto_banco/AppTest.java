package com.target.treinamento.projeto_banco;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// TDD = TEST DRIVEN DEVELOPMENT

public class AppTest
{
	
	@Test
	public void testSomaDoisNumeros() {
		int valorA = 2;
		int valorB = 5;
		
		int soma = valorA + valorB;
		
		assertEquals( 7.0 , soma);
	}
	

	
	@Test
	public void testSomaDoisNumerosEIgualASete() {
		double valorA = 2;
		double valorB = 5;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(valorA, valorB);
		
		assertEquals( 7.0, soma);
	}
	

	@Test
	public void testSomaDoisNumerosEIgualADez() {
		double valorA = 5;
		double valorB = 5;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(valorA, valorB);
		
		assertEquals( 10.0 , soma);
	}

	@Test
	public void testSomaDoisNumerosComDoubles() {
		double valorA = 5.0;
		double valorB = 2.0;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(valorA, valorB);
		
		assertEquals( 7.0 , soma);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testSomaDoisNumerosComValoresInvalidos() {
		double valorB = 2.0;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(null, valorB);
		
		assertEquals( 7.0 , soma);
	}
	
}
    
