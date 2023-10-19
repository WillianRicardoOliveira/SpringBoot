package modelo.spring.api.domain.produto.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoRecord(
		@NotBlank(message = "{nome.obrigatorio}") // Verifica se nao e null ou vazio (somente STRING)
		String nome) {

	
}
