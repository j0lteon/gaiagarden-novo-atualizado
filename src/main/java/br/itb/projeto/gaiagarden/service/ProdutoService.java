package br.itb.projeto.gaiagarden.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.gaiagarden.model.entity.Produto;
import br.itb.projeto.gaiagarden.model.repository.ProdutoRepository;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		super();
		this.produtoRepository = produtoRepository;
	}
	
	public List<Produto> findAll(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
	public Produto findById(long id) {
		Produto produto = produtoRepository.findById(id).orElseThrow();
		return produto;
	}
	
	@Transactional
	public Produto create(Produto produto) {
		
		produto.setStatusProd("ATIVO");
		
		return produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto update(Produto produto) {
		
		return produtoRepository.save(produto);
	}
	
}







