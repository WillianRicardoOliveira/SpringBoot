package modelo.spring.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Enderecos(
		
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		String logradouro,
		
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		String bairro,
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		@Pattern(regexp= "\\d{8}") // Para dizer que sao 8 digitos para o CEP
		String cep,
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		String cidade,
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		String uf,
		
		String numero,
		
		String complemento) {



}
