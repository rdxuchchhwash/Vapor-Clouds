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
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CustomerInfo extends JFrame{
	
	String csID;
	String newQty;
	
	JTextField txtPhoneNo = new JTextField();
	
	
	Connection connection=null;
	
	public CustomerInfo() {
		
		
		setBounds(100, 100, 500, 650);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\CustomerInfo.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Customer Info");
		
		JLabel lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewLabel.setBounds(146, 13, 220, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblNewLabel_1.setBounds(89, 109, 75, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblAddress.setBounds(89, 289, 75, 36);
		getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblEmail.setBounds(89, 172, 75, 36);
		getContentPane().add(lblEmail);
		
		JLabel lblPhoneNo = new JLabel("Phone no");
		lblPhoneNo.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblPhoneNo.setBounds(89, 233, 75, 36);
		getContentPane().add(lblPhoneNo);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setBounds(189, 174, 201, 34);
		getContentPane().add(txtEmail);
		
		
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPhoneNo.setBounds(189, 233, 201, 34);
		getContentPane().add(txtPhoneNo);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtAddress.setBounds(189, 299, 201, 113);
		getContentPane().add(txtAddress);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnConfirm.setBounds(269, 489, 97, 36);
		getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(118, 489, 97, 36);
		getContentPane().add(btnCancel);
		
		JTextField txtName = new JTextField();
		txtName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(189, 111, 201, 34);
		getContentPane().add(txtName);
		
		
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		connection= DatabaseConnection.dbConnector();
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try
				{
					
					String query ="select * from Customer where Phone_NO=?";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					pst.setString(1, txtPhoneNo.getText());
					ResultSet rs=pst.executeQuery();
					
									
						int count =0;
						while(rs.next())
							{
								count=count+1; 
							}
						if(count==1)
							{	
								 getCustomerID();
								 chkout();
								 updateProductInfo();
							}
												
						else
							{
								String sql1 ="INSERT into Customer (Name,Email,Phone_No,Address) values(?,?,?,?)";
							 	PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(sql1);
							 
								 st1.setString(1,txtName.getText());
								 st1.setString(2,txtEmail.getText());	
								 st1.setString(3,txtPhoneNo.getText());
								 st1.setString(4,txtAddress.getText());
								 st1.execute();
								 
								 getCustomerID();
								 chkout();
								 updateProductInfo();
								 
							}
												
						rs.close();
						pst.close();
						dispose();
					}
				catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
			    }
		});
	}
	

	void  chkout()
	{
		
		 String dt= GetDate.getDate();
		 double ttPrc ;
		 
		 ttPrc=AdminHome.qty*AdminHome.amount;
		 if(AdminHome.dis>0)
		 {
			 AdminHome.dis=(ttPrc*AdminHome.dis)/100;
		 }
		 ttPrc=ttPrc-AdminHome.dis;
		 
		 String totalPrice =String.valueOf(ttPrc);
		 
		 
		 
		
		connection= DatabaseConnection.dbConnector();
		 try
			{			 
			 	String sql1 ="INSERT into transaction (Type,Qty,Unit_Price,Total_Price,Discount,Datetime,CID,PID) values(?,?,?,?,?,?,?,?)";
			 	PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(sql1);
			 
				 st1.setString(1,"SELL");
				 st1.setString(2,String.valueOf(AdminHome.qty));	
				 st1.setString(3,String.valueOf(AdminHome.amount));
				 st1.setString(4,totalPrice);
				 st1.setString(5,String.valueOf(AdminHome.dis));
				 st1.setString(6,dt);
				 st1.setString(7,csID);
				 st1.setString(8,String.valueOf(AdminHome.pid));
				 
		
				 st1.execute();

				 //JOptionPane.showMessageDialog(null,"Successfully Created");
				 

			}
		 
		catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null,"Something wrong");
			}
	}
	
	
	
	
	void updateProductInfo()
	{	
		connection= DatabaseConnection.dbConnector();
	
			String RemainQty=String.valueOf(AdminHome.availQty-AdminHome.qty);
			
		
		  try
			  {
							       	         		         
			         String query2 ="update Product set Qty='"+RemainQty+"' where ID='"+AdminHome.pid+"'";
					 PreparedStatement ps3 = (PreparedStatement) connection.prepareStatement(query2);   
					 ps3.executeUpdate();
					 JOptionPane.showMessageDialog(null,"Successfully Updated");
					 //dispose();
			  }
		    catch(Exception ex)
			  {
				     JOptionPane.showMessageDialog(null, ex.getMessage());
			  }
	}
	
	public void getCustomerID()
		{
			connection= DatabaseConnection.dbConnector();
			
			try
			  {
					
			    ResultSet rs = null;
		    	String query = "select ID from Customer where Phone_No = ? ";
				PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
				ps.setString(1,txtPhoneNo.getText());
				rs = ps.executeQuery();
				    
				if(rs.next()){
		
					csID=rs.getString("ID");
						
				    } 
			  }
			    
			catch (Exception ex)
			    {
			       JOptionPane.showMessageDialog(null, "Product ID do not exist!");
			    }
		}
	}

