package gproject05.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * A graphical user interface (GUI) for inputting pet information.
 * <p>
 * This class represents a window that allows users to input pet information such as name, type, age, and species. 
 * It provides text fields for user input and a submit button to capture the entered data.
 * </p>
 */
@SuppressWarnings("serial")
public class PetInputView extends JFrame{
	private JPanel panel;
	private JTextField petNameTextField;
	private JTextField petTypeTextField;
	private JTextField petAgeTextField;
	JButton submitButton;
	private JLabel petSpeciesLabel;
	private JTextField petSpeciesTextField;
	
	public PetInputView() {
		setTitle("Add Pet Information Page");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		petNameTextField = new JTextField();
		petNameTextField.setBounds(196, 25, 130, 26);
		panel.add(petNameTextField);
		petNameTextField.setColumns(10);
		
		JLabel petNameLabel = new JLabel("Enter Pet Name:");
		petNameLabel.setBounds(96, 30, 110, 16);
		panel.add(petNameLabel);
		
		JLabel petTypeLabel = new JLabel("Enter Pet Type (Dog, Cat, or Rabbit):");
		petTypeLabel.setBounds(16, 74, 231, 16);
		panel.add(petTypeLabel);
		
		petTypeTextField = new JTextField();
		petTypeTextField.setBounds(242, 69, 130, 26);
		panel.add(petTypeTextField);
		petTypeTextField.setColumns(10);
		
		JLabel petAgeLabel = new JLabel("Enter Pet Age:");
		petAgeLabel.setBounds(96, 146, 88, 16);
		panel.add(petAgeLabel);
		
		petAgeTextField = new JTextField();
		petAgeTextField.setBounds(196, 141, 130, 26);
		panel.add(petAgeTextField);
		petAgeTextField.setColumns(10);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(163, 182, 117, 29);
		panel.add(submitButton);
		
		petSpeciesLabel = new JLabel("Enter Pet Species:");
		petSpeciesLabel.setBounds(74, 113, 110, 16);
		panel.add(petSpeciesLabel);
		
		petSpeciesTextField = new JTextField();
		petSpeciesTextField.setBounds(196, 108, 130, 26);
		panel.add(petSpeciesTextField);
		petSpeciesTextField.setColumns(10);
		
		setVisible(false);
	}
	/**
     * Retrieves the entered pet name.
     *
     * @return The pet name entered by the user.
     */
	public String getPetName() {
		return petNameTextField.getText();
	}
	/**
     * Retrieves the entered pet type.
     *
     * @return The pet type entered by the user.
     */
	public String getPetType() {
		return petTypeTextField.getText();
	}
	/**
     * Retrieves the entered pet age.
     *
     * @return The pet age entered by the user.
     */
	public String getPetAge() {
		return petAgeTextField.getText();
	}
	/**
     * Retrieves the entered pet species.
     *
     * @return The pet species entered by the user.
     */
	public String getPetSpecies() {
		return petSpeciesTextField.getText();
	}
	/**
     * Resets the pet type text field.
     */
	public void resetPetTypeTextField() {
		petTypeTextField.setText("");
	}
	/**
     * Resets the pet age text field.
     */
	public void resetPetAgeTextField() {
		petAgeTextField.setText("");
	}
	/**
     * Resets all input text fields.
     */
	public void resetTextFields() {
		petNameTextField.setText("");
		petSpeciesTextField.setText("");
		petAgeTextField.setText("");
		petTypeTextField.setText("");
	}
	/**
     * Adds an action listener to the submit button.
     *
     * @param listener The action listener to be added to the submit button.
     */
	public void addActionListenerToSubmitButton(ActionListener listener) {
		submitButton.addActionListener(listener);
	}
	
}
