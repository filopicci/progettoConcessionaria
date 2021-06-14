package it.nttdata.progettoconcessionaria.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Size(min = 1)
    private String modello;

    private Double prezzo;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "concessionario_id")
    private Concessionario concessionario;

    }
