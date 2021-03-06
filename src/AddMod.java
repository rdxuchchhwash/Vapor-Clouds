import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AddMod extends JFrame{
	private JTextField txtName;
	Connection connection=null;
	Calendar cal=new GregorianCalendar();


	public AddMod() {
		
		/*String date=GetDate.getDate();
		JOptionPane.showMessageDialog(null,date);*/
		
		setFont(new Font("Agency FB", Font.BOLD, 30));
		setBounds(100, 100, 650, 600);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\AddMod.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Add Mod");
		
		JLabel lblMod = new JLabel("MOD");
		lblMod.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblMod.setBounds(290, 0, 50, 42);
		getContentPane().add(lblMod);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblName.setBounds(117, 55, 77, 42);
		getContentPane().add(lblName);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBrand.setBounds(117, 115, 77, 42);
		getContentPane().add(lblBrand);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblCategory.setBounds(117, 170, 97, 42);
		getContentPane().add(lblCategory);
		
		JLabel lblBatteryLife = new JLabel("Battery Qty");
		lblBatteryLife.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBatteryLife.setBounds(117, 225, 103, 42);
		getContentPane().add(lblBatteryLife);
		
		JLabel lblOutputWatt = new JLabel("Output Watt");
		lblOutputWatt.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblOutputWatt.setBounds(117, 283, 103, 42);
		getContentPane().add(lblOutputWatt);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPrice.setBounds(117, 340, 97, 42);
		getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblQuantity.setBounds(117, 402, 77, 42);
		getContentPane().add(lblQuantity);
				
		JTextField txtOutputWatt = new JTextField();
		txtOutputWatt.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtOutputWatt.setColumns(10);
		txtOutputWatt.setBounds(220, 280, 240, 45);
		getContentPane().add(txtOutputWatt);
		
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(220, 338, 240, 45);
		getContentPane().add(txtPrice);
		
		JTextField txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(220, 399, 240, 45);
		getContentPane().add(txtQuantity);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnAdd.setBounds(331, 478, 129, 42);
		getContentPane().add(btnAdd);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(220, 55, 240, 45);
		getContentPane().add(txtName);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnCancel.setBounds(173, 478, 129, 42);
		getContentPane().add(btnCancel);
		
		JComboBox cbBrand = new JComboBox();
		cbBrand.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbBrand.setModel(new DefaultComboBoxModel(new String[] {"SMOK", "ELEAF", "MINIVOLT","MECH","EVIC","LAISIMO","VAPORESSO","BOXER","XCUDE","RX","PANZER","TRIADE"}));
		cbBrand.setBounds(220, 116, 240, 41);
		getContentPane().add(cbBrand);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"LOW WATTAGE", "MEDIUM WATTAGE", "HIGH WATTAGE"}));
		cbCategory.setBounds(220, 171, 240, 41);
		getContentPane().add(cbCategory);
		
		JComboBox cbQuantity = new JComboBox();
		cbQuantity.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbQuantity.setModel(new DefaultComboBoxModel(new String[] {"1", "2","3","4"}));
		cbQuantity.setBounds(220, 226, 240, 41);
		getContentPane().add(cbQuantity);
		
		JComboBox cbName = new JComboBox();
		cbName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbName.setModel(new DefaultComboBoxModel(new String[] {"iJUST 2", "iJUST S", "MINIVOLT","MECHMOD","EVIC VTC","EVIC V TWO","LAISIMO","VAPORESSEO","BOXED 85","BOXER 120","XCUBE ULTRA","RX200","PANZER DNA 200","TRIADE 200"}));
		cbName.setBounds(461, 55, 111, 45);
		getContentPane().add(cbName);
				
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		cbName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				txtName.setText(cbName.getSelectedItem().toString());
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
					     temp=txtOutputWatt.getText();
					     double outputWatt=Double.parseDouble(temp);
					     temp=cbQuantity.getSelectedItem().toString();
					     double battery_qty=Double.parseDouble(temp);
					     
					     String date=GetDate.getDate();
							
						 
						 	CallableStatement ps1 = connection.prepareCall
				    		     ("{call mod_add(?,?,?,?,?,?,?,?,?)}");
				    	
						 	ps1.setString(1,"MOD");
						 	ps1.setString(2,txtName.getText());
						 	ps1.setString(3,cbBrand.getSelectedItem().toString());
						 	ps1.setString(4,cbCategory.getSelectedItem().toString());
						 	ps1.setDouble(5,price);
						 	ps1.setDouble(6,quantity);
						 	ps1.setDouble(7,battery_qty);
						 	ps1.setDouble(8,outputWatt);
						 	ps1.setString(9,date);
				  
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
