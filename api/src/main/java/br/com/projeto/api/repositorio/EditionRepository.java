package br.com.projeto.api.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Edition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EditionRepository {

    @Lazy
    @Autowired
    private IEditionRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Edition save(Edition e) {
        return repository.save(e);
    }

    public Iterable<Edition> findAll() {
        return repository.findAll();
    }

    public Edition findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
