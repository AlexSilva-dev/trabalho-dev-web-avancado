package br.com.projeto.api.controle;

import br.com.projeto.api.modelo.Space;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.projeto.api.repositorio.SpaceRepository;

import java.util.Optional;

@RestController
public class SpaceController {
    
    @Autowired
    private SpaceRepository spaceRepository;

    @GetMapping("/spaces")
    public Iterable<Space> findAll() {
        return spaceRepository.findAll();
    }

    @GetMapping("/spaces/{spacesId}")
    public Optional<Space> findSpace(@PathVariable int spacesId) {
        return spaceRepository.findById(spacesId);
    }

    @PostMapping("/spaces")
    public void save(HttpServletResponse response, @RequestBody Space space){
        spaceRepository.save(space);
        response.setStatus(201);
    }

    @PutMapping("/spaces/{spaceId}")
    public void update(HttpServletResponse response, @PathVariable("spaceId") int spaceId,  @RequestBody Space space) {
        space.setId(spaceId);
        if (!spaceRepository.put(space)) {
            response.setStatus(400);
        }
    }
    @DeleteMapping("/spaces/{spacesId}")
    public void delete(@PathVariable int spacesId) {
        spaceRepository.deleteById(spacesId);
    }
    
}
