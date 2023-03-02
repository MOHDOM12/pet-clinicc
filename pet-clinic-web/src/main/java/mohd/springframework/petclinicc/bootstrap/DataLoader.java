package mohd.springframework.petclinicc.bootstrap;

import mohd.springframework.petclinicc.model.*;
import mohd.springframework.petclinicc.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    private  final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0 ){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        dog.setId(2L);
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat.setId(3L);
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mohammed");
        owner1.setLastName("Alomran");
        owner1.setCity("jalajil");
        owner1.setAddress("Mohammed bin Abdalaziz");
        owner1.setTelephone("12123131232");

        Pet miPet = new Pet();
        miPet.setPetType(savedDogPetType);
        miPet.setOwner(owner1);
        miPet.setBirthDay(LocalDate.now());
        miPet.setName("Rosco");
        owner1.getPets().add(miPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Naif");
        owner2.setLastName("Ibrahim");
        owner2.setCity("Riyadh");
        owner2.setAddress("Sudair");
        owner2.setTelephone("48297447934");

        Pet fiCat = new Pet();
        fiCat.setName("Just cat");
        fiCat.setBirthDay(LocalDate.now());
        fiCat.setPetType(savedCatPetType);
        owner2.getPets().add(fiCat);

        ownerService.save(owner2);

        Visit catVisit =new Visit();
        catVisit.setPet(fiCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);
        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Faris");
        vet1.setLastName("Ibrahim");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Fisal");
        vet2.setLastName("Alali");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
