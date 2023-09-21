package modelo.spring.api.domain.agendamento.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import modelo.spring.api.domain.agendamento.model.AgendamentoModel;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

	//Boolean existsByPessoaIdAndData(Long idPessoa, LocalDateTime data);

	
	boolean existsByPessoaIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);

}
