package com.produtos.apirest.resources;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;


@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Optional<Produto> listaProdutos(@PathVariable (value = "id") long id) { return produtoRepository.findById(id); }

	@PostMapping("/produto")
	public Produto adicionaProduto(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}

	}


	

