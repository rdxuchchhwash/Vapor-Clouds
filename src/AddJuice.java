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

public class AddJuice extends JFrame{

	Connection connection=null;


	public AddJuice() {
		
		
		setFont(new Font("Agency FB", Font.BOLD, 30));
		setVisible(true);
		setBounds(100, 100, 650, 600);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\AddJuice.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Add Juice");
		
		JLabel lblMod = new JLabel("Juice");
		lblMod.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblMod.setBounds(290, 0, 58, 42);
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
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPrice.setBounds(117, 236, 97, 42);
		getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblQuantity.setBounds(117, 298, 77, 42);
		getContentPane().add(lblQuantity);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtName.setBounds(220, 58, 240, 45);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(220, 234, 240, 45);
		getContentPane().add(txtPrice);
		
		JTextField txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(220, 295, 240, 45);
		getContentPane().add(txtQuantity);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnAdd.setBounds(336, 480, 129, 42);
		getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnCancel.setBounds(168, 480, 129, 42);
		getContentPane().add(btnCancel);
		
		JComboBox cbBrand = new JComboBox();
		cbBrand.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbBrand.setModel(new DefaultComboBoxModel(new String[] {"ETHOS", "CHARLIES CHALK DUST", "GLAZED","FLOWLESS","BAZOOKA","NAKED","HUMBLE","VAPE WILD","ROLL-UP","VGOD","PAWNS"}));
		cbBrand.setBounds(220, 116, 240, 41);
		getContentPane().add(cbBrand);
		
		JComboBox cbCategory = new JComboBox();
		cbCategory.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbCategory.setModel(new DefaultComboBoxModel(new String[] {"CEREALS", "DESSERTS", "FRUITS","CANDY","TOBBACO"}));
		cbCategory.setBounds(220, 171, 240, 41);
		getContentPane().add(cbCategory);
		
		JComboBox cbName = new JComboBox();
		cbName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		cbName.setModel(new DefaultComboBoxModel(new String[] {"CRISPY TREAT", "LOOPER", "CEREAL MILK","MUSTACHE MILK","BOSS RESERVE","MARSHMALLOW CRISP","DONUT","BLUEBERRY CHEESECAKE","STRAWBERRY CHEESECAKE","SOUR SWEET","BEERY BELTS","YUMMY GUM","BERRY BLOWDOE","TAFFY MAN","MIXED FRUITMAN","FLAVOUR BOOST","CLEVER FOOL","SCHMIDTEN","CANDYMAN","CANDYCANE","CANDYPAINT","CUBAN","CHIILED TOBACCO","VENTED","ICEBACCO","CARAMEKBACCO","CLASSICO"}));
		cbName.setBounds(462, 58, 134, 45);
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
					     
					     String date=GetDate.getDate();
							
						 
						 	CallableStatement ps1 = connection.prepareCall
				    		     ("{call juice_add(?,?,?,?,?,?,?)}");
				    	
						 	ps1.setString(1,"JUICE");
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
