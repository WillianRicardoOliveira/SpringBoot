package modelo.spring.api.domain.abelha.dto;

import jakarta.validation.constraints.NotNull;

public record AbelhaAtualizarRecord(
		
		@NotNull // Obrigatório
		Long id,
		String nome
		
		
		) {

	
	
}
