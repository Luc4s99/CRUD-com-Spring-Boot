package com.produtoapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

/*
 * A seguinte anotação indica que esta classe representa uma entidade no banco de dados 
 */
@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/*
	 * A seguinte anotação especifica qual é o identificador da entidade 
	 */
	@Id
	
	/*
	 * A anotação @GeneratedValue define que o identificador será um valor gerado, neste caso será automático
	 * A anotação @NotNull define que o campo que ela anota não pode possuir valor nulo 
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private float preco;
	
	@NotNull
	private String marca;
	
	private String descricao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", marca=" + marca + ", descricao=" + descricao + "]";
	}
}
