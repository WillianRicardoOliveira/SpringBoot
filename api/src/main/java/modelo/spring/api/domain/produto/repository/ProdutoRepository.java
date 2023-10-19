package modelo.spring.api.domain.produto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import modelo.spring.api.domain.produto.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	Page<ProdutoModel> findAllByAtivoTrue(Pageable paginacao);

}
