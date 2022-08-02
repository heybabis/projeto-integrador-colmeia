package com.colmeia.projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colmeia.projetointegrador.dto.EstoqueDeProdutosDTO;

@Repository
public interface EstoqueDeProdutosRepository extends JpaRepository<EstoqueDeProdutosDTO, Long>{

	
				
		
}
