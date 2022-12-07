package com.valdosm.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.domain.Cidade;
import com.valdosm.cursomc.domain.Cliente;
import com.valdosm.cursomc.domain.Endereco;
import com.valdosm.cursomc.domain.Estado;
import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.domain.enums.TipoCliente;
import com.valdosm.cursomc.repository.CategoriaRepository;
import com.valdosm.cursomc.repository.CidadeRepository;
import com.valdosm.cursomc.repository.ClienteRepository;
import com.valdosm.cursomc.repository.EnderecoRepository;
import com.valdosm.cursomc.repository.EstadoRepository;
import com.valdosm.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

	    Cidade cid1 = new Cidade(null, "Uberlandia", est1 );
		Cidade cid2 = new Cidade(null, "São Pulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria.silva@gmail.com","767.305.492-20", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32142800", "988263653"));

		Endereco e1 = new Endereco(null, "Rua flores", "1258", "santana do Aura", "Aguas brancas", "46640540", cli1, cid1);
		Endereco e2 = new Endereco(null, "satos", "125", "flores", "Terra Firme", "798565", cli1, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));


		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

			
		
	
	}

}
