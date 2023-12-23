package br.com.faculdade.boleto.util;

import java.time.LocalDate;

public class Data {
	
	 public static LocalDate dataAtual() {
		  	LocalDate dataAtual = LocalDate.now();
			return dataAtual;
	  }
}
