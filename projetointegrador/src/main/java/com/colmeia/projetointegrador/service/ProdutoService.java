package com.colmeia.projetointegrador.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colmeia.projetointegrador.dto.ProdutoDTO;
import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.exception.ResourceNotFoundException;
import com.colmeia.projetointegrador.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Transactional(readOnly = true)
	public Page<ProdutoDTO> findAllPaged(PageRequest pageRequest) {
		Page<Produto> list = repository.findAll(pageRequest);// chamando a busca paginada do reporitory
		return list.map(x -> new ProdutoDTO(x));
	}

	@Transactional(readOnly = true)//apenas consultas
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException("Não encontrado!"));
		return new ProdutoDTO(entity);
	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		
		entity.setNomeItem(dto.getNomeItem());
		entity.setQuantidade(dto.getQuantidade());
		entity.setCategoria(dto.getCategoria());		
		entity = repository.save(entity);
		return new ProdutoDTO(entity);
	}

	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		Produto entity = repository.getOne(id);// para pegar apenas 1x do BD
		try {
			entity.setNomeItem(dto.getNomeItem());
			entity.setQuantidade(dto.getQuantidade());
			entity.setCategoria(dto.getCategoria());
			entity = repository.save(entity);
			return new ProdutoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + id);
		}

	}

// N PRECISA TER O TRANSACTIONAL SE N, N CONSEGUE CAPTURAR
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado! " + id);
		}

	}

}