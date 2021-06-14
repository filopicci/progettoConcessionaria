package it.nttdata.progettoconcessionaria.controllers;

import it.nttdata.progettoconcessionaria.models.Auto;
import it.nttdata.progettoconcessionaria.repository.AutoRepository;
import it.nttdata.progettoconcessionaria.repository.ConcessionarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;


@Controller
public class AutoController {


    private final AutoRepository autoRepository;
    private final ConcessionarioRepository concessionarioRepository;
    public AutoController(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
    }

    @GetMapping("/listaauto")
    public String getAuto(Model model){
        model.addAttribute( "automobili" , autoRepository.findAll());
        return "listaauto";
    }

    @GetMapping("/listaauto/{nomeConcessionario}")
    public String getListaAutoConcessionario(Model model,@PathVariable("nomeConcessionario") String nomeConcessionario){
        ArrayList<Auto> listaAuto = (ArrayList<Auto>) autoRepository.findAll();
        ArrayList<Auto> listaAutoFiltrate = new ArrayList<>();
        for(Auto auto : listaAuto){
            if(auto.getConcessionario().getNome().equals(nomeConcessionario)) {
                listaAutoFiltrate.add(auto);
            }
        }
        model.addAttribute("automobili", listaAutoFiltrate);
        return "listaauto";
    }

    @GetMapping("/addauto")
    public String getForm(Model model){
        model.addAttribute("concessionarie", concessionarioRepository.findAll());
        return "formauto";
    }

    @PostMapping("/addauto")
    //@ResponseBody
    public String addAuto(Auto a){
        autoRepository.save(a);
        return "redirect:/listaauto";
    }
}
