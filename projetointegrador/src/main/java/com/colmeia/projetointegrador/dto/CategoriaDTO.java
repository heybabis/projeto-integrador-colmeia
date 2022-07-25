package com.colmeia.projetointegrador.dto;

import java.io.Serializable;

import com.colmeia.projetointegrador.entity.Categoria;

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String alimento;
	private String higiene;

	public CategoriaDTO() {

	}

	public CategoriaDTO(Long id, String alimento, String higiene) {
		this.id = id;
		this.alimento = alimento;
		this.higiene = higiene;
	}

	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.alimento = categoria.getAlimento();
		this.higiene = categoria.getHigiene();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlimento() {
		return alimento;
	}

	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}

	public String getHigiene() {
		return higiene;
	}

	public void setHigiene(String higiene) {
		this.higiene = higiene;
	}

}
