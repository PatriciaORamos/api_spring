package br.com.projeto.api.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Cliente;
import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class Controle {

    @Autowired
    private Servico servico;
    
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
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa p){
        return servico.cadastrar(p);
    }    
    
    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }
    
    @GetMapping("/api/{id}")
    public Pessoa selecionarPorId(@PathVariable int id){
        return acao.findById(id);
    }  

    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa p){
        return servico.editar(p);
    }
 
    @DeleteMapping("/api/{id}")
    public ResponseEntity<?> remover(@PathVariable int id){
        return servico.remover(id);
    }

    @GetMapping("/api/contador")
    public ResponseEntity<?> contador(){
        return servico.contador();
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

    @GetMapping("/api/somaIdade")
    public int somaIdade(){
        return acao.somaIdade();
    }

    @GetMapping("/api/pessoasIdadeIgualMaior")
    public List<Pessoa> pessoasIdadeIgualMaior(){
        return acao.idadeIgualMaior(50);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping("/cliente")
    public void cliente(@Valid @RequestBody Cliente cliente) {
        
    }
    
}
