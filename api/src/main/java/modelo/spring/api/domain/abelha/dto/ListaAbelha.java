package modelo.spring.api.domain.abelha.dto;

import modelo.spring.api.domain.abelha.model.AbelhaModel;

public record ListaAbelha(
		
		
		// Adiciono somente o que eu quero devolver
		
		Long id,
		
		String nome
		
		
		) {

	public ListaAbelha(AbelhaModel model) {
		
		// Adicionar os campos que eu quero
		this(model.getId(), model.getNome());
		
	}
	
	
}
