package book.Addressbook_Service_WithNameandType;

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
		int option = sc.nextInt();
		//using switch case to select option weather to add data or display data
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
}
