package gproject05.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gproject05.pets.Pet;
/**
 * Represents a shelter that holds a collection of pets.
 * <p>
 * This class allows adding, adopting, and sorting pets in the shelter. It works
 * with any type of pet that extends the Pet class, as indicated by the
 * generic type parameter T.
 * </p>
 *
 * @param <T> The type of pet, which must be a subclass of Pet.
 */
public class Shelter<T extends Pet>{
	private List<T> pets;
	/**
     * Constructs a new shelter with an empty list of pets.
     */
	public Shelter() {
		pets = new ArrayList<T>();
	}
	/**
     * Adds a list of pets to the shelter.
     *
     * @param petList The list of pets to be added.
     */
	public void addPets(List<T> petList) {
        for(T pet : petList) {
        	pets.add(pet);
        }
    }
	/**
     * Adds a single pet to the shelter.
     *
     * @param pet The pet to be added.
     */
    public void addPet(T pet) {
        pets.add(pet);
    }
    /**
     * Returns the list of pets in the shelter.
     *
     * @return A list containing all pets in the shelter.
     */
    public List<T> getPetList() {
        return pets;
    }
    /**
     * Adopts a pet from the shelter, setting its adoption status to true.
     *
     * @param pet The pet to be adopted.
     */
    public void adoptPet(T pet) {
        pet.setAdopted(true);
    }
    /**
     * Sorts the pets in the shelter using the default sorting order, 
     * based on the Pet compareTo method.
     */
    public void sortPetsDefault() {
    	Collections.sort(pets);
    }
}
