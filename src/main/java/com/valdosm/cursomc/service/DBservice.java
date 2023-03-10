package com.valdosm.cursomc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.domain.Cidade;
import com.valdosm.cursomc.domain.Estado;
import com.valdosm.cursomc.domain.Produto;
import com.valdosm.cursomc.domain.Cliente;
import com.valdosm.cursomc.domain.Endereco;
import com.valdosm.cursomc.domain.ItemPedido;
import com.valdosm.cursomc.domain.Pagamento;
import com.valdosm.cursomc.domain.PagamentoComBoleto;
import com.valdosm.cursomc.domain.PagamentoComCartao;
import com.valdosm.cursomc.domain.Pedido;
import com.valdosm.cursomc.domain.enums.EstadoPagamento;
import com.valdosm.cursomc.domain.enums.TipoCliente;
import com.valdosm.cursomc.repository.CategoriaRepository;
import com.valdosm.cursomc.repository.CidadeRepository;
import com.valdosm.cursomc.repository.ClienteRepository;
import com.valdosm.cursomc.repository.EnderecoRepository;
import com.valdosm.cursomc.repository.EstadoRepository;
import com.valdosm.cursomc.repository.ItemPedidoRepository;
import com.valdosm.cursomc.repository.PagamentoRepository;
import com.valdosm.cursomc.repository.PedidoRepository;
import com.valdosm.cursomc.repository.ProdutoRepository;

@Service
public class DBservice {
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
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public void instantiateTestDatabase() throws ParseException {
        

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");
        Categoria cat3 = new Categoria(null, "Cama, Mesa e banho");
        Categoria cat4 = new Categoria(null, "Jardinagem");
        Categoria cat5 = new Categoria(null, "Perfumaria");
        Categoria cat6 = new Categoria(null, "Ferramentas");
        Categoria cat7 = new Categoria(null, "Eletronicos");
        Categoria cat8 = new Categoria(null, "Decora????o");
        

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);
        Produto p4 = new Produto(null, "Mesa de Escrit??rio", 150.00);
        Produto p5 = new Produto(null, "Toalha", 50.00);
        Produto p6 = new Produto(null, "Colcha", 150.00);
        Produto p7 = new Produto(null, "Abajur", 110.00);
        Produto p8 = new Produto(null, "Shampo", 20.00);
        Produto p9 = new Produto(null, "Ra????o", 53.00);
        Produto p10 = new Produto(null, "Pesca", 20.00);
        Produto p11 = new Produto(null, "ca??a", 53.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat1));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "S??o Paulo");
        Estado est3 = new Estado(null, "Par??");

        Cidade cid1 = new Cidade(null, "Uberlandia", est1);
        Cidade cid2 = new Cidade(null, "S??o Pulo", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);
        Cidade cid4 = new Cidade(null, "Bel??m", est3);

        est1.getCidades().addAll(Arrays.asList(cid1));
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));
        est3.getCidades().addAll(Arrays.asList(cid4));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, cid4));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria.silva@gmail.com",
                "767.305.492-20", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("32142800", "988263653"));

        Cliente cli2 = new Cliente(null, "Edivaldo Moreira", "valdosm.moreira@gmail.com", "123.325.356-20",
                TipoCliente.PESSOAJURIDICA);
        cli2.getTelefones().addAll(Arrays.asList("99976288", "32142858"));

        Endereco e1 = new Endereco(null, "Rua flores", "1258", "santana do Aura", "Aguas brancas", "46640540", cli1,
                cid1);
        Endereco e2 = new Endereco(null, "satos", "125", "flores", "Terra Firme", "798565", cli1, cid2);

        Endereco e3 = new Endereco(null, "Nossa uni??o",
                "08", "liberal", "Terra firme",
                "2524587", cli2, cid4);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
        cli2.getEnderecos().addAll(Arrays.asList(e3));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("20/02/2012 10:22"), cli1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("20/02/2012 10:22"), cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
                null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.0, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.0, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
        ped1.getItens().addAll(Arrays.asList(ip1, ip2));

        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItems().addAll(Arrays.asList(ip1));
        p2.getItems().addAll(Arrays.asList(ip3));
        p3.getItems().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    
}

}