package gproject05.main;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;

import gproject05.PetController.PetController;
import gproject05.comparator.*;
import gproject05.model.PetListModel;
import gproject05.petloader.ExoticAnimalAdapter;
import gproject05.petloader.ExoticAnimalJson;
import gproject05.petloader.PetLoader;
import gproject05.pets.Pet;
import gproject05.shelter.Shelter;
import gproject05.shelter.ShelterSaver;
import gproject05.view.PetListView;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
//        Shelter<Pet> shelter = new Shelter<>();
//
//        //load standard pets and add to shelter
//        List<Pet> standardPets = PetLoader.loadStandardPets();
//        shelter.addPets(standardPets);
//
//        //load exotic pets and use adapter to adapt + add to shelter
//        List<ExoticAnimalJson> exoticJsonList = PetLoader.loadExoticPets();
//        List<Pet> adaptedExoticPets = ExoticAnimalAdapter.adaptJsonList(exoticJsonList);
//        shelter.addPets(adaptedExoticPets);
        
        
//        System.out.println("Pets in the shelter:");
//        for (Pet pet : shelter.getPets()) {
//            System.out.println(pet.toString());
//        }
//        
//        //sort by name (comparable)
//        Collections.sort(shelter.getPets());
//        
//        System.out.println("\nPets sorted by name:");
//        for (Pet pet : shelter.getPets()) {
//            System.out.println(pet.toString());
//        }
//        
//        //sort by age (comparator)
//        Collections.sort(shelter.getPets(), new PetAgeComparator());
//        
//        System.out.println("\nPets sorted by age:");
//        for (Pet pet : shelter.getPets()) {
//            System.out.println(pet.toString());
//        }
//        
//        //sort by species (comparator)
//        Collections.sort(shelter.getPets(), new PetSpeciesComparator());
//        
//        System.out.println("\nPets sorted by species:");
//        for (Pet pet : shelter.getPets()) {
//            System.out.println(pet.toString());
//        }
//        
        //save pets to Json file
//        ShelterSaver.savePetsToJson(shelter.getPets());
        
        SwingUtilities.invokeLater(() -> {
            PetController controller = null;
			try {
				controller = new PetController(new PetListView(), new PetListModel());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
            controller.initiate();
            
            
        });
    }

}
