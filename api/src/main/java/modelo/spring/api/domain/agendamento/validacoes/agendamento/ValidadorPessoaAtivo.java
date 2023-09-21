package modelo.spring.api.domain.agendamento.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.domain.pessoa.repository.PessoaRepository;
import modelo.spring.api.service.ValidacaoException;


@Component
public class ValidadorPessoaAtivo implements ValidadorAgendamento {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public void validar(DadosAgendamento dados) {
		// escolha da pessoa opcional
		
		
		if(dados.idPessoa() == null) {
			return;
		}
		
		
		// Precisa corrigir essa linha por que está dando erro, o TRUE foi colocado apenas para compilar
		var pessoaEstaAtivo = true;//pessoaRepository.findAtivoById(dados.idPessoa());
		
		if(!pessoaEstaAtivo) {
			
			throw new ValidacaoException("Agendamento não pode ser realizado por pessoa excluída");
			
		}
		
	}
}
