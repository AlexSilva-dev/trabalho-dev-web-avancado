package br.com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.modelo.Activities;
import br.com.projeto.api.repositorio.ActivitiesRepository;

@RestController
public class ActivitiesController {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @PostMapping("/editions/{editionId}/activities")
    public Activities save(@RequestBody Activities a) {
        return activitiesRepository.save(a);
    }

    @GetMapping("/editions/{editionId}/activities")
    public Iterable<Activities> searchAll() {
        return activitiesRepository.findAll();
    }

    @GetMapping("/editions/{editionId}/activities/{activitiesId}")
    public Activities searchUser(@PathVariable int activitiesId) {
        return activitiesRepository.findById(activitiesId);
    }

    @PutMapping("/editions/{editionId}/activities/{activitiesId}")
    public Activities update(@PathVariable int activitiesId, @RequestBody Activities a) {
        Activities activities = activitiesRepository.findById(activitiesId);
        activities.setName(a.getName());
        //activities.setType(a.getType());
        activities.setDescription(a.getDescription());
        activities.setDate(a.getDate());
        activities.setStart_time(a.getStart_time());
        activities.setEnd_time(a.getEnd_time());

        return activitiesRepository.save(activities);
    }
    
    @DeleteMapping("/editions/{editionId}/activities/{activitiesId}")
    public void delete(@PathVariable int activitiesId) {
        activitiesRepository.deleteById(activitiesId);
    }
    
}