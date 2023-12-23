package br.com.faculdade.boleto.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.faculdade.boleto.entity.Aluno;
import br.com.faculdade.boleto.exception.AlunoException;
import br.com.faculdade.boleto.repository.AlunoRepository;
import br.com.faculdade.boleto.util.Data;

@Service
public class AlunoService {
	
	protected static final String MENSAGEM_LISTA_ALUNOS_VAZIA = "Lista de alunos vazia.";
	protected static final String MENSAGEM_ALUNO_NULO = "Aluno não encontrado.";
	protected static final String MENSAGEM_ID_ALUNO_NAO_ENCONTRADO = "Informe o ID do aluno.";	
	protected static final String MENSAGEM_CURSO_ALUNO_NAO_ENCONTRADO = "Curso não encontrado.";	
	protected static final String MENSAGEM_TURMA_ALUNO_NAO_ENCONTRADO = "Turma não encontrada.";
	protected static final String MENSAGEM_NOME_ALUNO_NAO_INFORMADO = "Informe o nome do aluno.";
	protected static final String MENSAGEM_SEXO_ALUNO_INCORRETO = "Sexo incorreto.";
	protected static final String MENSAGEM_STATUS_ALUNO_INCORRETO = "Status incorreto.";
	protected static final String MENSAGEM_DATA_CADASTRO_ALUNO_NULL = "Data do cadastro não informada.";
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	private Data data;
	
	private LocalDate dataAtual;
	
	public Aluno salvar(Aluno aluno){
		if (aluno == null) {
	        throw new AlunoException(MENSAGEM_ALUNO_NULO);
	    } else if (aluno.getCurso() == null) {
	    	throw new AlunoException(MENSAGEM_CURSO_ALUNO_NAO_ENCONTRADO);
	    }else if (aluno.getCurso().getId() == null) {
	        throw new AlunoException(MENSAGEM_CURSO_ALUNO_NAO_ENCONTRADO);
	    } else if (aluno.getNome() == null || aluno.getNome().isBlank()) {
	        throw new AlunoException(MENSAGEM_NOME_ALUNO_NAO_INFORMADO);
	    }else if (aluno.getStatus() == null) {
	    	throw new AlunoException(MENSAGEM_STATUS_ALUNO_INCORRETO);
	    }
	    dataAtual = data.dataAtual();
	    aluno.setData(dataAtual);
	    return alunoRepository.save(aluno);
	}
}
