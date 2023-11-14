package com.api.beelieve.controles;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.analista_projeto.servico.AtribuiAnalista;
import com.api.beelieve.entidades.cronograma.Progresso;
import com.api.beelieve.entidades.cronograma.servico.AtualizaEstruturaCronograma;
import com.api.beelieve.entidades.cronograma.servico.CriaCronograma;
import com.api.beelieve.entidades.cronograma.servico.DeletaCronograma;
import com.api.beelieve.entidades.cronograma.servico.InicializacaoMesesCronograma;
import com.api.beelieve.entidades.data.DataAtualAplicacao;
import com.api.beelieve.entidades.projeto.FiltroProjeto;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosEstruturaProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.dto.DadosListagemProjeto;
import com.api.beelieve.entidades.projeto.dto.DadosOrcamentoProjeto;

import com.api.beelieve.entidades.projeto.dto.DadosProjetoCadastro;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoListagemGeral;
import com.api.beelieve.entidades.projeto.dto.DateInicializaProjeto;
import com.api.beelieve.entidades.projeto.servico.AtualizaOrcamento;
import com.api.beelieve.entidades.projeto.servico.AtualizarEstruturaProjetoNiveis;
import com.api.beelieve.entidades.projeto.servico.CadastroProjeto;
import com.api.beelieve.entidades.projeto.servico.ClonaDadosEstrutura;
import com.api.beelieve.entidades.projeto.servico.ConversorListagem;
import com.api.beelieve.entidades.projeto.servico.DeleteProjeto;
import com.api.beelieve.entidades.projeto.servico.InicializaProjeto;
import com.api.beelieve.entidades.projeto.servico.ListaProjetoGeral;
import com.api.beelieve.entidades.projeto.servico.MontarArvoreProjeto;
import com.api.beelieve.entidades.usuario.FiltroUsuario;
import com.api.beelieve.entidades.usuario.Usuario;
import com.api.beelieve.entidades.usuario.dto.DadosAtribuicaoAnalista;
import com.api.beelieve.repositorio.ProjetoRepositorio;
import com.api.beelieve.repositorio.ProjetoRepositorioPaginacao;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


@RestController
@RequestMapping("/projeto")
public class ControleProjeto {
	
	@Autowired
	private ProjetoRepositorio repositorio_projeto;
	
	@Autowired
	private AtualizaOrcamento atualizaOrcamento;
	
	@Autowired
	private ListaProjetoGeral listaProjetoGeral;
	
	@Autowired
	private CriaCronograma criaCronograma;
	
	@Autowired
	private AtualizaEstruturaCronograma atualizaEstruturaCronograma;

	@Autowired
	private AtualizarEstruturaProjetoNiveis atualizaEstruturaProjeto;
	
	@Autowired
	private AtribuiAnalista atibuiAnalista;
	
	@Autowired
	private ConversorListagem conversorListagem;
	
	@Autowired
	private CadastroProjeto cadastraProjeto;
	
	@Autowired
	private ClonaDadosEstrutura clonaDadosEstrutura;
	
	@Autowired
	private MontarArvoreProjeto arvoreProjeto;
	
	@Autowired
	private DeletaCronograma deletaCronograma;
	
	@Autowired
	private DeleteProjeto deletaProjeto;
	
	@Autowired
	private InicializacaoMesesCronograma inicializacaoCronograma;
	
	@Autowired
	private InicializaProjeto service;
	
	@Autowired
	private DataAtualAplicacao dataAtualAplicacao;
	
	@Autowired
	private ProjetoRepositorioPaginacao repositorio_projeto_paginado;
	
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<String> cadastrar(@RequestBody DadosProjetoCadastro projeto) {
		Projeto consultaProjetoNome = repositorio_projeto.findByNomeProjeto(projeto.nome_projeto());
		if(consultaProjetoNome != null) {
			return ResponseEntity.badRequest().body("Já existe um projeto com esse nome!");
		} else {
			Projeto projetoCadastrado = cadastraProjeto.cadastrarCascata(projeto);
			if (projeto.prazo_meses() != null) {
				criaCronograma.criarCronograma(projetoCadastrado, projeto.prazo_meses());
			}
			else {
				criaCronograma.criarCronograma(projetoCadastrado, 6);
			}
			return ResponseEntity.ok().build();
		}		
	}
	
	@PostMapping("/atribuir/analista")
	@Transactional
	public ResponseEntity atribuirAnalista(@RequestBody DadosAtribuicaoAnalista atribuicaoAnalista) {
		atibuiAnalista.atribuir(atribuicaoAnalista);
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/lista/paginada")
	public ResponseEntity<Page<DadosProjetoListagemGeral>> listaPaginada(
			@RequestParam Map<String, String> filtro,
			Pageable infoPaginacao){
		FiltroProjeto filtroProjeto = new FiltroProjeto(filtro);
		Page<DadosProjetoListagemGeral> paginacao = 
				repositorio_projeto_paginado.gerarPagina(filtroProjeto.toSpec(), infoPaginacao);
		return ResponseEntity.ok(paginacao);
	};
	
	
	@GetMapping("/listar")
	public ResponseEntity<List<DadosProjetoListagemGeral>> listar() {
		List<Projeto> listaProjeto = repositorio_projeto.findAll();
		List<DadosProjetoListagemGeral> listaProjetoModificada = listaProjetoGeral.listarProjetos(listaProjeto);
		return ResponseEntity.ok(listaProjetoModificada);
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<DadosListagemProjeto> listarId(@PathVariable Long id){
		DadosListagemProjeto projeto = repositorio_projeto.acharProjeto(id);
		//List<DadosArvoreProjetoBox> nodes = arvoreProjeto.arvoreProjetoBox(projeto);
		//List<DadosArvoreProjetoLigacao> edges = arvoreProjeto.arvoreProjetoLigacao(projeto);
		//List<Object> listaProjetoMaisArvore = new ArrayList<Object>();
		//listaProjetoMaisArvore.add(projeto);
		//listaProjetoMaisArvore.add(nodes);
		//listaProjetoMaisArvore.add(edges);

		return ResponseEntity.ok(projeto);
	};
	
	@PutMapping("/atualizar/estrutura")
	@Transactional
	public ResponseEntity<String> atualizarEstrutura(@RequestBody DadosEstruturaProjetoAtualizacao dadosAtualizacao){
		Projeto consultaProjetoNome = repositorio_projeto.findByNomeProjeto(dadosAtualizacao.nome_projeto());
		if (consultaProjetoNome != null) {
			return ResponseEntity.badRequest().body("Já existe um projeto com esse nome!");
		} 
		else {
			DadosEstruturaProjetoAtualizacao dadosClone = clonaDadosEstrutura.clonar(dadosAtualizacao);
			List<Progresso> listaNovosNiveis = atualizaEstruturaProjeto.atualizarProjeto(dadosAtualizacao.id_projeto(), dadosAtualizacao);
			atualizaEstruturaCronograma.atualizaEstrutura(dadosClone, listaNovosNiveis);
			return ResponseEntity.ok().build();
		}
	}
	
	@PutMapping("/atualizar/orcamento")
	@Transactional
	public ResponseEntity<DadosListagemProjeto> atualizarOrcamento(@RequestBody DadosOrcamentoProjeto dadoOrcamentoProduto){
		atualizaOrcamento.atualizaOrcamento(dadoOrcamentoProduto);
		DadosListagemProjeto projetoAtualizado = repositorio_projeto.acharProjeto(dadoOrcamentoProduto.id_projeto());
		return ResponseEntity.ok(projetoAtualizado);
	}
	
	@PostMapping("/{id}/iniciarprojeto")
	@Transactional
	public ResponseEntity<String> inicializaProjeto(@PathVariable Long id, @RequestBody DateInicializaProjeto projectStartDate) {
		Set<ConstraintViolation<DateInicializaProjeto>> violations = validator.validate(projectStartDate);
		for(var violation : violations) {
			return ResponseEntity.badRequest().body(violation.getMessage());
		}
		
		try {
			Calendar dataFront = Calendar.getInstance();
			Calendar dataBack = Calendar.getInstance();
			var formatter = new SimpleDateFormat("MM-yyyy");
			dataFront.setTime(formatter.parse(projectStartDate.data_inicio_projeto()));
			dataBack.setTime(dataAtualAplicacao.data);
			if((dataBack.get(Calendar.MONTH) == dataFront.get(Calendar.MONTH)) && (dataBack.get(Calendar.YEAR) == dataFront.get(Calendar.YEAR))) {
				var date = service.setaData(id, projectStartDate.data_inicio_projeto());
				inicializacaoCronograma.inicializarCronograma(formatter.parse(projectStartDate.data_inicio_projeto()), id);
				if (date.isEmpty()) {
					ResponseEntity.internalServerError().build();
				}
				return ResponseEntity.ok(date.get());
			}
			else {
				Projeto foundProject = repositorio_projeto.findById(id).get();
				foundProject.setData_inicio_projeto(dataAtualAplicacao.data);
				inicializacaoCronograma.inicializarCronograma(dataAtualAplicacao.data, id);
				repositorio_projeto.save(foundProject);
				return ResponseEntity.ok(formatter.format(dataAtualAplicacao.data));
			}	
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	@Transactional
	public ResponseEntity<?> deletarProjetoPorId(@PathVariable Long id) {
		Projeto projetoEscolhido = repositorio_projeto.findById(id).get();
		Long idProjetoEscolhido = projetoEscolhido.getId_projeto();
		deletaCronograma.deletar(idProjetoEscolhido);
		deletaProjeto.deleteCascata(projetoEscolhido);
		return ResponseEntity.ok().build();
	}
}

