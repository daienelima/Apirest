package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@CrossOrigin
	@GetMapping("/produto")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	
	@CrossOrigin
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto por id")
	public Produto listaProdutoUnico(@PathVariable(value="id")long id){
		return produtoRepository.findById(id);
	}

	@CrossOrigin
	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@CrossOrigin
	@DeleteMapping("/produto")
	@ApiOperation(value="Delete produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@CrossOrigin
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
