package com.uff.trabalhodevwebavancado.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
class UsuarioContoller{
    @GetMapping(value = "/")
    public String teste(){


        return "Teste com sucesso";
    }
}