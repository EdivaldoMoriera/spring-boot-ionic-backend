package com.valdosm.cursomc.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valdosm.cursomc.domain.Cliente;
import com.valdosm.cursomc.domain.dto.ClienteDto;
import com.valdosm.cursomc.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> findAll() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteDto> listDto = list.stream()
                .map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}")
    @GetMapping
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    // metodo put
    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@Valid @RequestBody ClienteDto objDto, @PathVariable Integer id) {
        Cliente obj = clienteService.fromDto(objDto);
        obj = clienteService.uppate(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    // metodo delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // paginação
    @GetMapping(value = "/pages")
    public ResponseEntity<Page<ClienteDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPages", defaultValue = "24") Integer linesPerPages,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Cliente> list = clienteService.findPage(page, linesPerPages, orderBy, direction);
        Page<ClienteDto> listDto = list.map(obj -> new ClienteDto(obj));
        return ResponseEntity.ok().body(listDto);

    }

}