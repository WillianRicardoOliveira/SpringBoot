package modelo.spring.api.domain.agendamento.validacoes.cancelamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import modelo.spring.api.domain.agendamento.dto.DadosCancelamentoAgendamento;
import modelo.spring.api.domain.agendamento.repository.AgendamentoRepository;
import modelo.spring.api.service.ValidacaoException;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeAgendamento {

	@Autowired
	private AgendamentoRepository repository;

    @Override
    public void validar(DadosCancelamentoAgendamento dados) {
    	
        var agendamento = repository.getReferenceById(dados.idAgendamento());
        
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, agendamento.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Agendamento somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
	
}
