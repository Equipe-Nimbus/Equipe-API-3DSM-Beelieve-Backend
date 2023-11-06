package com.api.beelieve.repositorio;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.api.beelieve.entidades.projeto.Projeto;
import com.api.beelieve.entidades.projeto.dto.DadosListagemProjeto;
import com.api.beelieve.entidades.projeto.dto.DadosProjetoListagemGeral;
import com.api.beelieve.entidades.projeto.servico.ConversorListagem;

public interface ProjetoRepositorioPaginacao extends PagingAndSortingRepository<Projeto, Long>, JpaSpecificationExecutor<Projeto> {

	public static final ConversorListagem conversorProjeto = new ConversorListagem();
	
	public  default Page<DadosProjetoListagemGeral> gerarPagina(Specification<Projeto> filtragem, Pageable paginaInfo){
		Page<Projeto> paginaProjetos = this.findAll(filtragem, paginaInfo);
		List<DadosProjetoListagemGeral> listaDadosProjeto = new ArrayList<DadosProjetoListagemGeral>();
		
		if(paginaProjetos.getContent() != null) {
			paginaProjetos.getContent().forEach((projeto)->{
				listaDadosProjeto.add(conversorProjeto.converterListagemGeralProjeto(projeto));
			});
		}
		
		Page<DadosProjetoListagemGeral> paginaDto = new PageImpl<DadosProjetoListagemGeral>(listaDadosProjeto, paginaProjetos.getPageable(), paginaProjetos.getTotalElements());
		return paginaDto;
	}
	
	
}
