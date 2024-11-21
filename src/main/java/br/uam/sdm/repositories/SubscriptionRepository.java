package br.uam.sdm.repositories;

import br.uam.sdm.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
    
}
