package br.com.projeto.api.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class Controle {
    
    @Autowired
    private Repositorio acao;

    @GetMapping("")
    public String mensagem(){
        return "API Spring";
    }

    @GetMapping("/welcome/{nome}")
    public String welcome(@PathVariable String nome ){
        return "Welcome " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }    
   
    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa p){
        return acao.save(p);
    }
    
    
    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }
    
    @GetMapping("/api/{id}")
    public Pessoa selecionarPorId(@PathVariable int id){
        return acao.findById(id);
    }  

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa p){
        return acao.save(p);
    }
 
    @DeleteMapping("/api/{id}")
    public void remover(@PathVariable int id){
        Pessoa p = acao.findById(id);
        acao.delete(p);
    }

    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }
        
    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNome();
    }

    @GetMapping("/api/ordenarNomesDecrecente")
    public List<Pessoa> ordenarNomesDecrecente(){
        return acao.findByOrderByNomeDesc();
    }

    @GetMapping("/api/ordenarNomesIdade")
    public List<Pessoa> ordenarNomesIdade(){
        return acao.findByOrderByIdadeDesc();
    }

    @GetMapping("/api/nomeContem/{termo}")
    public List<Pessoa> nomeContem(@PathVariable String termo){
        return acao.findByNomeContaining(termo);
    }
    
    @GetMapping("/api/nomeComeca/{termo}")
    public List<Pessoa> nomeComeca(@PathVariable String termo){
        return acao.findByNomeStartsWith(termo);
    }

    @GetMapping("/api/nomeFinaliza/{termo}")
    public List<Pessoa> nomeFinaliza(@PathVariable String termo){
        return acao.findByNomeEndsWith(termo);
    }

}
