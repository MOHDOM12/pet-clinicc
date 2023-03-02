package mohd.springframework.petclinicc.repositories;

import mohd.springframework.petclinicc.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long>
{

}
