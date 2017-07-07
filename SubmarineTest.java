package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubmarineTest {
	private Submarine newtestsubmarine; //declare new private Submarine called newtestsubmarine

	@Before
	public void setUp() throws Exception {
		newtestsubmarine = new Submarine(); //create newtestsubmarine as new Submarine
	}

	@Test
	public void testGetShipType() {
        assertTrue(newtestsubmarine.getShipType().equals("Submarine")); //assert true that ship type string returns as "Submarine"
        assertFalse(newtestsubmarine.getShipType().equals("Cruiser")); //assert that ships string is not being returned something other than Submarine 
	}
	
	public void testGetShipLength(){
		assertEquals(newtestsubmarine.length, 1);
		assertNotEquals(newtestsubmarine.length, 4);
	}
}
