package modelo.spring.api.domain.agendamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.domain.agendamento.dto.DadosCancelamentoAgendamento;
import modelo.spring.api.domain.agendamento.dto.DadosDetalhamentoAgendamento;
import modelo.spring.api.domain.agendamento.model.AgendamentoModel;
import modelo.spring.api.domain.agendamento.repository.AgendamentoRepository;
import modelo.spring.api.domain.agendamento.validacoes.agendamento.ValidadorAgendamento;
import modelo.spring.api.domain.agendamento.validacoes.cancelamento.ValidadorCancelamentoDeAgendamento;
import modelo.spring.api.domain.atividade.repository.AtividadeRepository;
import modelo.spring.api.domain.pessoa.repository.PessoaRepository;
import modelo.spring.api.service.ValidacaoException;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private List<ValidadorAgendamento> validadores;
	
	@Autowired
	private List<ValidadorCancelamentoDeAgendamento> validadoresCancelamento;

	public DadosDetalhamentoAgendamento agendar(DadosAgendamento dados) {
		
		if(!pessoaRepository.existsById(dados.idPessoa())) {		
			throw new ValidacaoException("Id da pessoa informada não existe.");
		}
		
		if(!atividadeRepository.existsById(dados.idAtividade())) {
			throw new ValidacaoException("Id da atividade informada não existe.");
		}
		
		validadores.forEach(v -> v.validar(dados));
		
		var pessoa = pessoaRepository.getReferenceById(dados.idPessoa());
		
		var atividade = atividadeRepository.getReferenceById(dados.idAtividade());
		
		var agendamento = new AgendamentoModel(null, pessoa, atividade, dados.data(), null);
		
		agendamentoRepository.save(agendamento);
		
		return new DadosDetalhamentoAgendamento(agendamento);
		
	}
	
	public void cancelar(DadosCancelamentoAgendamento dados) {
	    if (!agendamentoRepository.existsById(dados.idAgendamento())) {
	        throw new ValidacaoException("Id do agendamento informado não existe!");
	    }

	    validadoresCancelamento.forEach(v -> v.validar(dados));
	    
	    var agendamento = agendamentoRepository.getReferenceById(dados.idAgendamento());
	    agendamento.cancelar(dados.motivo());
	}
	
	// CANCELAR ----- REAGENDAR
	
	/*
	private PessoaModel escolherPessoa(DadosAgendamento dados) {
		
		if(dados.idPessoa() != null) {
			return pessoaRepository.getReferenceById(dados.idPessoa());
		}
		
		pessoaRepository.escolherPessoaAleatorioLivreNaData(dados), dados.data());
		
	}
	*/
	
}
