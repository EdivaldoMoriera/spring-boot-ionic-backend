package com.valdosm.cursomc.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.valdosm.cursomc.domain.Categoria;
import com.valdosm.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    @Query("SELECT DISTINC ojb FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
    Page<Produto> search(@Param("nome") String nome,@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
    
}
