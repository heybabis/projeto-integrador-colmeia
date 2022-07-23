package com.colmeia.projetointegrador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_Funcionario")

public class Funcionario extends Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFuncionario")
	private Long idFuncionario;
	
	@OneToOne
	@Column(name="idCentroDistribuicao")
	private Long idCentroDistribuicao;
	 

		
	public Funcionario(Long idUsuario, String nome, String sobrenone, String nomeSocial, String email, @NotBlank @CPF @Size(max = 11) String cpf,
			String telefone) {
		super(idUsuario, nome, sobrenone, nomeSocial, email, cpf, telefone);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;



	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Long getIdCentroDistribuicao() {
		return idCentroDistribuicao;
	}

	public void setIdCentroDistribuicao(Long idCentroDistribuicao) {
		this.idCentroDistribuicao = idCentroDistribuicao;
	}
	
	
}
