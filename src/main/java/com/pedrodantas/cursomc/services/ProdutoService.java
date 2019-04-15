package com.pedrodantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Produto;
import com.pedrodantas.cursomc.repositories.ProdutoRepository;
import com.pedrodantas.cursomc.services.exception.ObjectNotFoundException;



@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado ID:" + id + " tipo: " + Produto.class.getName()));
	}

}
