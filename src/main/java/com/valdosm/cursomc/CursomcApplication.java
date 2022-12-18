package com.valdosm.cursomc;

import java.text.SimpleDateFormat;
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
import com.valdosm.cursomc.domain.Pagamento;
import com.valdosm.cursomc.domain.PagamentoComBoleto;
import com.valdosm.cursomc.domain.PagamentoComCartao;
import com.valdosm.cursomc.domain.Pedido;
import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.domain.enums.EstadoPagamento;
import com.valdosm.cursomc.domain.enums.TipoCliente;
import com.valdosm.cursomc.repository.CategoriaRepository;
import com.valdosm.cursomc.repository.CidadeRepository;
import com.valdosm.cursomc.repository.ClienteRepository;
import com.valdosm.cursomc.repository.EnderecoRepository;
import com.valdosm.cursomc.repository.EstadoRepository;
import com.valdosm.cursomc.repository.PagamentoRepository;
import com.valdosm.cursomc.repository.PedidoRepository;
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
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;

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
		Estado est3 = new Estado(null, "Pará");

	    Cidade cid1 = new Cidade(null, "Uberlandia", est1 );
		Cidade cid2 = new Cidade(null, "São Pulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		Cidade cid4 = new Cidade(null, "Belém", est3);

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		est3.getCidades().addAll(Arrays.asList(cid4));


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria.silva@gmail.com",
		"767.305.492-20", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("32142800", "988263653"));

		Cliente cli2 = new Cliente(null, "Edivaldo Moreira", "valdosm.moreira@gmail.com","123.325.356-20", TipoCliente.PESSOAJURIDICA);
		cli2.getTelefones().addAll(Arrays.asList("99976288", "32142858"));



		Endereco e1 = new Endereco(null, "Rua flores", "1258", "santana do Aura", "Aguas brancas", "46640540", cli1, cid1);
		Endereco e2 = new Endereco(null, "satos", "125", "flores", "Terra Firme", "798565", cli1, cid2);

		Endereco e3 = new Endereco(null, "Nossa união",
		 "08", "liberal", "Terra firme",
		 "2524587", cli2, cid4);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));


		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	Pedido ped1  = new Pedido(null, sdf.parse("20/02/2012 10:22"), cli1, e1);	
	Pedido ped2  = new Pedido(null, sdf.parse("20/02/2012 10:22"), cli1, e2);	
	
	Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
	ped1.setPagamento(pagto1);

	Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,sdf.parse("20/10/2017 00:00"), null);
	ped2.setPagamento(pagto2);

	cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

	pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
	pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

	

		
	
	}

}
