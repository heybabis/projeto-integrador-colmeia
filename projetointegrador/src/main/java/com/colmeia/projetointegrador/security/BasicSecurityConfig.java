package com.colmeia.projetointegrador.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // espera uma requisicao de servico @bean
@EnableWebSecurity // indica q a classe vai ser usada para configar a seguranca da aplicacao
@EnableGlobalMethodSecurity(prePostEnabled = true) // habilita a seguranca
public class BasicSecurityConfig {

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable().cors();

		http.authorizeHttpRequests(
				(auth) -> auth.antMatchers("/usuarios/logar").permitAll().antMatchers("/usuarios/cadastrar").permitAll()
						.antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated())
				.httpBasic();

		return http.build();

	}

}
