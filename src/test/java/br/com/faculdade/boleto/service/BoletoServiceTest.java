package br.com.faculdade.boleto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.faculdade.boleto.entity.Aluno;
import br.com.faculdade.boleto.entity.Boleto;
import br.com.faculdade.boleto.exception.BoletoException;
import br.com.faculdade.boleto.repository.BoletoRepository;
import br.com.faculdade.boleto.util.Data;

@ExtendWith(MockitoExtension.class)
public class BoletoServiceTest {
	
	@Mock
	private BoletoRepository boletoRepository;
	@InjectMocks
	private BoletoService boletoService;
	@Autowired
	private Data data;
	private LocalDate dataAtual = LocalDate.now(); // pego a data atual
	private LocalDate dataMaxima = dataAtual.plusMonths(1);
	
	@Test
	public void testCriarBoletoComAlunoNull() {
		Boleto b = new Boleto();
		b.setAluno(null); 
		assertThrows(BoletoException.class, 
				() -> boletoService.criar(b));
	}
	@Test
	public void testCriarBoletoComAlunoIdNull() {
		Boleto b = new Boleto();
		Aluno a = new Aluno();
		a.setId(null);
		b.setAluno(a);
		assertThrows(BoletoException.class, 
				() -> boletoService.criar(b));
	}
	@Test
	public void testCriarBoletoDataVencNull() {
		Boleto b = new Boleto();
		b.setDataVencimento(null);
		assertThrows(BoletoException.class, 
				() -> boletoService.criar(b));
	}
	
	@Test
	public void testCriarBoletoDataVencMenorQueAtual() {
		Boleto b = new Boleto();
		//b.setDataVencimento().is;
		assertThrows(BoletoException.class, 
				() -> boletoService.criar(b));
	}
	@Test
	public void testCriarBoletoComValorNaoExistente() {
		Boleto b = new Boleto();
		b.setValor(-1);
		assertThrows(BoletoException.class, 
				() -> boletoService.criar(b));
	}
	@Test
	public void testCriar() {
		Boleto b = new Boleto();
		Aluno a = new Aluno();
		LocalDate d = data.dataAtual();
		a.setId(1);
		b.setAluno(a);
		b.setDataVencimento(d);
		b.setPago(false);
		b.setValor(100);
		Boleto boletoEsperado = new Boleto();
		Aluno a2 = new Aluno();
		LocalDate d2 = data.dataAtual();
		a2.setId(1);
		boletoEsperado.setAluno(a);
		boletoEsperado.setDataVencimento(d);
		boletoEsperado.setPago(false);
		boletoEsperado.setValor(100);
		Mockito.when(boletoService.criar(boletoEsperado)).thenReturn(boletoEsperado);
		
		Boleto boletoRetornado = boletoService.criar(b);
		
		assertEquals(boletoEsperado, boletoRetornado);
	}

}
