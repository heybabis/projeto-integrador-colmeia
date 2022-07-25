package com.colmeia.projetointegrador.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank
	@Size(max = 20)
	private String alimento;

	@NotBlank
	@Size(max = 20)
	private String higiene;

	public Categoria() {

	}

	public Categoria(Long id, @NotBlank @Size(max = 20) String alimento, @NotBlank @Size(max = 20) String higiene) {
		Id = id;
		this.alimento = alimento;
		this.higiene = higiene;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(Id, alimento, higiene);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(alimento, other.alimento)
				&& Objects.equals(higiene, other.higiene);
	}

}
