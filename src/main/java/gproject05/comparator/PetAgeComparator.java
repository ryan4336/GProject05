package gproject05.comparator;

import java.util.Comparator;

import gproject05.pets.Pet;

public class PetAgeComparator implements Comparator<Pet> {
	
    @Override
    public int compare(Pet p1, Pet p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
	
}
