package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShipTest {
	Ship p;
	Ocean testOcean;
	Ship a;
	Ship d;
	Ship e;

	@Before
	public void setUp() throws Exception {
		p = new Submarine(); //create a new sub to test
		a = new Cruiser(); //create a new cruiser to test 
		d = new Destroyer(); //create new destroyer to test
		e = new Cruiser();
		testOcean=new Ocean();
	}

	@Test
	public void testGetLength() {
		assertEquals(p.getLength(),1);
		assertNotEquals(p.getLength(),3);
		assertNotEquals(p.getLength(),""); //check that not returning string
		assertEquals(a.getLength(), 3);
		assertNotEquals(a.getLength(),2);

	}

	@Test
	public void testGetBowRow() {
		p.placeShipAt(2, 2, true, testOcean);
		assertEquals(p.getBowRow(),2);
		assertNotEquals(p.getBowRow(),3);
		a.bowRow=5;
		assertEquals(a.getBowRow(),5);
		assertNotEquals(a.getBowRow(),7);
		a.placeShipAt(7, 7, true, testOcean);
		assertEquals(a.getBowRow(),7);
		assertNotEquals(a.getBowRow(),8);
		a.placeShipAt(5, 7, false, testOcean);
		assertEquals(a.getBowRow(),5);
		assertNotEquals(a.getBowRow(),6);
		assertNotEquals(a.getBowRow(),7);
		p.bowRow=3;
		assertEquals(p.getBowRow(),3);
		assertNotEquals(p.getBowRow(),2);
		a.placeShipAt(7, 5, true, testOcean);
		assertEquals(a.getBowRow(),7);
		assertNotEquals(a.getBowRow(),8);
	}

	@Test
	public void testGetBowColumn() {
		p.bowColumn=2;
		assertEquals(p.getBowColumn(),2);
		assertNotEquals(p.getBowColumn(),3);
		a.bowColumn=4;
		assertEquals(a.getBowColumn(),4);
		assertNotEquals(a.getBowColumn(),5);
		p.placeShipAt(3, 3, true, testOcean);
		assertEquals(p.getBowColumn(),3);
		assertNotEquals(p.getBowColumn(),2);
		p.placeShipAt(2, 2, false, testOcean);
		assertEquals(p.getBowColumn(),2);
		assertNotEquals(p.getBowColumn(),3);
		a.placeShipAt(7, 7, true, testOcean);
		assertEquals(a.getBowColumn(),7);
		assertNotEquals(a.getBowColumn(),8);
		a.placeShipAt(5, 7, false, testOcean);
		assertEquals(a.getBowColumn(),7);
		assertNotEquals(a.getBowColumn(),6);
		assertNotEquals(a.getBowColumn(),5);
		assertNotEquals(a.getBowColumn(),"");
		assertNotEquals(a.getBowColumn(),10);
		assertNotEquals(a.getBowColumn(),-1);




	}

	@Test
	public void testIsHorizontal() {
		p.horizontal=true;
		assertEquals(p.isHorizontal(),true);
		assertNotEquals(p.isHorizontal(),false);
		p.horizontal=false;
		assertEquals(p.isHorizontal(),false);
		assertNotEquals(p.isHorizontal(),true);
		a.horizontal=false;
		assertEquals(a.isHorizontal(),false);
	}

	@Test
	public void testSetBowRow() {
		p.setBowRow(2);
		assertEquals(p.getBowRow(), 2);
		assertEquals(p.bowRow,2);
		assertNotEquals(p.bowRow,3);
		p.setBowRow(3);
		assertEquals(p.getBowRow(), 3);
		assertEquals(p.bowRow,3);
		assertNotEquals(p.bowRow,2);
		a.setBowRow(3);
		assertEquals(a.getBowRow(), 3);
		assertEquals(a.bowRow,3);
		assertNotEquals(a.bowRow,2);
		a.setBowRow(2);
		assertEquals(a.getBowRow(), 2);
		assertEquals(a.bowRow,2);
		assertNotEquals(a.bowRow,3);
		assertNotEquals(a.bowRow,10);
		assertNotEquals(a.bowRow,-1);
		assertNotEquals(a.bowRow,"");

	}

	@Test
	public void testSetBowColumn() {
		a.setBowColumn(2);
		assertEquals(a.getBowColumn(), 2);
		assertEquals(a.bowColumn,2);
		assertNotEquals(a.bowColumn,3);
		p.setBowColumn(3);
		assertEquals(p.getBowColumn(), 3);
		assertEquals(p.bowColumn,3);
		assertNotEquals(p.bowColumn,2);
		a.setBowColumn(3);
		assertEquals(a.getBowColumn(), 3);
		assertEquals(a.bowColumn,3);
		assertNotEquals(a.bowColumn,2);
		a.setBowColumn(5);
		assertEquals(a.getBowColumn(), 5);
		assertEquals(a.bowColumn,5);
		assertNotEquals(a.bowColumn,3);
		assertNotEquals(a.bowColumn,"");
		assertNotEquals(a.bowColumn,-1);


		
	}

	@Test
	public void testSetHorizontal() {
		p.setHorizontal(true);
		assertEquals(p.horizontal,true);
		assertNotEquals(p.horizontal,false);
		p.setHorizontal(false);
		assertEquals(p.horizontal,false);
		assertNotEquals(p.horizontal,true);
		a.setHorizontal(true);
		assertEquals(a.horizontal,true);
		assertNotEquals(a.horizontal,false);
		a.setHorizontal(false);
		assertEquals(a.horizontal,false);
		assertNotEquals(a.horizontal,true);
	}

	@Test
	public void testOkToPlaceShipAt() {
		//p.placeShipAt(2,3, true, testOcean);
		assertEquals(p.okToPlaceShipAt(2, 3, true, testOcean),true);
		assertEquals(p.okToPlaceShipAt(7,5 , true, testOcean),true);
		assertTrue(p.okToPlaceShipAt(9, 2, true, testOcean));
		//a.placeShipAt(9, 9, false, testOcean);
		assertEquals(a.okToPlaceShipAt(9, 9, false, testOcean), false);
		assertEquals(p.okToPlaceShipAt(10, 10, true, testOcean),false);
		assertEquals(a.okToPlaceShipAt(9, 9	, true, testOcean),false);
		p.placeShipAt(5, 7, false, testOcean);
		//assertEquals(a.okToPlaceShipAt(7, 7, true, testOcean), false);
	}

	@Test
	public void testPlaceShipAt() {
		a.placeShipAt(2, 3, true, testOcean);
		assertEquals(a.getBowColumn(), 3);
		assertEquals(a.getBowRow(), 2);
		p.placeShipAt(5, 7, true, testOcean);
		assertEquals(p.getBowColumn(), 7);
		assertEquals(p.getBowRow(), 5);
		assertNotEquals(p.getBowRow(), 6);
		assertNotEquals(p.getBowRow(), 7);
		assertNotEquals(p.getBowColumn(), 4);
		a.placeShipAt(5, 7, false, testOcean);
		assertEquals(a.getBowColumn(), 7);
		assertNotEquals(a.getBowColumn(), 5);
		assertNotEquals(a.getBowColumn(), 8);
		assertNotEquals(a.getBowColumn(), 9);
		assertEquals(a.getBowRow(), 5);
		assertNotEquals(a.getBowRow(), 6);

	}

	@Test
	public void testShootAt() {
		a.placeShipAt(2, 3, true, testOcean);
		assertEquals(a.shootAt(2, 3), true);
		assertEquals(a.shootAt(2, 4), true);
		assertEquals(a.shootAt(2, 5), true);
		assertEquals(a.shootAt(2, 6), false);
		assertTrue(a.shootAt(2, 3));
		assertTrue(a.shootAt(2, 4));
		assertTrue(a.shootAt(2, 5));
		assertFalse(a.shootAt(2, 1));
		assertNotEquals(a.shootAt(2, 3), false);
		p.placeShipAt(4, 6, true, testOcean);
		assertNotEquals(a.shootAt(4, 5), true);
		
	}

	@Test
	public void testIsSunk() {
		p.hit[0]=false;
		assertEquals(p.isSunk(),false);	
		assertFalse(p.isSunk());
		p.hit[0]=true;
		assertEquals(p.isSunk(), true);
		assertTrue(p.isSunk());
		a.hit[0]=true;
		a.hit[1]=true;
		assertEquals(a.isSunk(), false);
		a.hit[2]=true;
		assertEquals(a.isSunk(),true);
		assertTrue(a.isSunk());
		d.hit[0]=true;
		assertEquals(d.isSunk(), false);
		d.hit[1]=true;
		d.hit[2]=true;
		d.hit[3]=true;
		assertEquals(d.isSunk(), true);
		e.placeShipAt(5, 7, true, testOcean);
		e.shootAt(5, 7);
		assertEquals(e.isSunk(), false);
		e.shootAt(5, 8);
		assertEquals(e.isSunk(), false);
		e.shootAt(5, 9);
		assertEquals(e.isSunk(), true);


	}


}
