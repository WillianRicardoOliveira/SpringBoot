package modelo.spring.api.domain.abelha.dto;

import jakarta.validation.constraints.NotBlank;

public record AbelhaRecord(
		@NotBlank(message = "{nome.obrigatorio}") // Verifica se nao e null ou vazio (somente STRING)
		String nome) {

	
}
