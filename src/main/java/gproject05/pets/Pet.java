package gproject05.pets;
/**
 * Represents a pet.
 * <p>
 * This is an abstract class that serves as a base class for different types of pets (e.g., Dog, Cat, ExoticAnimal).
 * It defines common properties and behaviors for all pets, such as ID, name, species, age, and adoption status.
 * The class also provides methods to adopt a pet, compare pets by name, and get basic information about the pet.
 * </p>
 */
public abstract class Pet implements Comparable<Pet> {
	protected int id;
    protected String name;
    protected String species;
    protected int age;
    protected boolean isAdopted;
    /**
     * Constructs a new Pet with the specified properties.
     * <p>
     * Initializes the pet with the given ID, name, species, age, and adoption status.
     * </p>
     *
     * @param id the unique identifier for the pet
     * @param name the name of the pet
     * @param species the species of the pet
     * @param age the age of the pet
     * @param adopted the adoption status of the pet
     */
    public Pet(int id, String name, String species, int age, boolean adopted) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.isAdopted = adopted;
    }
    /**
     * Gets the type of the pet.
     * <p>
     * This is an abstract method that must be implemented by subclasses to return the specific type of pet.
     * </p>
     *
     * @return the type of the pet
     */
    public abstract PetType getType(); 
    /**
     * Adopts the pet if it has not already been adopted.
     * <p>
     * If the pet is not adopted, it sets the adoption status to true and returns true.
     * If the pet has already been adopted, it returns false.
     * </p>
     *
     * @return true if the pet was successfully adopted, false if the pet was already adopted
     */
    public boolean adopt() {
    	if(isAdopted) {
    		return false;
    	}
    	isAdopted = true;
    	return true;
    }
    /**
     * Gets the ID of the pet.
     *
     * @return the unique identifier of the pet
     */
	public int getId() {
		return id;
	}
	/**
     * Sets the ID of the pet.
     *
     * @param id the new ID for the pet
     */
	public void setId(int id) {
		this.id = id;
	}
	/**
     * Gets the name of the pet.
     *
     * @return the name of the pet
     */
	public String getName() {
		return name;
	}
	/**
     * Sets the name of the pet.
     *
     * @param name the new name for the pet
     */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * Gets the species of the pet.
     *
     * @return the species of the pet
     */
	public String getSpecies() {
		return species;
	}
	/**
     * Sets the species of the pet.
     *
     * @param species the new species for the pet
     */
	public void setSpecies(String species) {
		this.species = species;
	}
	/**
     * Gets the age of the pet.
     *
     * @return the age of the pet
     */
	public int getAge() {
		return age;
	}
	/**
     * Sets the age of the pet.
     *
     * @param age the new age for the pet
     */
	public void setAge(int age) {
		this.age = age;
	}
	/**
     * Gets the adoption status of the pet.
     *
     * @return true if the pet is adopted, false otherwise
     */
	public boolean isAdopted() {
		return isAdopted;
	}
	/**
     * Sets the adoption status of the pet.
     *
     * @param isAdopted the adoption status of the pet
     */
	public void setAdopted(boolean isAdopted) {
		this.isAdopted = isAdopted;
	}
	/**
     * Returns a string representation of the pet.
     * <p>
     * The string representation includes the pet's name, species, and age.
     * </p>
     *
     * @return a string representation of the pet
     */
	@Override
	public String toString() {
		return name + "; " + species + ", " + age + " years old.";
	}
	/**
     * Compares this pet with another pet by name.
     * <p>
     * This method compares pets using their names, ignoring case differences.
     * </p>
     *
     * @param other the pet to be compared
     * @return a negative integer, zero, or a positive integer as this pet's name is lexicographically less than, equal to, or greater than the specified pet's name
     */
	@Override
    public int compareTo(Pet other) {
        return this.name.compareToIgnoreCase(other.name);
    }
	
	
}
