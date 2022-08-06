package com.colmeia.projetointegrador.service;

import java.util.List;
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
	private ProdutoRepository produtoRepository;

	/*@Transactional(readOnly = true)
	public Page<ProdutoDTO> findAllPaged(PageRequest pageRequest) {
		Page<Produto> list = repository.findAll(pageRequest);// chamando a busca paginada do reporitory
		return list.map(x -> new ProdutoDTO(x));
	}

	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		Produto entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada! "));
		return new ProdutoDTO(entity);
	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		entity.setQntd(dto.getQntd());
		entity.setFoto(dto.getFoto());
		entity.setTipoCategoria(dto.getTipoCategoria());
		entity = repository.save(entity);
		return new ProdutoDTO(entity);
	}

	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		Produto entity = repository.getOne(id);// para pegar apenas 1x do BD
		try {
			entity.setNome(dto.getNome());
			entity.setQntd(dto.getQntd());
			entity.setFoto(dto.getFoto());
			entity.setTipoCategoria(dto.getTipoCategoria());
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

	}*/
	public List<Produto> getAll() {

		return produtoRepository.findAll();

	}

	public Optional<Produto> getById(Long id) {

		return produtoRepository.findById(id);

	}

	public Produto post(Produto produto) {

		return produtoRepository.save(produto);

	}

	public Optional<Produto> put(Produto produto) {

		if (produtoRepository.existsById(produto.getId()))
			return Optional.ofNullable(produtoRepository.save(produto));
		
		return Optional.empty();
		

	}

	public void delete(Long id) {

		if (produtoRepository.existsById(id))
			produtoRepository.deleteById(id);

	}


}