package modelo.spring.api.domain.abelha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import modelo.spring.api.domain.abelha.model.AbelhaModel;

public interface AbelhaRepository extends JpaRepository<AbelhaModel, Long> {

	Page<AbelhaModel> findAllByAtivoTrue(Pageable paginacao);

}
