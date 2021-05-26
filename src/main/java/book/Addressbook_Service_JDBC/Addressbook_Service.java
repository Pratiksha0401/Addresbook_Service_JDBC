package book.Addressbook_Service_JDBC;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Addressbook_Service 
{
	static Scanner sc =new Scanner(System.in);
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	System.out.println("Select option");
		System.out.println("1. Retrieve All Records ");
		System.out.println("2. Update Record ");		
		System.out.println("3. Reterive Record For Particular Date Range ");
		System.out.println("4. Get Contact By City Name ");
		System.out.println("5. Insert Record ");
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			printData();
			break;
		case 2:
			updateData();
			break;	
		case 3:
			ReteriveDataForParticularDateRange();
			break;	
		case 4:
			getContactByCity();
			break;	
		case 5:
			InsertRecord();
		}
}

	private static void printData() throws ClassNotFoundException, SQLException {
		AddressbookRepo addressbookRepo = new AddressbookRepo();
		List<Contact> detailList = addressbookRepo.findAll();
		detailList.forEach(value -> System.out.println(value));
	}
	
	private static void updateData() throws ClassNotFoundException, SQLException {
		System.out.println("Enter first name");
		String firstName = sc.next();
		System.out.println("Enter new phone number");
		String phoneNo = sc.next();
		AddressbookRepo updateInfo = new AddressbookRepo();
		updateInfo.updateContact(firstName, phoneNo);
	}
	
	private static void ReteriveDataForParticularDateRange() throws SQLException {
		AddressbookRepo addressbookRepo = new AddressbookRepo();
		List<Contact> details = addressbookRepo.findAllForParticularDateRange();
		details.forEach(System.out::println);
	}
	
	
	private static void getContactByCity() throws SQLException {
		AddressbookRepo addressbookRepo = new AddressbookRepo();
		List<Contact> details = addressbookRepo.getContactByCity();
		details.forEach(System.out::println);		
	}
	
	private static void InsertRecord() throws SQLException {
    	Contact info = new Contact();
    	
    	System.out.println("Enter FirstName");
		info.setFirstName(sc.next());
		
		System.out.println("Enter LastName");
		info.setLastName(sc.next());
		
		System.out.println("Enter Address");
		info.setAddress(sc.next());
		
		System.out.println("Enter City");
		info.setCity(sc.next());
		
		System.out.println("Enter State");
		info.setState(sc.next());
		
		System.out.println("Enter ZipCode");
		info.setZipCode(sc.next());
		
		System.out.println("Enter PhoneNumber");
		info.setPhoneNo(sc.next());
		
		System.out.println("Enter EmailId");
		info.setEmail_ID(sc.next());
		
		System.out.println("Enter Date Added");
		info.setDate(sc.next());
			
		AddressbookRepo repo = new AddressbookRepo();
		repo.insertRecord(info);
		
	}
}
