package modelo.spring.api.domain.cadastro.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import modelo.spring.api.domain.abelha.model.AbelhaModel;
import modelo.spring.api.domain.cadastro.model.CadastroModel;

public interface CadastroRepository extends JpaRepository<CadastroModel, Long> {

	Page<CadastroModel> findAllByAtivoTrue(Pageable paginacao);

}
