package AddressbookMultiThread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import book.Addressbook_Service_JDBC.Contact;

public class AddressbookRepo {
public void insertMultipleRecord(AddressbookData value) throws SQLException {
		
		Connection connection = null;
		PreparedStatement prepstatement = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_service", "root", "root");
			try {
				connection.setAutoCommit(false);
				String query = "insert into addressbook(FirstName,LastName,Address,City,State,ZipCode,PhoneNumber,EmailId,date_added) value(?,?,?,?,?,?,?,?,?)";
				prepstatement = connection.prepareStatement(query);
				prepstatement.setString(1, value.FirstName);
				prepstatement.setString(2, value.LastName);
				prepstatement.setString(3, value.Address);
				prepstatement.setString(4, value.City);
				prepstatement.setString(5, value.State);
				prepstatement.setString(6, value.ZipCode);
				prepstatement.setString(7, value.PhoneNo);
				prepstatement.setString(8, value.Email_ID);
				prepstatement.setString(9, value.date);
				
				prepstatement.executeUpdate();
				connection.commit();

		     }catch (SQLException e) {
				     e.printStackTrace();
					 connection.rollback();
					 System.out.println("Rolled Back Successfully");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			    }catch (Exception e) {
				    e.printStackTrace();
			 }finally {
			 	if(connection != null) {
			 		connection.close();
				}
				if(prepstatement != null) {
					prepstatement.close();
				}
			 }
	}
}
