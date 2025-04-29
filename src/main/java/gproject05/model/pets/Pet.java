package gproject05.model.pets;

public abstract class Pet {
	protected int id;
    protected String name;
    protected String species;
    protected int age;
    protected boolean isAdopted;

    public Pet(int id, String name, String species, int age, boolean adopted) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.isAdopted = adopted;
    }

    public abstract PetType getType(); 
	
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
		return "Pet [id=" + id + ", name=" + name + ", species=" + species + ", age=" + age + ", isAdopted=" + isAdopted
				+ "]";
	}
	
	
}
