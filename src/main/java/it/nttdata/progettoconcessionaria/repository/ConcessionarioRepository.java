package it.nttdata.progettoconcessionaria.repository;

import it.nttdata.progettoconcessionaria.models.Concessionario;
import org.springframework.data.repository.CrudRepository;

public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {
}
