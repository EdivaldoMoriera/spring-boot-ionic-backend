package com.valdosm.cursomc.domain;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date instante;
    public Pedido(){

    }
    public Pedido(Integer id, Date instante) {
        this.id = id;
        this.instante = instante;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getInstante() {
        return instante;
    }
    public void setInstante(Date instante) {
        this.instante = instante;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
