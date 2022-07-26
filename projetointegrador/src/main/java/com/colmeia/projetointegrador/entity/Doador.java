package com.colmeia.projetointegrador.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_doador")

public class Doador extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_doador")
	private Long idDoador;

	public Doador(@NotBlank @Size(max = 50) String nome, @NotBlank @Size(max = 80) @Email String email,
			@NotBlank @CPF @Size(max = 11) String cpf, @NotBlank @Size(max = 11) String telefone, Long idDoador) {
		super(nome, email, cpf, telefone);
		this.idDoador = idDoador;
	}

	public Long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idDoador);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doador other = (Doador) obj;
		return Objects.equals(idDoador, other.idDoador);
	}

}
