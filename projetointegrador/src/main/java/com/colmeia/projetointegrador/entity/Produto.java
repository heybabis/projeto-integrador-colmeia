package com.colmeia.projetointegrador.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@NotBlank
	@Size(max = 35)
	@Column(name = "nome_item")
	private String nomeItem;

	@NotBlank
	private Integer quantidade;

	@NotBlank
	@Size(max = 20)
	@Column(name = "nome_categoria")
	private String categoria;
	
	public Produto() {
		
	}
	
	public Produto(Long id, @NotBlank @Size(max = 35) String nomeItem, @NotBlank Integer quantidade,
			@NotBlank @Size(max = 20) String categoria) {
		this.id = id;
		this.nomeItem = nomeItem;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}

	public Long getId() {
		return  id;
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
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(id, other.id)
				&& Objects.equals(nomeItem, other.nomeItem) && Objects.equals(quantidade, other.quantidade);
	}

}
