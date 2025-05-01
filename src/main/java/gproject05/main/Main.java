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
/**
 * The entry point for the Pet Management application.
 * 
 * This class initializes the GUI on the Event Dispatch Thread
 * and sets up the MVC components: PetListView, PetListModel, and PetController.
 * 
 */
public class Main {
	/**
     * The main method that starts the application.
     * Uses SwingUtilities invokeLater(Runnable) to ensure that the GUI is created and updated.
     *
     * @param args command-line arguments (not used)
     * @throws FileNotFoundException if the required data file is not found during controller initialization
     */
	public static void main(String[] args) throws FileNotFoundException {
        
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
