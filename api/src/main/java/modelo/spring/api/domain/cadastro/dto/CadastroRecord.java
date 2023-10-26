package modelo.spring.api.domain.cadastro.dto;

public record CadastroRecord(
		
		String nome,		
		String nascimento,
		String cpf,
		String telefone,
		String email,
		String senha,
		String cidade,
		UnidadeFederativaRecord estado
		
		) {

	
}
