package com.colmeia.projetointegrador.dto;

import java.io.Serializable;

import com.colmeia.projetointegrador.entity.Doador;
import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.entity.Usuario;

public class DoadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDoador;

	
	public DoadorDTO(Long idDoador) {
		super();
		this.idDoador = idDoador;
	}

	//public DoadorDTO(Doador doador) {
		//this.idDoador = doador.getIdDoador();
		
	//}

		
	public DoadorDTO(Usuario x) {
		// TODO Auto-generated constructor stub
	}

	public Long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}
	
	
	
}
