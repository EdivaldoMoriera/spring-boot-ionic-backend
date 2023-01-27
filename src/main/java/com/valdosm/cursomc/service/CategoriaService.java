package com.valdosm.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.domain.dto.CategoriaDto;
import com.valdosm.cursomc.repository.CategoriaRepository;
import com.valdosm.cursomc.service.exception.DataIntegrityException;
import com.valdosm.cursomc.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> fidAll() {
        return categoriaRepository.findAll();
    }
    // por id
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado Id:" + id + ", Tipo:" + Categoria.class.getName()));
    }
    // inserir nova categoria metodo post
    public Categoria insert(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    // metodo put
    public Categoria uppate(Integer id, Categoria obj) {
        Categoria entity = categoriaRepository.getReferenceById(id);
        updateData(obj, entity);
        return categoriaRepository.save(entity);
    }

    private void updateData(Categoria obj, Categoria entity) {
        entity.setNome(obj.getNome());
    }

    // delete
    public void delete(Integer id) {
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");

        }
    }

    // paginação
    public Page<Categoria> findPage(Integer page, Integer linesPerPages, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPages, Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);

    }
    public Categoria fromDto( CategoriaDto categoriaDto){
        return new Categoria(categoriaDto.getId(), categoriaDto.getNome());
    }
}
