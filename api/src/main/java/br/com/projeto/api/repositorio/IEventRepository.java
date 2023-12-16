package br.com.projeto.api.repositorio;

import br.com.projeto.api.modelo.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends CrudRepository<Event, Integer> {

}
