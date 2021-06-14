package it.nttdata.progettoconcessionaria.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Concessionario concessionario;

    @NonNull
    @Size(min = 1)
    private String nome;

    @NonNull
    @Size(min = 1)
    private String cognome;

    private Double stipendio;

    @NonNull
    @Min(18)
    private Integer eta;
}
