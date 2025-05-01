package gproject05.petloader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import gproject05.pets.Cat;
import gproject05.pets.Dog;
import gproject05.pets.Pet;
import gproject05.pets.Rabbit;

import java.io.FileNotFoundException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Reader;


public class PetLoader {

	public static List<Pet> loadStandardPets() throws FileNotFoundException {
        List<Pet> standardPetList = new ArrayList<Pet>();
        Gson gson = new Gson();
        
        
        try {
        	InputStream inputStream = PetLoader.class.getClassLoader().getResourceAsStream("pets.json");
        	if (inputStream == null) {
        	    throw new FileNotFoundException("Resource not found");
        	}
        	Reader reader = new InputStreamReader(inputStream);
            
            Type petListType = new TypeToken<List<PetJson>>() {}.getType();
            List<PetJson> petJsonList = gson.fromJson(reader, petListType);

            for (PetJson pj : petJsonList) {
            	Pet pet = null;
                switch (pj.getType().toUpperCase()) {
                    case "DOG":
                    	pet = new Dog(pj.getId(), pj.getName(), pj.getSpecies(), pj.getAge(), pj.isAdopted());
                    	break;
                    case "CAT":
                    	pet = new Cat(pj.getId(), pj.getName(), pj.getSpecies(), pj.getAge(), pj.isAdopted());
                    	break;
                    case "RABBIT":
                    	pet = new Rabbit(pj.getId(), pj.getName(), pj.getSpecies(), pj.getAge(), pj.isAdopted());
                    	break;
                    default:
                    	throw new IllegalArgumentException("Unknown pet type: " + pj.getType());
                	}
                standardPetList.add(pet);
            }
            
        } catch (Exception e) {
            	e.printStackTrace();
            }
        
            return standardPetList;
        }
	
	public static List<ExoticAnimalJson> loadExoticPets() throws FileNotFoundException {
        Gson gson = new Gson();
        InputStream inputStream = PetLoader.class.getClassLoader().getResourceAsStream("exotic_animals.json");
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found");
        }
    	Reader reader = new InputStreamReader(inputStream);
        
        try {
        	Type exoticListType = new TypeToken<List<ExoticAnimalJson>>() {}.getType();
            return gson.fromJson(reader, exoticListType);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

       
