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
import gproject05.pets.PetType;
import gproject05.pets.Rabbit;
import gproject05.shelter.Shelter;
import gproject05.shelter.ShelterSaver;
import gproject05.view.PetInputView;
import gproject05.view.PetListView;
import gproject05.comparator.*;

public class PetController {
	private PetListView petListView;
	private PetListModel petListModel;
	private PetInputView petInputView;
	
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
	
	
	public void initiate() {
		petListView.setVisible(true);
	}
	
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
	
	private class RemovePetButtonActionListener implements ActionListener {
		
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
	
	private class AdoptPetButtonActionListener implements ActionListener {

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
	
	private class ViewDetailsButtonActionListener implements ActionListener {

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
	
	private class SortComboBoxActionListener implements ActionListener {

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
	
	private class SaveButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ShelterSaver.savePetsToJson(petListModel.getPetList());
			JOptionPane.showMessageDialog(null,
			        "Pets saved successfully!",
			        "Success",
			        JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	private class AddButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			petInputView.setVisible(true);
		}
	}
	
	private class SubmitPetButtonActionListener implements ActionListener {

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

