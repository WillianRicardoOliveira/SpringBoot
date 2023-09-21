package modelo.spring.api.domain.caixa.dto;

import jakarta.validation.constraints.NotNull;

public record CaixaAtualizarRecord(
		
		@NotNull // Obrigatório
		Long id,
		String nome
		
		
		) {

	
	
}
