package facturePRO.database;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import newdatabase.Towar;
import newdatabase.connector.*;

public class DatabaseTest {

	@Ignore
	@Test
	public void getVatTest() {
		for(int i = 0; i < 10; i++)
			System.out.println(VatConnector.getVat(i));
	}
	
	@Ignore
	@Test
	public void getTowarTest() {
		for(int i = 0; i < 10; i++)
			System.out.println(TowarConnector.getTowar(i));
		System.out.println("OK");
	}
	
	/*
	@Ignore
	@Test
	public void getTowarsTest() {
		List<Towar> towars = TowarConnector.getTowars();
		for(Towar towar: towars)
			System.out.println(towar);
		System.out.println("OK");
	}
	*/
}
