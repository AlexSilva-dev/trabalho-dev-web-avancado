package br.com.projeto.api.controle;

import br.com.projeto.api.repositorio.UserRepository;
import br.com.projeto.api.responses.MessageResponse;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.api.modelo.User;

import org.springframework.beans.factory.annotation.Autowired;

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
    public User saveFavorite(@PathVariable int userId, @RequestBody User p) {
        return p;
    }

    @DeleteMapping("/users/{userId}/favorites/{activityId}")
    public void removerFavorito(@PathVariable int userId, @PathVariable int activityId) {
        System.out.println("Removendo favorito " + activityId + " do usuário " + userId);

    }

    @GetMapping("/users/{userId}/favorites")
    public User buscarFavoritos(@PathVariable int userId) {
        return new User();
    }

    @PostMapping("/users/{userId}/notifications")
    public User enviarNotificacao(@PathVariable int userId, @RequestBody User p) {
        return p;
    }


}
