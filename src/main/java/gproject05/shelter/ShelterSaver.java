package gproject05.shelter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gproject05.pets.Pet;
/**
 * Utility class for saving pet data to a JSON file.
 * <p>
 * This class provides a method to save a list of Pet objects to a JSON file.
 * The file name includes a timestamp to ensure that each saved file has a unique name.
 * </p>
 */
public class ShelterSaver {
	/**
     * Saves a list of pets to a JSON file.
     * <p>
     * The file is named using the current timestamp in the format "yyyyMMdd_HHmmss_pets.json".
     * The JSON is written in a pretty-printed format for better readability.
     * </p>
     *
     * @param pets The list of pets to be saved.
     */
	public static void savePetsToJson(List<Pet> pets) {
        
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String fileName = timestamp + "_pets.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(pets, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
