package com.colmeia.projetointegrador.repository;

//o dia é lindo!!
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.colmeia.projetointegrador.entity.EstoqueDeProdutos;

@Repository
public interface EstoqueDeProdutosRepository extends JpaRepository<EstoqueDeProdutos, Long>{

	
		public List<EstoqueDeProdutosRepository>findBynome(String nomeItem, org.springframework.data.domain.Pageable pageable); 
		
		
}
