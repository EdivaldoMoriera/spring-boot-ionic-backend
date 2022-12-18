package com.valdosm.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.valdosm.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

public PagamentoComBoleto() {
 }

public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
    super(id, estado, pedido);
    this.dataPagamento = dataPagamento;
    this.dataVencimento = dataVencimento;
    
}

public Date getDataVencimento() {
    return dataVencimento;
}

public void setDataVencimento(Date dataVencimento) {
    this.dataVencimento = dataVencimento;
}

public Date getDataPagamento() {
    return dataPagamento;
}

public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
}
 
}