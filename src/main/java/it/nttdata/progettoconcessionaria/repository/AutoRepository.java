package it.nttdata.progettoconcessionaria.repository;

import it.nttdata.progettoconcessionaria.models.Auto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AutoRepository extends CrudRepository<Auto, Long> {

}
