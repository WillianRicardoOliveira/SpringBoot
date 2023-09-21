package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import modelo.spring.api.domain.pessoa.dto.Pessoas;
import modelo.spring.api.domain.pessoa.model.PessoaModel;
import modelo.spring.api.domain.pessoa.repository.PessoaRepository;

@RestController
@RequestMapping("pessoas")
@SecurityRequirement(name = "bearer-key")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Pessoas pessoas) {
		
		pessoaRepository.save(new PessoaModel(pessoas));
		
		
	}	
	
}
