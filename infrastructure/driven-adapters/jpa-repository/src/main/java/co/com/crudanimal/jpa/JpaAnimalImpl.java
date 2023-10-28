package co.com.crudanimal.jpa;

import co.com.crudanimal.model.animal.Animal;
import co.com.crudanimal.model.animal.gateways.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@AllArgsConstructor
public class JpaAnimalImpl implements AnimalRepository {

    private JPARepositoryAdapter jpaRepositoryAdapter;

    @Override
    public void create(Animal animal) {
        String id = UUID.randomUUID().toString();
        animal.setId(id);
        jpaRepositoryAdapter.save(animal);
    }
    @Override
    public List<Animal> getAll() {
        return jpaRepositoryAdapter.findAll();
    }
    @Override
    public Animal read(String id) {return jpaRepositoryAdapter.findById(id);}

    @Override
    public Animal update(String id, Animal animal) throws Exception {
        Animal animalDb = jpaRepositoryAdapter.findById(id);

        if (animalDb == null) throw new Exception("Animal Not Found : " + id);

        animalDb.setGender(animal.getGender());
        animalDb.setLegs(animal.getLegs());
        animalDb.setSpecies(animal.getSpecies());
        animalDb.setHabitat(animal.getHabitat());
        animalDb.setDomestic(animal.getDomestic());

        jpaRepositoryAdapter.save(animalDb);
        return animalDb;
    }

    @Override
    public void delete(String id) {
        jpaRepositoryAdapter.deleteById(id);
    }


}

