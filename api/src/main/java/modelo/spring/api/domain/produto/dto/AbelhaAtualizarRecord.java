package modelo.spring.api.domain.produto.dto;

import jakarta.validation.constraints.NotNull;

public record AbelhaAtualizarRecord(
		
		@NotNull // Obrigatório
		Long id,
		String nome
		
		
		) {

	
	
}
