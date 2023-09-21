package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import modelo.spring.api.domain.caixa.dto.CaixaAtualizarRecord;
import modelo.spring.api.domain.caixa.dto.CaixaRecord;
import modelo.spring.api.domain.caixa.dto.ListaCaixa;
import modelo.spring.api.domain.caixa.model.CaixaModel;
import modelo.spring.api.domain.caixa.repository.CaixaRepository;

@RestController 			//
@RequestMapping("caixa")	//
@SecurityRequirement(name = "bearer-key")
public class CaixaController {
	
	@Autowired	//
	private CaixaRepository repository;

	@PostMapping	//
	@Transactional	//
	public void cadastrar(@RequestBody @Valid CaixaRecord dados) {
		repository.save(new CaixaModel(dados));
	}
	
	@GetMapping // ?size=5&page=1&sort=nome,desc
	public Page<ListaCaixa> listar(@PageableDefault(page = 0, size = 5, sort = {"nome"}) Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(ListaCaixa::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid CaixaAtualizarRecord dados) {
		repository.getReferenceById(dados.id()).atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.getReferenceById(id).inativar();
	}
	
}
