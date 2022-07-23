package com.colmeia.projetointegrador.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_Doador")

public class Doador extends Usuario {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnoreProperties("itensdoacao")
	@Column(name="idDoador")
	private Long idDoador;
	
	@NotBlank
	@Size(max=20)
	@Column(name="nomeDoador")
	private String nome;
	
	
		
	public Doador(Long idDoador, String nome, String sobrenone, String nomeSocial, String email, @NotBlank @CPF @Size(max = 11) String cpf, String telefone) {
		super(idDoador, nome, sobrenone, nomeSocial, email, cpf, telefone);
	
	}



	public Long getIdDoador() {
		return idDoador;
	}



	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
