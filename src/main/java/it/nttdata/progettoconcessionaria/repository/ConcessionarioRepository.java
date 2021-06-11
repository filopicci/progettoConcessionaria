package it.nttdata.progettoconcessionaria.repository;

import it.nttdata.progettoconcessionaria.models.Concessionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConcessionarioRepository extends CrudRepository<Concessionario, Long> {

    @Query("SELECT count(distinct C.regione) from Concessionario C")
    Integer countRegion();
}
