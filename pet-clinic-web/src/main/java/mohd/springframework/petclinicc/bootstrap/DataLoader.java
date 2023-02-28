package mohd.springframework.petclinicc.bootstrap;

import mohd.springframework.petclinicc.model.Owner;
import mohd.springframework.petclinicc.model.Vet;
import mohd.springframework.petclinicc.services.OwnerService;
import mohd.springframework.petclinicc.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Mohammed");
        owner1.setLastName("Alomran");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Naif");
        owner2.setLastName("Ibrahim");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Faris");
        vet1.setLastName("Ibrahim");

        vetService.save(vet1);

        Vet vet2= new Vet();
        vet2.setFirstName("Fisal");
        vet2.setLastName("Alali");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
