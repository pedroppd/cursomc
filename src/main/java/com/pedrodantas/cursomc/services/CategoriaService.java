package com.pedrodantas.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Categoria;
import com.pedrodantas.cursomc.repositories.CategoriaRepository;
import com.pedrodantas.cursomc.services.exception.DataIntegrityException;
import com.pedrodantas.cursomc.services.exception.ObjectNotFoundException;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID:" + id + " tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
			find(id);
			categoriaRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possuí produtos !");
		}
	}
	
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	

}
