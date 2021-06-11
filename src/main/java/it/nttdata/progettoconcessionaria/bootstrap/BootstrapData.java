package it.nttdata.progettoconcessionaria.bootstrap;

import it.nttdata.progettoconcessionaria.models.Auto;
import it.nttdata.progettoconcessionaria.models.Concessionario;
import it.nttdata.progettoconcessionaria.models.Dipendente;
import it.nttdata.progettoconcessionaria.models.Regione;
import it.nttdata.progettoconcessionaria.repository.AutoRepository;
import it.nttdata.progettoconcessionaria.repository.ConcessionarioRepository;
import it.nttdata.progettoconcessionaria.repository.Dipendenterepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    private AutoRepository autoRepository;
    private ConcessionarioRepository concessionarioRepository;
    private Dipendenterepository dipendenterepository;

    public BootstrapData(AutoRepository autoRepository, ConcessionarioRepository concessionarioRepository, Dipendenterepository dipendenterepository) {
        this.autoRepository = autoRepository;
        this.concessionarioRepository = concessionarioRepository;
        this.dipendenterepository = dipendenterepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Concessionario c1 = new Concessionario();
        c1.setNome("concessionario 1");
        c1.setVia("via Milano");
        c1.setCitta("Milano");
        c1.setRegione(Regione.LOMBARDIA);

        Concessionario c2 = new Concessionario();
        c2.setNome("concessionario 2");
        c2.setVia("via Roma");
        c2.setCitta("Roma");
        c2.setRegione(Regione.LAZIO);

        Auto a1 = new Auto();
        a1.setModello("Fiat panda");
        a1.setConcessionario(c1);
        a1.setPrezzo((double) 15000);

        Auto a2 = new Auto();
        a2.setModello("Audi A2");
        a2.setConcessionario(c2);
        a2.setPrezzo((double) 30000);

        Dipendente d1 = new Dipendente();
        d1.setNome("Mario");
        d1.setCognome("Rossi");
        d1.setEta(26);
        d1.setConcessionario(c1);
        d1.setStipendio((double) 1400);

        Dipendente d2 = new Dipendente();
        d2.setNome("Andrea");
        d2.setCognome("Bianchi");
        d2.setEta(50);
        d2.setConcessionario(c2);
        d2.setStipendio((double) 1550);

        c1.getListadipendenti().add(d1);
        c1.getListaauto().add(a1);
        c2.getListadipendenti().add(d2);
        c2.getListaauto().add(a2);

        concessionarioRepository.save(c1);
        concessionarioRepository.save(c2);

        autoRepository.save(a1);
        autoRepository.save(a2);

        dipendenterepository.save(d1);
        dipendenterepository.save(d2);
    }
}
