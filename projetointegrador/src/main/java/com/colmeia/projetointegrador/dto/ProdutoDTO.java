package com.colmeia.projetointegrador.dto;

import java.io.Serializable;
import com.colmeia.projetointegrador.entity.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer qntd;

	public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String nome, Integer qntd) {
		this.id = id;
		this.nome = nome;
		this.qntd = qntd;
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.qntd = produto.getQntd();
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

}
