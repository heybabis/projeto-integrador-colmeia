package com.colmeia.projetointegrador.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome do produto não pode ser vazio")
	@Size(max = 60)
	private String nome;

	@NotBlank
	private Integer qntd;

	private String foto;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria tipoCategoria;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	public Produto() {

	}

	public Produto(Long id, @NotBlank(message = "O nome do produto não pode ser vazio") @Size(max = 60) String nome,
			@NotBlank Integer qntd, String foto, Categoria tipoCategoria, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.qntd = qntd;
		this.foto = foto;
		this.tipoCategoria = tipoCategoria;
		this.usuario = usuario;
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

	public Integer getQntd() {
		return qntd;
	}

	public void setQntd(Integer qntd) {
		this.qntd = qntd;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(Categoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foto, id, nome, qntd, tipoCategoria, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(foto, other.foto) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(qntd, other.qntd) && Objects.equals(tipoCategoria, other.tipoCategoria)
				&& Objects.equals(usuario, other.usuario);
	}

}
