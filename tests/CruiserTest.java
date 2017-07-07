package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CruiserTest {
	private Cruiser newtestcruiser; //declare new private Cruiser called newtestcruiser

	@Before
	public void setUp() throws Exception {
		newtestcruiser = new Cruiser(); //create newtestcruiser as new Cruiser
	}

	@Test
	public void testGetShipType() {
		assertTrue(newtestcruiser.getShipType().equals("Cruiser")); //assert true that ship type string returns as "Cruiser"
		assertFalse(newtestcruiser.getShipType().equals("Destroyer")); //assert that ship type string is not returning as "Destroyer"

	}

	public void testGetShipLength(){
		assertEquals(newtestcruiser.length, 3); //assert cruiser length is 3
		assertNotEquals(newtestcruiser.length, 4); //assert cruiser length is not 4

	}

}
