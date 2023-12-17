package br.com.projeto.api.controle;

import br.com.projeto.api.modelo.Activitie;
import br.com.projeto.api.modelo.Event;
import br.com.projeto.api.repositorio.UserRepository;
import br.com.projeto.api.responses.MessageResponse;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.api.modelo.User;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public User save(@RequestBody User u) {
        return userRepository.save(u);
    }

    @GetMapping("/users")
    public Iterable<User> searchAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public User searchUser(@PathVariable int userId) {
        return userRepository.findById(userId);
    }

    @PutMapping("/users/{userId}")
    public User update(@PathVariable int userId, @RequestBody User p) {
        User user = userRepository.findById(userId);
        user.setName(p.getName());
        user.setAffiliation(p.getAffiliation());

        return userRepository.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public void delete(@PathVariable int userId) {
        userRepository.deleteById(userId);
    }


    @PostMapping("/users/login")
    public MessageResponse login(@RequestBody User u) {
        var user = userRepository.login(u.getLogin(), u.getPassword());

        if (user.isEmpty()) {
            return new MessageResponse("Usuário ou senha inválidos");
        }

        return new MessageResponse("Login realizado com sucesso");
    }


    @PostMapping("/users/{userId}/favorites")
    public void saveFavorite(@PathVariable int userId, @RequestBody Activitie a) {
        User u = userRepository.findById(userId);
        u.appendFavorites(a);
        userRepository.save(u);
    }

    @DeleteMapping("/users/{userId}/favorites/{activityId}")
    public void removerFavorito(@PathVariable int userId, @PathVariable int activityId) {
        User u = userRepository.findById(userId);
        List<Activitie> favorites = u.getFavorites();
        favorites.removeIf(activitie -> activitie.getId() == activityId);
        userRepository.save(u);
        System.out.println("Removendo favorito " + activityId + " do usuário " + u.getName());
    }

    @GetMapping("/users/{userId}/favorites")
    public List<Activitie> buscarFavoritos(@PathVariable int userId) {
        return userRepository.findById(userId).getFavorites();
    }

    @GetMapping("/users/{userId}/notifications")
    public MessageResponse enviarNotificacao(@PathVariable int userId) {
        User u = userRepository.findById(userId);
        return new MessageResponse("Enviando notificação para o usuário " + u.getName() + " do e-mail " + u.getEmail() + " sobre as suas atividades favoritas.");
    }
}