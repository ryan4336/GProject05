package gproject05.PetController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import gproject05.model.PetListModel;
import gproject05.petloader.ExoticAnimalAdapter;
import gproject05.petloader.ExoticAnimalJson;
import gproject05.petloader.PetLoader;
import gproject05.pets.Pet;
import gproject05.shelter.Shelter;
import gproject05.view.PetListView;

public class PetController {
	private PetListView petListView;
	private PetListModel petListModel;
	
	public PetController(PetListView view, PetListModel model) throws FileNotFoundException {
		this.petListView = view;
		this.petListModel = model;
		this.petListView.addActionListenerToRemovePetButton(new RemovePetButtonActionListener());
		
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
        
        return shelter;
	}
	
	private class RemovePetButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedUser = petListView.getSelectedUser();
			petListView.getList().remove(selectedUser);
			petListModel.getPetList().remove(selectedUser);
			
		}
		
	}
	
}

