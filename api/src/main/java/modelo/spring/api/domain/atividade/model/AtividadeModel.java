package modelo.spring.api.domain.atividade.model;


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
@Table(name = "atividades") // Informa o nome da tabela no banco caso necessário

@Entity // Informa que é uma entidade do banco de dados com o mesmo nome da classe

@Getter // Gera os gets e sets

@NoArgsConstructor // Cria um construtor sem argumentos

@AllArgsConstructor // Cria um construtor com argumentos

@EqualsAndHashCode(of = "id") // Gera um hash no ID


public class AtividadeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String nome;	
	
	
}
