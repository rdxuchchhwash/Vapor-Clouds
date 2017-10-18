import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.*;

import javax.swing.JOptionPane;
import java.sql.*;


public class UpdateCustomerDetails extends JFrame{

	Connection connection=null;
	public UpdateCustomerDetails() {
		
		
		setBounds(100, 100, 500, 650);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\UpdateCustomerDetails.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Update Customer Info");
		
		JLabel lblNewLabel = new JLabel("Update Customer");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewLabel.setBounds(161, 13, 220, 36);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblNewLabel_1.setBounds(31, 158, 75, 36);
		add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblAddress.setBounds(31, 338, 75, 36);
		add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblEmail.setBounds(31, 221, 75, 36);
		add(lblEmail);
		
		JLabel lblPhoneNo = new JLabel("Phone no");
		lblPhoneNo.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPhoneNo.setBounds(31, 282, 75, 36);
		add(lblPhoneNo);
		
		
		JTextField txtEmail = new JTextField();
		txtEmail.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(131, 223, 201, 34);
		add(txtEmail);
		
		JTextField txtPhoneNo = new JTextField();
		txtPhoneNo.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setBounds(131, 282, 201, 34);
		add(txtPhoneNo);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtAddress.setBounds(131, 348, 201, 113);
		add(txtAddress);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnUpdate.setBounds(259, 527, 97, 36);
		add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(108, 527, 97, 36);
		add(btnCancel);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(131, 160, 201, 34);
		add(txtName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblId.setBounds(31, 100, 75, 36);
		add(lblId);
		
		JTextField txtCustomerId = new JTextField();
		txtCustomerId.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtCustomerId.setColumns(10);
		txtCustomerId.setBounds(131, 106, 201, 34);
		add(txtCustomerId);
		
		JButton btnDetails = new JButton("Details");
		btnDetails.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnDetails.setBounds(349, 104, 97, 36);
		add(btnDetails);
		
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
						    	String query = "select * from Customer where ID = ?";
								PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
								ps.setString(1,txtCustomerId.getText());
								rs = ps.executeQuery();
							    if(rs.next()){
							          
							    	String name=rs.getString("Name");
							    	txtName.setText(name);
							    	
		               				String email 	  = rs.getString("Email");
		               				txtEmail.setText(email);
		               				
		               										        
							        String phoneNo   = rs.getString("Phone_No");
							        txtPhoneNo.setText(phoneNo);
							        
							        
							        
							        String address   = rs.getString("Address");
							        txtAddress.setText(address);
							        
							     
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
		
		btnUpdate.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    
						        
							    	 String value1=txtName.getText();
							         String value2=txtEmail.getText();
							         String value3=txtPhoneNo.getText();
							         String value4=txtAddress.getText();
							         
							    								         
							         String query2 ="update Customer set Name='"+value1+"', Email='"+value2+"',Phone_No='"+value3+"',Address='"+value4+"'where ID='"+txtCustomerId.getText()+"'";
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
