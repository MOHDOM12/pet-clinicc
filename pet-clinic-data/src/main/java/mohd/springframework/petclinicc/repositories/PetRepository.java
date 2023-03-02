package mohd.springframework.petclinicc.repositories;

import mohd.springframework.petclinicc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long>
{

}
