package br.com.projeto.api.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa p){
        return acao.save(p);
    }

    @GetMapping("")
    public String message(){
        return "Hello World!";
    }

    @GetMapping("/boasvindas")
    public String boas_vindas(){
        return "Seja Bem-Vindo!";
    }

    @GetMapping("/boasvindas/{nome}")
    public String boas_vindas(@PathVariable String nome){
        return "Seja Bem-Vindo "+ nome +"!";
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }
}
