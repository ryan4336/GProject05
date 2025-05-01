package gproject05.petloader;
/**
 * Represents the JSON structure for a pet.
 * <p>
 * This class holds the properties of a pet as they are represented in the JSON format, including
 * an ID, name, species, age, adoption status, and type.
 * </p>
 */
public class PetJson {
	private int id;
    private String name;
    private String species;
    private int age;
    private boolean adopted;
    private String type;
    /**
     * Gets the ID of the pet.
     *
     * @return the ID of the pet
     */
	public int getId() {
		return id;
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
     * Gets the species of the pet.
     *
     * @return the species of the pet
     */
	public String getSpecies() {
		return species;
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
     * Checks if the pet has been adopted.
     *
     * @return {@code true} if the pet is adopted, {@code false} otherwise
     */
	public boolean isAdopted() {
		return adopted;
	}
	/**
     * Gets the type of the pet (e.g., dog, cat, etc.).
     *
     * @return the type of the pet
     */
	public String getType() {
		return type;
	}
    
}
