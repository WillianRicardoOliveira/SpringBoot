package modelo.spring.api.domain.caixa.dto;

import jakarta.validation.constraints.NotBlank;

public record CaixaRecord(
		
		@NotBlank
		String nome
		
		) {

}
