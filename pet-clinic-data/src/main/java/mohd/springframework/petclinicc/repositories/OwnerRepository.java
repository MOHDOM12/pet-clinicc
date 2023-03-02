package mohd.springframework.petclinicc.repositories;

import mohd.springframework.petclinicc.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
    Owner findByLastName(String lastName);
}
