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

import com.colmeia.projetointegrador.entity.Produto;
import com.colmeia.projetointegrador.repository.ProdutoRepository;
import com.colmeia.projetointegrador.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> findAllByProdutos() {

		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIdProduto(@PathVariable long id) {

		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> findAllByNomeProdutos(@PathVariable String nome) {

		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {

		return ResponseEntity.ok(produtoRepository.save(produto));
	}

	@PutMapping("/produto_item/produtos/{idProduto}/itens/{idItem}")
	public ResponseEntity<Produto> putProduto(@PathVariable long idProduto, @PathVariable long idItem) {

		return ResponseEntity.ok(produtoService.addProduto(idProduto, idItem));
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {

		produtoRepository.deleteById(id);
	}
}
