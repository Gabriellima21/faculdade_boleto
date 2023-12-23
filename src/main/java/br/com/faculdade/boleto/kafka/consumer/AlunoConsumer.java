package br.com.faculdade.boleto.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.faculdade.boleto.entity.Aluno;
import br.com.faculdade.boleto.entity.Boleto;
import br.com.faculdade.boleto.service.AlunoService;

@Component
public class AlunoConsumer {

    @Autowired
    private AlunoService alunoService;
    private ObjectMapper objectMapper = new ObjectMapper();
    

    @Value("${topico.aluno}")
    private String topico;

    @KafkaListener(topics = "${requisicao.aluno}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumirMensagemAluno(ConsumerRecord<String, String> consumerRecord) throws JsonMappingException, JsonProcessingException { //ConsumerRecord registro consumido de um tópico Kafka. 
        // Processar a mensagem recebida do Kafka
        String mensagem = consumerRecord.value(); //retorna o valor da mensagem como uma string.//
        
        Aluno aluno = objectMapper.readValue(mensagem, Aluno.class);
        
        alunoService.salvar(aluno);
    }
    
    public void chamarKafka(Boleto boleto) {
        RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForEntity(topico, boleto, Void.class); //URI (topico),Request Object (boleto): O objeto ,Response Type (Void.class).
    }
}
