package br.com.projeto.api.controle;

import br.com.projeto.api.modelo.User;
import br.com.projeto.api.repositorio.IEventRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.projeto.api.modelo.Event;
import br.com.projeto.api.repositorio.EventRepository;

import java.io.IOException;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

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

    @PostMapping("/events/{eventId}/organizers")
    public void eventsEventIdOrganizersPost(HttpServletResponse response, @PathVariable int eventId) {
        System.out.print(eventId);
        response.setStatus(201);
        /* - para mandar uma mensagem no corpo da resposta:
        try {
            response.getWriter().println("Hello World!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
    }
}
