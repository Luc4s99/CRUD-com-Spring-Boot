package com.produtoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * A seguinte anotação trabalha com classes que possuem métodos que processam requisições em uma aplicação web
 */
@Controller
public class IndexController {

	/*
	 * A seguinte anotação direciona um determinado endereço, passado por parâmetro, para um determinado método,
	 * quando aquele endereço for acessado o método abaixo da anotação será executado. Geralmente utilizado em 
	 * classes com a @Controller 
	 */
	@RequestMapping("/")
	public String index() {
		//return "index";
		return "index.html"; // Retorna o arquivo index.html localizado em src/main/resources/templates
	}
	
}
