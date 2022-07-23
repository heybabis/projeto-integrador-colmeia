package com.colmeia.projetointegrador.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "tb_Usuarios")

public abstract class Usuario  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name="idUsuário")
	private Long idUsuario;
	
	@NotBlank
	@Size(max=20)
	@Column(name="nomeUsuário")
	private String nome;
	
	@NotBlank
	@Size(max=40)
	@Column(name="sobrenomeUsuário")
	private String sobrenome;
	
	
	@NotBlank
	@Size(max=35)	
	@Column(name="nomesocialUsuário")
	private String nomeSocial;
	
	@NotBlank
	@Size(max=80)
	@Email
	@Column(name="emailUsuario")
	private String email;

	@NotBlank
	@CPF
	@Size(max=11)
	@Column(name="CPFlUsuario")
	private String cpf;

	//Na camada controller é preciso colocar a anotação valid
	
	
	@NotBlank
	@Size(max=80)
	@Column(name="enderecolUsuario")
	private  List<Endereco>enderecos = new ArrayList<Endereco>();;

	@NotBlank
	@Size(max=11)
	@Value("telefone")
	private String telefone;
	
	public Usuario(Long idUsuario, String nome, String sobrenome, String nomeSocial, String email, @NotBlank @CPF @Size(max = 11) String cpf, String telefone) {	
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		
		}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
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

	public void setCpf(@NotBlank @CPF @Size(max = 11) String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return Objects.equals(email, other.email) && Objects.equals(idUsuario, other.idUsuario) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeSocial, other.nomeSocial) && Objects.equals(sobrenome, other.sobrenome)&&Objects.equals(cpf, other.cpf);
	}


}
