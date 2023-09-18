package com.api.beelieve.controles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.api.beelieve.entidades.nivelsubprojeto.DadosNivelSubProjetoCadastro;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.subprojeto.DadosSubProjetoCadastro;
import com.api.beelieve.entidades.subprojeto.SubProjeto;
import com.api.beelieve.entidades.tarefa.DadosTarefaCadastro;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.SubProjetoRepositorio;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureJsonTesters
@ActiveProfiles("test")
class ControleNivelSubProjetoTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private JacksonTester<DadosSubProjetoCadastro> json;
	
	@Autowired
	private SubProjetoRepositorio repositorio_subprojeto;
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Test
	void cadastrarTeste() throws Exception {
		repositorio_projeto.deleteAll();
		repositorio_projeto.save(new Projeto());
		List<DadosNivelSubProjetoCadastro> listaNivel = null;
		List<DadosTarefaCadastro> listaTarefa = null;
		Date prazo = new Date();
		DadosSubProjetoCadastro subProjetoACadastrar = new DadosSubProjetoCadastro(Long.valueOf(1), "Bateria", "Calos", prazo, 0.0, BigDecimal.valueOf(1000), BigDecimal.valueOf(10000), listaNivel, listaTarefa);
		MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/sub_projeto/cadastrar")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(subProjetoACadastrar).getJson())
				).andReturn().getResponse();
		
		System.out.println(response.getContentAsString());

	}

}
