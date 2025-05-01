package gproject05.shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gproject05.pets.Pet;

public class Shelter<T extends Pet>{
	private List<T> pets;
	
	public Shelter() {
		pets = new ArrayList<T>();
	}

	public void addPets(List<T> petList) {
        for(T pet : petList) {
        	pets.add(pet);
        }
    }

    public void addPet(T pet) {
        pets.add(pet);
    }

    public List<T> getPetList() {
        return pets;
    }

    public void adoptPet(T pet) {
        pet.setAdopted(true);
    }
    
    public void sortPetsDefault() {
    	Collections.sort(pets);
    }
}
