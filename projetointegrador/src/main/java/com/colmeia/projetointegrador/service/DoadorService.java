package com.colmeia.projetointegrador.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colmeia.projetointegrador.dto.DoadorDTO;
import com.colmeia.projetointegrador.entity.Doador;
import com.colmeia.projetointegrador.exception.ResourceNotFoundException;
import com.colmeia.projetointegrador.repository.DoadorRepository;

@Service
public class DoadorService {

	@Autowired
	DoadorRepository repository;

	@Transactional(readOnly = true)
	public Page<DoadorDTO> findAllPaged(PageRequest pageRequest) {
		Page<DoadorDTO> list = repository.findAll(pageRequest);// chamando a busca paginada do reporitory
		return list.map(x -> new DoadorDTO(x));
	}

	@Transactional(readOnly = true)
	public DoadorDTO findById(Long idDoador) {
		Optional<Doador> obj = Optional.empty();
		Doador entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada! "));
		return new DoadorDTO(entity);
	}

	@Transactional
	public DoadorDTO insert(DoadorDTO dto) {
		Doador entity = new Doador(null, null, null, null, null);
		entity.setIdDoador(dto.getIdDoador());
		return new DoadorDTO(entity);
	}

	@Transactional
	public DoadorDTO update(Long idDoador, DoadorDTO dto) {
		DoadorDTO entity = repository.getOne(idDoador);// para pegar apenas 1x do BD
		try {
			entity.setIdDoador(dto.getIdDoador());
			entity = repository.save(entity);
			return new DoadorDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + idDoador);
		}
	}

	// N PRECISA TER O TRANSACTIONAL SE N, N CONSEGUE CAPTURAR
	public void delete(Long idDoador) {
		try {
			repository.deleteById(idDoador);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + idDoador);
		}

	}

}