import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ShowAll extends JFrame{
	
	Connection connection=null;
	JTable table = new JTable();
	
	public ShowAll() {
		
		setBounds(100, 100, 1360, 768);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setLayout(null);
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\ShowAll.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Show All");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 66, 1240, 543);
		add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnShowAll.setBounds(693, 644, 146, 37);
		add(btnShowAll);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(466, 644, 146, 37);
		add(btnCancel);
		
		JTextField txtSearch = new JTextField();
		txtSearch.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtSearch.setBounds(987, 644, 141, 34);
		add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnSearch.setBounds(1145, 644, 146, 37);
		add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("All Product Information");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewLabel.setBounds(601, 13, 223, 30);
		add(lblNewLabel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		

		 connection= DatabaseConnection.dbConnector();
		 showAll();
		
		 //Button actions and uml operation against button click
		 
		 btnShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					showAll();
					
				}
			});
			
		 btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					 try
						{
						 	String query ="select * from Product where Name=?";
						 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						 	pst.setString(1,txtSearch.getText());
						 	ResultSet rs=pst.executeQuery();
						 	table.setModel(DbUtils.resultSetToTableModel(rs));
						
						}
					catch(Exception e)
						{
							JOptionPane.showMessageDialog(null,e);
						}
				}
			});
		 
			
	}
	
	public void showAll()
	{
		 try
			{
			 	String query ="select * from Product";
			 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			 	ResultSet rs=pst.executeQuery();
			 	table.setModel(DbUtils.resultSetToTableModel(rs));
			
			}
		catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
			}
	}
}
