package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptySeaTest {
	private int rowone; //declare int rowone
	private int columnone; //declare int columone
	private EmptySea newemptysea; //declare EmptySea called newemptysea
	private Submarine newsubmarine; //declare ship type Submarine newsubmarine
	private Ocean ocean; //declare new ocean 
	private int rowtwo; //declare int rowtwo
	private int columntwo; //declare int columntwo

	
	@Before
	public void setUp() throws Exception {
		rowone = 1; //set rowone to position 1 (1,1)
		columnone = 1; //set columnone to position 1 (1,1)
		rowtwo = 2; //set rowtwo to position 2 (2,2)
		columntwo = 2; //set columntwo to position 2 (2,2)
		newemptysea = new EmptySea(); //initiate newemptysea as a new empty sea  
		newsubmarine = new Submarine(); //initiate the new ship type newsubmarine as a new submarine 
		ocean = new Ocean(); //intiiate new ocean
		newemptysea.placeShipAt(rowone, columnone, true, ocean); //place the empty sea ship in coordinate (1,1) as declared above
		newsubmarine.placeShipAt(rowtwo, columntwo, true, ocean); //place the submarine ship in coordinate (2,2) as declared abo
	}

	@Test
	public void testGetShipType() {
		assertTrue(newemptysea.getShipType().equals("empty")); //assert that newemptysea, an EmptySea, returns "empty"
		assertFalse(newsubmarine.getShipType().equals("empty")); //assert that another type does not return "empty"
		assertTrue(newsubmarine.getShipType().equals("Submarine")); //assert that submarine type only returns sub
		assertFalse(newemptysea.getShipType().equals("Submarine")); //assert that newemptysea, an EmptySea, does not return something other than "empty"
	}

	@Test
	public void testShootAt() {
		assertFalse(newemptysea.shootAt(rowone, columnone)); //assert that shooting at the newemptysea at (1,1) returns false, as it always should
		assertTrue(newsubmarine.shootAt(rowtwo, columntwo)); //assert that shooting at sub at (2,2) does not not return false
		newsubmarine.placeShipAt(2, 2, true, ocean);
		assertFalse(newemptysea.shootAt(2, 2));
	}

	@Test
	public void testIsSunk() {
		assertFalse(newemptysea.isSunk()); //assert that newemptysea returns false as it always should
		assertFalse(newsubmarine.isSunk()); //assert that newsub returns false as it should
		assertNotEquals(newsubmarine.isSunk(), true);
		assertEquals(newsubmarine.isSunk(), false);
		assertNotEquals(newemptysea.isSunk(), true);
		assertEquals(newemptysea.isSunk(), false);

	}

	@Test
	public void testToString() {
		assertTrue(newemptysea.toString().equals(".")); //assert that newemptysea, before it is shot at, returns a period
		newemptysea.shootAt(rowone, columnone); //shoot at newemptysea
		assertTrue(newemptysea.toString().equals("-")); //assert that newemptysea, after it is shot, returns a "-" as it should
		newemptysea.shootAt(rowone, columnone); //shoot at newemptysea again!
		assertTrue(newemptysea.toString().equals("-"));	////assert that newemptysea, after it is shot again, still returns a "-" as it should
		
	}

}
