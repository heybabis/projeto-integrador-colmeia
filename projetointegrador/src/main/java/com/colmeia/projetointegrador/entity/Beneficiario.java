package com.colmeia.projetointegrador.entity;

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
@Table(name = "tb_beneficiario")

public class Beneficiario extends Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_beneficiario")
	private Long idBeneficiario;

	public Beneficiario(@NotBlank @Size(max = 50) String nome, @NotBlank @Size(max = 80) @Email String email,
			@NotBlank @CPF @Size(max = 11) String cpf, @NotBlank @Size(max = 11) String telefone, Long idBeneficiario) {
		super(nome, email, cpf, telefone);
		this.idBeneficiario = idBeneficiario;
	}

	public Long getIdBeneficiario() {
		return idBeneficiario;
	}

	public void setIdBeneficiario(Long idBeneficiario) {
		this.idBeneficiario = idBeneficiario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idBeneficiario);
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
		Beneficiario other = (Beneficiario) obj;
		return Objects.equals(idBeneficiario, other.idBeneficiario);
	}

}
