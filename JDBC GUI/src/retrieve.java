import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;



public class retrieve {
	
	public static ResultSet rs;
	public static String fName="", lName="", ssn="", salary = "", gender="";
	   static Connection con;
	    static Statement st;
///////////
	
 public static void main(String args[]) {
 JFrame f = new JFrame("Conor Brett - Assignment 1");
 	
	final JLabel fNameLabel = new JLabel("Name: ");
	JLabel lNameLabel = new JLabel("Last Name: ");
	JLabel ssnLabel = new JLabel("SSN Number: ");
	JLabel genderLabel = new JLabel("Gender: ");
	JLabel salaryLabel = new JLabel("Salary: ");
	final JTextField fNameField = new JTextField(65);
	final JTextField lNameField = new JTextField(65);
	final JTextField ssnField = new JTextField(65);
	final JTextField genderField = new JTextField(1);
	final JTextField salaryField = new JTextField(65);
	JButton btnUpdate = new JButton("Update");
	JButton btnDelete = new JButton("Delete");
	JButton btnInsert = new JButton("Save");
	JButton next = new JButton("Next");
	JButton prev = new JButton("Prev");

	
	
	

	
	try{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery("select * from test");
		
		
	}
		
	catch(Exception e){}
	
		JPanel p = new JPanel(new GridLayout(8,8));
		p.add(fNameLabel);
		p.add(fNameField);
		p.add(lNameLabel);
		p.add(lNameField);
		p.add(ssnLabel);
		p.add(ssnField);
		p.add(salaryLabel);
		p.add(salaryField);
		p.add(genderLabel);
		p.add(genderField);
		p.add(next);
		p.add(prev);
		p.add(btnInsert);
		p.add(btnUpdate);
		p.add(btnDelete);
		f.add(p);
		f.setVisible(true);
		f.pack();
		
		
	    //UPDATE Customers
		//Handles Update Button
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
		             
		            st = con.createStatement();
		            st.executeUpdate("UPDATE test SET fName = " + "'" + fNameField.getText() + "'," + "gender = " + "'" + genderField.getText() + "',"  +  "salary = " + "'" + salaryField.getText() + "',"  + "lName = "  + "'" + lNameField.getText() + "'" + "WHERE ssn =" + ssnField.getText() +";" ); //Basic Update funciton, TODO Add other variables
		            //Success Popup
		            JOptionPane.showMessageDialog(null, 
                              "User has been successfully updated!", 
                              "Success!", 
                              JOptionPane.WARNING_MESSAGE);  
		        
		        
		        } 
		        catch (Exception e) {
		            e.printStackTrace();
		        }finally {
		            try {   
		                st.close();
		                con.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		    }   
		
		});
		
		
	
		//Handles Delete Button
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try
				        {
				            Class.forName("com.mysql.jdbc.Driver");
				            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
				             
				            st = con.createStatement();
				            st.execute("DELETE FROM test WHERE ssn = + " + "'" +ssnField.getText() + "'" + "AND fName = " + "'" + fNameField.getText() + "'" + "'" + lNameField.getText() + "'" + "'" + genderField.getText() + "'" + "'" + salaryField.getText() + "'"); 		//Delete username when all text fields match a user
				            //Set fields to empty
				            fNameField.setText("");
				            lNameField.setText("");
				            ssnField.setText("");
				            salaryField.setText("");
				            genderField.setText("");
				            //Success Popup
				            JOptionPane.showMessageDialog(null, 
		                              "User has been successfully deleted!", 
		                              "Success!", 
		                              JOptionPane.WARNING_MESSAGE);
				        } 
				        catch (Exception e) {
				            e.printStackTrace();
				        }finally {
				            try {   
				                st.close();
				                con.close();
				            } catch (Exception e) {
				                e.printStackTrace();
				            }
				        }
				    }   
				
				});
				
				
				//Handles Insert Button
				btnInsert.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (fNameField.getText() == null || fNameField.getText().trim().isEmpty() || lNameField.getText() == null || lNameField.getText().trim().isEmpty() || ssnField.getText() == null || ssnField.getText().trim().isEmpty() || salaryField.getText() == null || salaryField.getText().trim().isEmpty() || genderField.getText() == null || genderField.getText().trim().isEmpty()) {
			            	JOptionPane.showMessageDialog(null, 
		                              "Please Fill In All The Fields!", 
		                              "ERROR!", 
		                              JOptionPane.WARNING_MESSAGE);
			            	
			           }
						
						else if (!genderField.getText().equals("M") && !genderField.getText().equals("F") ) {
			            	JOptionPane.showMessageDialog(null, 
		                              "Please Input a valid gender (M/F)!", 
		                              "ERROR!", 
		                              JOptionPane.WARNING_MESSAGE);
			            	
			           }
						else
						
						try
				        {
				            Class.forName("com.mysql.jdbc.Driver");
				            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
				            
				            
				             
				            st = con.createStatement();
				            st.executeUpdate("INSERT INTO test (fName, lName, ssn, salary, gender) VALUES('"+ fNameField.getText() +"','"+ lNameField.getText() +"','"+ ssnField.getText()+ "','" + salaryField.getText() + "','"+ genderField.getText() +"'" + ")"); //Using temporary placeholder of 5 for salary
				            //Set fields to empty
				            fNameField.setText("");
				            lNameField.setText("");
				            ssnField.setText("");
				            salaryField.setText("");
				            genderField.setText("");
				            //Success Popup
				            JOptionPane.showMessageDialog(null, 
		                              "User has been successfully created!", 
		                              "Success!", 
		                              JOptionPane.WARNING_MESSAGE);
				            
				        } 
						
				        catch (Exception e)  {
				        	
				        	e.printStackTrace();
				        }finally {
				            try {   
				                st.close();
				                con.close();
				            } catch (Exception e) {
				                e.printStackTrace();
				            }
				            
				        }
				    }   
				
				});
				
				

		
		//Handles Previous Button
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (rs.previous()){
						fName=rs.getString("fName");
						fNameField.setText(fName);
						
						lName=rs.getString("lName");
						lNameField.setText(lName);
						
						ssn=rs.getString("ssn");
						ssnField.setText(ssn);
						
						gender=rs.getString("gender");
						genderField.setText(gender);
						
						salary=rs.getString("salary");
						salaryField.setText(salary);
				
				
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
						
						ssn=rs.getString("ssn");
						ssnField.setText(ssn);
						
						gender=rs.getString("gender");
						genderField.setText(gender);
						
						salary=rs.getString("salary");
						salaryField.setText(salary);
				
				
					}
				} catch (SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}





}