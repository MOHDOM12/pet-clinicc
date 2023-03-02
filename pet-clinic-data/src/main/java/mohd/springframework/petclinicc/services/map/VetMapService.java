package mohd.springframework.petclinicc.services.map;

import mohd.springframework.petclinicc.model.Speciality;
import mohd.springframework.petclinicc.model.Vet;

import mohd.springframework.petclinicc.services.SpecialityService;
import mohd.springframework.petclinicc.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findByID(Long id) {
        return super.findById(id);
    }
    @Override
    public Vet save(Vet object)
    {
        if(object.getSpecialities().size() > 0)
        {
            object.getSpecialities().forEach(speciality -> {
                if(speciality .getId() == null)
                {
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteId(Long id)
    {
     super.deleteById(id);
    }
}
