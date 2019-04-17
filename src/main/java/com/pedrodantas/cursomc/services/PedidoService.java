package com.pedrodantas.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrodantas.cursomc.domain.Pedido;
import com.pedrodantas.cursomc.repositories.PedidoRepository;
import com.pedrodantas.cursomc.services.exception.ObjectNotFoundException;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido find(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado ID:" + id + " tipo: " + Pedido.class.getName()));
	}

}
