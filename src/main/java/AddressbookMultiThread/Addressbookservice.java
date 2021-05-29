package AddressbookMultiThread;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Addressbookservice {
	public static void main(String[] args) throws SQLException {
		AddressbookData[] data = {
				new AddressbookData("Mark","Smith","WestVilla","Kentucky","NewStates","510034","9000056102","mark123@gmail.com","2020-04-21"),
				new AddressbookData("Gary","Lu","CrossHill","Missouri","Texas","120000","911456102","lu@gmail.com","2020-05-11"),
				new AddressbookData("Sam","Sam","OxfordRoad","Vegas","LasVegas","842300","990156102","sam@outlook.com","2020-05-25")
		};
		
		AddressbookRepo repo = new AddressbookRepo();	
		Instant start = Instant.now();
		
		Arrays.stream(data).forEach(value -> {
			Runnable task = () ->{
				try {
					repo.insertMultipleRecord(value);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			};
		});
		Instant end = Instant.now();
		System.out.println("Duration with thread:" +Duration.between(start, end));
	}
}
