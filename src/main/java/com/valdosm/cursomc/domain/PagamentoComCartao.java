package com.valdosm.cursomc.domain;

import javax.persistence.Entity;

import com.valdosm.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private Integer numeroDeParcelas;

    public PagamentoComCartao(){
        
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Integer numeroDeParcelas) {
        super(id, estado);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
    
}
