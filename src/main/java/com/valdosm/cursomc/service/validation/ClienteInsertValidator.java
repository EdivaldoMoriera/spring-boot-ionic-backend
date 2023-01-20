package com.valdosm.cursomc.service.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.valdosm.cursomc.domain.dto.ClienteNewDto;
import com.valdosm.cursomc.domain.enums.TipoCliente;
import com.valdosm.cursomc.resource.exceptions.FieldMessage;
import com.valdosm.cursomc.service.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDto> {
    @Override
    public void initialize(ClienteInsert ann) {
      // TODO document why this method is empty
    }

    @Override
    public boolean isValid(ClienteNewDto clienteNewDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        // inclua os testes aqui, inserindo erros na lista
        if(clienteNewDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(clienteNewDto.getCpfOuCnpj())){
            list.add(new FieldMessage("CpfOucnpj", "  Cpf invalido "));
        }
        if(clienteNewDto.getCpfOuCnpj().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(clienteNewDto.getCpfOuCnpj())){
            list.add(new FieldMessage("CpfOuCnpj", "Cnpj Invalido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}