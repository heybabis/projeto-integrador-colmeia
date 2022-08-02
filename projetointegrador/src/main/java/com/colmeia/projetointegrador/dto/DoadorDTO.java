package com.colmeia.projetointegrador.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.colmeia.projetointegrador.entity.Doador;
import com.colmeia.projetointegrador.entity.Usuario;

public class DoadorDTO extends UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDoador;


	public DoadorDTO(@NotBlank @Size(max = 50) String nome, @NotBlank @Size(max = 80) @Email String email,
			@NotBlank @CPF @Size(max = 11) String cpf, @NotBlank @Size(max = 11) String telefone, Long idDoador) {
		super(nome, email, cpf, telefone);
		this.idDoador = idDoador;
	}

	public DoadorDTO(Doador entity) {
		this.idDoador = entity.getIdDoador();
		
			}
	
	public DoadorDTO(DoadorDTO entity) {
		// TODO Auto-generated constructor stub
	}

	public Long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return getNome();
	}



}