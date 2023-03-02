package mohd.springframework.petclinicc.services.Springdatajpa;

import mohd.springframework.petclinicc.model.Pet;
import mohd.springframework.petclinicc.model.Vet;
import mohd.springframework.petclinicc.repositories.VetRepository;
import mohd.springframework.petclinicc.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService
{

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return null;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }
    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
