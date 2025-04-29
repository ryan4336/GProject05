package gproject05.pets;

public abstract class Pet {
	private int id;
	private String name;
	private PetType type;
	private String species;
	private int age;
	private boolean isAdopted;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PetType getType() {
		return type;
	}
	public void setType(PetType type) {
		this.type = type;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAdopted() {
		return isAdopted;
	}
	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", species=" + species + ", age=" + age
				+ ", isAdopted=" + isAdopted + "]";
	}
	
	
}
