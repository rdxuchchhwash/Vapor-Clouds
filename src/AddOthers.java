import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AddOthers extends JFrame{
	Connection connection=null;
	
	public AddOthers() {
		
		
		setFont(new Font("Agency FB", Font.BOLD, 30));
		setBounds(100, 100, 650, 600);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\AddOthers.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Add Others");
		
		JLabel lblMod = new JLabel("Others");
		lblMod.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblMod.setBounds(290, 0, 85, 42);
		add(lblMod);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblName.setBounds(117, 55, 77, 42);
		add(lblName);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBrand.setBounds(117, 115, 77, 42);
		add(lblBrand);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblCategory.setBounds(117, 170, 97, 42);
		add(lblCategory);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPrice.setBounds(117, 236, 97, 42);
		add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblQuantity.setBounds(117, 298, 77, 42);
		add(lblQuantity);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtName.setBounds(220, 58, 240, 45);
		add(txtName);
		txtName.setColumns(10);
		
		JComboBox cbBrand = new JComboBox();
		cbBrand.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbBrand.setModel(new DefaultComboBoxModel(new String[] {"Brand 1", "Brand 2", "Brand 3","Brand 4","Brand 5","Brand 6"}));
		cbBrand.setBounds(220, 116, 240, 41);
		getContentPane().add(cbBrand);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"OTHERS CAT 1", "OTHERS CAT 2", "OTHERS CAT 3","OTHERS CAT 4"}));
		cbCategory.setBounds(220, 171, 240, 41);
		getContentPane().add(cbCategory);
		
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(220, 234, 240, 45);
		add(txtPrice);
		
		JTextField txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(220, 295, 240, 45);
		add(txtQuantity);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnAdd.setBounds(331, 452, 129, 42);
		add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnCancel.setBounds(170, 452, 129, 42);
		add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		
		connection= DatabaseConnection.dbConnector();
		 btnAdd.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) {
					 try
						{	
						 String  temp=txtPrice.getText();
					     double price=Double.parseDouble(temp);
					     temp=txtQuantity.getText();
					     double quantity=Double.parseDouble(temp);
					     
					     String date=GetDate.getDate();
							
						 
						 	CallableStatement ps1 = connection.prepareCall
				    		     ("{call others_add(?,?,?,?,?,?,?)}");
				    	
						 	ps1.setString(1,"OTHERS");
						 	ps1.setString(2,txtName.getText());
						 	ps1.setString(3,cbBrand.getSelectedItem().toString());
						 	ps1.setString(4,cbCategory.getSelectedItem().toString());
						 	ps1.setDouble(5,price);
						 	ps1.setDouble(6,quantity);
						 	ps1.setString(7,date);
				  
						 	ps1.executeUpdate();
						 	ps1.close();

							 JOptionPane.showMessageDialog(null,"Successfully Created");
							 dispose();

						}
					 
					catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,"Something wrong");
						}
			}
			}
		 );
	}
}
