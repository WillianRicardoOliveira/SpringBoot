package modelo.spring.api.domain.agendamento.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import modelo.spring.api.domain.agendamento.dto.MotivoCancelamento;
import modelo.spring.api.domain.atividade.model.AtividadeModel;
import modelo.spring.api.domain.pessoa.model.PessoaModel;
@Table(name = "agendamentos") // Informa o nome da tabela no banco caso necessário

@Entity(name="AgendamentoModel") // Informa que é uma entidade do banco de dados com o mesmo nome da classe

@Getter // Gera os gets e sets

@NoArgsConstructor // Cria um construtor sem argumentos

@AllArgsConstructor // Cria um construtor com argumentos

@EqualsAndHashCode(of = "id") // Gera um hash no ID


public class AgendamentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@ManyToOne(fetch = FetchType.LAZY) // 
	@JoinColumn(name = "idPessoa", referencedColumnName="id")
	private PessoaModel pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY) // 
	@JoinColumn(name = "atividade_id" )
	private AtividadeModel atividade;
	


	private LocalDateTime data;
	
	@Column(name = "motivo_cancelamento")
	@Enumerated(EnumType.STRING)
	private MotivoCancelamento motivoCancelamento;
	
	public void cancelar(MotivoCancelamento motivo) {
	    this.motivoCancelamento = motivo;
	}
}
