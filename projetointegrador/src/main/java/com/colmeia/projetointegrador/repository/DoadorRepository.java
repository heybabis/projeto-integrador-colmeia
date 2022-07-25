package com.colmeia.projetointegrador.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.colmeia.projetointegrador.entity.Usuario;

public interface DoadorRepository extends JpaRepository<Usuario, Long> {

	//Page<Usuario> findByNome(String nome, org.springframework.data.domain.Pageable pageable);
}
