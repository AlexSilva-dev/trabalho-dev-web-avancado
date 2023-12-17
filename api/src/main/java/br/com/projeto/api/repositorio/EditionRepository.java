package br.com.projeto.api.repositorio;

import br.com.projeto.api.modelo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Edition;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

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

    @Autowired
    private UserRepository userRepository;

    public void organizerSave(int userId, int editionId) {
        Optional<Edition> edition = repository.findById(editionId);
        User user = userRepository.findById(userId);
        Edition editionNew = edition.get();
        editionNew.setOrganizer(user);
        repository.save(editionNew);
    }

    public void organizerDelete(int editionId, int userId) {
        Optional<Edition> rEdition = repository.findById(editionId);
        if (rEdition.isPresent()) {
            Edition edition = rEdition.get();
            edition.setUsers(null);
        }
    }

}
