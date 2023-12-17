package br.com.projeto.api.repositorio;

import br.com.projeto.api.modelo.Edition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class EventRepository {

    @Lazy
    @Autowired
    private IEventRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Event save(Event ev) {
        return repository.save(ev);
    }

    public Iterable<Event> findAll() {
        return repository.findAll();
    }

    public Event findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
