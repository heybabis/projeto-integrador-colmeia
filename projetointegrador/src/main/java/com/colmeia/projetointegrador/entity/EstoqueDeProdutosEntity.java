package com.colmeia.projetointegrador.entity;

//o dia é lindo!!
import java.io.Serializable;
import java.util.LinkedHashMap;
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

public class EstoqueDeProdutosEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "estoque")
	public static Map<String, List<Produto>> estoque = new LinkedHashMap<String, List<Produto>>();;

	@NotBlank
	@Column(name = "produto")
	private static Produto p;

	@NotBlank
	@Column(name = "copia_do_estoque")
	private static Map<String, List<Produto>> copiaDoEstoque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static Map<String, List<Produto>> getEstoque() {
		return estoque;
	}

	public static void setEstoque(Map<String, List<Produto>> estoque) {
		EstoqueDeProdutosEntity.estoque = estoque;
	}

	public static Produto getP() {
		return p;
	}

	public static void setP(Produto p) {
		EstoqueDeProdutosEntity.p = p;
	}

	public static Map<String, List<Produto>> getCopiaDoEstoque() {
		return copiaDoEstoque;
	}

	public static void setCopiaDoEstoque(Map<String, List<Produto>> copiaDoEstoque) {
		EstoqueDeProdutosEntity.copiaDoEstoque = copiaDoEstoque;
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
		EstoqueDeProdutosEntity other = (EstoqueDeProdutosEntity) obj;
		return Objects.equals(id, other.id);
	}

}
