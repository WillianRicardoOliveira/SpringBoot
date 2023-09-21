package modelo.spring.api.domain.pessoa.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import modelo.spring.api.domain.pessoa.dto.Pessoas;
import modelo.spring.api.pessoa.Especialidade;

@Table(name = "pessoas")
@Entity
@Getter
@NoArgsConstructor // Criar contrutor sem argumento
@AllArgsConstructor // Criar contrutor com argumento
@EqualsAndHashCode(of = "id") // gera em cima do ID
public class PessoaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	//@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	

	
	private boolean ativo;
	
	public PessoaModel(Pessoas dados) {
		
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.especialidade = dados.especialidade();
		
		this.ativo = true;
	}

	public void inativar() {
		this.ativo = false;
	}

	
	/*
	 * 
	 * 	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	
	 */
	
}
