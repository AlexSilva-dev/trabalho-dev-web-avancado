package br.com.projeto.api.repositorio;

//import br.com.projeto.api.modelo.Space;
import br.com.projeto.api.modelo.Space;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public void save(Space space) {
        repository.save(space);
    }

    public Iterable<Space> findAll() {
        return repository.findAll();
    }

    public Optional<Space> findById(int spaceId) {
        return repository.findById(spaceId);
    }

    public boolean put(Space newSpace) {
        Optional<Space> recoveredSpace = repository.findById(newSpace.getId());
        if (recoveredSpace.isEmpty()) {
            return false;
        }
        Space space = recoveredSpace.get();

        BeanUtils.copyProperties(newSpace, space, "id");
        System.out.print(newSpace + " - " + space);
        repository.save(space);
        return true;
    }

}
