package br.com.projeto.api.repositorio;

//import br.com.projeto.api.modelo.Space;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository
public class SpaceRepository {

    @Lazy
    @Autowired
    private ISpaceRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public void deleteById(int id) {
        repository.deleteById(id);
    }
    
}
