package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import modelo.spring.api.domain.abelha.dto.AbelhaAtualizarRecord;
import modelo.spring.api.domain.abelha.dto.AbelhaRecord;
import modelo.spring.api.domain.abelha.dto.DadosDetalhamentoAbelha;
import modelo.spring.api.domain.abelha.dto.ListaAbelha;
import modelo.spring.api.domain.abelha.model.AbelhaModel;
import modelo.spring.api.domain.abelha.repository.AbelhaRepository;

@RestController				//
@RequestMapping("abelha")	//
@SecurityRequirement(name = "bearer-key")
public class AbelhaController {

	@Autowired	//
	private AbelhaRepository repository;
	
	@PostMapping	//
	@Transactional	//
	public ResponseEntity cadastrar(@RequestBody @Valid AbelhaRecord dados, UriComponentsBuilder uriBuilder) {
		
		var abelha = new AbelhaModel(dados);
				
		repository.save(abelha);
		
		var uri = uriBuilder.path("/abelha/{id}").buildAndExpand(abelha.getId()).toUri();
		
		
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoAbelha(abelha));
		
	}
	
	@GetMapping // ?size=5&page=1&sort=nome,desc
	public ResponseEntity<Page<ListaAbelha>> listar(@PageableDefault(page = 0, size = 5, sort = {"nome"}) Pageable paginacao){
	
		
				
		var page = repository.findAllByAtivoTrue(paginacao).map(ListaAbelha::new);
		
		return ResponseEntity.ok(page);
		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid AbelhaAtualizarRecord dados) {
		
		AbelhaModel abelhaModel = repository.getReferenceById(dados.id());
		
		abelhaModel.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoAbelha(abelhaModel));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id) {
		repository.getReferenceById(id).inativar();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{id}")
	@Secured("ROLE_ADMIN") // Somente tem acesso o perfil ADMIN, existe uma configuração para habilitar esse recurso no arquivo Securityconfigurations
	//A anotação @Secured pode ser adicionada em métodos individuais ou mesmo na classe, que seria o equivalente a adicioná-la em todos os métodos.
	
	// Por padrão esse recurso vem desabilitado no spring Security, sendo que para o utilizar devemos adicionar a seguinte anotação na classe Securityconfigurations do projeto
	public ResponseEntity detalhar(@PathVariable Long id) {
		AbelhaModel abelhaModel = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoAbelha(abelhaModel));
		
	}
	
}
