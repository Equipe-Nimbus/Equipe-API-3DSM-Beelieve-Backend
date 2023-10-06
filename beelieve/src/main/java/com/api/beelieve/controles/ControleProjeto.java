package com.api.beelieve.controles;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.beelieve.entidades.cronograma.Progresso;
import com.api.beelieve.entidades.cronograma.servico.AtualizaEstruturaCronograma;
import com.api.beelieve.entidades.cronograma.servico.CriaCronograma;
import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosArvoreProjetoBox;
import com.api.beelieve.entidades.projeto.dto.DadosArvoreProjetoLigacao;
import com.api.beelieve.entidades.projeto.dto.DadosEstruturaProjetoAtualizacao;
import com.api.beelieve.entidades.projeto.dto.DadosListagemProjeto;
import com.api.beelieve.entidades.projeto.dto.DadosOrcamentoProjeto;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoCadastro;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoListagemGeral;
import com.api.beelieve.entidades.projeto.servico.AtualizaOrcamento;
import com.api.beelieve.entidades.projeto.servico.AtualizarEstruturaProjetoNiveis;
import com.api.beelieve.entidades.projeto.servico.CadastroProjeto;
import com.api.beelieve.entidades.projeto.servico.ClonaDadosEstrutura;
import com.api.beelieve.entidades.projeto.servico.ConversorListagem;
import com.api.beelieve.entidades.projeto.servico.ListaProjetoGeral;
import com.api.beelieve.entidades.projeto.servico.MontarArvoreProjeto;

import com.api.beelieve.repositorio.ProjetoRepositorio;

import jakarta.transaction.Transactional;


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
	private ConversorListagem conversorListagem;
	
	@Autowired
	private CadastroProjeto cadastraProjeto;
	
	@Autowired
	private ClonaDadosEstrutura clonaDadosEstrutura;
	
	@Autowired
	private MontarArvoreProjeto arvoreProjeto;
	
	@PostMapping("/cadastrar")
	@Transactional
	public void cadastrar(@RequestBody DadosProjetoCadastro projeto) {
		Projeto projetoCadastrado = cadastraProjeto.cadastrarCascata(projeto);
		if (projeto.prazo_meses() != null) {
			criaCronograma.criarCronograma(projetoCadastrado, projeto.prazo_meses());
		}
		else {
			criaCronograma.criarCronograma(projetoCadastrado, 6);
		}
		
	}
	
	
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
	public ResponseEntity<List<Progresso>> atualizarEstrutura(@RequestBody DadosEstruturaProjetoAtualizacao dadosAtualizacao){
		DadosEstruturaProjetoAtualizacao dadosClone = clonaDadosEstrutura.clonar(dadosAtualizacao);
		List<Progresso> listaNovosNiveis = atualizaEstruturaProjeto.atualizarProjeto(dadosAtualizacao.id_projeto(), dadosAtualizacao);
		atualizaEstruturaCronograma.atualizaEstrutura(dadosClone, listaNovosNiveis);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/atualizar/orcamento")
	@Transactional
	public ResponseEntity<DadosListagemProjeto> atualizarOrcamento(@RequestBody DadosOrcamentoProjeto dadoOrcamentoProduto){
		atualizaOrcamento.atualizaOrcamento(dadoOrcamentoProduto);
		DadosListagemProjeto projetoAtualizado = repositorio_projeto.acharProjeto(dadoOrcamentoProduto.id_projeto());
		return ResponseEntity.ok(projetoAtualizado);
	}
}
