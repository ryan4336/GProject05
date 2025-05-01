package gproject05.pets;
/**
 * Represents a rabbit pet.
 * <p>
 * This class extends the Pet class and represents a rabbit type pet. It
 * overrides the getType method to return PetType.RABBIT as the pet's type.
 * </p>
 */
public class Rabbit extends Pet{
	private PetType type = PetType.RABBIT;

    /**
     * Constructs a new Rabbit instance.
     *
     * @param id The unique identifier for the rabbit.
     * @param name The name of the rabbit.
     * @param species The species of the rabbit.
     * @param age The age of the rabbit in years.
     * @param adopted The adoption status of the rabbit.
     */
	public Rabbit(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}
	/**
     * Returns the type of pet, which is PetType.RABBIT.
     *
     * @return The pet type, PetType.RABBIT.
     */
	@Override
	public PetType getType() {
		return type;
	}

}
