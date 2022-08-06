package com.colmeia.projetointegrador.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuarios")
public  class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo Nome é Obrigatório!")
	private String nome;

	@NotNull(message = "O atributo Usuário é Obrigatório!")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;

	@NotBlank(message = "O atributo Senha é Obrigatório!")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;

	@NotBlank
	@CPF
	private String CPF;

	@Column(name = "tipo_usuario")
	private String tipoUsuario;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;

	
	
	public Usuario(Long id, @NotNull(message = "O atributo Nome é Obrigatório!") String nome,
			@NotNull(message = "O atributo Usuário é Obrigatório!") @Email(message = "O atributo Usuário deve ser um email válido!") String usuario,
			@NotBlank(message = "O atributo Senha é Obrigatório!") @Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres") String senha,
			@NotBlank @org.hibernate.validator.constraints.br.CPF String cPF, String tipoUsuario,
			List<Produto> produto) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		CPF = cPF;
		this.tipoUsuario = tipoUsuario;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;

	}

	public List<Produto> getProduto() {
		return this.produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

}
