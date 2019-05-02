package com.pedrodantas.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Estado;
import com.pedrodantas.cursomc.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository ep;
	
	
	public List<Estado> findAll(){
		return ep.findAllByOrderByNome();
	}
}
