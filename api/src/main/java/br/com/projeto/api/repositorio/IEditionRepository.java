package br.com.projeto.api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.modelo.Edition;

@Repository
public interface IEditionRepository extends CrudRepository<Edition, Integer>{
}
