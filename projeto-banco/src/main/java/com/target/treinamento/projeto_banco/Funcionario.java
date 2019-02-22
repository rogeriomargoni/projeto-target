package com.target.treinamento.projeto_banco;

public class Funcionario {
//POJO tabela Funcionarios
	public String nome;
	public String cargo;
	public Integer idade;
	public Double salario; 
	public Long id;
	
	
	
	
	public Funcionario() {
		
	}


	public Funcionario(String nome, String cargo, Integer idade, Double salario, Long id) {
		this.nome = nome;
		this.cargo = cargo;
		this.idade = idade;
		this.salario = salario;
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public Double getSalario() {
		return salario;
	}


	public void setSalario(Double salario) {
		this.salario = salario;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", idade=" + idade + ", salario=" + salario + ", id="
				+ id + "]";
	}
	
	
	
	
	
}