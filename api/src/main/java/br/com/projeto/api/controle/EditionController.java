package br.com.projeto.api.controle;

import br.com.projeto.api.modelo.Activitie;
import br.com.projeto.api.repositorio.ActivitieRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.modelo.Edition;
import br.com.projeto.api.modelo.User;
import br.com.projeto.api.repositorio.EditionRepository;
import br.com.projeto.api.repositorio.UserRepository;

import java.util.Map;


@RestController
public class EditionController {

    @Autowired
    private ActivitieRepository activitiesRepository;
    @Autowired
    private EditionRepository editionRepository;



    @PostMapping("/editions")
    public void save(HttpServletResponse response, @RequestBody Edition edition){
        editionRepository.save(edition);
        response.setStatus(201);
    }

    @GetMapping("/editions")
    public Iterable<Edition> searchAll() {
        return editionRepository.findAll();
    }
    @GetMapping("/editions/{editionId}")
    public Edition searchEdition(@PathVariable int editionId) {
        return editionRepository.findById(editionId);
    }

    @PutMapping("/editions/{editionId}")
    public Edition update(@PathVariable int editionId, @RequestBody Edition e) {
        Edition edition = editionRepository.findById(editionId);
        edition.setNumber(e.getNumber());
        edition.setYear(e.getYear());
        edition.setCity(e.getCity());
        edition.setStartDate(e.getStartDate());
        edition.setEndDate(e.getEndDate());

        return editionRepository.save(edition);
    }

    @DeleteMapping("/editions/{editionId}")
    public void delete(@PathVariable int editionId) {
        editionRepository.deleteById(editionId);
    }

    @GetMapping("/edition/{editionId}/organizer")
    public User editionById(@PathVariable("editionId") int editionId) {
        return editionRepository.findById(editionId).getOrganizer();
    }

    @PostMapping("/edition/{editionId}/organizer")
    public void organizerSave(@PathVariable("editionId") int editionId, @RequestBody Map<String, Integer> data){

        editionRepository.organizerSave(data.get("userId"), editionId);
    }

    @DeleteMapping("/edition/{editionId}/organizers/{userId}")
    public void organizerDelete(@PathVariable("editionId") int editionId, @PathVariable("userId") int userId){
        editionRepository.organizerDelete(editionId, userId);
    }

}
