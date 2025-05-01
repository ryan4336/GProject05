package gproject05.view;

import javax.swing.*;

import gproject05.pets.Pet;


@SuppressWarnings("serial")
public class PetListView extends JFrame {
	private JPanel panel;
	private JList<Pet> list;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField txtSortBy;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PetListView() {
		setTitle("Pet List Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 100, 500, 400);
		
		panel = new JPanel();
		setContentPane(panel);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Pet");
		btnNewButton.setBounds(6, 306, 100, 29);
		panel.add(btnNewButton);
		
		DefaultListModel<Pet> modelList = new DefaultListModel<Pet>();
		list = new JList<Pet>(modelList);
		
		list.setBounds(6, 6, 488, 288);
		panel.add(list);
		
		btnNewButton_1 = new JButton("Remove Pet");
		btnNewButton_1.setBounds(6, 337, 100, 29);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Adopt Pet");
		btnNewButton_2.setBounds(118, 337, 92, 29);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("View Details");
		btnNewButton_3.setBounds(222, 337, 108, 29);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Save");
		btnNewButton_4.setBounds(377, 337, 117, 29);
		panel.add(btnNewButton_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Species", "Age"}));
		comboBox.setBounds(377, 307, 105, 27);
		panel.add(comboBox);
		
		txtSortBy = new JTextField();
		txtSortBy.setText("Sort by:");
		txtSortBy.setBounds(317, 306, 64, 26);
		panel.add(txtSortBy);
		txtSortBy.setColumns(10);
	}


	
	public DefaultListModel<Pet> getList() {
		return (DefaultListModel<Pet>) list.getModel();
	}
}
