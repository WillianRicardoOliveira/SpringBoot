package modelo.spring.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import modelo.spring.api.domain.agendamento.dto.DadosAgendamento;
import modelo.spring.api.domain.agendamento.dto.DadosDetalhamentoAgendamento;
import modelo.spring.api.domain.agendamento.service.AgendamentoService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class AgendamentoControllerTest {

	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosAgendamento> dadosAgendamentoJson;
	
	@Autowired
	private JacksonTester<DadosDetalhamentoAgendamento> dadosDetalhamentoAgendamentoJson;
	
	
	@Autowired
	private AgendamentoService agendamentoService;
	
	@MockBean
	private DadosAgendamento dadosAgendamento;
	
	@Test
	@DisplayName("Deveria devolver código http 400 quando informações estão inválidas")
	@WithMockUser
	void agendar_cenario1() throws Exception {
		
		var response = mvc.perform(post("/agendamento")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
		
	}
	
	@Test
	@DisplayName("Deveria devolver código http 200 quando informações estão sválidas")
	@WithMockUser
	void agendar_cenario2() throws Exception {
		/*
		var data = LocalDateTime.now().plusHours(1);
	//	var especialidade = Especialidade.CRIADOR;
		
		var dadosDetalhamentoAgendamento = new DadosDetalhamentoAgendamento(null, 1l, 1l, data);
		when(agendamentoService.agendar(any())).thenReturn(dadosDetalhamentoAgendamento);
		
		var response = mvc.perform(
				post("/agendamento")
				.contentType(MediaType.APPLICATION_JSON)
				.content(dadosAgendamentoJson.write(
							new DadosAgendamento(1l, 1l, data)
						).getJson())
				).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		
		
		var jsonEsperado = dadosDetalhamentoAgendamentoJson.write(
				
				
				
				dadosDetalhamentoAgendamento
				).getJson();
		
		assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
		*/
	}
	
}
