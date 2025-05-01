package gproject05.pets;
/**
 * Represents an exotic animal pet.
 * <p>
 * This class extends the Pet class and represents a specific type of pet: an exotic animal.
 * It sets the pet type to PetType.EXOTIC and provides the necessary constructor and behavior.
 * </p>
 */
public class ExoticAnimal extends Pet{
	private PetType type = PetType.EXOTIC;
	/**
     * Constructs a new ExoticAnimal with the given properties.
     * <p>
     * This constructor initializes the pet with the provided ID, name, species, age, and adoption status.
     * The pet type is automatically set to PetType.EXOTIC.
     * </p>
     *
     * @param id the unique identifier of the pet
     * @param name the name of the exotic animal
     * @param species the species of the exotic animal
     * @param age the age of the exotic animal
     * @param adopted the adoption status of the exotic animal
     */
	public ExoticAnimal(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	/**
     * Gets the type of the pet, which is PetType.EXOTIC.
     *
     * @return the type of the pet, PetType.EXOTIC
     */
	@Override
	public PetType getType() {
		return type;
	}
	
}
