import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RemoveItem extends JFrame{

	
	Connection connection=null;
	String ptyp;

	
	public RemoveItem() {
		
		
		setFont(new Font("Agency FB", Font.BOLD, 30));
		setBounds(100, 100, 650, 600);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\RemoveItem.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Remove Item");
		
		JLabel lblMod = new JLabel("Product Info");
		lblMod.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblMod.setBounds(262, 0, 170, 42);
		getContentPane().add(lblMod);
		
		JLabel lblBrand = new JLabel("Product Type");
		lblBrand.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBrand.setBounds(102, 175, 156, 42);
		getContentPane().add(lblBrand);
		
		JLabel lblCategory = new JLabel("Product Category");
		lblCategory.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblCategory.setBounds(102, 256, 156, 42);
		getContentPane().add(lblCategory);
		
		JLabel lblBatteryLife = new JLabel("Product Name");
		lblBatteryLife.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBatteryLife.setBounds(102, 347, 156, 42);
		getContentPane().add(lblBatteryLife);
			
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnRemove.setBounds(330, 456, 146, 42);
		getContentPane().add(btnRemove);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(160, 456, 146, 42);
		getContentPane().add(btnCancel);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblProductId.setBounds(102, 89, 156, 42);
		getContentPane().add(lblProductId);
		
		JTextField txtProductID = new JTextField();
		txtProductID.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductID.setBounds(247, 97, 185, 36);
		getContentPane().add(txtProductID);
		txtProductID.setColumns(10);
		
		JTextField txtProductType = new JTextField();
		txtProductType.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductType.setColumns(10);
		txtProductType.setBounds(247, 181, 185, 36);
		getContentPane().add(txtProductType);
		
		JTextField txtProductCategory = new JTextField();
		txtProductCategory.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductCategory.setColumns(10);
		txtProductCategory.setBounds(247, 262, 185, 36);
		getContentPane().add(txtProductCategory);
		
		JTextField txtProductName = new JTextField();
		txtProductName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductName.setColumns(10);
		txtProductName.setBounds(247, 347, 185, 36);
		getContentPane().add(txtProductName);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnDetails.setBounds(454, 97, 146, 36);
		getContentPane().add(btnDetails);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		connection= DatabaseConnection.dbConnector();
		btnDetails.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    ResultSet rs = null;
						    	String query = "select * from Product where ID = ?";
								PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
								ps.setString(1,txtProductID.getText());
								rs = ps.executeQuery();
							    if(rs.next()){
							          
							    	String proType=rs.getString("Type");
							    	txtProductType.setText(proType);
							    	ptyp=proType;
							    	
		               				String proCat 	  = rs.getString("Catagory");
		               				txtProductCategory.setText(proCat);
		               				
		               										        
							        String proName   = rs.getString("Name");
							        txtProductName.setText(proName);
							        
							     
							      } 
							    
							    else
							    {
							          JOptionPane.showMessageDialog(null, "Customer ID do not exist!");
							     }
							    }
						    catch(Exception ex)
						    {
							           JOptionPane.showMessageDialog(null, ex.getMessage());
						    }
								  
								
							}
			
		});
		
		btnRemove.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    if(ptyp.equals("MOD"))
							    {
							    	String query2 ="delete from MOD where PID=?";
								 	PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement(query2);
								 	pst2.setString(1,txtProductID.getText());
								 	pst2.execute();		
								 	JOptionPane.showMessageDialog(null,"Removed Successfully");
								 	dispose();
							    }
							    else if(ptyp.equals("TANK"))
							    {
							    	String query2 ="delete from coil where PID=?";
								 	PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement(query2);
								 	pst2.setString(1,txtProductID.getText());
								 	pst2.execute();		
								 	JOptionPane.showMessageDialog(null,"Removed Successfully");
								 	dispose();
							    }
						    	
						    	String query2 ="delete from Product where ID=?";
							 	PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement(query2);
							 	pst2.setString(1,txtProductID.getText());
							 	pst2.execute();		
							 	
							 	dispose();
				    }
						    catch(Exception ex)
						    {
							           JOptionPane.showMessageDialog(null, ex.getMessage());
						    }
								  
								
					}
			
		});
		
	}
}
