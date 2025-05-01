package gproject05.model;

import java.util.ArrayList;
import java.util.List;

import gproject05.pets.Pet;
/**
 * The model class for managing a list of Pet objects.
 * 
 * Provides methods to retrieve and update the internal list of pets.
 * 
 */
public class PetListModel {
	private List<Pet> petList;
	
	/**
     * Constructs a new PetListModel with an empty list of pets.
     */
	public PetListModel() {
		petList = new ArrayList<Pet>();
		
	}
	/**
     * Returns the list of pets.
     *
     * @return a List of type Pet representing the current list of pets
     */
	public List<Pet> getPetList() {
		return petList;
	}
	/**
     * Sets the list of pets.
     *
     * @param petList a List of type Pet to replace the current list
     */
	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}
	
	
    
}
