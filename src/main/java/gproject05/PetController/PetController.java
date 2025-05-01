package gproject05.PetController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import gproject05.model.PetListModel;
import gproject05.petloader.ExoticAnimalAdapter;
import gproject05.petloader.ExoticAnimalJson;
import gproject05.petloader.PetLoader;
import gproject05.pets.Cat;
import gproject05.pets.Dog;
import gproject05.pets.Pet;
import gproject05.pets.Rabbit;
import gproject05.shelter.Shelter;
import gproject05.shelter.ShelterSaver;
import gproject05.view.PetInputView;
import gproject05.view.PetListView;
import gproject05.comparator.*;
/**
 * The controller class that manages interactions between the PetListView,
 * PetListModel, and other components of the Pet Management application.
 * <p>
 * This class handles user actions such as removing pets, adopting pets, viewing pet details,
 * sorting the pet list, adding new pets, and saving the pet list to a file.
 * </p>
 */
public class PetController {
	private PetListView petListView;
	private PetListModel petListModel;
	private PetInputView petInputView;
	/**
     * Constructs a PetController that initializes the view and model,
     * sets up event listeners, and loads the initial data for the pet shelter.
     *
     * @param view the PetListView to be controlled
     * @param model the PetListModel to store the pet data
     * @throws FileNotFoundException if a required file cannot be found during initialization
     */
	public PetController(PetListView view, PetListModel model) throws FileNotFoundException {
		this.petListView = view;
		this.petListModel = model;
		this.petInputView = new PetInputView();
		this.petListView.addActionListenerToRemovePetButton(new RemovePetButtonActionListener());
		this.petListView.addActionListenerToAdoptButton(new AdoptPetButtonActionListener());
		this.petListView.addActionListenerToViewDetailsButton(new ViewDetailsButtonActionListener());
		this.petListView.addActionListenerToSortComboBox(new SortComboBoxActionListener());
		this.petListView.addActionListenerToSaveButton(new SaveButtonActionListener());
		this.petListView.addActionListenerToAddButton(new AddButtonActionListener());
		this.petInputView.addActionListenerToSubmitButton(new SubmitPetButtonActionListener());
		
		//initialize shelter and import pets, send PetList to model and view
		Shelter<Pet> shelter = initShelter();
		model.setPetList(shelter.getPetList());
		for(Pet pet : shelter.getPetList()) {
			view.getList().addElement(pet);
		}
		
	}
	
	/**
     * Displays the pet list view to the user.
     */
	public void initiate() {
		petListView.setVisible(true);
	}
	/**
     * Initializes the shelter by loading standard and exotic pets, then sorts them.
     *
     * @return a Shelter containing the pets
     * @throws FileNotFoundException if any required files for loading pets cannot be found
     */
	public Shelter<Pet> initShelter() throws FileNotFoundException {
		Shelter<Pet> shelter = new Shelter<>();
		List<Pet> standardPets = PetLoader.loadStandardPets();
        shelter.addPets(standardPets);
        
        List<ExoticAnimalJson> exoticJsonList = PetLoader.loadExoticPets();
        List<Pet> adaptedExoticPets = ExoticAnimalAdapter.adaptJsonList(exoticJsonList);
        shelter.addPets(adaptedExoticPets);
        shelter.sortPetsDefault();
        
        return shelter;
	}
	/**
     * The action listener for removing a selected pet from the pet list.
     */
	private class RemovePetButtonActionListener implements ActionListener {
		/**
         * Removes the selected pet from the list. If no pet is selected, a message is displayed.
         *
         * @param e the action event triggered by clicking the remove pet button
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = petListView.getSelectedPet();
			if (selectedPetIndex == -1) {
		        JOptionPane.showMessageDialog(null, "Please select a pet first.");
		        return;
		    }
			petListView.getList().remove(selectedPetIndex);
			petListModel.getPetList().remove(selectedPetIndex);
			
		}
	}
	/**
     * The action listener for adopting a selected pet.
     * Ensures the pet is not already adopted before updating its status.
     */
	private class AdoptPetButtonActionListener implements ActionListener {
		/**
         * Adopts the selected pet if it is not already adopted. If no pet is selected, or the pet is already adopted,
         * an error message is displayed.
         *
         * @param e the action event triggered by clicking the adopt pet button
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = petListView.getSelectedPet();
			if (selectedPetIndex == -1) {
		        JOptionPane.showMessageDialog(null, "Please select a pet first.");
		        return;
		    }
			Pet pet = petListModel.getPetList().get(selectedPetIndex);
			
			if(pet.isAdopted()) {
				JOptionPane.showMessageDialog(null,
			            "This pet has already been adopted.",
			            "Action Not Allowed",
			            JOptionPane.ERROR_MESSAGE);
			        return;
			}
			petListView.getList().get(selectedPetIndex).setAdopted(true);
			petListModel.getPetList().get(selectedPetIndex).setAdopted(true);
			petListView.getList().setElementAt(pet, selectedPetIndex);
			JOptionPane.showMessageDialog(null,
			        pet.getName() + " adopted successfully!",
			        "Success",
			        JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
     * The action listener for viewing the details of a selected pet.
     * Displays pet details in a message dialog.
     */
	private class ViewDetailsButtonActionListener implements ActionListener {
		/**
         * Displays the details of the selected pet. If no pet is selected, a message is displayed.
         *
         * @param e the action event triggered by clicking the view details button
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			int index = petListView.getSelectedPet();
		    if (index == -1) {
		        JOptionPane.showMessageDialog(null, "Please select a pet first.");
		        return;
		    }

		    Pet selectedPet = petListModel.getPetList().get(index);
		    String details = "ID: " + selectedPet.getId() +
		    				 "\nName: " + selectedPet.getName() +
		                     "\nType: " + selectedPet.getType() +
		                     "\nAge: " + selectedPet.getAge() +
		                     "\nAdopted: " + (selectedPet.isAdopted() ? "Yes" : "No");

		    JOptionPane.showMessageDialog(null, details, "Pet Details", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	/**
     * The action listener for sorting pets based on selected criteria from a combo box.
     * Supports sorting by Name, Species, or Age.
     */
	private class SortComboBoxActionListener implements ActionListener {
		/**
         * Sorts the pet list based on the selected criterion from the combo box.
         * It updates both the view and the model.
         *
         * @param e the action event triggered by selecting a sorting criterion from the combo box
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			String selected = (String) petListView.getSelectedItemFromComboBox();
	        
			switch(selected) {
	        	case "Name":
	        		//update PetListView
	        		DefaultListModel<Pet> model = petListView.getList();
	        		
	        		List<Pet> pets = new ArrayList<>();
	        		for (int i = 0; i < model.size(); i++) {
	        		    pets.add(model.getElementAt(i));
	        		}
	        		Collections.sort(pets);
	        		
	        		model.clear();
	        		for (Pet pet : pets) {
	        		    model.addElement(pet);
	        		}
	        		
	        		//Update PetListModel
	        		Collections.sort(petListModel.getPetList());
	        		return;
	        		
	        	case "Species":
	        		//Update PetListView
	        		DefaultListModel<Pet> model1 = petListView.getList();
	        		
	        		List<Pet> pets1 = new ArrayList<>();
	        		for (int i = 0; i < model1.size(); i++) {
	        		    pets1.add(model1.getElementAt(i));
	        		}
	        		Collections.sort(pets1, new PetSpeciesComparator());
	        		
	        		model1.clear();
	        		for (Pet pet : pets1) {
	        		    model1.addElement(pet);
	        		}
	        		
	        		//Update PetListModel
	        		Collections.sort(petListModel.getPetList(), new PetSpeciesComparator());
	        		
	        		return;
	        		
	        	case "Age":
	        		//Update PetListView
	        		DefaultListModel<Pet> model2 = petListView.getList();
	        		
	        		List<Pet> pets2 = new ArrayList<>();
	        		for (int i = 0; i < model2.size(); i++) {
	        		    pets2.add(model2.getElementAt(i));
	        		}
	        		Collections.sort(pets2, new PetAgeComparator());
	        		
	        		model2.clear();
	        		for (Pet pet : pets2) {
	        		    model2.addElement(pet);
	        		}
	        		
	        		//Update PetListModel
	        		Collections.sort(petListModel.getPetList(), new PetAgeComparator());
	        		
	        		return;
	        }
		}
	}
	/**
     * The action listener for saving the pet list to a file.
     */
	private class SaveButtonActionListener implements ActionListener {
		/**
         * Saves the current pet list to a JSON file and displays a success message.
         *
         * @param e the action event triggered by clicking the save button
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			ShelterSaver.savePetsToJson(petListModel.getPetList());
			JOptionPane.showMessageDialog(null,
			        "Pets saved successfully!",
			        "Success",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	/**
     * The action listener for opening the pet input form to add a new pet.
     */
	private class AddButtonActionListener implements ActionListener {
		/**
         * Displays the pet input form to the user.
         *
         * @param e the action event triggered by clicking the add button
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			petInputView.setVisible(true);
		}
	}
	/**
     * The action listener for submitting a new pet's information.
     * Validates inputs and adds a new pet to the list if valid.
     */
	private class SubmitPetButtonActionListener implements ActionListener {
		/**
         * Validates the inputs for the new pet, creates a new Pet, and adds it to the list.
         * Displays error messages if validation fails.
         *
         * @param e the action event triggered by clicking the submit button on the pet input form
         */
		@Override
		public void actionPerformed(ActionEvent e) {
			String newPetName = petInputView.getPetName();
			String newPetSpecies = petInputView.getPetSpecies();
			String stringPetAge = petInputView.getPetAge();
			String stringPetType = petInputView.getPetType().toLowerCase();
			Integer newPetAge = 0;
			Pet newPet = null;
			int idIncrement = petListModel.getPetList().size();
			
			
			if(newPetName.trim().isEmpty() || stringPetAge.trim().isEmpty() || stringPetType.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null,
			            "Every field is required!",
			            "Input Error",
			            JOptionPane.ERROR_MESSAGE);
			        return;
			}
			
			try {
				newPetAge = Integer.parseInt(stringPetAge);
				if (newPetAge <= 0) {
			        JOptionPane.showMessageDialog(null,
			            "Age must be a positive, non-zero number.",
			            "Input Error",
			            JOptionPane.ERROR_MESSAGE);
			        petInputView.resetPetAgeTextField();
			        return;
			    }
			}catch(NumberFormatException n) {
			    JOptionPane.showMessageDialog(null,
			            "Please enter a valid number for age.",
			            "Input Error",
			            JOptionPane.ERROR_MESSAGE);
			    petInputView.resetPetAgeTextField();
				return;
			}
			
			switch(stringPetType) {
				case "dog":
					newPet = new Dog(idIncrement++, newPetName, newPetSpecies, newPetAge, false);
					break;
				case "cat":
					newPet = new Cat(idIncrement++, newPetName, newPetSpecies, newPetAge, false);
					break;
				case "rabbit":
					newPet = new Rabbit(idIncrement++, newPetName, newPetSpecies, newPetAge, false);
					break;
				default:
					JOptionPane.showMessageDialog(null,
				            "Please enter a valid pet type.",
				            "Input Error",
				            JOptionPane.ERROR_MESSAGE);
					petInputView.resetPetTypeTextField();
					return;
			}
			
			petListView.getList().addElement(newPet);
			petListModel.getPetList().add(newPet);
			petInputView.resetTextFields();
			
			//sort list by name to accommodate new element
			DefaultListModel<Pet> model = petListView.getList();
    		
    		List<Pet> pets = new ArrayList<>();
    		for (int i = 0; i < model.size(); i++) {
    		    pets.add(model.getElementAt(i));
    		}
    		Collections.sort(pets);
    		
    		model.clear();
    		for (Pet pet : pets) {
    		    model.addElement(pet);
    		}
    		
    		//Update PetListModel as well
    		Collections.sort(petListModel.getPetList());
    		return;
		}
	}
	
	
	
}

