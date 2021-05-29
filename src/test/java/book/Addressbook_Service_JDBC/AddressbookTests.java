package book.Addressbook_Service_JDBC;

import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressbookTests 
{  
    	@Test
    	public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount() throws SQLException {
    		AddressbookRepo repo = new AddressbookRepo(); 
    		List<Contact> contactData = repo.findAll();
    		Assert.assertEquals(11, contactData.size());
    }
}
