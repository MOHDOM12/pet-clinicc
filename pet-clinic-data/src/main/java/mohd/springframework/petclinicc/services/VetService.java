package mohd.springframework.petclinicc.services;

import mohd.springframework.petclinicc.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long> {

    Vet findById(Long id);

    Vet save(Vet owner);
    Set<Vet> findAll();
}
