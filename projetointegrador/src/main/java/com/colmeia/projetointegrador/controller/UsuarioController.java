package com.colmeia.projetointegrador.controller;

import java.util.List;
import java.util.Optional;

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

import com.colmeia.projetointegrador.entity.Usuario;
import com.colmeia.projetointegrador.entity.UsuarioLogin;
import com.colmeia.projetointegrador.repository.UsuarioRepository;
import com.colmeia.projetointegrador.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAllByUsuario() {

		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findByIdUsuario(@PathVariable long id) {

		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	/* PARA LOGARMOS NO SISITEMA TRABALHAMOS COM A CLASSE 'UserLogin' */
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return service.Logar(user).map(resp -> ResponseEntity.ok(resp))
				/* CASO SEU USUARIO SEJA INVALIDO VOCE RECEBERA UM ERRO DE NAO AUTORIZADO */
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	/*
	 * CHAMA O METODO DE CADASTRAR USUARIOS QUE E RESPONSAVEL POR VERIFICAR SE O
	 * USUARIO INSERIDO JA SE ENCONTRA NA BASE DE DADOS, CODIFICAR A SENHA INSERIDA
	 * E SALVAR OS DADOS CADASTRADO NA BASE DE DADOS
	 */
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		Optional<Usuario> user = service.CadastrarUsuario(usuario);

		try {
			return ResponseEntity.ok(user.get());

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();

		}

	}

	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {

		return ResponseEntity.ok(repository.save(usuario));
	}

	@DeleteMapping("/{id}")
	public void deletaCliente(@PathVariable long id) {

		repository.deleteById(id);
	}

}
