package br.com.projeto.api.controle;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.modelo.Activitie;
import br.com.projeto.api.modelo.Edition;
import br.com.projeto.api.repositorio.ActivitieRepository;
import br.com.projeto.api.repositorio.EditionRepository;

@RestController
public class ActivitieController {

    @Autowired
    private ActivitieRepository activitiesRepository;
    @Autowired
    private EditionRepository editionRepository;


    @PostMapping("/editions/{editionId}/activities")
    public Activitie save(@PathVariable int editionId,@RequestBody Activitie activitie) {
        Edition edition = editionRepository.findById(editionId);

        var created = activitiesRepository.save(activitie);
        edition.addActivitie(created);
        editionRepository.save(edition);
        return activitie;
    }

    @GetMapping("/editions/{editionId}/activities")
    public Iterable<Activitie> searchAll(@PathVariable int editionId) {
        Edition edition = editionRepository.findById(editionId);
        return edition.getActivities();
    }
    
    
    @GetMapping("/editions/{editionId}/activities/{activitiesId}")
    public Activitie searchActivitieDescription(@PathVariable int editionId,@PathVariable int activitiesId) {
        Edition edition = editionRepository.findById(editionId);
        return edition.getActivitieById(activitiesId);
    }

    @PutMapping("/editions/{editionId}/activities/{activitiesId}")
    public Activitie update(@PathVariable int activitiesId, @RequestBody Activitie a) {
        Activitie activities = activitiesRepository.findById(activitiesId);
        activities.setName(a.getName());
        activities.setType(a.getType());
        activities.setDescription(a.getDescription());
        activities.setDate(a.getDate());
        activities.setStart_time(a.getStart_time());
        activities.setEnd_time(a.getEnd_time());

        return activitiesRepository.save(activities);
    }
    
    @DeleteMapping("/editions/{editionId}/activities/{activitiesId}")
    public void delete(@PathVariable int editionId,@PathVariable int activitiesId) {
        Activitie a = activitiesRepository.findById(activitiesId);
        Edition edition = editionRepository.findById(editionId);
            if (edition != null) {
                edition.removeActivitie(a);; // Remove a atividade da lista de atividades da edição
                editionRepository.save(edition); // Atualiza a edição no banco de dados
            }
        activitiesRepository.deleteById(activitiesId);
    
    }
    
}
