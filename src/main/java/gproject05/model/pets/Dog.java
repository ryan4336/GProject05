package gproject05.model.pets;

public class Dog extends Pet{
	private PetType type = PetType.DOG;

	public Dog(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public PetType getType() {
		return type;
	}
	
	
}
