package it.nttdata.progettoconcessionaria.controllers;

import it.nttdata.progettoconcessionaria.models.Auto;
import it.nttdata.progettoconcessionaria.models.Concessionario;
import it.nttdata.progettoconcessionaria.repository.AutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;


@Controller
public class AutoController {


    private final AutoRepository autoRepository;

    public AutoController(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
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
}
