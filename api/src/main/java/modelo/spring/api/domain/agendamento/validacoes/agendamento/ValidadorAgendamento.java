package modelo.spring.api.domain.agendamento.validacoes.agendamento;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;

public interface ValidadorAgendamento {

	void validar(DadosAgendamento dados);
	
}
