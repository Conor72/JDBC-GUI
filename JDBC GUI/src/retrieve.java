import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;




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
	final JTextField fNameField = new JTextField(65);
	final JTextField lNameField = new JTextField(65);
	final JTextField ssnField = new JTextField(65);
	final JTextField genderField = new JTextField(1);
	JButton btnDelete = new JButton("Update");
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
		p.add(genderLabel);
		p.add(genderField);
		p.add(next);
		p.add(prev);
		p.add(btnDelete);
		f.add(p);
		f.setVisible(true);
		f.pack();
		
		
		
	
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