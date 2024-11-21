package br.uam.sdm.services;

import br.uam.sdm.entities.User;
import br.uam.sdm.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing users.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found for deletion");
        }
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found for update"));
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
        entity.setSubscription(obj.getSubscription());
    }
}
