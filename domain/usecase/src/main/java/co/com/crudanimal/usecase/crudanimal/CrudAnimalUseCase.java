package co.com.crudanimal.usecase.crudanimal;

import co.com.crudanimal.model.animal.Animal;
import co.com.crudanimal.model.animal.gateways.AnimalRepository;
import lombok.AllArgsConstructor;


import java.util.List;

@AllArgsConstructor
public class CrudAnimalUseCase {
     private AnimalRepository animalRepository;
     public void create(Animal animal){animalRepository.create(animal);}
     public Animal read(String id){ return animalRepository.read(id);}
     public Animal update(String id, Animal animal) throws Exception {
         animalRepository.update(id, animal);
         return animal;
     }
     public void delete(String id) {animalRepository.delete(id);}
     public List<Animal> getAll() {return animalRepository.getAll();}
}
