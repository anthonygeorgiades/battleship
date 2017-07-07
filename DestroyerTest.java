package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DestroyerTest {
	private Destroyer newtestdestroyer; //declare new private Destroyer called newtestdestroyer

	@Before
	public void setUp() throws Exception {
		newtestdestroyer = new Destroyer(); //create newtestdestroyer as new Destroyer
	}

	@Test
	public void testGetShipType() {
		assertTrue(newtestdestroyer.getShipType().equals("Destroyer")); //assert true that ship type string returns as "Destroyer"
		assertFalse(newtestdestroyer.getShipType().equals("Cruiser")); //assert that ships string is not being returned something other than destroyer 
	}

	public void testGetShipLength(){
		assertEquals(newtestdestroyer.length, 2); 
		assertNotEquals(newtestdestroyer.length, 4);
	}
}
