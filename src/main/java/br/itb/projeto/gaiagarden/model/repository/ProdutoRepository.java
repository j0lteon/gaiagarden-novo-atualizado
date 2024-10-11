package br.itb.projeto.gaiagarden.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.itb.projeto.gaiagarden.model.entity.Produto;

@Repository
public interface ProdutoRepository extends 
					JpaRepository<Produto, Long> {
	
}









