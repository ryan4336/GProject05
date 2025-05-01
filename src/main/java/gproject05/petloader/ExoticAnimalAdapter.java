package gproject05.petloader;

import java.util.ArrayList;
import java.util.List;

import gproject05.pets.ExoticAnimal;
import gproject05.pets.Pet;
/**
 * A utility class responsible for adapting a list of ExoticAnimalJson objects to a list of Pet objects.
 * <p>
 * This class is used to convert the data from the JSON representation of exotic animals into ExoticAnimal objects,
 * which are a subtype of Pet.
 * </p>
 */
public class ExoticAnimalAdapter {
	/**
     * Adapts a list of ExoticAnimalJson objects to a list of Pet objects by converting each 
     * ExoticAnimalJson to an ExoticAnimal.
     * <p>
     * The method assigns a unique ID starting from 1000 to each adapted pet, and sets the initial adoption status to false.
     * </p>
     *
     * @param exoticJsonList a list of ExoticAnimalJson objects to be converted
     * @return a list of Pet objects, specifically ExoticAnimal objects, created from the input JSON data
     */
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
