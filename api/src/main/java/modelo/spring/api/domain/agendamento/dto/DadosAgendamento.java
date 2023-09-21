package modelo.spring.api.domain.agendamento.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record DadosAgendamento(
		
		
		/*
		 * os nomes dos campos enviados no JSON para a API devem ser idênticos aos nomes dos atributos das classes DTO, pois assim o Spring consegue preencher corretamente as informações recebidas.
		 */
		//  @JsonAlias({“produto_id”, “id_produto”}) Long idProduto, = O Spring procula um dos alias
		Long idPessoa,
		
		
		@NotNull
		Long idAtividade,
		
		
		
		
		// @JsonFormat(pattern = "dd/MM/yyyy HH:mm") = Para formatar a data que recebemos
		@NotNull //
		@Future // A data tem que ser no futuro
		LocalDateTime data
		
		
		
		
		
		) {

	
	
}
