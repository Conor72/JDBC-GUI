import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class retrieve {
	
	public static ResultSet rs;
	public static String fName="", lName="";
///////////
	
 public static void main(String args[]) {
 JFrame f = new JFrame();
	JLabel fNameLabel = new JLabel("Name: ");
	JLabel lNameLabel = new JLabel("Last Name: ");
	final JTextField fNameField = new JTextField(20);
	final JTextField lNameField = new JTextField(20);
	JButton next = new JButton("Next");
	JButton prev = new JButton("Prev");

	
	try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery("select * from test");
	}
		
	catch(Exception e){}
	
		JPanel p = new JPanel(new GridLayout(4,2));
		p.add(fNameLabel);
		p.add(fNameField);
		p.add(lNameLabel);
		p.add(lNameField);
		p.add(next);
		p.add(prev);
		f.add(p);
		f.setVisible(true);
		f.pack();
		
		//Handles Previous Button
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (rs.previous()){
						fName=rs.getString("fName");
						fNameField.setText(fName);
						
						lName=rs.getString("lName");
						lNameField.setText(lName);
				
				
					}
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//Handles Next Button
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (rs.next()){
						fName=rs.getString("fName");
						fNameField.setText(fName);
						
						lName=rs.getString("lName");
						lNameField.setText(lName);
				
					}
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}





}