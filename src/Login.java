

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;





public class Login extends JFrame {
	
	// here is the declaration of all components
	
	JButton btLogin=new JButton("Login");
	JTextField txtUserName=new JTextField();
	JPasswordField txtPassword = new JPasswordField(10);
	JLabel labelUserName=new JLabel("Username");
	JLabel labelPassword=new JLabel("Password");	
	JLabel txtLoginInfo = new JLabel("Vapor Cloud");
	
	Connection connection =null;
	String userTp=new String();
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */

	public Login()
	{	
		super("Vapor Cloud");
		setSize(600,400);
		
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\Login.jpg")));
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Login");
		
		
		txtLoginInfo.setFont(new Font("Agency FB", Font.BOLD, 40));
		txtLoginInfo.setBounds(208, 0, 188, 62);
		getContentPane().add(txtLoginInfo);
		
		btLogin.setFont(new Font("Agency FB", Font.BOLD, 24));
		btLogin.setBounds(380,250,95,30);
		getContentPane().add(btLogin);
		
		getContentPane().setLayout(null);
		txtUserName.setFont(new Font("Agency FB", Font.BOLD, 20));
		txtUserName.setBounds(300,90,180,30);
		getContentPane().add(txtUserName);
		
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(300,150,180,30);
		getContentPane().add(txtPassword);
		
		labelUserName.setBounds(150,90,200,30);
		labelUserName.setFont(new Font("Agency FB", Font.BOLD, 24));
		getContentPane().add(labelUserName);
		
		labelPassword.setBounds(150,150,200,30);
		labelPassword.setFont(new Font("Agency FB", Font.BOLD, 24));
		getContentPane().add(labelPassword);


		connection=DatabaseConnection.dbConnector();
		//JOptionPane.showMessageDialog(null,"Database Connection successful");
		
		
		// button actions and performed uml operation in database
		
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try
				{
					
					String query ="select * from User_Login where Username=? and Password=?";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					pst.setString(1, txtUserName.getText());
					pst.setString(2, txtPassword.getText());
					ResultSet rs=pst.executeQuery();
					String gtUserTp=txtUserName.getText();gtUserTp=txtUserName.getText();
					
						int count =0;
						while(rs.next())
							{
								count=count+1; 
							}
						if(count==1)
							{	
									
							userpanels(gtUserTp);
							
							
							if(userTp.equals("Admin"))
								{	
									
									AdminHome ab= new AdminHome();
									dispose();
								}
							else if(userTp.equals("Employee"))
								{	
									EmployeeHome ab= new EmployeeHome();
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
				catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
			    }
		});
	
}
	public void userpanels(String x)
	{	try
		{
			ResultSet rs = null;
	    	String query = "select User_Type from user_info where Username = ?";
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1,x);
			rs = ps.executeQuery();
		
			if(rs.next())
				{		        	
					userTp	= (String)rs.getString("User_Type");		        			        
				}
		}
		catch(Exception e)
		{			
				JOptionPane.showMessageDialog(null,e);
		}

	}

	

	
}


