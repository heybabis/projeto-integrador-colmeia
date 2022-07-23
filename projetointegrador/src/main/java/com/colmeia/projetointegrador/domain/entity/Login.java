package com.colmeia.projetointegrador.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import org.springframework.security.core.GrantedAuthority;

import com.colmeia.projetointegrador.entity.Usuario;

import com.colmeia.projetointegrador.domain.entity.Login;

import com.colmeia.projetointegrador.domain.entity.Permission;

@Entity
@Table(name = "Login")

public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLogin")
	private Long idLogin;

	@Column(name = "idUsuario")
	private Long idUsuario;

	//Fiquei com dúvida, se é assim//
	
	@Column(name = "login(CPF)")
	private Usuario cpf;
	
	@Column(name= "senha")
	private String senha;

	// Aqui não sei como colocar alguma regra...não sei se é aqui o local correto.
	
	@Column(name="Data Cadastro")
	private Date dataCadastro;
	
	public Login() {
		}
	public Login(Long idLogin, Long idUsuario, Usuario cpf, String senha, Date dataCadastro) {
		super();
		this.idLogin = idLogin;
		this.idUsuario = idUsuario;
		this.cpf = cpf;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
	}
	
	public String getSenha() {
		return this.senha;
	}

	public Usuario getCPF() {
		return this.cpf;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_permission", 
	joinColumns = { @JoinColumn(name = "id_user") }
	, inverseJoinColumns = {	@JoinColumn(name = "id_permission") })
	private List<Permission> permissions;

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (Permission permission : this.permissions) {
			roles.add(permission.getDescription());
		}
		return roles;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, senha, permissions, cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return  Objects.equals(idUsuario, other.idUsuario) && Objects.equals(senha, other.senha)
				&& Objects.equals(permissions, other.permissions) && Objects.equals(cpf, other.cpf);
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public Usuario setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return null;
	}
	public Usuario getCpf() {
		return cpf;
	}
	public void setCpf(Usuario cpf) {
		this.cpf = cpf;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}



	
	
	
	
	//@Override
	//public Collection<? extends GrantedAuthority> getAuthorities() {
		//return this.permissions;
	//}
	
	
	
	
	
	
	
	
}
