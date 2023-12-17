package br.com.projeto.api.repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Activitie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ActivitieRepository {

    @Lazy
    @Autowired
    private static IActivitieRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public Activitie save(Activitie a) {
        return repository.save(a);
    }

    public Iterable<Activitie> findAll() {
        return repository.findAll();
    }

    public  Activitie findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
