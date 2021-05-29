package book.Addressbook_Service_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressbookRepo {
		
		private List<Contact> contactList=new ArrayList<>();
		
		private AddressbookRepo (List<Contact> contactList) {
			this();
			this.contactList=contactList;
		}
		public AddressbookRepo() {
			// TODO Auto-generated constructor stub
		}
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
					
					int id=result.getInt(1);
					info.setId(id);
					
					String firstName = result.getString(2);
					info.setFirstName(firstName);
					
					String lastName = result.getString(3);
					info.setLastName(lastName);
					
					String address = result.getString(4);
					info.setAddress(address);
					
					String city = result.getString(5);
					info.setCity(city);
					
					String state = result.getString(6);
					info.setState(state);
					
					String zip = result.getString(7);
					info.setZipCode(zip);
					
					String phoneNo = result.getString(8);
					info.setPhoneNo(phoneNo);
					
					String email = result.getString(9);
					info.setEmail_ID(email);
					
					String date=result.getString(12);
					info.setDate(date);
					
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
		
		
		//method get contact added between particular date range
		public List<Contact> findAllForParticularDateRange() throws SQLException {
			
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
				String query = "Select * from addressbook where addDate between Cast('2020-01-01' as date) and date(now())";
				
				ResultSet result = statement.executeQuery(query);
				
				//using while loop with .next() method for result to get next result
				while(result.next()) {
					Contact info = new Contact();
					
					int id=result.getInt(1);
					info.setId(id);
					
					String firstName = result.getString(2);
					info.setFirstName(firstName);
					
					String lastName = result.getString(3);
					info.setLastName(lastName);
					
					String address = result.getString(4);
					info.setAddress(address);
					
					String city = result.getString(5);
					info.setCity(city);
					
					String state = result.getString(6);
					info.setState(state);
					
					String zip = result.getString(7);
					info.setZipCode(zip);
					
					String phoneNo = result.getString(8);
					info.setPhoneNo(phoneNo);
					
					String email = result.getString(9);
					info.setEmail_ID(email);
					
					String date=result.getString(12);
					info.setDate(date);
					
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
		
		//method to list contact  bt city name
		public List<Contact> getContactByCity() throws SQLException {
			
			Connection connection = null;
			Statement statement = null;
			
			List<Contact> details=new ArrayList<>();
			try {
				//loading and registering driver
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
				
				//establishing connection with getConncetion() method 
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
				
				//creating object of statement with createStatement() method
				statement = connection.createStatement();
				//query to get list of contact by city name
				String query = "select * from addressbook where City = 'Bhandara'";
				
				ResultSet result = statement.executeQuery(query);
				
				//using while loop with .next() method for result to get next result
				while(result.next()) {
					Contact info = new Contact();
					
					int id=result.getInt(1);
					info.setId(id);
					
					String firstName = result.getString(2);
					info.setFirstName(firstName);
					
					String lastName = result.getString(3);
					info.setLastName(lastName);
					
					String address = result.getString(4);
					info.setAddress(address);
					
					String city = result.getString(5);
					info.setCity(city);
					
					String state = result.getString(6);
					info.setState(state);
					
					String zip = result.getString(7);
					info.setZipCode(zip);
					
					String phoneNo = result.getString(8);
					info.setPhoneNo(phoneNo);
					
					String email = result.getString(9);
					info.setEmail_ID(email);
					
					String date=result.getString(12);
					info.setDate(date);
					
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
		
		public void insertRecord(Contact info) throws SQLException {
			
			Connection connection = null;
			Statement statement = null;
			try {
			//Step1: Load & Register Driver Class
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			
			//Step2: Establish a MySql Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
			
			//Step3: Create Statement
			 statement = connection.createStatement();
			
			//Step4: Execute Query
			String query = "insert into addressBook(FirstName, LastName, Address, City, State, Zip, PhoneNo, Email_ID, addDate) "
					        + "value('"+info.getFirstName()+"','"+info.getLastName()+"','"+info.getAddress()+"','"+info.getCity()+"','"+info.getState()+"','"+info.getZipCode()+"','"+info.getPhoneNo()+ "','"+info.getEmail_ID()+ "','"+info.getDate()+"')";
			int result = statement.executeUpdate(query);
			System.out.print("Rows affected : "+result);
			
			}catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(connection != null) {
				statement.close();
				}
				if(statement != null) {
				connection.close();
				}
			}
			
		}

}