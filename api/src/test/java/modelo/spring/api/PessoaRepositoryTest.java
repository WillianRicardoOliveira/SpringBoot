package modelo.spring.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import modelo.spring.api.domain.pessoa.model.PessoaModel;
import modelo.spring.api.domain.pessoa.repository.PessoaRepository;
import modelo.spring.api.pessoa.Especialidade;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PessoaRepositoryTest {
/*
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	@DisplayName("Deveria retornar a pessoa se estiver ativo")
	void findAtivoByIdCenario1() {
		
		
		
		// given ou arrange
	//	var pessoa = cadastrarPessoa("Willian", "willian@gmail.com", "12345678", Especialidade.CRIADOR);
		

		
		// when ou act
	//	var pessoaAtivo = pessoaRepository.findAtivoById(pessoa.getId());
		
		// then ou assert
	//	assertThat(pessoaAtivo).isEqualTo(pessoa);
	}
	
	public PessoaModel cadastrarPessoa(String nome, String email, String telefone, Especialidade especialidade) {
		
		var pessoa = new PessoaModel(null, nome, email, telefone, especialidade, true);
		
		em.persist(pessoa);
		
		return pessoa;
		
	}
*/
}
