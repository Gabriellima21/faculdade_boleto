package br.com.faculdade.boleto.kafka.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConsumerConfiguration {
	
	 	@Value("${spring.kafka.bootstrap-servers}")
	    private String bootstrapServers;

	    @Value("${spring.kafka.consumer.group-id}")
	    private String groupId;

	    @Value("${spring.kafka.consumer.auto-offset-reset}")
	    private String autoOffsetReset;

	    @Bean
	    public KafkaConsumer<String, String> kafkaConsumer() { //cria e configura o consumidor Kafka.Metodo do tipo KafkaConsumer 
	        Map<String, Object> consumerPropriedades = new HashMap<>();
	        consumerPropriedades.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);//propriedade 
	        consumerPropriedades.put(ConsumerConfig.GROUP_ID_CONFIG, groupId); //consumidor Kafka com o valor obtido da propriedade 
	        consumerPropriedades.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);

	        return new KafkaConsumer<>(consumerPropriedades);
	    }

}
