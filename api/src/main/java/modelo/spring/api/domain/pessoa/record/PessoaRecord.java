package modelo.spring.api.domain.pessoa.record;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import modelo.spring.api.endereco.Enderecos;
import modelo.spring.api.pessoa.Especialidade;

public record PessoaRecord(
		
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		String nome,
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		@Email // Verificar se o email e valido
		String email,
		
		@NotBlank // Verifica se nao e null ou vazio (somente STRING)
		String telefone,
		
		// Sao numeros(digitos de 4 a 6)
		//@Pattern(regexp= "\\d{4,6}")
		
		@NotNull
		Especialidade especialidade
		
		//@NotNull
		//@Valid // Para dizer que tem que validar o objeto endereco e colocar a validacoes la tambem
		//Enderecos endereco
		
		//@NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,
		
		) {

}
