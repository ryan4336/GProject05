package gproject05.pets;

public class ExoticAnimal extends Pet{
	private PetType type = PetType.EXOTIC;
	
	public ExoticAnimal(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public PetType getType() {
		return type;
	}
	
}
