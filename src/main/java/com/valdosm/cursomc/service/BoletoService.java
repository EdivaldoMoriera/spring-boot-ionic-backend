package com.valdosm.cursomc.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {
    public void preecherPagamentoComBoleto(PagamentoComBoleto pagto, Date instateDoPedido){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(instateDoPedido);
        calendar.add(Calendar.DAY_OF_MONTH,7 );
        pagto.setDataVencimento(calendar.getTime());

    }
    
}
