package br.com.faculdade.boleto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.faculdade.boleto.entity.Aluno;
import br.com.faculdade.boleto.entity.Boleto;
import br.com.faculdade.boleto.kafka.consumer.AlunoConsumer;
import br.com.faculdade.boleto.service.BoletoService;

@RestController
@RequestMapping(path = "boleto")
public class BoletoController {
	
	@Autowired
	private BoletoService boletoService;
    @Autowired
    private AlunoConsumer alunoConsumer;
    
    

    @PostMapping
    public Boleto criar(Boleto boleto) {
    	// Chama o serviço para criar o boleto
        Boleto boletoRetornado = boletoService.criar(boleto);

        // Simula uma chamada ao endpoint do consumidor Kafka usando RestTemplate
        alunoConsumer.chamarKafka(boletoRetornado);

        return boletoRetornado;
    }
}
