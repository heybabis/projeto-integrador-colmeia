package com.colmeia.projetointegrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colmeia.projetointegrador.dto.DoadorDTO;
import com.colmeia.projetointegrador.dto.ProdutoDTO;
import com.colmeia.projetointegrador.service.ProdutoService;

@RestController
@RequestMapping(value = "/doador")

public class DoadorController {
	@Autowired
	private ProdutoService service;

	
	//@GetMapping
	//public ResponseEntity<Page<DoadorDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
		//	@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
		//	@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
		//	@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		//PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		//Page<DoadorDTO> list = service.findAllPaged(pageRequest);
		//return ResponseEntity.ok().body(list);
	//}


	
	//@GetMapping(value = "/{id}")
	//public ResponseEntity<DoadorDTO> findById(@PathVariable Long idDoador) {
		//DoadorDTO dto = service.findById(Long idDoador);
		//return ResponseEntity.ok().body(dto);

	//}
	
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DoadorDTO> update(@PathVariable Long idDoador, @RequestBody DoadorDTO dto) {
		//dto = service.update(idDoador, dto);// passa as variáveis de cima.
		return ResponseEntity.ok().body(dto);

	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long idDoador) {// RETORNO VOID O CORPO FICA VAZIO
		service.delete(idDoador);// passa as variáveis de cima, DO MÉTODO
		return ResponseEntity.noContent().build();// O DELETE NAO PRECISA TER O BODY(CORPO)
// DEVOLVE UMA RESPOSTA 204, DEU CERTO A EXCLUSÃO

	}
	
	
}
