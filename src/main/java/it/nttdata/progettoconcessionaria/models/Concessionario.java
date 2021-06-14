package it.nttdata.progettoconcessionaria.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Concessionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    @Size(min = 1)
    private String nome;
    @NonNull
    @Size(min = 1)
    private String via;
    @NonNull
    @Size(min = 1)
    private String citta;
    @NonNull
    private Regione regione;
    @NonNull
    private String descrizione;

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendente> listadipendenti = new HashSet<>();

    @OneToMany(mappedBy = "concessionario")
    private Set<Auto> listaauto = new HashSet<>();
}