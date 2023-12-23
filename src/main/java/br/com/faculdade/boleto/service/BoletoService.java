package br.com.faculdade.boleto.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.faculdade.boleto.entity.Boleto;
import br.com.faculdade.boleto.exception.BoletoException;
import br.com.faculdade.boleto.repository.BoletoRepository;
import br.com.faculdade.boleto.util.CodigoBoleto;

@Service
public class BoletoService {
	
	protected static final String MENSAGEM_ALUNO_NAO_EXISTENTE = "Aluno não existe.";
	protected static final String MENSAGEM_DATA_VENCIMENTO_NAO_EXISTENTE = "Data de vencimento não informada.";
	protected static final String MENSAGEM_DATA_INFERIOR = "A Data de vencimento é inferior a data atual.";
	protected static final String MENSAGEM_DATA_LIMITE = "O boleto só pode ser gerado com até um mês de diferença da data atual.";
	protected static final String MENSAGEM_VALOR_NAO_EXISTENTE = "Valor do boleto não informado.";
	
	@Autowired
	private BoletoRepository boletoRepository;
	@Autowired
	private CodigoBoleto codBoleto;
	
	public Boleto criar (Boleto boleto) {
        LocalDate dataAtual = LocalDate.now(); // pego a data atual
        LocalDate dataMaxima = dataAtual.plusMonths(1); // Verifica se a data do boleto esta no prazo de no max 1 mes
		if(boleto.getAluno()== null || boleto.getAluno().getId() == null) {
			throw new BoletoException(MENSAGEM_ALUNO_NAO_EXISTENTE);
		} else if (boleto.getDataVencimento().isBefore(dataAtual)) {
			throw new BoletoException(MENSAGEM_DATA_INFERIOR);
		} else if (boleto.getDataVencimento().isAfter(dataMaxima)) {
			throw new BoletoException(MENSAGEM_DATA_LIMITE);
		}else if(boleto.getDataVencimento() == null) {
			throw new BoletoException( MENSAGEM_DATA_VENCIMENTO_NAO_EXISTENTE );
		}
		int codigo = codBoleto.gerarCodigo();
		boleto.setCodigo(codigo);
		boleto.setPago(false);
		if(boleto.getValor() < 0) {
			throw new BoletoException(MENSAGEM_VALOR_NAO_EXISTENTE);
		}
		return boletoRepository.save(boleto);
	}
}
