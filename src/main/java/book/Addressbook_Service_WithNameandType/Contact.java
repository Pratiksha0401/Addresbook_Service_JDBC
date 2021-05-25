package book.Addressbook_Service_WithNameandType;

public class Contact {
	private int Id;
	private String FirstName;
	private String LastName;
	private String Address;
	private String City;
	private String PhoneNo;
	private String Email_ID;
	
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Contact [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Address=" + Address
				+ ", City=" + City + ", PhoneNo=" + PhoneNo + "]";
	}
	

	
	

	
}
