
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

public class TransactionHistory extends JFrame{
	
	JTable table = new JTable();
	Connection connection=null;

	public TransactionHistory() {

	
		setBounds(100, 100, 1360, 768);
		setVisible(true);
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
	    setContentPane(new JLabel(new ImageIcon("C:\\Users\\Uchchhwash\\workspace\\Vapor Clouds\\Images\\TransactionHistory.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	    setResizable(false);
		setTitle("Transaction History");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 66, 1240, 543);
		getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowAll.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnShowAll.setBounds(669, 644, 146, 37);
		getContentPane().add(btnShowAll);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnCancel.setBounds(499, 644, 146, 37);
		getContentPane().add(btnCancel);
		
		
		JTextField txtSearch = new JTextField();
		txtSearch.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtSearch.setBounds(971, 644, 157, 34);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnSearch.setBounds(1145, 644, 146, 37);
		getContentPane().add(btnSearch);
		
		JLabel lblNewLabel = new JLabel("Transaction History");
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblNewLabel.setBounds(601, 13, 214, 40);
		getContentPane().add(lblNewLabel);
		
		JTextField txtDelete = new JTextField();
		txtDelete.setFont(new Font("Agency FB", Font.PLAIN, 20));
		txtDelete.setColumns(10);
		txtDelete.setBounds(51, 644, 157, 34);
		getContentPane().add(txtDelete);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Agency FB", Font.BOLD, 24));
		btnDelete.setBounds(224, 644, 146, 37);
		getContentPane().add(btnDelete);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		

		 connection= DatabaseConnection.dbConnector();
		 showDetails();
		
		 //Button actions and uml operation against button click
		 
		 btnShowAll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					showDetails();
				}
			});
			
		 btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					 try
						{
						 	String query ="select * from Transaction where ID=?";
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
		 
		 btnDelete.addActionListener(new ActionListener() 
		 {
				public void actionPerformed(ActionEvent e) 
				{
					 try
						{	
						 	String query ="delete from transaction where ID=?";
						 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
						 	pst.setString(1,txtDelete.getText());
						 	pst.execute();		
						 	showDetails();
						
						}
					catch(Exception a)
						{
							JOptionPane.showMessageDialog(null,"Enter an ID on the Textfield!");
						}
				}
		 });
		 
		 
	}
	public void showDetails()
	{	
		connection= DatabaseConnection.dbConnector();
		try
			{
				
				String query ="select * from Transaction";
			 	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(query);
			 	ResultSet rs=pst.executeQuery();
			 	table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		
		catch(Exception a)
		{
			JOptionPane.showMessageDialog(null,a);
		}
	}
	
}
