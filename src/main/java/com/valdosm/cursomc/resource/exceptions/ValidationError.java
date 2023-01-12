package com.valdosm.cursomc.resource.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.valdosm.cursomc.resource.StandardError;

public class ValidationError extends StandardError {
    private List<FieldMenssage> erros = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }
    public List<FieldMenssage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String message){
        erros.add(new FieldMenssage(fieldName, message));

    }
    }
    
