package gproject05.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;

import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	
	public String getPetName() {
		return petNameTextField.getText();
	}
	
	public String getPetType() {
		return petTypeTextField.getText();
	}
	
	public String getPetAge() {
		return petAgeTextField.getText();
	}
	
	public String getPetSpecies() {
		return petSpeciesTextField.getText();
	}

	public void addActionListenerToSubmitButton(ActionListener listener) {
		submitButton.addActionListener(listener);
	}
	
}
