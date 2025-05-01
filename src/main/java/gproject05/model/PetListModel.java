package gproject05.model;

import java.util.ArrayList;
import java.util.List;

import gproject05.pets.Pet;

public class PetListModel {
	private List<Pet> petList;

	public PetListModel() {
		petList = new ArrayList<Pet>();
		
	}

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}
	
	
    
}
