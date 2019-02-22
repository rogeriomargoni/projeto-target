package com.target.treinamento.projeto_banco;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

// TDD = TEST DRIVEN DEVELOPMENT

public class CalculadoraTest
{

	
// S O M A  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	@Test
	public void testSomaDoisNumeros() {
		int valorA = 2;
		int valorB = 5;
		
		int soma = valorA + valorB;
		
		assertEquals( 7.0 , soma, 0);
	}
	
	@Test
	public void testSomaDoisNumerosEIgualASete() {
		double valorA = 2;
		double valorB = 5;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(valorA, valorB);
		
		assertEquals( 7.0, soma, 0);
	}
	
	@Test
	public void testSomaDoisNumerosEIgualADez() {
		double valorA = 5;
		double valorB = 5;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(valorA, valorB);
		
		assertEquals( 10.0 , soma, 0);
	}

	@Test
	public void testSomaDoisNumerosComDoubles() {
		double valorA = 5.0;
		double valorB = 2.0;
		
		Calculadora calculadora = new Calculadora();
		double soma = calculadora.soma(valorA, valorB);
		
		assertEquals( 7.0 , soma, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSomaDoisNumerosComPrimeiroParametroInvalido() {
		double valorB = 2.0;
		
		Calculadora calculadora = new Calculadora();
		calculadora.soma(null, valorB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSomaDoisNumerosComSegundoParametroInvalido() {
		double valorA = 2.0;
		
		Calculadora calculadora = new Calculadora();
		calculadora.soma(valorA, null);
	}
	
	
// S U B T R A C A O ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testSubtracaoDoisNumerosEIgualAtres() {
		double valorA = 5;
		double valorB = 2;
		
		Calculadora calculadora = new Calculadora();
		double subtracao = calculadora.subtracao(valorA, valorB);
		
		assertEquals( 3.0, subtracao, 0);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testsubtracaoDoisNumerosComPrimeiroParametroInvalido() {
		double valorB = 2.0;
		
		Calculadora calculadora = new Calculadora();
		calculadora.subtracao(null, valorB);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testsubtracaoDoisNumerosComSegundoParametroInvalido() {
		double valorA = 5.0;
		
		Calculadora calculadora = new Calculadora();
		calculadora.subtracao(valorA, null);
	}

// D I V I S A O ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testdivisaoDoisNumerosEIgualAtres() {
	double valorA = 6;
	double valorB = 2;
	
	Calculadora calculadora = new Calculadora();
	double divisao = calculadora.divisao(valorA, valorB);
	assertEquals( 3.0, divisao, 0);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testdivisaoDoisNumerosComPrimeiroParametroInvalido() {
	double valorB = 2.0;
	
	Calculadora calculadora = new Calculadora();
	calculadora.divisao(null, valorB);
	}

	
	
	@Test(expected = IllegalArgumentException.class)
	public void testdivisaoDoisNumerosComSegundoParametroInvalido() {
	double valorA = 5.0;
	
	Calculadora calculadora = new Calculadora();
	calculadora.divisao(valorA, null);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testdivisaoDoisNumerosComPrimeiroNumeroIgualAZero() {
	double valorA = 0.0;
	double valorB = 2.0;
	
	Calculadora calculadora = new Calculadora();
	calculadora.divisao(valorA, valorB);
	}


// M U L T I P L I C A C A O ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testmultiplicaDoisNumerosEIgualADoze() {
	double valorA = 6;
	double valorB = 2;
	
	Calculadora calculadora = new Calculadora();
	double multiplica = calculadora.multiplica(valorA, valorB);
	assertEquals( 12.0, multiplica, 0);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testmultiplicaDoisNumerosComPrimeiroParametroInvalido() {
	double valorB = 2.0;
	
	Calculadora calculadora = new Calculadora();
	calculadora.multiplica(null, valorB);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testmultiplicaDoisNumerosComSegundoParametroInvalido() {
	double valorA = 6.0;
	
	Calculadora calculadora = new Calculadora();
	calculadora.multiplica(valorA, null);
	}
}
    
