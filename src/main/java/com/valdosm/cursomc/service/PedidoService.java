package com.valdosm.cursomc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.ItemPedido;
import com.valdosm.cursomc.domain.PagamentoComBoleto;
import com.valdosm.cursomc.domain.Pedido;
import com.valdosm.cursomc.domain.enums.EstadoPagamento;
import com.valdosm.cursomc.repository.ItemPedidoRepository;
import com.valdosm.cursomc.repository.PagamentoRepository;
import com.valdosm.cursomc.repository.PedidoRepository;
import com.valdosm.cursomc.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private BoletoService boletoService;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    public List<Pedido>findAll(){
        return pedidoRepository.findAll();
    }

     // por id
     public Pedido findById(Integer id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado Id:" + id + ", Tipo:" + Pedido.class.getName()));
    }
     // inserir nova categoria metodo post
     @Transactional
     public Pedido insert(Pedido pedido) {
        pedido.setId(null);
        pedido.setInstante(new Date());
        pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);
        if(pedido.getPagamento()instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
            boletoService.preecherPagamentoComBoleto(pagto, pedido.getInstante() );

        }
        pedido = pedidoRepository.save(pedido);
        pagamentoRepository.save(pedido.getPagamento());
        for(ItemPedido ip : pedido.getItens()){
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.findById(ip.getProduto().getId()).getPreco());
            ip.setPedido(pedido);

        }
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;

    }

    
}
