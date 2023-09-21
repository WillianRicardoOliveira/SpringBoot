package modelo.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.domain.agendamento.dto.DadosCancelamentoAgendamento;
import modelo.spring.api.domain.agendamento.service.AgendamentoService;

@RestController
@RequestMapping("agendamento")
@SecurityRequirement(name = "bearer-key")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity agendar(@RequestBody @Valid DadosAgendamento dados) {
		return ResponseEntity.ok(agendamentoService.agendar(dados));		
	}

	@DeleteMapping
	@Transactional
	public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoAgendamento dados) {
		agendamentoService.cancelar(dados);
	    return ResponseEntity.noContent().build();
	}
	
}
