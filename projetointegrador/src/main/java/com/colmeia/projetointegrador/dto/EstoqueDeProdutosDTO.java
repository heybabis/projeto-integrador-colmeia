package com.colmeia.projetointegrador.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.colmeia.projetointegrador.entity.EstoqueDeProdutosEntity;
import com.colmeia.projetointegrador.entity.Produto;


//o dia é lindo!!
public class EstoqueDeProdutosDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Map<String, List<Produto>> estoque;
	private Produto p;
	private Map<String, List<Produto>> copiaDoEstoque;

	public EstoqueDeProdutosDTO(EstoqueDeProdutosEntity estoqueProdutos) {
		this.id= estoqueProdutos.getId();
		this.estoque = estoqueProdutos.getEstoque();
		this.p = estoqueProdutos.getP();
		this.copiaDoEstoque = estoqueProdutos.getCopiaDoEstoque();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, List<Produto>> getEstoque() {
		return estoque;
	}

	public void setEstoque(Map<String, List<Produto>> estoque) {
		this.estoque = estoque;
	}

	public Produto getP() {
		return p;
	}

	public void setP(Produto p) {
		this.p = p;
	}

	public Map<String, List<Produto>> getCopiaDoEstoque() {
		return copiaDoEstoque;
	}

	public void setCopiaDoEstoque(Map<String, List<Produto>> copiaDoEstoque) {
		this.copiaDoEstoque = copiaDoEstoque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(copiaDoEstoque, estoque, id, p);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstoqueDeProdutosDTO other = (EstoqueDeProdutosDTO) obj;
		return Objects.equals(copiaDoEstoque, other.copiaDoEstoque) && Objects.equals(estoque, other.estoque)
				&& Objects.equals(id, other.id) && Objects.equals(p, other.p);
	}

	
	
	
	
	
	
}
