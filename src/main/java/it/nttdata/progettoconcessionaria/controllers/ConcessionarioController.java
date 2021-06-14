package it.nttdata.progettoconcessionaria.controllers;

import it.nttdata.progettoconcessionaria.models.Concessionario;
import it.nttdata.progettoconcessionaria.models.Regione;
import it.nttdata.progettoconcessionaria.repository.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

    @GetMapping("/concessionario/{id}")
    public String getDettaglioConcessionario(@PathVariable("id") Long id, Model model){
        Optional<Concessionario> opt = concessionarioRepository.findById(id);

        if (opt.isPresent()) {
           Concessionario c = opt.get();
            model.addAttribute("nomeconcessionaria", c.getNome());
            model.addAttribute("descrizioneconcessionario", c.getDescrizione());
        } else{
            model.addAttribute("nomeconcessionaria", "NON TROVATO");
            model.addAttribute("descrizioneconcessionario", "NON TROVATO");
        }

        return "dettaglioconcessionario";
    }

    @GetMapping("/addconcessionario")
    public String getFormConcessionario(Model model){
        model.addAttribute("regioni", Regione.values());
        return "formconcessionario";
    }

    @PostMapping("/addconcessionario")
    public String addConcessionario(Concessionario concessionario){
        concessionarioRepository.save(concessionario);
        return "redirect:/listaconcessionarie";
    }
}
