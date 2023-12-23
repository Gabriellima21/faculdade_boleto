package br.com.faculdade.boleto.util;

import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class CodigoBoleto {
	
	public static Integer gerarCodigo() {
        Random random = new Random();
        int codigo = random.nextInt();
        return codigo;
    }
}
