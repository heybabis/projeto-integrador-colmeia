package com.colmeia.projetointegrador.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import com.colmeia.projetointegrador.entity.Item;
import com.colmeia.projetointegrador.entity.Usuario;
import com.colmeia.projetointegrador.entity.UsuarioLogin;
import com.colmeia.projetointegrador.repository.ItemRepository;
import com.colmeia.projetointegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ItemRepository itemRepository;

	public Optional<Usuario> CadastrarUsuario(Usuario usuario) {

		if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent() && usuario.getId() == 0) {
			return null;

		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);

		/* GERANDO CARRINHO USUARIO */
		/* INSTANCIA UM NOVO CARRINHO 'Pedido' */
		Item item = new Item();

		/* REGISTRA O USUARIO NA BASE DE DADOS */
		usuarioRepository.save(usuario);

		/* ASSOCIA O USUARIO AO CARRINHO */
		item.setUsuario(usuario);

		/* REGISTRA O CARRINHO NA BASE DE DADOS */
		itemRepository.save(item);

		return Optional.of(usuarioRepository.save(usuario));

	}

	/* LOGA USUARIO NO SISTEMA */
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> usuarioLogin) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());

		/*
		 * CASO TENHA ALGUM VALOR DIGITADO, IREMOS COMPARAR OS DADOS QUE ESTAO
		 * CADASTRADOS NA BASE DE DADOS COM O QUE O USUARIO ACABOU DE DIGITAR
		 */
		if (usuario.isPresent()) {
			/*
			 * COMPARA O QUE FOI DIGITADO NO BODY COM O QUE ESTA NO BANCO DE DADOS REFERENTE
			 * AQUELE DETERMINADO USUARIO
			 */
			if (encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

				/* CRIA UMA STRING COM O 'NOME_USUARIO:SENHA' */
				String auth = usuarioLogin.get().getUsuario() + ":" + usuarioLogin.get().getSenha();

				/*
				 * CRIA UM ARRAY DE BYTE, QUE RECEBE A STRING GERADA ACIMA E FORMATA NO PADRAO
				 * 'US-ASCII'
				 */
				byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));

				/* GERA O TOKEN PARA ACESSO DE USUARIO POR MEIO DO ARRAY DE BY GERADO */
				String authHeader = "Basic " + new String(encodedAuth);

				/* INSERE O TOKEN GERADO DENTRO DE NOSSO ATRIBUTO TOKEN */
				usuarioLogin.get().setToken(authHeader);
				usuarioLogin.get().setUsuario(usuario.get().getUsuario());
				usuarioLogin.get().setSenha(usuario.get().getSenha());
				usuarioLogin.get().setTipoUsuario(usuario.get().getTipoUsuario());
				usuarioLogin.get().setNome(usuario.get().getNome());
				usuarioLogin.get().setCpf(usuario.get().getCPF());
				usuarioLogin.get().setId(usuario.get().getId());

				return usuarioLogin;

			}
		}

		return null;
	}

}