package br.itb.projeto.gaiagarden.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.itb.projeto.gaiagarden.model.entity.Produto;
import br.itb.projeto.gaiagarden.service.ProdutoService;

@RestController
@RequestMapping("/produto/")
public class ProdutoController {

	private ProdutoService produtoService;
	
	// Source -> Generate Constructor0s using Fields...
	public ProdutoController(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@GetMapping("findAll")
	public ResponseEntity<List<Produto>> findAll(){
		
		List<Produto> produtos = produtoService.findAll();
		
		return new ResponseEntity<List<Produto>>(
								produtos, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Produto> findById(
			@PathVariable long id){
		
		Produto produto =
				produtoService.findById(id);
		
		return new ResponseEntity<Produto>
					(produto, HttpStatus.OK);
	}
	
	
	@PostMapping("create")
	public ResponseEntity<Produto> create (
					@RequestBody Produto produto){
		System.out.println(produto.getNome());
		Produto _produto = produtoService.create(produto);
		
		return new ResponseEntity<Produto> 
						(_produto, HttpStatus.OK);
	}
	
	@PostMapping("update")
	public ResponseEntity<Produto> update(
			@RequestBody Produto produto){
				  
		Produto _produto = 
				produtoService.update(produto);
		
		System.out.println(_produto.getId());
		
		return new ResponseEntity<Produto>(
				_produto, HttpStatus.OK);
	}
	
}




