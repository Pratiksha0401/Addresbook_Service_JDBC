package book.Addressbook_Service_WithNameandType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressbookRepo {
	
		//method to get data in list
		public List<Contact>findAll() throws SQLException {
			Connection connection = null;
			Statement statement = null;
			
			List<Contact> details=new ArrayList<>();
			try {
				//loading and registering driver
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
				
				//establishing connection with getConncetion() method for DriverManager from Connection interface
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
				
				//creating object of statement with createStatement() method
				statement = connection.createStatement();
				//query to pass
				String query ="Select * from addressbook";
				
				ResultSet result = statement.executeQuery(query);
				
				//using while loop with .next() method for result to get next result
				while(result.next()) {
					Contact info = new Contact();
					
					String firstName = result.getString(2);
					info.setFirstName(firstName);
					
					String lastName = result.getString(3);
					info.setLastName(lastName);
					
					String address = result.getString(4);
					info.setAddress(address);
					
					String city = result.getString(5);
					info.setCity(city);
					
					String phoneNo = result.getString(8);
					info.setPhoneNo(phoneNo);
					
					details.add(info);
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					//closing connection and statement
					if(connection != null) {
						connection.close();
					}
					if(statement != null) {
					   statement.close();
					}
				}
				return details;
		}
		
		public void updateContact(String firstName, String phoneNo) {
			Connection connection = null;
			PreparedStatement prestatement = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
				String query =  "update addressbook set PhoneNo = ? where FirstName = ?";
				prestatement = connection.prepareStatement(query);
				prestatement.setString(1, phoneNo);
				prestatement.setString(2, firstName);
				
				int result = prestatement.executeUpdate();
				System.out.println("Contact Updated");
			}catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
}
