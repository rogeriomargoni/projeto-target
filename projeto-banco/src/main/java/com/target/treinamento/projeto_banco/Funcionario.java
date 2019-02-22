package com.target.treinamento.projeto_banco;

public class Funcionario {
	public Long    id;
	public String  nome;
	public Integer cargo;
	public Integer idade;
	public Double  salario; 

	public Funcionario() {

	}

	
	public Funcionario(String nome, Integer cargo, Integer idade, Double salario, Long id) {
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


	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", idade=" + idade + ", salario=" + salario + ", id="
				+ id + "]";
	}
}