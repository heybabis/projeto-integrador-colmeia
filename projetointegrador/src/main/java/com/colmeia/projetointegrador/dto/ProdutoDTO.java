package com.colmeia.projetointegrador.dto;

import java.io.Serializable;
import java.util.Objects;

import com.colmeia.projetointegrador.entity.Categoria;
import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.entity.Usuario;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer qntd;
	private String foto;
	private Categoria tipoCategoria;
	private Usuario usuario;

	public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String nome, Integer qntd, String foto, Categoria tipoCategoria, Usuario usuario) {
		this.id = id;
		this.nome = nome;
		this.qntd = qntd;
		this.foto = foto;
		this.tipoCategoria = tipoCategoria;
		this.usuario = usuario;
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.qntd = produto.getQntd();
		this.foto = produto.getFoto();
		this.tipoCategoria = produto.getTipoCategoria();
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
		ProdutoDTO other = (ProdutoDTO) obj;
		return Objects.equals(foto, other.foto) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(qntd, other.qntd) && Objects.equals(tipoCategoria, other.tipoCategoria)
				&& Objects.equals(usuario, other.usuario);
	}

}
