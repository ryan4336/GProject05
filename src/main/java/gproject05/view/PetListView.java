package gproject05.view;

import javax.swing.*;

import gproject05.pets.Pet;


@SuppressWarnings("serial")
public class PetListView extends JFrame {
	private JPanel panel;
	private JList<Pet> list;
	
	
	public PetListView() {
		setTitle("Pet List Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Pet");
		btnNewButton.setBounds(6, 337, 100, 29);
		panel.add(btnNewButton);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>();
		list = new JList<Pet>(modelList);
		
		list.setBounds(6, 6, 488, 288);
		panel.add(list);
	}


	
	public DefaultListModel<Pet> getList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
	
	
}
