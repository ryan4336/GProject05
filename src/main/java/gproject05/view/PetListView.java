package gproject05.view;

import java.awt.event.ActionListener;

import javax.swing.*;
import gproject05.pets.Pet;


@SuppressWarnings("serial")
public class PetListView extends JFrame {
	private JPanel panel;
	private JList<Pet> list;
	private JButton removeButton;
	private JButton adoptButton;
	private JButton viewDetailsButton;
	private JButton saveButton;
	private JTextField txtSortBy;
	private JButton addButton;
	private JComboBox<String> sortComboBox;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PetListView() {
		setTitle("Pet List Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>();
		list = new JList<Pet>(modelList);
		
		list.setBounds(6, 6, 488, 288);
		panel.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		addButton = new JButton("Add Pet");
		addButton.setBounds(6, 306, 100, 29);
		panel.add(addButton);
		
		removeButton = new JButton("Remove Pet");
		removeButton.setBounds(6, 337, 100, 29);
		panel.add(removeButton);
		
		adoptButton = new JButton("Adopt Pet");
		adoptButton.setBounds(118, 337, 92, 29);
		panel.add(adoptButton);
		
		viewDetailsButton = new JButton("View Details");
		viewDetailsButton.setBounds(222, 337, 108, 29);
		panel.add(viewDetailsButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(377, 337, 117, 29);
		panel.add(saveButton);
		
		sortComboBox = new JComboBox();
		sortComboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Species", "Age"}));
		sortComboBox.setBounds(377, 307, 105, 27);
		panel.add(sortComboBox);
		
		txtSortBy = new JTextField();
		txtSortBy.setText("Sort by:");
		txtSortBy.setBounds(317, 306, 64, 26);
		panel.add(txtSortBy);
		txtSortBy.setColumns(10);
		
	}


	
	public DefaultListModel<Pet> getList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	
	public int getSelectedPet() {
		return list.getSelectedIndex();
	}

	public void addActionListenerToRemovePetButton(ActionListener listener) {
		removeButton.addActionListener(listener);
	}
	
	public void addActionListenerToAdoptButton(ActionListener listener) {
		adoptButton.addActionListener(listener);
		
	}
	
	public void addActionListenerToViewDetailsButton(ActionListener listener) {
		viewDetailsButton.addActionListener(listener);
		
	}

	public void addActionListenerToSortComboBox(ActionListener listener) {
		sortComboBox.addActionListener(listener);
	}

	public String getSelectedItemFromComboBox() {
		return (String) sortComboBox.getSelectedItem();
		
	}



	
	
	
	
}
