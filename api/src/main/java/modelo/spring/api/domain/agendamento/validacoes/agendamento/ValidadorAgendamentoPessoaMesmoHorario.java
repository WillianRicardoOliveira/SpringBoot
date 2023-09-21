package modelo.spring.api.domain.agendamento.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.domain.agendamento.repository.AgendamentoRepository;
import modelo.spring.api.service.ValidacaoException;

@Component
public class ValidadorAgendamentoPessoaMesmoHorario implements ValidadorAgendamento {

	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public void validar(DadosAgendamento dados) {
		
		var pessoaPossuiOutroAgendamento = agendamentoRepository.existsByPessoaIdAndDataAndMotivoCancelamentoIsNull(dados.idPessoa(), dados.data());
		
		if(pessoaPossuiOutroAgendamento) {
			
			throw new ValidacaoException("Pessoa já possuí agendamento no mesmo horário");
			
		}
		
		
	}
	
}
