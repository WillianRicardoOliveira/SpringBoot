package modelo.spring.api.domain.agendamento.validacoes.agendamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.service.ValidacaoException;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamento {

	
	public void validar(DadosAgendamento dados) {
		
		
		var dataAgen = dados.data();
		
		var agora = LocalDateTime.now();
		
		
		var diferencaEmMinutos = Duration.between(agora, dataAgen).toMinutes();
		
		if(diferencaEmMinutos < 30) {
			
			throw new ValidacaoException("O agendamento deve ser realizado com 30 minutos de antecedencia.");
			
		}
		
	}
	
}
