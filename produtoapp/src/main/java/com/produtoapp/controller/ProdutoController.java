package com.produtoapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.produtoapp.model.Produto;
import com.produtoapp.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	/*
	 * A seguinte anotação é utilizada para demarcar o ponto de injeção da classe 
	 */
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.GET)
	public String form() {
		return "produto/formProduto.html";
	}
	
	/*
	 * A anotação @Valid indica que o objeto será validado de acordo com as anotações dos campos do mesmo 
	 * Receberá o produto por parametro, quando uma requisição POST for feita na URL determinada
	 */
	@RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
	public String form(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarProduto";
		}
		produtoRepository.save(produto);
		redirectAttributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return "redirect:/verProdutos";
	}
	
	//Método para atualizar registros
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String editarProduto(@Valid Produto produto) {
		/*
		 * O método save serve tanto para salvar quanto para atualizar, se o registro já possuir um id, ele é atualizado automaticamente, senão ele é salvo
		 */
		produtoRepository.save(produto);
		return "redirect:/verProdutos";
	}
	
	//Método para deletar registros
	@RequestMapping("/deletar")
	public String deletarProduto(long id) {
		produtoRepository.deleteById(id);
		return "redirect:/verProdutos";
	}
	
	//Método para ver os registros
	@RequestMapping("/verProdutos")
	public ModelAndView listaProdutos() {
		ModelAndView modelAndView = new ModelAndView("produto/formProdutos.html");
		Iterable<Produto> produtos = produtoRepository.findAll(); //Procura por todos os produtos  registradosno banco
		modelAndView.addObject("produtos", produtos); //Através de um método o ModelAndView adiciona todos os valores encontrados em uma variável produtos em formProdutos.html
		return modelAndView;
	}
	
	/*
	 * A anotação PathVariable indica que alguma informação será passada pela URL, não como um parâmetro após o ?, mas sim como parte da própria URL
	 */
	@RequestMapping("/{id}")
	public ModelAndView infoProduto(@PathVariable("id") long id) {
		Produto produto = produtoRepository.findById(id);
		ModelAndView modelAndView = new ModelAndView("produto/infoProduto.html");
		modelAndView.addObject("produto", produto);
		return modelAndView;
	}
}
