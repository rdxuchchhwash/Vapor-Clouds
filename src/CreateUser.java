/**
 * this class is for creating new user.
 * only admin can create new user.
 */

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreateUser extends JFrame {
	
	// here is the declaration for all components used
	
	JComboBox DateComboBox = new JComboBox();
	JComboBox MonthComboBox = new JComboBox();
	JComboBox YearComboBox = new JComboBox();
	JComboBox userTypeComboBox = new JComboBox();
	JLabel labelName = new JLabel("Name");
	JLabel labelgender = new JLabel("Gender");
	JLabel labelPhone = new JLabel("Phone");
	JLabel labelAddress = new JLabel("Address");
	JLabel labelDateBirth = new JLabel("Date Of Birth");
	JLabel labelUserName = new JLabel("User Name");
	JLabel labelPass = new JLabel("User Password");
	JLabel labelUserType = new JLabel("User Type");
	JRadioButton MaleRadioButton = new JRadioButton("Male");
	JRadioButton FemaleRadioButton = new JRadioButton("Female");
	JTextField txtName = new JTextField();
    JPasswordField txtPassField = new JPasswordField();
	JTextField txtPhone = new JTextField();
	JTextField txtAddress = new JTextField();
	JTextField txtUserName = new JTextField();
	JButton btCreate = new JButton("Submit");
	JButton btCancel = new JButton("Cancel");
	JLabel labelUserInfo = new JLabel("User Information");
	
	Connection connection=null;
	String s;
	String dateOfBirth;
	
	/**
	 * here is the constructor and all the declarations 
	 * here the frame is fixed and not resizable
	 * the background image path is declared
	 */
	
	public CreateUser() {
		getContentPane().setFont(new Font("Agency FB", Font.BOLD, 24));
	
		ButtonGroup grp= new ButtonGroup();
		
		setTitle("Create User");
		
		
		setBounds(100, 100, 974, 656);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	    getContentPane().setLayout(null);
	    setResizable(false);
	    setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\CreateUser.jpg")));
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	
		labelName.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelName.setBounds(49, 107, 96, 22);
		getContentPane().add(labelName);
		
		
		labelgender.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelgender.setBounds(49, 186, 96, 22);
		getContentPane().add(labelgender);
		
		
		labelPhone.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelPhone.setBounds(49, 337, 109, 22);
		getContentPane().add(labelPhone);
		
		
		labelAddress.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelAddress.setBounds(49, 427, 109, 22);
		getContentPane().add(labelAddress);
		
		
		labelDateBirth.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelDateBirth.setBounds(50, 257, 137, 28);
		getContentPane().add(labelDateBirth);
		
	
		labelUserName.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelUserName.setBounds(488, 174, 114, 22);
		getContentPane().add(labelUserName);
		
		
		labelPass.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelPass.setBounds(488, 273, 151, 28);
		getContentPane().add(labelPass);
		

		
		labelUserType.setFont(new Font("Agency FB", Font.BOLD, 24));
		labelUserType.setBounds(488, 367, 125, 34);
		getContentPane().add(labelUserType);
		
		
		MaleRadioButton.setBounds(174, 186, 73, 23);
		MaleRadioButton.setContentAreaFilled(false);
		grp.add(MaleRadioButton);
		getContentPane().add(MaleRadioButton);
		MaleRadioButton.setActionCommand("Male");
		
		
		FemaleRadioButton.setBounds(261, 185, 109, 23);
		FemaleRadioButton.setContentAreaFilled(false);
		grp.add(FemaleRadioButton);
		getContentPane().add(FemaleRadioButton);
		FemaleRadioButton.setActionCommand("Female");
		
		
		txtName.setBounds(177, 101, 275, 40);
		txtName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		
		txtPhone.setColumns(10);
		txtPhone.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtPhone.setBounds(177, 331, 275, 40);
	    getContentPane().add(txtPhone);
		
		
		txtAddress.setColumns(10);
		txtAddress.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtAddress.setBounds(177, 405, 275, 73);
		getContentPane().add(txtAddress);
		
		
		txtUserName.setColumns(10);
		txtUserName.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtUserName.setBounds(641, 168, 275, 40);
	    getContentPane().add(txtUserName);
		
	
		txtPassField.setBounds(641, 270, 275, 40);
		txtPassField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    getContentPane().add(txtPassField);
		
		
		userTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Employee"}));
		userTypeComboBox.setFont(new Font("Agency FB", Font.PLAIN, 24));
		userTypeComboBox.setBounds(641, 367, 275, 40);
		getContentPane().add(userTypeComboBox);
		
		
		DateComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		DateComboBox.setFont(new Font("Agency FB", Font.PLAIN, 20));
		DateComboBox.setBounds(174, 258, 46, 32);
	    getContentPane().add(DateComboBox);
		
	    MonthComboBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "Sepetember", "October", "November", "December"}));
	    MonthComboBox.setFont(new Font("Agency FB", Font.PLAIN, 20));
	    MonthComboBox.setBounds(244, 258, 83, 32);
		getContentPane().add(MonthComboBox);
		
		
		YearComboBox.setModel(new DefaultComboBoxModel(new String[] {"1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		YearComboBox.setFont(new Font("Agency FB", Font.PLAIN, 20));
		YearComboBox.setBounds(353, 258, 70, 32);
		getContentPane().add(YearComboBox);
		
		btCreate.setFont(new Font("Agency FB", Font.BOLD, 24));
		btCreate.setBounds(512, 531, 125, 45);
		getContentPane().add(btCreate);
		
		btCancel.setFont(new Font("Agency FB", Font.BOLD, 24));	
		btCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btCancel.setBounds(329, 531, 125, 45);
		getContentPane().add(btCancel);
		
		
		labelUserInfo.setFont(new Font("Agency FB", Font.BOLD, 30));
		labelUserInfo.setBounds(338, 11, 328, 40);
		getContentPane().add(labelUserInfo);
	
		// UML oprations done in database against button click 		
		
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
		
		 connection= DatabaseConnection.dbConnector();
		 btCreate.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) {
					 try
						{				 
						 	String sql1 ="INSERT into user_info (Name,Username,Password,Gender,DOB,Phone_No,Address,user_type) values(?,?,?,?,?,?,?,?)";
						 	PreparedStatement st1 = (PreparedStatement) connection.prepareStatement(sql1);
						 
						 	String UserType  =userTypeComboBox.getSelectedItem().toString();
						 	dateOfBirth=getDate();
						 
							 st1.setString(1,txtName.getText());
							 st1.setString(2,txtUserName.getText());							 
							 st1.setString(3,txtPassField.getText());
							 st1.setString(4,grp.getSelection().getActionCommand());							
							 st1.setString(5,dateOfBirth);					 
							 st1.setString(6,txtPhone.getText());
							 st1.setString(7,txtAddress.getText());
							 st1.setString(8,UserType);	
							 st1.execute();

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
	
	// method for getting date of birth
	
	  public String getDate()
      {
          String date  =DateComboBox.getSelectedItem().toString();
          String month =MonthComboBox.getSelectedItem().toString();
          String year  = YearComboBox.getSelectedItem().toString();
          String dob;
          
          if(month=="January")
          {
        	  month="JAN";
          }
          else if(month=="February")
          {
        	  month="FEB";
          }
          else if(month=="March")
          {
        	  month="MAR";
          }
          else if(month=="April")
          {
        	  month="APR";
          }
          else if(month=="May")
          {
        	  month="MAY";
          }
          else if(month=="June")
          {
        	  month="JUN";
          }
          else if(month=="July")
          {
        	  month="JUL";
          }
          else if(month=="August")
          {
        	  month="AUG";
          }
          else if(month=="September")
          {
        	  month="SEP";
          }
          else if(month=="October")
          {
        	  month="OCT";
          }
          else if(month=="November")
          {
        	  month="NOV";
          }
          else if(month=="December")
          {
        	  month="DEC";
          }
          
          
          dob = date+"-"+month+"-"+year ;
          
          return dob;
          
      }
	
	
}
