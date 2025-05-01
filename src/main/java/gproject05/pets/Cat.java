package gproject05.pets;

public class Cat extends Pet {

	private PetType type = PetType.CAT;

	public Cat(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public PetType getType() {
		return type;
	}
	
}
