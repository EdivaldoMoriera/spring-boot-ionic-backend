package com.valdosm.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Cliente;
import com.valdosm.cursomc.domain.dto.ClienteDto;
import com.valdosm.cursomc.repository.ClienteRepository;
import com.valdosm.cursomc.service.exception.DataIntegrityException;
import com.valdosm.cursomc.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
    // por id
    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado Id:" + id + ", Tipo:" + Cliente.class.getName()));
    }
    //post
    public Cliente insert(Cliente cliente){
        return clienteRepository.save(cliente);
    }
     // metodo put
     public Cliente uppate(Integer id, Cliente obj) {
        Cliente entity = clienteRepository.getReferenceById(id);
        updateData(obj, entity);
        return clienteRepository.save(entity);
    }

    private void updateData(Cliente obj, Cliente entity) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
    }
     // delete
     public void delete(Integer id) {
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma entidades relacionadas");

        }
    }

    // paginação
    public Page<Cliente> findPage(Integer page, Integer linesPerPages, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPages, Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);

    }
    public Cliente fromDto( ClienteDto clienteDto){
        return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), null, null);
    }
    }

   
