import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;

public class ChangePassword extends JFrame{
	
	Connection connection=null;


	public ChangePassword() {
		
		
		setFont(new Font("Agency FB", Font.PLAIN, 24));
		setBounds(100, 100, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\ChangePassword.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Change Password");
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewLabel.setBounds(156, 13, 178, 33);
		getContentPane().add(lblNewLabel);
		
		JPasswordField txtOldPassword = new JPasswordField();
		txtOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOldPassword.setColumns(10);
		txtOldPassword.setBounds(264, 144, 165, 32);
		getContentPane().add(txtOldPassword);
		
		JButton btnChange = new JButton("Change");
		btnChange.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnChange.setBounds(264, 347, 105, 33);
		getContentPane().add(btnChange);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(118, 347, 111, 33);
		getContentPane().add(btnCancel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblUsername.setBounds(75, 86, 105, 33);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Old Password");
		lblPassword.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblPassword.setBounds(75, 143, 128, 33);
		getContentPane().add(lblPassword);
		
		JPasswordField txtNewPass = new JPasswordField();
		txtNewPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNewPass.setColumns(10);
		txtNewPass.setBounds(264, 203, 165, 32);
		getContentPane().add(txtNewPass);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewPassword.setBounds(75, 202, 154, 33);
		getContentPane().add(lblNewPassword);
		
		JTextField txtUserName = new JTextField();
		txtUserName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtUserName.setColumns(10);
		txtUserName.setBounds(264, 87, 165, 32);
		getContentPane().add(txtUserName);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblConfirmPassword.setBounds(75, 259, 178, 33);
		getContentPane().add(lblConfirmPassword);
		
		JPasswordField txtConfirmPass = new JPasswordField();
		txtConfirmPass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtConfirmPass.setColumns(10);
		txtConfirmPass.setBounds(264, 260, 165, 32);
		getContentPane().add(txtConfirmPass);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		btnChange.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
				{
					connection= DatabaseConnection.dbConnector();
					
					String oldPass=new String (txtOldPassword.getPassword());
					String confirmPass= new String (txtConfirmPass.getPassword());
					String newPass = new String (txtNewPass.getPassword());
					String user=txtUserName.getText();
					boolean result = false;
					
					if( confirmPass.equals(newPass))
					{	
						
						try {
							
							String query ="select * from User_Login where Username=? AND Password=?";
							PreparedStatement ps1 = (PreparedStatement) connection.prepareStatement(query);
							ps1.setString(1, user);
							ps1.setString(2, oldPass);
							ResultSet rs=ps1.executeQuery();
							if(rs.next())
								{
			                        result = true;
								}
			                else
			                 	{
			                        result = false;
			                    }
		
		                
						    String userName = rs.getString("Username");
						
							String query1 ="update user_login set Password=? where Username= '"+userName+"'";
					    	PreparedStatement ps2 = (PreparedStatement) connection.prepareStatement(query1);
							ps2.setString(1,newPass);
							ps2.execute();
							
							JOptionPane.showMessageDialog(null,"Successfully Changed");
							dispose();
							
						} 	
						
						catch(Exception e2)
						{
							JOptionPane.showMessageDialog(null,"Username Don't Exist!");
						}
						
					}
					else
					{
					
						JOptionPane.showMessageDialog(null,"New Password and Confirm Password Password Miss-Match");
					
					}
					
					
				}
			});
	}
}