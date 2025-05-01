package gproject05.pets;
/**
 * Represents a dog pet.
 * <p>
 * This class extends the Pet class and represents a specific type of pet: a dog.
 * It sets the pet type to PetType.DOG and provides the necessary constructor and behavior.
 * </p>
 */
public class Dog extends Pet{
	private PetType type = PetType.DOG;
	/**
     * Constructs a new Dog with the given properties.
     * <p>
     * This constructor initializes the pet with the provided ID, name, species, age, and adoption status.
     * The pet type is automatically set to PetType.DOG.
     * </p>
     *
     * @param id the unique identifier of the pet
     * @param name the name of the dog
     * @param species the species of the dog
     * @param age the age of the dog
     * @param adopted the adoption status of the dog
     */
	public Dog(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	/**
     * Gets the type of the pet, which is PetType.DOG.
     *
     * @return the type of the pet, PetType.DOG
     */
	@Override
	public PetType getType() {
		return type;
	}
	
	
}
