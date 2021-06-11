package it.nttdata.progettoconcessionaria.controllers;

import it.nttdata.progettoconcessionaria.repository.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConcessionarioController {

    private ConcessionarioRepository concessionarioRepository;


    public ConcessionarioController(ConcessionarioRepository concessionarioRepository) {
        this.concessionarioRepository = concessionarioRepository;
    }


    @GetMapping("/listaconcessionarie")
    public String getConcessionarie(Model model){
        model.addAttribute("concessionarie", concessionarioRepository.findAll());
        return "listaconcessionarie";
    }
}
