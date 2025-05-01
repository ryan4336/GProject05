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
import gproject05.pets.Pet;
import gproject05.shelter.Shelter;
import gproject05.view.PetListView;
import gproject05.comparator.*;

public class PetController {
	private PetListView petListView;
	private PetListModel petListModel;
	
	public PetController(PetListView view, PetListModel model) throws FileNotFoundException {
		this.petListView = view;
		this.petListModel = model;
		this.petListView.addActionListenerToRemovePetButton(new RemovePetButtonActionListener());
		this.petListView.addActionListenerToAdoptButton(new AdoptPetButtonActionListener());
		this.petListView.addActionListenerToViewDetailsButton(new ViewDetailsButtonActionListener());
		this.petListView.addActionListenerToSortComboBox(new SortComboBoxActionListener());
		
		
		//initialize shelter and import pets, send PetList to model and view
		Shelter<Pet> shelter = initShelter();
		shelter.sortPetsDefault();
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
        
        return shelter;
	}
	
	private class RemovePetButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPet = petListView.getSelectedPet();
			petListView.getList().remove(selectedPet);
			petListModel.getPetList().remove(selectedPet);
			
		}
	}
	
	private class AdoptPetButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedPetIndex = petListView.getSelectedPet();
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
	
	
	
}

