package gproject05.main;

import java.io.FileNotFoundException;
import java.util.List;

import gproject05.model.petloader.ExoticAnimalAdapter;
import gproject05.model.petloader.ExoticAnimalJson;
import gproject05.model.petloader.PetLoader;
import gproject05.model.pets.ExoticAnimal;
import gproject05.model.pets.Pet;
import gproject05.model.shelter.Shelter;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
        Shelter<Pet> shelter = new Shelter<>();

        //load standard pets and add to shelter
        List<Pet> standardPets = PetLoader.loadStandardPets();
        shelter.addPets(standardPets);

        //load exotic pets and use adapter to adapt + add to shelter
        List<ExoticAnimalJson> exoticJsonList = PetLoader.loadExoticPets();
        List<Pet> adaptedExoticPets = ExoticAnimalAdapter.adaptJsonList(exoticJsonList);
        shelter.addPets(adaptedExoticPets);
        

        
        System.out.println("Pets in the shelter:");
        for (Pet pet : shelter.getPets()) {
            System.out.println(pet.getName() + " is a " + pet.getType() + " (" + pet.getSpecies() + ")");
        }
    }

}
