package br.com.projeto.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.modelo.Mensagem;
import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    public ResponseEntity<?> cadastrar(Pessoa p){
        if (p.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (p.getIdade() < 0){
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            acao.save(p);
            return new ResponseEntity<>(acao.save(p), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> selecionar(){
        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);
    }
    
    public ResponseEntity<?> contador(){
        if (acao.count() == 0){
            mensagem.setMensagem("Nao foi encontrado nenhuma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.count(), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> editar(Pessoa p){
        if (acao.count() == 0){
            mensagem.setMensagem("Nao foi encontrado nenhuma pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (p.getNome().equals("")){
            mensagem.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (p.getIdade() < 0){
            mensagem.setMensagem("Informe uma idade valida");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            acao.save(p);
            return new ResponseEntity<>(acao.save(p), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> remover(int id){
        if (acao.countById(id) == 0){
            mensagem.setMensagem("O codigo informado nao existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            Pessoa p = acao.findById(id);
            acao.delete(p);
            mensagem.setMensagem("O codigo informado nao existe");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        }

    }
}
