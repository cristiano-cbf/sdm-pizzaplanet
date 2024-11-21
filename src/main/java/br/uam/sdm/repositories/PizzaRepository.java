package br.uam.sdm.repositories;

import br.uam.sdm.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long>{
    
}
