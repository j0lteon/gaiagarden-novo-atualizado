package br.itb.projeto.gaiagarden.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.itb.projeto.gaiagarden.model.entity.Categoria;
import br.itb.projeto.gaiagarden.model.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService {
	
	private CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
		
	public List<Categoria> findAll(){
		List<Categoria> categorias = 
				categoriaRepository.findAll();
		return categorias;
	}

	public Categoria findById(long id) {
		Categoria categoria = 
				categoriaRepository.findById(id)
					.orElseThrow();
		return categoria;
	}
	
	//jakarta.transaction.Transactional
	@Transactional
	public Categoria create (Categoria categoria) {
		
		return categoriaRepository.save(categoria);
	}
	
}







