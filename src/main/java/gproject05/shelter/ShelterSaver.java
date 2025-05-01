package gproject05.shelter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gproject05.pets.Pet;

public class ShelterSaver {
	
	public static void savePetsToJson(List<Pet> pets) {
        
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String fileName = timestamp + "_pets.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(pets, writer);
            System.out.println("\nPets saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
