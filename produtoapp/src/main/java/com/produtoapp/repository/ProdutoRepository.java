package com.produtoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.produtoapp.model.Produto;

//Deve ser passado "Long" e não "long" pois tipos primitivos não são aceitos em declarações de tipo genérico
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	Produto findById(long id);
}
