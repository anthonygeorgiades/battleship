package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OceanTest {
	Ocean testOcean;
	Ship testsubmarine;
	Ship testcruiser;
	Ship testdestroyer;
	Ship[][] ships = new Ship [10][10]; //Used to quickly determine which ship is in any given location
	int shotsFired; //The total number of shots red by the user.
	int hitCount; //The number of times a shot hit a ship
	int shipsSunk; //The number of ships sunk (10 ships in all)

	@Before
	public void setUp() throws Exception {
		testsubmarine = new Submarine(); //The new ship p made using abstract class Ship of type Submarine.
		testcruiser = new Cruiser();
		testdestroyer = new Destroyer();
		testOcean= new Ocean();
		shotsFired = 0; //initializes game variable
		hitCount = 0; //initializes game variable
		shipsSunk =0; //initializes game variable
	}

	@Test
	public void testOcean() {	
		Ship[][] ships = testOcean.getShipArray();
		for (int i=0; i < 10; i++) {
			for (int j=0; j < 10; j++) {
				assertTrue(ships[i][j].getShipType().equals("empty"));
			}
		}
	}

	@Test
	public void testPlaceAllShipsRandomly() {
		int count;
		count = 0;
		testOcean.placeAllShipsRandomly();
		Ship[][] ships = testOcean.getShipArray();
		for (int i=0; i < 10; i++) {
			for (int j=0; j < 10; j++) {
				if (testOcean.isOccupied(i, j)){
					count++;
				}
			}
		}
		assertEquals(20, count);
	}

	@Test
	public void testIsOccupied() {
		testsubmarine.placeShipAt(1, 2, true, testOcean); //The ship is being placed in the ocean array
		assertEquals(testOcean.isOccupied(1,2),true); //checking if ship is occupied
		assertEquals(testOcean.isOccupied(9,9),false);
		testsubmarine.placeShipAt(2, 2, true, testOcean); //The ship is being placed in the ocean array
		assertEquals(testOcean.isOccupied(2,2),true); //checking if ship is occupied
		assertEquals(testOcean.isOccupied(7,7),false);
		testdestroyer.placeShipAt(5, 5, true, testOcean); //The ship is being placed in the ocean array
		assertEquals(testOcean.isOccupied(5,5),true);
		assertEquals(testOcean.isOccupied(5,6),true);
		testcruiser.placeShipAt(7, 7, false, testOcean); //The ship is being placed in the ocean array
		assertEquals(testOcean.isOccupied(7,7),true);
		assertEquals(testOcean.isOccupied(8,7),true);
		assertEquals(testOcean.isOccupied(9,7),true);
		assertEquals(testOcean.isOccupied(6,7),false); 
		assertEquals(testOcean.isOccupied(2,2),true); 


	}

	@Test
	public void testShootAt() {
		testsubmarine.placeShipAt(1, 2, true, testOcean); //The ship is being placed in the ocean array.
		assertEquals(testOcean.shootAt(1,2),true); //checking if shootAt shoots the ship
		assertEquals(testOcean.shootAt(8,8),false);
		testdestroyer.placeShipAt(5, 5, true, testOcean); //The ship is being placed in the ocean array
		assertEquals(testOcean.shootAt(5,5),true); //checking if shootAt shoots the ship
		assertEquals(testOcean.shootAt(5,6),true); //checking if shootAt shoots the ship
		assertEquals(testOcean.shootAt(5,7),false); //checking if shootAt shoots the ship
		assertEquals(testOcean.shootAt(5,6),true); //checking if shootAt shoots the ship
		assertEquals(testOcean.shootAt(2,2),false); //checking shooting at empty sea

	}

	@Test
	public void testGetShotsFired() {
		testOcean.shotsFired=2; //initializing shotsFired value
		assertEquals(testOcean.getShotsFired(),2); //Checking true value
		assertNotEquals(testOcean.getShotsFired(),0); //Checking other value
		assertNotEquals(testOcean.getShotsFired()," "); //checking for string type
		testOcean.shootAt(5, 5);
		assertEquals(testOcean.getShotsFired(),3); //Checking true value
		assertNotEquals(testOcean.getShotsFired(),2); //Checking true value
		testOcean.shootAt(5, 5);
		assertNotEquals(testOcean.getShotsFired(),3); //Checking true value
		assertEquals(testOcean.getShotsFired(),4); //Checking true value
		testOcean.shotsFired=0; //initializing shotsFired value
		testOcean.shootAt(5, 5);
		assertEquals(testOcean.getShotsFired(),1); //Checking true value
		assertNotEquals(testOcean.getShotsFired(),3); //Checking true value

	}

	@Test
	public void testGetHitCount() {
		testOcean.hitCount=4; //initializing hitCount value
		assertEquals(testOcean.getHitCount(),4); //Checking true value
		assertNotEquals(testOcean.getHitCount(),1); //Checking other value
		assertNotEquals(testOcean.getHitCount()," "); //Checking for string type
		testsubmarine.placeShipAt(1, 2, true, testOcean); //The ship is being placed in the ocean array.
		testOcean.shootAt(1, 2);
		testOcean.shootAt(2, 3);
		assertEquals(testOcean.getHitCount(),5); //Checking true value
		assertNotEquals(testOcean.getHitCount(),6); //Checking true value
		testdestroyer.placeShipAt(5, 5, false, testOcean); //The ship is being placed in the ocean array.
		testOcean.shootAt(5, 5);
		assertEquals(testOcean.getHitCount(),6); //Checking true value
		testOcean.shootAt(8, 8);
		assertEquals(testOcean.getHitCount(),6); //Checking true value


	}

	@Test
	public void testGetShipsSunk() {
		testOcean.shipsSunk=6; //initializing shipsSunk value
		assertEquals(testOcean.getShipsSunk(),6); //Checking for true value
		assertNotEquals(testOcean.getShipsSunk(),3); //Checking other value
		assertNotEquals(testOcean.getShipsSunk()," "); //Checking for string type;
		testOcean.shipsSunk=8; //initializing shipsSunk value
		assertEquals(testOcean.getShipsSunk(),8); //Checking for true value

	}

	@Test
	public void testIsGameOver() {
		testOcean.shipsSunk=10; //initializing shipsSunk value to 10
		assertEquals(testOcean.isGameOver(),true); //checking if game over is true
		testOcean.shipsSunk=9; //initializing shipsSunk value to 9
		assertEquals(testOcean.isGameOver(),false); //checking if game over is false
	}

	@Test
	public void testGetShipArray() {
		assertEquals(10, ships.length);
		for (int i=0; i < 10; i++){
			assertEquals(10, ships[i].length);
		}
	}

}
