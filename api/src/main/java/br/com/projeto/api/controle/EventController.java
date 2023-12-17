package br.com.projeto.api.controle;

import br.com.projeto.api.repositorio.IEventRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EventController {
    @Autowired
    private IEventRepository eventRepository;

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
