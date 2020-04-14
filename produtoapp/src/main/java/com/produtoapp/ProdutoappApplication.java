package com.produtoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Essa é classe de inicialização, para rodar o projeto deve-se executar esta classe

/* 
 * A seguinte anotação, engloba algumas outras anotações como @EnableAutoConfiguration, que tentam "adivinhar"
 * as configurações necessárias para rodar o projeto
 */ 
@SpringBootApplication
public class ProdutoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutoappApplication.class, args);
	}

}
