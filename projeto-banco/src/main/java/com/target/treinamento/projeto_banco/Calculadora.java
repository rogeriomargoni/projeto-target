package com.target.treinamento.projeto_banco;

public class Calculadora {
	
	public double soma(Double valorA, Double valorB) {
		if (valorA == null || valorB == null) {
			throw new IllegalArgumentException("Operação não permitida");
		}		
		
		return valorA + valorB;
	}	
	
	
	public double subtracao(Double valorA, Double valorB) {
		if (valorA == null || valorB == null) {
			throw new IllegalArgumentException("Operação não permitida");
		}		
		
		return valorA - valorB;
	}
	
	
	public double divisao(Double valorA, Double valorB) {
		if (valorA == null || valorA == 0.0  || valorB == null) {
			throw new IllegalArgumentException("Operação não permitida");
		}		
		
		return valorA / valorB;
	}	

	
	public double multiplica(Double valorA, Double valorB) {
		if (valorA == null || valorB == null) {
			throw new IllegalArgumentException("Operação não permitida");
		}		
		
		return valorA * valorB;
	}	
}
