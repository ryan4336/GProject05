package gproject05.pets;
/**
 * Represents a cat pet.
 * <p>
 * This class extends the Pet class and represents a specific type of pet: a cat.
 * It sets the pet type to PetType.CAT and provides the necessary constructor and behavior.
 * </p>
 */
public class Cat extends Pet {

	private PetType type = PetType.CAT;
	/**
     * Constructs a new Cat with the given properties.
     * <p>
     * This constructor initializes the pet with the provided ID, name, species, age, and adoption status.
     * The pet type is automatically set to PetType CAT.
     * </p>
     *
     * @param id the unique identifier of the pet
     * @param name the name of the cat
     * @param species the species of the cat
     * @param age the age of the cat
     * @param adopted the adoption status of the cat
     */
	public Cat(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	/**
     * Gets the type of the pet, which is PetType CAT.
     *
     * @return the type of the pet, PetType CAT
     */
	@Override
	public PetType getType() {
		return type;
	}
	
}
