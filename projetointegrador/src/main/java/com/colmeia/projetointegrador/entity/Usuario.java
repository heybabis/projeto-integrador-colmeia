package com.colmeia.projetointegrador.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Value;

@Entity

public abstract class Usuario {

	@NotBlank
	@Size(max = 50)
	private String nome;

	@NotBlank
	@Size(max = 80)
	@Email
	private String email;

	@NotBlank
	@CPF
	@Size(max = 11)
	private String cpf;

	public Object dto;

	//Na camada controller é preciso colocar a anotação valid
	


	public Usuario(@NotBlank @Size(max = 50) String nome, @NotBlank @Size(max = 80) @Email String email,
			@NotBlank @CPF @Size(max = 11) String cpf, @NotBlank @Size(max = 11) String telefone) {
		super();

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.telefone = telefone;
	}
/*
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
*/
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

}
