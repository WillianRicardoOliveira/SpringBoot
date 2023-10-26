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
import modelo.spring.api.domain.cadastro.dto.CadastroRecord;
import modelo.spring.api.domain.cadastro.dto.UnidadeFederativaRecord;

@Table(name = "cadastro")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CadastroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;
	private String nascimento;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	private String cidade;
	private UnidadeFederativaRecord unidadeFederativa;
	
	private boolean ativo;
	
	// Recebe o RECORD
	public CadastroModel(CadastroRecord dados) {		
		this.nome = dados.nome();	
		this.nascimento = dados.nascimento();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.senha = dados.senha();
		this.cidade = dados.cidade();
		this.unidadeFederativa = dados.estado();
		this.ativo = true;		
	}
	
	public void atualizarInformacoes(AbelhaAtualizarRecord dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
	}

	public void inativar() {
		this.ativo = false;
	}
	
}
