import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JOptionPane;
import java.sql.*;

public class UpdateProducts extends JFrame{

	Connection connection=null;
	double calQuantity ;
	public UpdateProducts() {
	
		
		setFont(new Font("Agency FB", Font.BOLD, 30));
		setBounds(100, 100, 700, 650);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\UpdateProducts.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Update Products");
		
		JLabel lblMod = new JLabel("Update Info");
		lblMod.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblMod.setBounds(262, 0, 170, 42);
		getContentPane().add(lblMod);
		
		JLabel lblBrand = new JLabel("Product ID");
		lblBrand.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBrand.setBounds(111, 56, 156, 42);
		getContentPane().add(lblBrand);
		
		JLabel lblCategory = new JLabel("Product Category");
		lblCategory.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblCategory.setBounds(111, 187, 156, 42);
		getContentPane().add(lblCategory);
		
		JLabel lblBatteryLife = new JLabel("Product Name");
		lblBatteryLife.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblBatteryLife.setBounds(111, 255, 156, 42);
		getContentPane().add(lblBatteryLife);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPrice.setBounds(111, 323, 97, 42);
		getContentPane().add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblQuantity.setBounds(111, 387, 77, 42);
		getContentPane().add(lblQuantity);
		
		JTextField txtPrice = new JTextField();
		txtPrice.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(262, 323, 232, 45);
		getContentPane().add(txtPrice);
		
		JTextField txtQuantity = new JTextField();
		txtQuantity.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(262, 391, 232, 45);
		getContentPane().add(txtQuantity);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnUpdate.setBounds(331, 484, 146, 42);
		getContentPane().add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(155, 484, 146, 42);
		getContentPane().add(btnCancel);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnDetails.setBounds(519, 56, 107, 42);
		getContentPane().add(btnDetails);
		
		JTextField txtProductID = new JTextField();
		txtProductID.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductID.setColumns(10);
		txtProductID.setBounds(262, 55, 232, 45);
		getContentPane().add(txtProductID);
		
		JTextField txtProductCategory = new JTextField();
		txtProductCategory.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductCategory.setEnabled(false);
		txtProductCategory.setColumns(10);
		txtProductCategory.setBounds(262, 184, 232, 45);
		getContentPane().add(txtProductCategory);
		
		JTextField txtProductName = new JTextField();
		txtProductName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductName.setEnabled(false);
		txtProductName.setColumns(10);
		txtProductName.setBounds(262, 255, 232, 45);
		getContentPane().add(txtProductName);
		
		JLabel lblProductType = new JLabel("Product Type");
		lblProductType.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblProductType.setBounds(111, 126, 156, 42);
		getContentPane().add(lblProductType);
		
		JTextField txtProductType = new JTextField();
		txtProductType.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtProductType.setEnabled(false);
		txtProductType.setColumns(10);
		txtProductType.setBounds(262, 123, 232, 45);
		getContentPane().add(txtProductType);
		
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
							    	
		               				String proCat = rs.getString("Catagory");
		               				txtProductCategory.setText(proCat);
		               				
		               				String proName = rs.getString("Name");
		               				txtProductName.setText(proName);
							        			
							        String proQty  = rs.getString("Qty");
							        txtQuantity.setText(proQty);
							        calQuantity= Integer.parseInt(proQty);
							        
							        String proPrice   = rs.getString("Price");
							        txtPrice.setText(proPrice);
							        						     
							      } 
							    
							    else
							    {
							          JOptionPane.showMessageDialog(null, "Product ID do not exist!");
							     }
							    }
						    catch(Exception ex)
						    {
							           JOptionPane.showMessageDialog(null, ex.getMessage());
						    }
								  
								
							}
			
		});
		
		btnUpdate.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    					        
							    	 String value1=txtQuantity.getText();
							         String value2=txtPrice.getText();
							         calQuantity=calQuantity+Integer.parseInt(txtQuantity.getText());
							         value1= String.valueOf(calQuantity);
							         
						    								         
							         String query2 ="update Product set Qty='"+value1+"', Price='"+value2+"' where ID='"+txtProductID.getText()+"'";
									 PreparedStatement ps3 = (PreparedStatement) connection.prepareStatement(query2);   
									 ps3.executeUpdate();
									 JOptionPane.showMessageDialog(null,"Successfully Updated");
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
