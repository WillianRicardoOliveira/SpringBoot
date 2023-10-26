package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import modelo.spring.api.domain.pessoa.model.PessoaModel;
import modelo.spring.api.domain.pessoa.record.PessoaRecord;
import modelo.spring.api.domain.pessoa.repository.PessoaRepository;

@RestController
@RequestMapping("pessoa")
@SecurityRequirement(name = "bearer-key")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid PessoaRecord pessoa) {
		repository.save(new PessoaModel(pessoa));		
	}	
	
}
