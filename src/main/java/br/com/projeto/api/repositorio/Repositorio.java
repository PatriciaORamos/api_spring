package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.modelo.Pessoa;

@Repository
public interface Repositorio extends CrudRepository<Pessoa, Integer>{
    
    List<Pessoa> findAll();
    
    Pessoa findById(int id);

    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByOrderByNomeDesc();

    List<Pessoa> findByOrderByIdadeDesc();

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);
}