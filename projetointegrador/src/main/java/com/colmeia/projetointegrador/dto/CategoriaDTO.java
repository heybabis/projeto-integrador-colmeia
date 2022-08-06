package com.colmeia.projetointegrador.dto;

import java.io.Serializable;
import java.util.Objects;

import com.colmeia.projetointegrador.entity.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String tipoCategoria;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Long id, String tipoCategoria) {
		this.id = id;
		this.tipoCategoria = tipoCategoria;
	}

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.tipoCategoria = categoria.getTipoCategoria();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoCategoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipoCategoria, other.tipoCategoria);
	}

}
