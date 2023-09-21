package modelo.spring.api.domain.agendamento.validacoes.cancelamento;

import modelo.spring.api.domain.agendamento.dto.DadosCancelamentoAgendamento;

public interface ValidadorCancelamentoDeAgendamento {

	void validar(DadosCancelamentoAgendamento dados);
	
}
