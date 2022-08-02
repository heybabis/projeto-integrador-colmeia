package com.colmeia.projetointegrador.entity;

//o dia é lindo!!
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produtos")

public class EstoqueDeProdutos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "estoque")
	public static List<Produto> estoque = (@NotBlank List<Produto>) new Produto();;

	@NotBlank
	@Column(name = "produto")
	private static Produto p;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static List<Produto> getEstoque() {
		return estoque;
	}

	public static void setEstoque(List<Produto> estoque) {
		EstoqueDeProdutos.estoque = estoque;
	}

	public static Produto getP() {
		return p;
	}

	public static void setP(Produto p) {
		EstoqueDeProdutos.p = p;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstoqueDeProdutos other = (EstoqueDeProdutos) obj;
		return Objects.equals(id, other.id);
	}

}
