package gproject05.comparator;

import java.util.Comparator;

import gproject05.pets.Pet;
/**
 * A comparator for Pet objects that compares them based on their age.
 * This comparator imposes an ordering based on ascending age.
 */
public class PetAgeComparator implements Comparator<Pet> {
	/**
     * Compares two Pet objects by their age.
     *
     * @param p1 the first pet to be compared
     * @param p2 the second pet to be compared
     * @return a negative integer, zero, or a positive integer as the first pet is
     *         younger than, the same age as, or older than the second pet
     */
    @Override
    public int compare(Pet p1, Pet p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
	
}
