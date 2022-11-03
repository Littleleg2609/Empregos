package com.example.cadastroemprego.controllers;

import com.example.cadastroemprego.entities.Emprego;
import com.example.cadastroemprego.repositories.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {

    @Autowired
    EmpregoRepository empregoRepository;
    @RequestMapping("/")
    public String listaEmpregos(Model model){
    model.addAttribute("empregos",empregoRepository.findAll());
    return "lista";
    }
    @GetMapping("/add")
    public String empregoForm(Model model){
        model.addAttribute("emprego",new Emprego());
        return "EmpregoForm";
    }
    @PostMapping("/process")
    public  String processForm(@Validated Emprego emprego, BindingResult result){
     if(result.hasErrors()){
         return "EmpregoForm";
     }
     empregoRepository.save(emprego);
     return "redirect:/";
    }
}
