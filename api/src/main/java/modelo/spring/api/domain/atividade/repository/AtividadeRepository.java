package modelo.spring.api.domain.atividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.spring.api.domain.atividade.model.AtividadeModel;

public interface AtividadeRepository extends JpaRepository<AtividadeModel, Long> {

}
