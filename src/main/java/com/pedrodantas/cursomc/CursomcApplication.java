package com.pedrodantas.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedrodantas.cursomc.domain.Categoria;
import com.pedrodantas.cursomc.domain.Cidade;
import com.pedrodantas.cursomc.domain.Cliente;
import com.pedrodantas.cursomc.domain.Endereco;
import com.pedrodantas.cursomc.domain.Estado;
import com.pedrodantas.cursomc.domain.ItemPedido;
import com.pedrodantas.cursomc.domain.Pagamento;
import com.pedrodantas.cursomc.domain.PagamentoComBoleto;
import com.pedrodantas.cursomc.domain.PagamentoComCartao;
import com.pedrodantas.cursomc.domain.Pedido;
import com.pedrodantas.cursomc.domain.Produto;
import com.pedrodantas.cursomc.domain.enums.EstadoPagamento;
import com.pedrodantas.cursomc.domain.enums.TipoCliente;
import com.pedrodantas.cursomc.repositories.CategoriaRepository;
import com.pedrodantas.cursomc.repositories.CidadeRepository;
import com.pedrodantas.cursomc.repositories.ClienteRepository;
import com.pedrodantas.cursomc.repositories.EnderecoRepository;
import com.pedrodantas.cursomc.repositories.EstadoRepository;
import com.pedrodantas.cursomc.repositories.ItemPedidoRepository;
import com.pedrodantas.cursomc.repositories.PagamentoRepository;
import com.pedrodantas.cursomc.repositories.PedidoRepository;
import com.pedrodantas.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
    
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}

