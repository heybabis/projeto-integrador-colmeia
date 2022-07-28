package com.colmeia.projetointegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colmeia.projetointegrador.entity.Doador;


@Repository
	public interface DoadorRepository extends JpaRepository<Doador, Long> {

		

	}
