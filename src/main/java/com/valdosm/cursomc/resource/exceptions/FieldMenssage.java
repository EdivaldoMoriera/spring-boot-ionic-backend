package com.valdosm.cursomc.resource.exceptions;

import java.io.Serializable;

public class FieldMenssage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;
    public FieldMenssage(){    
    }
    
    public FieldMenssage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
