package com.colmeia.projetointegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colmeia.projetointegrador.entity.Categoria;
import com.colmeia.projetointegrador.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	/*@Transactional(readOnly = true)
	public Page<CategoriaDTO> findAllPaged(PageRequest pageRequest) {
		Page<Categoria> list = repository.findAll(pageRequest);// chamando a busca paginada do reporitory
		return list.map(x -> new CategoriaDTO(x));
	}

	@Transactional(readOnly = true)
	public CategoriaDTO findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		Categoria entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada! "));
		return new CategoriaDTO(entity);
	}

	@Transactional
	public CategoriaDTO insert(CategoriaDTO dto) {
		Categoria entity = new Categoria();
		entity.setTipoCategoria(dto.getTipoCategoria());
		entity = repository.save(entity);
		return new CategoriaDTO(entity);
	}

	@Transactional
	public CategoriaDTO update(Long id, CategoriaDTO dto) {
		Categoria entity = repository.getOne(id);// para pegar apenas 1x do BD
		try {
			entity.setTipoCategoria(dto.getTipoCategoria());
			entity = repository.save(entity);
			return new CategoriaDTO(entity);
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
	public List<Categoria> getAll() {

		return categoriaRepository.findAll();

	}

	public Optional<Categoria> getById(Long id) {

		return categoriaRepository.findById(id);

	}

	public Categoria post(Categoria setor) {

		return categoriaRepository.save(setor);

	}

	public Optional<Categoria> put(Categoria setor) {

		if (categoriaRepository.existsById(setor.getId()))
			return Optional.ofNullable(categoriaRepository.save(setor));
		
		return Optional.empty();
		

	}

	public void delete(Long id) {

		if (categoriaRepository.existsById(id))
			categoriaRepository.deleteById(id);

	}
}
