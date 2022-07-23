package com.colmeia.projetointegrador.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Beneficiario extends Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idBeneficiario")
	private Long idBeneficiario;
	
	private static final long serialVersionUID = 1L;
	
	public boolean restricaoAlimentar;
	
	public boolean necessidadeEspacialHigiene;
	
	public int qteDependentes;
	
	//Agenda de retirada de produtos.
	
	
	public Beneficiario(Long idUsuario, String nome, String sobrenone, String nomeSocial, String email, String cpf,
			String telefone) {
		super(idUsuario, nome, sobrenone, nomeSocial, email, cpf, telefone);
		// TODO Auto-generated constructor stub
	}

	
}
