package com.colmeia.projetointegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colmeia.projetointegrador.entity.Categoria;
import com.colmeia.projetointegrador.service.CategoriaService;



@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	/*@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<CategoriaDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
		CategoriaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping // inseri um novo recurso
	public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		// insere um objeto, e retorna 201
		return ResponseEntity.created(uri).body(dto);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
		dto = service.update(id, dto);// passa as variáveis de cima.
		return ResponseEntity.ok().body(dto);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {// RETORNO VOID O CORPO FICA VAZIO
		service.delete(id);// passa as variáveis de cima, DO MÉTODO
		return ResponseEntity.noContent().build();// O DELETE NAO PRECISA TER O BODY(CORPO)
// DEVOLVE UMA RESPOSTA 204, DEU CERTO A EXCLUSÃO

	}*/
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaService.getAll());
	}
    
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return categoriaService.getById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	public ResponseEntity<Categoria> postProduto(@Valid @RequestBody Categoria setor){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.post(setor));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> putProduto(@Valid @RequestBody Categoria setor) {
		return categoriaService.put(setor)
                .map(resposta -> ResponseEntity.status(HttpStatus.OK).body(setor))
                .orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoriaService.delete(id);
	}

}
