package com.colmeia.projetointegrador.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.colmeia.projetointegrador.entity.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeItem;
	private Integer quantidade;
	private String categoria;

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nomeItem = produto.getNomeItem();
		this.quantidade = produto.getQuantidade();
		this.categoria = produto.getCategoria();

	}

	public static List<ProdutoDTO> converterLista(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, id, nomeItem, quantidade);
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
		return Objects.equals(categoria, other.categoria) && Objects.equals(id, other.id)
				&& Objects.equals(nomeItem, other.nomeItem) && Objects.equals(quantidade, other.quantidade);
	}

}
