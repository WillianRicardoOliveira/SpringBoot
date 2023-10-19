package modelo.spring.api.domain.produto.dto;

import modelo.spring.api.domain.produto.model.ProdutoModel;

/*
 * Adiciono somente o que eu quero devolver
 */
public record ListaProduto(Long id, String nome) {

	public ListaProduto(ProdutoModel model) {
		this(model.getId(), model.getNome());
	}
	
	
}
