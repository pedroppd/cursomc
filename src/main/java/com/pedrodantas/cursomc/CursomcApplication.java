package com.pedrodantas.cursomc;

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
import com.pedrodantas.cursomc.domain.Produto;
import com.pedrodantas.cursomc.domain.enums.TipoCliente;
import com.pedrodantas.cursomc.repositories.CategoriaRepository;
import com.pedrodantas.cursomc.repositories.CidadeRepository;
import com.pedrodantas.cursomc.repositories.ClienteRepository;
import com.pedrodantas.cursomc.repositories.EnderecoRepository;
import com.pedrodantas.cursomc.repositories.EstadoRepository;
import com.pedrodantas.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
    
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "informática");
		Categoria cat2 = new Categoria(null, "escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas gerais");
		Estado est2 = new Estado(null, "São paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		Cliente cli1 = new Cliente(null, "maria", "maria@gmail.com", "952365123285", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("975111058", "9888728190"));
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "apto 203", "Jardim", "38220934", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida matos", "105", "sala 800", "centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		
		
		
		
		
		
	}

}

