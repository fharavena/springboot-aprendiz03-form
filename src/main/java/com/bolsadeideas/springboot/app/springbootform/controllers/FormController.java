package com.bolsadeideas.springboot.app.springbootform.controllers;

import javax.validation.Valid;

import com.bolsadeideas.springboot.app.springbootform.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
        model.addAttribute("titulo", "Resultado Form");

        if (result.hasErrors()) {
            return "form";
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}