package br.com.projeto.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.repositorio.SpaceRepository;

@RestController
public class SpaceController {
    
    @Autowired
    private SpaceRepository SpaceRepository;

    @DeleteMapping("/spaces/{spacesId}")
    public void delete(@PathVariable int spacesId) {
        SpaceRepository.deleteById(spacesId);
    }
    
}
