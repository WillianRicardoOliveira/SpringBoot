package modelo.spring.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import modelo.spring.api.domain.usuario.model.UsuarioModel;

@Service
public class TokenService {

	/*Documentacao : https://github.com/auth0/java-jwt*/
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	@Value("${api.security.token.issuer}")
	private String issuer ;
	
	public String gerarToken(UsuarioModel usuario) {
		
		try {
		    Algorithm algoritimo = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer(issuer)
		        .withSubject(usuario.getLogin())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritimo);
		} catch (JWTCreationException exception){
		    throw new RuntimeException("erro ao gerar token jwt", exception);
		}
		
	}
	
	/*
	 * Verifica se o toke é válido
	 * */
	public String getSubject(String tokenJWT) {
		
	    try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                            .withIssuer(issuer)
                            .build()
                            .verify(tokenJWT)
                            .getSubject();
	    } catch (JWTVerificationException exception) {
	    	throw new RuntimeException("Token JWT inválido ou expirado: " +tokenJWT);
	    }
		
	}

	private Instant dataExpiracao() {	
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
