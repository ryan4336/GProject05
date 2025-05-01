package gproject05.petloader;

import java.util.ArrayList;
import java.util.List;

import gproject05.pets.ExoticAnimal;
import gproject05.pets.Pet;

public class ExoticAnimalAdapter {
	public static List<Pet> adaptJsonList(List<ExoticAnimalJson> exoticJsonList) {
		List<Pet> adaptedAnimals = new ArrayList<Pet>();
        int idCounter = 1000; 

        for (ExoticAnimalJson json : exoticJsonList) {
            ExoticAnimal exoticPet = new ExoticAnimal(
                idCounter++,
                json.getAnimalName(),
                json.getSubSpecies(),
                json.getYearsOld(),
                false
            );
            adaptedAnimals.add(exoticPet);
        }
        return adaptedAnimals;
    }
}
