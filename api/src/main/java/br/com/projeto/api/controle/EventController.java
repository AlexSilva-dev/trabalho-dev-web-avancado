package br.com.projeto.api.controle;

import br.com.projeto.api.modelo.Edition;
import br.com.projeto.api.modelo.User;
import br.com.projeto.api.repositorio.EditionRepository;
import br.com.projeto.api.repositorio.IEventRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.projeto.api.modelo.Event;
import br.com.projeto.api.repositorio.EventRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EditionRepository editionRepository;



    @PostMapping("/events")
    public void save(HttpServletResponse response, @RequestBody Event ev){
        eventRepository.save(ev);
        response.setStatus(201);
    }

    @GetMapping("/events")
    public Iterable<Event> searchAll() {
        return eventRepository.findAll();
    }

    @GetMapping("/events/{eventId}")
    public Event searchEvent(@PathVariable int eventId) {
        return eventRepository.findById(eventId);
    }

    @DeleteMapping("/events/{eventId}")
    public void delete(@PathVariable int eventId) {
        eventRepository.deleteById(eventId);
    }

    @PutMapping("/events/{eventId}")
    public Event update(@PathVariable int eventId, @RequestBody Event ev) {
        Event event = eventRepository.findById(eventId);
        event.setName(ev.getName());
        event.setAcronym(ev.getAcronym());
        event.setDescription(ev.getDescription());

        return eventRepository.save(event);
    }

    @GetMapping("/events/{eventId}/editions")
    public List<Edition> buscaEdicoes(@PathVariable int eventId) {
        var e = eventRepository.findById(eventId);
        return e.getEdition();
    }

    @PostMapping("/events/{eventId}/editions")
    public void addEdition(@PathVariable("eventId") int eventId, @RequestBody Edition edition){
        var ev = eventRepository.findById(eventId);
        var created = editionRepository.save(edition);
        ev.getEdition().add(created);
        eventRepository.save(ev);
    }


    @GetMapping("/events/{eventId}/users")
    public List<User> buscarFavoritos(@PathVariable int eventId) {
        return eventRepository.findById(eventId).getUsers();
    }

}
