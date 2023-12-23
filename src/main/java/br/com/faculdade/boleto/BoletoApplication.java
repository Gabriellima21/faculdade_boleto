package br.com.faculdade.boleto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BoletoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoletoApplication.class, args);
	}

}
