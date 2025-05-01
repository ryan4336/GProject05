package gproject05.view;

import java.awt.event.ActionListener;

import javax.swing.*;
import gproject05.pets.Pet;

/**
 * A graphical user interface (GUI) for displaying a list of pets.
 * <p>
 * This class represents a window that displays a list of pets in a JList component. 
 * It allows users to interact with the pet list by removing, adopting, viewing details, 
 * sorting, and saving pets. Additionally, users can add new pets through a button.
 * </p>
 */
@SuppressWarnings("serial")
public class PetListView extends JFrame {
	private JPanel panel;
	private JList<Pet> list;
	private JButton removeButton;
	private JButton adoptButton;
	private JButton viewDetailsButton;
	private JButton saveButton;
	private JButton addButton;
	private JComboBox<String> sortComboBox;
	
	/**
     * Constructs a new PetListView.
     * <p>
     * Initializes the GUI components including the pet list, buttons for various actions, 
     * and a combo box for sorting the pet list.
     * </p>
     */
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
		
		JLabel lblNewLabel = new JLabel("Sort by:");
		lblNewLabel.setBounds(328, 311, 61, 16);
		panel.add(lblNewLabel);
	}


	/**
     * Retrieves the model of the pet list.
     *
     * @return The DefaultListModel representing the list of pets.
     */
	public DefaultListModel<Pet> getList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	/**
     * Retrieves the index of the currently selected pet in the list.
     *
     * @return The index of the selected pet, or -1 if no pet is selected.
     */
	public int getSelectedPet() {
		return list.getSelectedIndex();
	}
	/**
     * Retrieves the selected sort option from the combo box.
     *
     * @return The selected sorting option (e.g., "Name", "Species", "Age").
     */
	public String getSelectedItemFromComboBox() {
		return (String) sortComboBox.getSelectedItem();
	}
	/**
     * Adds an action listener to the "Remove Pet" button.
     *
     * @param listener The action listener to be added to the remove button.
     */
	public void addActionListenerToRemovePetButton(ActionListener listener) {
		removeButton.addActionListener(listener);
	}
	/**
     * Adds an action listener to the "Adopt Pet" button.
     *
     * @param listener The action listener to be added to the adopt button.
     */
	public void addActionListenerToAdoptButton(ActionListener listener) {
		adoptButton.addActionListener(listener);
	}
	/**
     * Adds an action listener to the "View Details" button.
     *
     * @param listener The action listener to be added to the view details button.
     */
	public void addActionListenerToViewDetailsButton(ActionListener listener) {
		viewDetailsButton.addActionListener(listener);
	}
	/**
     * Adds an action listener to the sort combo box.
     *
     * @param listener The action listener to be added to the sort combo box.
     */
	public void addActionListenerToSortComboBox(ActionListener listener) {
		sortComboBox.addActionListener(listener);
	}
	/**
     * Adds an action listener to the "Save" button.
     *
     * @param listener The action listener to be added to the save button.
     */
	public void addActionListenerToSaveButton(ActionListener listener) {
		saveButton.addActionListener(listener);
	}
	/**
     * Adds an action listener to the "Add Pet" button.
     *
     * @param listener The action listener to be added to the add pet button.
     */
	public void addActionListenerToAddButton(ActionListener listener) {
		addButton.addActionListener(listener);
	}
}
