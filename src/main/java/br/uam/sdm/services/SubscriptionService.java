package br.uam.sdm.services;

import br.uam.sdm.entities.Subscription;
import br.uam.sdm.repositories.SubscriptionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing subscriptions.
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository repository;

    public List<Subscription> findAll() {
        return repository.findAll();
    }

    public Subscription findById(Long id) {
        Optional<Subscription> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Subscription not found"));
    }

    public Subscription insert(Subscription obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Subscription not found for deletion");
        }
        repository.deleteById(id);
    }

    public Subscription update(Long id, Subscription obj) {
        Subscription entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found for update"));
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Subscription entity, Subscription obj) {
        entity.setType(obj.getType());
        entity.setPrice(obj.getPrice());
    }
}