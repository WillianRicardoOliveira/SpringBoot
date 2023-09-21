package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import modelo.spring.api.domain.usuario.dto.DadosAutenticacao;
import modelo.spring.api.domain.usuario.model.UsuarioModel;
import modelo.spring.api.infra.security.DadosTokenJWT;
import modelo.spring.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		
		try {
		
			var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
			
			var authentication = manager.authenticate(authenticationToken);
			
			var tokenJWT = tokenService.gerarToken((UsuarioModel) authentication.getPrincipal());
			
			return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
		} catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
}
