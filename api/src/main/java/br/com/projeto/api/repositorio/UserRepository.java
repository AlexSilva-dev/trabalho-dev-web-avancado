package br.com.projeto.api.repositorio;

import br.com.projeto.api.modelo.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Lazy
    @Autowired
    private IUserRepository repository;

    @PersistenceContext
    private EntityManager entityManager;


    public User save(User p) {
        return repository.save(p);
    }

    public User findById(int id) {
        return repository.findById(id).get();
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public List<User> login(String login, String password) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password", User.class)
                .setParameter("login", login)
                .setParameter("password", password)
                .getResultList();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
