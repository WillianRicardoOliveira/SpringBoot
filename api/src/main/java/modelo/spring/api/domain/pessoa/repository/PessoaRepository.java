package modelo.spring.api.domain.pessoa.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modelo.spring.api.domain.pessoa.model.PessoaModel;
import modelo.spring.api.pessoa.Especialidade;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

	
	
	@Query("""
			select p.ativo
			from PessoaModel p
			where
			p.id = : idPessoa
			""")
	public Boolean findAtivoById(Long idPessoa);

	/*
	
	@Query("""
            select m from Medico m
            where
            m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where
                c.data = :data
        and
                c.motivoCancelamento is null
            )
            order by rand()
            limit 1
""")
	void escolherPessoaAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
*/
}
