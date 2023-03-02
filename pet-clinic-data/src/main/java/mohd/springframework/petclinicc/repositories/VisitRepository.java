package mohd.springframework.petclinicc.repositories;

import mohd.springframework.petclinicc.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long>
{

}
