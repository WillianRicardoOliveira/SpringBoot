package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import modelo.spring.api.domain.produto.dto.ListaProduto;
import modelo.spring.api.domain.produto.repository.ProdutoRepository;



@RestController
@RequestMapping("produto")
@SecurityRequirement(name = "bearer-key")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	/*
	 * 
	 */
	
	@GetMapping
	public ResponseEntity<Page<ListaProduto>> listar(@PageableDefault(page = 0, size = 5, sort = {"nome"}) Pageable paginacao){
			
		var page = repository.findAllByAtivoTrue(paginacao).map(ListaProduto::new);
		
		return ResponseEntity.ok(page);
		
	}
	
	
	
	
	
	
	
	
	
	
	/*
	@PostMapping	//
	@Transactional	//
	public ResponseEntity cadastrar(@RequestBody @Valid AbelhaRecord dados, UriComponentsBuilder uriBuilder) {
		
		var abelha = new AbelhaModel(dados);
				
		repository.save(abelha);
		
		var uri = uriBuilder.path("/abelha/{id}").buildAndExpand(abelha.getId()).toUri();
		
		
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoAbelha(abelha));
		
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
	*/
}
