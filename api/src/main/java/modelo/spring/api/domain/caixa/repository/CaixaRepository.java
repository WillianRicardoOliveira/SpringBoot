package modelo.spring.api.domain.caixa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import modelo.spring.api.domain.caixa.model.CaixaModel;

public interface CaixaRepository extends JpaRepository<CaixaModel, Long> {
	Page<CaixaModel> findAllByAtivoTrue(Pageable paginacao);
}
