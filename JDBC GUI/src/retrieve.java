import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class retrieve {
	
	public static ResultSet rs;
	public static String name="", email ="", lastname="";
///////////
	
 public static void main(String args[]) {
 JFrame f = new JFrame();
	JLabel nameLabel = new JLabel("Name: ");
	JLabel emailLabel = new JLabel("Email: ");
	JLabel lastNameLabel = new JLabel("Last Name: ");
	final JTextField nameField = new JTextField(20);
	final JTextField emailField = new JTextField(20);
	final JTextField lastNameField = new JTextField(20);
	JButton next = new JButton("Next");
	JButton prev = new JButton("Prev");

	
	try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_create_db", "root", "password");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery("select * from data");
	}
		
	catch(Exception e){}
	
		JPanel p = new JPanel(new GridLayout(4,2));
		p.add(nameLabel);
		p.add(nameField);
		p.add(lastNameLabel);
		p.add(lastNameField);
		p.add(emailLabel);
		p.add(emailField);
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
						name=rs.getString("name");
						nameField.setText(name);
						
						lastname=rs.getString("lastname");
						lastNameField.setText(lastname);
				
						email=rs.getString("email");
						emailField.setText(email);
				
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
						name=rs.getString("name");
						nameField.setText(name);
						
						lastname=rs.getString("lastname");
						lastNameField.setText(lastname);
				
						email=rs.getString("email");
						emailField.setText(email);
				
					}
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}





}