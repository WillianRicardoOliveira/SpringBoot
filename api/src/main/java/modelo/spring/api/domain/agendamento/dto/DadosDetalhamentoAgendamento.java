package modelo.spring.api.domain.agendamento.dto;

import java.time.LocalDateTime;

import modelo.spring.api.domain.agendamento.model.AgendamentoModel;

public record DadosDetalhamentoAgendamento(Long id, Long idPessoa, Long idAtividade, LocalDateTime data) {

	public DadosDetalhamentoAgendamento(AgendamentoModel agendamento) {
		// TODO Auto-generated constructor stub
		
		
		this(	agendamento.getId(), 
				agendamento.getPessoa().getId(),
				agendamento.getAtividade().getId(),
				agendamento.getData()
			);
		
	}

}
