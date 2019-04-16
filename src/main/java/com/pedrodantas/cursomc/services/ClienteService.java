package com.pedrodantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Cliente;
import com.pedrodantas.cursomc.repositories.ClienteRepository;
import com.pedrodantas.cursomc.services.exception.ObjectNotFoundException;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente find(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrado ID:" + id + " tipo: " + Cliente.class.getName()));
	}
	

}
