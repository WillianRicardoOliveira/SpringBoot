package modelo.spring.api.domain.produto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import modelo.spring.api.domain.produto.dto.ProdutoRecord;

@Table(name = "produto")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProdutoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;	
	private boolean ativo;
	
	/*
	 * 
	 */
	public ProdutoModel(ProdutoRecord dados) {		
		this.nome = dados.nome();		
		this.ativo = true;		
	}
	
	
	/*
	public void atualizarInformacoes(AbelhaAtualizarRecord dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	}

	public void inativar() {
		this.ativo = false;
	}
	*/
}
