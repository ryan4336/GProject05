package gproject05.comparator;

import java.util.Comparator;

import gproject05.pets.Pet;
/**
 * A comparator for Pet objects that compares them based on their species.
 * The comparison is case-insensitive and uses lexicographical ordering.
 */
public class PetSpeciesComparator implements Comparator<Pet> {
	/**
     * Compares two Pet objects by their species name, ignoring case.
     *
     * @param p1 the first pet to be compared
     * @param p2 the second pet to be compared
     * @return a negative integer, zero, or a positive integer as the species of
     *         the first pet is lexicographically less than, equal to, or greater
     *         than the species of the second pet
     */
    @Override
    public int compare(Pet p1, Pet p2) {
        return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
    }

}
