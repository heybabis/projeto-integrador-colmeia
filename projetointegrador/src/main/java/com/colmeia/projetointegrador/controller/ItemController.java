package com.colmeia.projetointegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colmeia.projetointegrador.entity.Item;
import com.colmeia.projetointegrador.repository.ItemRepository;
import com.colmeia.projetointegrador.service.ProdutoService;

@RestController
@RequestMapping("/itens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

	@Autowired
	private ItemRepository repository;

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Item>> findAllByItens() {

		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Item> findByIdItem(@PathVariable long id) {

		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Item> postItem(@RequestBody Item item) {

		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(item));
	}

	@PutMapping
	public ResponseEntity<Item> putItem(@RequestBody Item item) {

		return ResponseEntity.ok(repository.save(item));
	}

	@DeleteMapping("/{id}")
	public void deleteItem(@PathVariable long id) {

		repository.deleteById(id);
	}

	@DeleteMapping("/produto_item/produtos/{idProduto}/itens/{idItem}")
	public void putProduto(@PathVariable long idProduto, @PathVariable long idItem) {

		service.deletarProduto(idProduto, idItem);
	}

}
