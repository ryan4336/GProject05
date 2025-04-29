package gproject05.model.pets;

public class Rabbit extends Pet{
	private PetType type = PetType.RABBIT;

	public Rabbit(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public PetType getType() {
		return type;
	}

}
