package modelo.spring.api.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.spring.api.domain.usuario.repository.UsuarioRepository;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	
	@Autowired // Injecao de dependencia
	private TokenService tokenService;
	
	@Autowired	//
	private UsuarioRepository usuarioRepository;
	
	/*
	 * Executa a cada requiicao
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("CHAMANDO O FILTRO.");
		
		
		// Recuperar o token
		var tokenJWT = recuperarToken(request);
		
		// System.out.println(tokenJWT);
		
		// Verificar se o token está válido.
		if(tokenJWT != null) {
			
			
			var subject = tokenService.getSubject(tokenJWT);
			
			
			// Recuperar o objeto usuário
			var usuario = usuarioRepository.findByLogin(subject);
			
			
			
			var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			
			System.out.println("LOGADO NA REQUISICAO");
			
		}
		
		// System.out.println(subject);
		
		
		
		
		
		// Chamar o proximo filtro
		filterChain.doFilter(request, response);
		
	}

	// retorna a string do token
	
	// Recuperar o toke do header
	private String recuperarToken(HttpServletRequest request) {
		
		// Recuperei o Token
		var authorizationHeader = request.getHeader("Authorization");
		
		// Validar de existe o token no header
		if(authorizationHeader != null) {

			// substituir palavra Bearer por vazio
			return authorizationHeader.replace("Bearer ", "").trim();
		}

		return null;
		
	}
	

	
	
}
