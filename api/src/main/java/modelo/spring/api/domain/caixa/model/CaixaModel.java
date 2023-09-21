package modelo.spring.api.domain.caixa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import modelo.spring.api.domain.caixa.dto.CaixaAtualizarRecord;
import modelo.spring.api.domain.caixa.dto.CaixaRecord;

@Table(name = "caixas")	//
@Entity	//
@Getter	//
@NoArgsConstructor	//
@AllArgsConstructor	//
@EqualsAndHashCode	//
public class CaixaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;	
	private boolean ativo;
	
	public CaixaModel(CaixaRecord dados) {
		this.nome = dados.nome();
		this.ativo = true;
	}
	
	public void atualizarInformacoes(CaixaAtualizarRecord dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	}
	
	public void inativar() {
		this.ativo = false;
	}
	
}
