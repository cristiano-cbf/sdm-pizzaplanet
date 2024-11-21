package br.uam.sdm.controller;

import br.uam.sdm.entities.Subscription;
import br.uam.sdm.services.SubscriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService service;

    @GetMapping
    public ResponseEntity<List<Subscription>> findAll() {
        List<Subscription> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Subscription> findById(@PathVariable Long id) {
        Subscription obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Subscription> insert(@RequestBody Subscription obj) {
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Subscription> update(@PathVariable Long id, @RequestBody Subscription obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}