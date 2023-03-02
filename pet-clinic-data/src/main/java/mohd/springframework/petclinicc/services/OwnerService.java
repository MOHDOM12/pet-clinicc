package mohd.springframework.petclinicc.services;

import mohd.springframework.petclinicc.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
