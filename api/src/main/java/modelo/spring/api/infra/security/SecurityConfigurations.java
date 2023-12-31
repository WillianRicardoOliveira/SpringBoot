package modelo.spring.api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/*
 * https://docs.spring.io/spring-security/reference/servlet/authorization/method-security.html
 * 
 */
@Configuration
@EnableWebSecurity

@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfigurations {
	
	@Autowired
	private SecurityFilter securityFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http.csrf(csrf -> csrf.disable())
	            
	    		.cors(Customizer.withDefaults())
	    		.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests(req -> {
	                req.requestMatchers(HttpMethod.POST, "/login").permitAll();
	                
// Liberar para popder usar o SpringDoc (https://springdoc.org)
// http://localhost:8080/v3/api-docs
// http://localhost:8080/swagger-ui/index.html
	                
	                
	                /**
	                 * https://www.openapis.org
	                 * 
	                 * mais detalhes
	                 */
	                
req.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll();
	                
	                
	                
	                req.requestMatchers(HttpMethod.DELETE, "/medicos").hasRole("ADMIN");
	                req.requestMatchers(HttpMethod.DELETE, "/pacientes").hasRole("ADMIN");
	                
	                req.anyRequest().authenticated();
	            })
	            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		
		return configuration.getAuthenticationManager();
		
	}
	
	
	/**
	 * Tipo de criptografia da senha
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
