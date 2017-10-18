import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;


public class AdminHome extends JFrame{

	JTextField txtSearch = new JTextField ();
	 JTextField txtQuantity = new JTextField ();
	 JTextField txtDiscount = new JTextField ();
	 JComboBox cbProductType = new JComboBox();
	 JComboBox cbProductCategory = new JComboBox();
	 JComboBox cbProductName = new JComboBox();
	 JLabel lblPriceAmount = new JLabel("0");
	 public static double pid=0;
	 
	 public static  double qty=0;
	 public static double dis=0;
	 public static String ptyp="";
	 public static String pcat="";
	 public static String pname="";
	 public static double amount=0;
	 public static double availQty=0;
	 
	 
	
	JLabel lblSell = new JLabel("Sell");
	JLabel lblNewLabel = new JLabel("Product Category");
	JLabel lblProductType = new JLabel("Product Type");
	JLabel lblProductName = new JLabel("Product Name");
	//txtSearch = new JTextField();
	JLabel lblAvailable = new JLabel("Available Quantity :");
	JLabel lblPrice = new JLabel("Price                    :");
	JLabel lblQuantity = new JLabel("Quantity                :");
	JLabel lblDiscount = new JLabel("Discount               :");
	JLabel lblAvailableQuantity = new JLabel("0");
	
	JButton btnCheckout = new JButton("Checkout");
	Connection connection=null;
	String proType="0";
	

	public AdminHome() {
	
		
		setFont(new Font("Agency FB", Font.BOLD, 20));
		setBounds(100, 100, 1360, 768);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\AdminHome.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Admin Home");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInventory = new JMenu("Inventory");
		mnInventory.setFont(new Font("Agency FB", Font.BOLD, 24));
		menuBar.add(mnInventory);
		
		JMenu mnAddNewItem = new JMenu("Add New Item");
		mnAddNewItem.setFont(new Font("Agency FB", Font.PLAIN, 24));
		mnInventory.add(mnAddNewItem);
		
		JMenuItem mntmMod = new JMenuItem("MOD");
		mntmMod.setFont(new Font("Agency FB", Font.PLAIN, 24));
		mnAddNewItem.add(mntmMod);
		
		JMenuItem mntmJuice = new JMenuItem("Juice");
		mntmJuice.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnAddNewItem.add(mntmJuice);
		
		JMenuItem mntmTank = new JMenuItem("Tank");
		mntmTank.setFont(new Font("Agency FB", Font.PLAIN, 24));
		
		mnAddNewItem.add(mntmTank);
		
		JMenuItem mntmCoil = new JMenuItem("Coil");
		mntmCoil.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnAddNewItem.add(mntmCoil);
		
		JMenuItem mntmBattery = new JMenuItem("Battery");
		mntmBattery.setFont(new Font("Agency FB", Font.PLAIN, 24));
		mnAddNewItem.add(mntmBattery);
		
		JMenuItem mntmOthers = new JMenuItem("Others");
		mntmOthers.setFont(new Font("Agency FB", Font.PLAIN, 24));
		
		mnAddNewItem.add(mntmOthers);
		
		JMenuItem mntmUpdateitem = new JMenuItem("UpdateItem");
		mntmUpdateitem.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnInventory.add(mntmUpdateitem);
		
		JMenuItem mntmRemoveItem = new JMenuItem("Remove Item");
		mntmRemoveItem.setFont(new Font("Agency FB", Font.PLAIN, 24));
		
		mnInventory.add(mntmRemoveItem);
		
		JMenuItem mntmShowInfo = new JMenuItem("Show Info");
		mntmShowInfo.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnInventory.add(mntmShowInfo);
		
		JMenu mnTransaction = new JMenu("Transaction");
		mnTransaction.setFont(new Font("Agency FB", Font.BOLD, 24));
		menuBar.add(mnTransaction);
		
		JMenuItem mntmTransactionHistory = new JMenuItem("Transaction History");
		mntmTransactionHistory.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnTransaction.add(mntmTransactionHistory);
		
		JMenu mnCustomer = new JMenu("Customer");
		mnCustomer.setFont(new Font("Agency FB", Font.BOLD, 24));
		menuBar.add(mnCustomer);
		
		JMenuItem mntmUpdateCustomerDetails = new JMenuItem("Update Customer Details");
		mntmUpdateCustomerDetails.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnCustomer.add(mntmUpdateCustomerDetails);
		
		JMenuItem mntmSeeAllCustomer = new JMenuItem("See All Customer");
		mntmSeeAllCustomer.setFont(new Font("Agency FB", Font.PLAIN, 24));
			
		JMenu mnUser = new JMenu("User");
		mnUser.setFont(new Font("Agency FB", Font.BOLD, 24));
		menuBar.add(mnUser);
		
		JMenuItem mntmCreateUser = new JMenuItem("Create User");
		mntmCreateUser.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnUser.add(mntmCreateUser);
		
		JMenuItem mntmRemoveUser = new JMenuItem("Remove User");
		mntmRemoveUser.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnUser.add(mntmRemoveUser);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnUser.add(mntmChangePassword);
		
		JMenuItem mntmAllUserInformation = new JMenuItem("All User Information");
		mntmAllUserInformation.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnUser.add(mntmAllUserInformation);
		
		JMenu mnOthers = new JMenu("Others");
		mnOthers.setFont(new Font("Agency FB", Font.BOLD, 24));
		menuBar.add(mnOthers);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setFont(new Font("Agency FB", Font.PLAIN, 24));
	
		mnOthers.add(mntmLogOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Agency FB", Font.PLAIN, 24));
		

		mnOthers.add(mntmExit);
		getContentPane().setLayout(null);
	
	
		
		
		lblSell.setFont(new Font("Agency FB", Font.BOLD, 40));
		lblSell.setBounds(53, 77, 68, 36);
		getContentPane().add(lblSell);
		
		
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblNewLabel.setBounds(53, 272, 265, 36);
		getContentPane().add(lblNewLabel);
		
		
		lblProductType.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblProductType.setBounds(53, 156, 265, 36);
		getContentPane().add(lblProductType);
		
		
		lblProductName.setFont(new Font("Agency FB", Font.BOLD, 24));
		lblProductName.setBounds(53, 389, 265, 36);
		getContentPane().add(lblProductName);
		
	
		
		
		txtSearch.setBounds(534, 193, 285, 48);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		txtSearch.setFont(new Font("Agency FB", Font.BOLD, 24));
		
	
		lblAvailable.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblAvailable.setBounds(534, 284, 191, 36);
		getContentPane().add(lblAvailable);
		
	
		JButton btnSearch = new JButton("Search");
	
		lblPrice.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblPrice.setBounds(534, 337, 191, 36);
		getContentPane().add(lblPrice);
		
		
		lblQuantity.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblQuantity.setBounds(534, 387, 191, 36);
		getContentPane().add(lblQuantity);
		
		
		lblDiscount.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblDiscount.setBounds(534, 437, 191, 36);
		getContentPane().add(lblDiscount);
		
		
	
		txtQuantity.setBounds(737, 388, 158, 36);
		getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		txtQuantity.setFont(new Font("Agency FB", Font.BOLD, 24));
		
	
		txtDiscount.setColumns(10);
		txtDiscount.setBounds(737, 437, 158, 36);
		getContentPane().add(txtDiscount);
		txtDiscount.setText("0");
		txtDiscount.setFont(new Font("Agency FB", Font.BOLD, 24));
		
	
		lblAvailableQuantity.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblAvailableQuantity.setBounds(737, 286, 158, 36);
		getContentPane().add(lblAvailableQuantity);
		
		
		lblPriceAmount.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblPriceAmount.setBounds(737, 336, 158, 36);
		getContentPane().add(lblPriceAmount);
	
		
		
		btnCheckout.setFont(new Font("Agency FB", Font.BOLD, 30));
		btnCheckout.setBounds(737, 512, 159, 36);
		getContentPane().add(btnCheckout);
		
		
		btnSearch.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnSearch.setBounds(850, 193, 137, 48);
		getContentPane().add(btnSearch);
		
		cbProductType.setBounds(53, 193, 265, 48);
		getContentPane().add(cbProductType);
		cbProductType.setModel(new DefaultComboBoxModel(new String[] {"MOD", "TANK", "JUICE","COIL","BATTERY","OTHERS"}));
		cbProductType.setFont(new Font("Agency FB", Font.BOLD, 30));
	
		
		
		cbProductCategory.setBounds(53, 309, 265, 48);
		getContentPane().add(cbProductCategory);
		cbProductCategory.setFont(new Font("Agency FB", Font.BOLD, 30));
	
		
		
		cbProductName.setBounds(53, 425, 265, 48);
		getContentPane().add(cbProductName);
		cbProductName.setFont(new Font("Agency FB", Font.BOLD, 30));
		
		
		mntmMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				AddMod a = new AddMod();
			}
		});
		
		mntmJuice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddJuice a = new AddJuice();
			}
		});
		
		
		mntmTank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTank a = new   AddTank();
				
			}
		});
		mntmCoil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCoil  a = new   AddCoil();
				
			}
		});
		mntmBattery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBattery  a = new   AddBattery();
			}
		});
		mntmOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddOthers  a = new   AddOthers();
			}
		});
		mntmUpdateitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProducts  a = new   UpdateProducts();
			}
		});
		mntmRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveItem  a = new   RemoveItem();
			}
		});
		mntmShowInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAll  a = new   ShowAll();
			}
		});
		mntmTransactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionHistory  a = new   TransactionHistory();
			}
		});
		mntmUpdateCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomerDetails  a = new   UpdateCustomerDetails();
			}
		});
		
		mntmCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser a = new CreateUser();
			}
		});
		mntmRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveUser a = new RemoveUser();
			}
		});
		mntmChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword a = new ChangePassword();
			}
		});
		
		mnCustomer.add(mntmSeeAllCustomer);
		mntmSeeAllCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllCustomers  a = new   ShowAllCustomers();
			}
		});
		
		mntmAllUserInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllUserDetails a = new AllUserDetails();
			}
		});
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
				
			}
		});
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cbProductType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbProductType.getSelectedItem().toString()=="MOD")
				{
					cbProductCategory.setModel(new DefaultComboBoxModel(new String[] {"LOW WATTAGE", "MEDIUM WATTAGE", "HIGH WATTAGE"}));
				}
				else if(cbProductType.getSelectedItem().toString()=="TANK")
				{
					cbProductCategory.setModel(new DefaultComboBoxModel(new String[] {"SUB-OHM TANK", "RDA", "RTA","RDTA"}));
				}
				else if(cbProductType.getSelectedItem().toString()=="JUICE")
				{
					cbProductCategory.setModel(new DefaultComboBoxModel(new String[] {"CEREALS", "DESSERTS", "FRUITS","CANDY","TOBBACO"}));
				}
				else if(cbProductType.getSelectedItem().toString()=="COIL")
				{
					cbProductCategory.setModel(new DefaultComboBoxModel(new String[] {"PRE-BUILD COILS", "PRE-ROLLED COILS", "COIL GAUZE"}));
				}
				else if(cbProductType.getSelectedItem().toString()=="BATTERY")
				{
					cbProductCategory.setModel(new DefaultComboBoxModel(new String[] {"MODEL-18650", "MODEL-26650", "LIPO"}));
				}
				else if(cbProductType.getSelectedItem().toString()=="OTHERS")
				{
					cbProductCategory.setModel(new DefaultComboBoxModel(new String[] {"OTHERS CAT 1", "OTHERS CAT 2", "OTHERS CAT 3","OTHERS CAT 4"}));
				}
			}
		});
		connection=DatabaseConnection.dbConnector();
		cbProductCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
			    {
			    // Your database connections
					cbProductName.removeAllItems();
					String query ="select name from product where type=? and catagory=?";
					PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
					pst.setString(1, cbProductType.getSelectedItem().toString());
					pst.setString(2, cbProductCategory.getSelectedItem().toString());
					ResultSet rs=pst.executeQuery();

					//rs= st.executeQuery("select Column from Table");
			    while(rs.next()){                            
			    	cbProductName.addItem(rs.getString(1));
			    }
			    //connection.close();
			    }
			    catch(Exception ex)
			    {
			    	JOptionPane.showMessageDialog(null, "Error");
			    } 
				
			}
		});
		cbProductName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					lblAvailableQuantity.setText("0");
					lblPriceAmount.setText("0");
					
					
				    ResultSet rs = null;
			    	String query = "select * from Product where type = ? and catagory=? and name=?";
					PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
					ps.setString(1,cbProductType.getSelectedItem().toString());
					ps.setString(2,cbProductCategory.getSelectedItem().toString());
					ps.setString(3,cbProductName.getSelectedItem().toString());
					rs = ps.executeQuery();
					    
					if(rs.next()){
					          
					    	proType=rs.getString("QTY");
					    	lblAvailableQuantity.setText(proType);
					    	
	           				String proCat = rs.getString("PRICE");
	           				lblPriceAmount.setText(proCat);
	           				
	           				String productId = rs.getString("ID");
	           				pid=Double.parseDouble(productId);
	           				
					    } 
					    
					else
					    {
					       JOptionPane.showMessageDialog(null, "Product ID do not exist!");
					    }
				    }
			    catch(Exception ex)
			    {
			    	//JOptionPane.showMessageDialog(null, "Prodcut not found!");
			    }
					  
					
				
			}
		});
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double dbQty = Double.parseDouble(proType);
				double userQty = Double.parseDouble(txtQuantity.getText());

				if(dbQty>userQty)
				{
					
					CustomerInfo a = new CustomerInfo();
					
					 qty=Double.parseDouble(txtQuantity.getText());
					 dis=Double.parseDouble(txtDiscount.getText().toString());
					 ptyp=cbProductType.getSelectedItem().toString();
					 pcat=cbProductCategory.getSelectedItem().toString();
					 pname=cbProductName.getSelectedItem().toString();
					 amount=Double.parseDouble(lblPriceAmount.getText());
					 availQty=Double.parseDouble(lblAvailableQuantity.getText());
				}
				else
				{
					//customer form
				}
				
			}
		});
		btnSearch.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e1) 
					{
						    try{
					
							    ResultSet rs = null;
						    	String query = "select * from Product where ID = ?";
								PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
								ps.setString(1,txtSearch.getText());
								rs = ps.executeQuery();
							    if(rs.next()){
							        
		               				String proTyp = rs.getString("TYPE");
		               				cbProductType.setSelectedItem(proTyp);
		               				
		               				String proCat = rs.getString("CATAGORY");
		               				cbProductCategory.setSelectedItem(proCat);
		               				
		               				String proName  = rs.getString("NAME");
							        cbProductName.setSelectedItem(proName);
							        							        		
							        String proPrice   = rs.getString("Price");
							        lblPriceAmount.setText(proPrice);
							        							        
							        String proQty   = rs.getString("QTY");
							        lblAvailableQuantity.setText(proQty);
						        						     
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
		
	}
}
