package modelo.spring.api.domain.agendamento.validacoes.agendamento;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.service.ValidacaoException;

@Component
public class ValidadorHorario implements ValidadorAgendamento {

	
	public void validar(DadosAgendamento dados) {
		
		var dataAgen = dados.data();
		
		
		var domingo = dataAgen.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		
	
		var antesDaAbertura = dataAgen.getHour() < 7;
	
		var depoisDoEncerramento = dataAgen.getHour() > 18;
		
		if(domingo|| antesDaAbertura || depoisDoEncerramento ) {
			
			throw new ValidacaoException("Agendamento fora do horário definido.");
			
		}
		
	}
	
}
