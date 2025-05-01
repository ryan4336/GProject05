package gproject05.petloader;
/**
 * Represents the JSON structure for exotic animal data.
 * <p>
 * This class holds the properties of an exotic animal as they are represented in the JSON format, 
 * such as a unique identifier, name, category, sub-species, and age.
 * </p>
 */
public class ExoticAnimalJson {
	
    private String uniqueId;
    private String animalName;
    private String category;
    private String subSpecies;
    private int yearsOld;
    /**
     * Gets the unique identifier for the exotic animal.
     *
     * @return the unique ID of the exotic animal
     */
	public String getUniqueId() {
		return uniqueId;
	}
	/**
     * Gets the name of the exotic animal.
     *
     * @return the name of the exotic animal
     */
	public String getAnimalName() {
		return animalName;
	}
	/**
     * Gets the category of the exotic animal.
     *
     * @return the category of the exotic animal
     */
	public String getCategory() {
		return category;
	}
	/**
     * Gets the sub-species of the exotic animal.
     *
     * @return the sub-species of the exotic animal
     */
	public String getSubSpecies() {
		return subSpecies;
	}
	/**
     * Gets the age of the exotic animal in years.
     *
     * @return the age of the exotic animal
     */
	public int getYearsOld() {
		return yearsOld;
	}
    	
}
