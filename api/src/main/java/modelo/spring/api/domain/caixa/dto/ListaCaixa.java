package modelo.spring.api.domain.caixa.dto;

import modelo.spring.api.domain.caixa.model.CaixaModel;

public record ListaCaixa(Long id, String nome) { // Adiciono somente o que eu quero devolver

	public ListaCaixa(CaixaModel model) {
		this(model.getId(), model.getNome()); // Adicionar os campos que eu quero	
	}
	
}
