package com.colmeia.projetointegrador.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.colmeia.projetointegrador.entity.Usuario;
import com.colmeia.projetointegrador.entity.UsuarioLogin;
import com.colmeia.projetointegrador.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

		if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
			return Optional.empty();

		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return Optional.of(usuarioRepository.save(usuario));
	}

	

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {

		if (usuarioRepository.findById(usuario.getId()).isPresent()) {
			
			Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(usuario.getUsuario()); 
			
			if ((buscaUsuario.isPresent()) && buscaUsuario.get().getId()!= usuario.getId())
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário  já existe", null);
			

			usuario.setSenha(criptografarSenha(usuario.getSenha()));
			
			return Optional.of(usuarioRepository.save(usuario));
	}
		return Optional.empty();
	}
	
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());
		
		if(usuario.isPresent()) {
			if (compararSenha(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {
				
				usuarioLogin.get().setId(usuario.get().getId());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setTipoUsuario(usuario.get().getTipoUsuario());
				usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(), usuarioLogin.get().getSenha()));
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				
				return usuarioLogin;
				
			}
			
		}
		
		return Optional.empty();
		
	}
	
	
	
	private String gerarBasicToken(String usuario, String senha) {
		String token = usuario + ":" + senha;
		
		byte[] tokenBase64 = Base64.encode(token.getBytes(Charset.forName("US-ASCII")));
		
		return "Basic " + new String(tokenBase64);
	
	}



	private boolean compararSenha(String senhaDigitada, String senhaBanco) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.matches(senhaDigitada, senhaBanco);
	}



	private String criptografarSenha(String senha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.encode(senha);
	}



	



	



		

}