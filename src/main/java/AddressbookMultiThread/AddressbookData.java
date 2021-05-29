package AddressbookMultiThread;

public class AddressbookData {
	
	public String FirstName;
	public String LastName;
	public String Address;
	public String City;
	public String State;
	public String ZipCode;
	public String PhoneNo;
	public String Email_ID;
	public String date;
	
	public AddressbookData( String firstName, String lastName, String address, String city, String state,
			String zipCode, String phoneNo, String email_ID, String date) {
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.ZipCode = zipCode;
		this.PhoneNo = phoneNo;
		this.Email_ID = email_ID;
		this.date = date;
	}
}
