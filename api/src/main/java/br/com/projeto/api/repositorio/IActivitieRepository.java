package br.com.projeto.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Activitie;

@Repository
public interface IActivitieRepository extends CrudRepository<Activitie,Integer> {
    
}
