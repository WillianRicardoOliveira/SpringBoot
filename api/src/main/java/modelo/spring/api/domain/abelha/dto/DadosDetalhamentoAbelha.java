package modelo.spring.api.domain.abelha.dto;

import modelo.spring.api.domain.abelha.model.AbelhaModel;

public record DadosDetalhamentoAbelha(Long id, String nome) {

	public DadosDetalhamentoAbelha(AbelhaModel model) {
		
		this(model.getId(), model.getNome());
		
	}
	
}
