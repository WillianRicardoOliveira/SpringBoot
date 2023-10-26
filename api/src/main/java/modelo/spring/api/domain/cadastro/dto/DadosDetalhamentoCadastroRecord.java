package modelo.spring.api.domain.cadastro.dto;

import modelo.spring.api.domain.cadastro.model.CadastroModel;

public record DadosDetalhamentoCadastroRecord(Long id, String nome) {

	public DadosDetalhamentoCadastroRecord(CadastroModel model) {
		
		this(model.getId(), model.getNome());
		
	}
	
}
