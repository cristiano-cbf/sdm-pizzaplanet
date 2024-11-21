package br.uam.sdm.services;

import br.uam.sdm.entities.Pizza;
import br.uam.sdm.repositories.PizzaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing pizzas.
 */
@Service
public class PizzaService {

    @Autowired
    private PizzaRepository repository;

    public List<Pizza> findAll() {
        return repository.findAll();
    }

    public Pizza findById(Long id) {
        Optional<Pizza> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Pizza not found"));
    }

    public Pizza insert(Pizza obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Pizza not found for deletion");
        }
        repository.deleteById(id);
    }

    public Pizza update(Long id, Pizza obj) {
        Pizza entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Pizza not found for update"));
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Pizza entity, Pizza obj) {
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
    }
}