package com.pedrodantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Cidade;
import com.pedrodantas.cursomc.repositories.CidadeRepository;
import com.pedrodantas.cursomc.services.exception.ObjectNotFoundException;



@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade find(Integer id) throws ObjectNotFoundException {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID:" + id + " tipo: " + Cidade.class.getName()));
	}

}
