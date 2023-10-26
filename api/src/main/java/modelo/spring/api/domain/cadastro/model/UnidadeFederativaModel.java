package modelo.spring.api.domain.cadastro.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import modelo.spring.api.domain.abelha.dto.AbelhaAtualizarRecord;
import modelo.spring.api.domain.abelha.dto.AbelhaRecord;
import modelo.spring.api.domain.cadastro.dto.UnidadeFederativaRecord;

@Table(name = "estado")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UnidadeFederativaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;
	private String sigla;
	private boolean ativo;
	
	// Recebe o RECORD
	public UnidadeFederativaModel(UnidadeFederativaRecord dados) {		
		this.nome = dados.nome();
		this.sigla = dados.sigla();
		this.ativo = true;		
	}
	
	/*
	public void atualizarInformacoes(AbelhaAtualizarRecord dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	}
*/
	public void inativar() {
		this.ativo = false;
	}
	
}
