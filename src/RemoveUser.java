import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JTextField;

import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;

public class RemoveUser extends JFrame {


	JLabel lblRemoveUser = new JLabel("Remove User");
	JPasswordField txtPassword = new JPasswordField();
	JButton btnRemove = new JButton("Remove");

	JLabel lblUsername = new JLabel("Username");
	JLabel lblPassword = new JLabel("Password");
	Connection connection=null;
	JTextField txtUsername = new JTextField();
	boolean check;
	private final JButton btnCancel = new JButton("Cancel");

	



	
	public RemoveUser() {
		
		setFont(new Font("Agency FB", Font.PLAIN, 24));
		setBounds(100, 100, 450, 450);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\RemoveUser.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Remove User");
		
		
		lblRemoveUser.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblRemoveUser.setBounds(157, 13, 178, 33);
		getContentPane().add(lblRemoveUser);
		
		txtPassword.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPassword.setColumns(10);
		txtPassword.setBounds(204, 185, 165, 32);
		getContentPane().add(txtPassword);
		
		
		btnRemove.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnRemove.setBounds(229, 312, 113, 33);
		getContentPane().add(btnRemove);
		
		lblUsername.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblUsername.setBounds(68, 129, 105, 33);
		getContentPane().add(lblUsername);
		
		
		lblPassword.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblPassword.setBounds(68, 185, 105, 33);
		getContentPane().add(lblPassword);
		txtUsername.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtUsername.setColumns(10);
		txtUsername.setBounds(204, 136, 165, 32);
		
		getContentPane().add(txtUsername);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(92, 312, 113, 33);
		
		getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		
		 connection= DatabaseConnection.dbConnector();
		 btnRemove.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) {
					 try
						{	
							String query ="select * from USER_LOGIN where Username=? and Password=?";
							PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
							pst.setString(1, txtUsername.getText());
							pst.setString(2, txtPassword.getText());
							ResultSet rs=pst.executeQuery();
						
							
							int count =0;
							while(rs.next())
								{
									count=count+1; 
								}
							if(count==1)
								{	
									check=true;
									if(check==true)
									{	
										String query2 ="delete from User_info where Username=?";
									 	PreparedStatement pst2 = (PreparedStatement) connection.prepareStatement(query2);
									 	pst2.setString(1,txtUsername.getText());
									 	pst2.execute();		
									 	JOptionPane.showMessageDialog(null,"Removed Successfully");
									 	dispose();
									}
								}
							
							else
								{
									JOptionPane.showMessageDialog(null,"Username or Password is incorrect!");
								}
							
							
							rs.close();
							pst.close();

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
