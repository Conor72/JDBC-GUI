import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
import javax.swing.JOptionPane;



public class retrieve {
	
	public static ResultSet rs;
	public static String fName="", lName="", ssn="", salary = "", gender="";
	   static Connection con;
	    static Statement st;
///////////
	
 public static void main(String args[]) {
 JFrame f = new JFrame();
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
	JButton btnInsert = new JButton("Insert");
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
		p.add(ssnLabel);
		p.add(ssnField);
		p.add(salaryLabel);
		p.add(salaryField);
		p.add(genderLabel);
		p.add(genderField);
		p.add(next);
		p.add(prev);
		p.add(btnDelete);
		p.add(btnInsert);
		p.add(btnUpdate);
		f.add(p);
		f.setVisible(true);
		f.pack();
		
		
	//	UPDATE Customers
		//Handles Update Button
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
		        {
		            Class.forName("com.mysql.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
		             
		            st = con.createStatement();
		            st.executeUpdate("UPDATE test SET fName = " + "'" + fNameField.getText() + "'," + "gender = " + "'" + genderField.getText() + "',"  +  "salary = " + "'" + salaryField.getText() + "',"  + "lName = "  + "'" + lNameField.getText() + "'" + "WHERE ssn =" + ssnField.getText() +";" ); //Basic Update funciton, TODO Add other variables
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
				            st.execute("DELETE FROM test WHERE ssn = " +ssnField.getText()); 		//Uses SSN number as unique ID 
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
						else
						
						try
				        {
				            Class.forName("com.mysql.jdbc.Driver");
				            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "password");
				            
				            
				             
				            st = con.createStatement();
				            st.executeUpdate("INSERT INTO test (fName, lName, ssn, salary, gender) VALUES('"+ fNameField.getText() +"','"+ lNameField.getText() +"','"+ ssnField.getText()+ "','" + salaryField.getText() + "','"+ genderField.getText() +"'" + ")"); //Using temporary placeholder of 5 for salary
				            fNameField.setText("");
				            lNameField.setText("");
				            ssnField.setText("");
				            salaryField.setText("");
				            genderField.setText("");
				        } 
						
				        catch (Exception e)  {
				        	
				        	JOptionPane.showMessageDialog(null, "You MUST include a first name!");
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
		
		
		

		
		
		
//		
//		btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
//	        // TODO add your handling code here:
//	        int i = tblStudents.getSelectedRow();
//	        if (i >= 0) {
//	            int option = JOptionPane.showConfirmDialog(rootPane,
//	                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
//	            if (option == 0) {
//	                TableModel model = tblStudents.getModel();
//
//	                String id = model.getValueAt(i, 2).toString();
//	                if (tblStudents.getSelectedRows().length == 1) {
//	                    delete(id);
//	                    DefaultTableModel model1 = (DefaultTableModel) tblStudents.getModel();
//	                    model1.setRowCount(0);
//	                    fetch();
//	                    clear();
//	                }
//	            }
//	        } else {
//	            alert("Please select a row to delete");
//	        }
//		
//		
//		
		
		
		
		
	}





}