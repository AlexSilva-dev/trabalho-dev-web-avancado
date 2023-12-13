package br.com.projeto.api.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Activities;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ActivitiesRepository {

    @Lazy
    @Autowired
    private IActivitiesRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Activities save(Activities a) {
        return repository.save(a);
    }

    public Iterable<Activities> findAll() {
        return repository.findAll();
    }

    public Activities findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
