package it.nttdata.progettoconcessionaria.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    @OneToMany(mappedBy = "concessionario")
    private Set<Dipendente> listadipendenti;

    @OneToMany(mappedBy = "concessionario")
    private Set<Auto> listaauto;

    public Concessionario(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    public Set<Dipendente> getListadipendenti() {
        return listadipendenti;
    }

    public void setListadipendenti(Set<Dipendente> listadipendenti) {
        this.listadipendenti = listadipendenti;
    }

    public Set<Auto> getListaauto() {
        return listaauto;
    }

    public void setListaauto(Set<Auto> listaauto) {
        this.listaauto = listaauto;
    }
}
