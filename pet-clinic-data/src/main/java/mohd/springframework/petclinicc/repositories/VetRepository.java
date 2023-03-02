package mohd.springframework.petclinicc.repositories;

import mohd.springframework.petclinicc.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VetRepository extends CrudRepository<Vet, Long>
{

}
