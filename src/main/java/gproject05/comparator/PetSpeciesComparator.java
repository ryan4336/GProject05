package gproject05.comparator;

import java.util.Comparator;

import gproject05.pets.Pet;

public class PetSpeciesComparator implements Comparator<Pet> {
	
    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
    }

}
