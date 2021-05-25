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
		System.out.println("1. get all records ");
		int option = sc.nextInt();
		//using switch case to select option weather to add data or display data
		switch(option) {
		case 1:
			printData();
			break;
		}
}

	private static void printData() throws ClassNotFoundException, SQLException {
		AddressbookRepo addressbookRepo = new AddressbookRepo();
		List<Contact> detailList = addressbookRepo.findAll();
		detailList.forEach(value -> System.out.println(value));
	}
}
