package modelo.spring.api.domain.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import modelo.spring.api.domain.usuario.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	UserDetails findByLogin(String username);

}
