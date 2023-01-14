package com.valdosm.cursomc.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.valdosm.cursomc.domain.Cliente;

public class ClienteDto  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    
    @NotEmpty(message = "Campo Obrigatorio")
    @Length(min=5, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatorio")
    @Email(message = "Email invalido")
    private String email;
    public ClienteDto(){

    }
    public ClienteDto(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

    
}
