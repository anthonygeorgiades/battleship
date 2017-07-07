package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BattleshipTest {
	private Battleship newtestship; //declare a new Battleship called newtestship


	@Before
	public void setUp() throws Exception {
		newtestship = new Battleship(); //create new Battleship called newtestship
	}

	@Test
	public void testGetShipType() {
		assertTrue(newtestship.getShipType().equals("Battleship")); //assert true that it returns the right ship type as string of "Battleship"
		assertFalse(newtestship.getShipType().equals("Submarine")); //assert that this ship type is not another string type
	}

	public void testGetShipLength(){
		assertEquals(newtestship.length, 4); //assert that length is 4
		assertNotEquals(newtestship.length, 5);

	}

}
