package battleship;

import java.util.ArrayList;

import battleship.EmptySea;

//ship is an abstract class
//we never create a ship, we always want to just create a specific type of ship

public abstract class Ship {

	// This contains a 10x10 array of Ships, representing the "ocean," and some
	// methods to manipulate it.

	// Instance Variables for this class
	int bowRow; // the row (0 to 9) which contains the bow (front) of the ship
	int bowColumn; // the column (0 to 9) which contains the bow (front) of the ship
	int length; // the number of squares occupied by the ship. An "empty sea" location has length 1
	boolean horizontal; // true if the ship occupies a single row, false otherwise
	public boolean[] hit = new boolean[4]; // an array of booleans telling whether that part of the ship has been hit

	// Methods
	/**
	 * method to return length
	 * @return the length of this ship, to be over-ridden in extended classes
	 * this will be overridden
	 */
	public int getLength() {
		return this.length; //return length of shipo
	}

	// Getters
	/**
	 * Getter
	 * @return the row of this bow
	 */
	public int getBowRow() { //getter to return row 
		return this.bowRow; //return row of this bow
	}

	/**
	 * Getter
	 * @return return the column of this bow
	 */
	public int getBowColumn() {  //getter to return column
		return this.bowColumn; //return column of bow
	}

	/**
	 * Getter
	 * 
	 * @return whether or not the ship is horizontal
	 */
	public boolean isHorizontal() {
		return this.horizontal; //return whether or not ship is horizontal 
	}

	// Setters
	/**
	 * Setter
	 * 
	 * @param set the parameter of the bow by setting the row
	 */
	public void setBowRow(int row) {
		bowRow = row;
	}

	/**
	 * Setter
	 * 
	 * @param column set the column of the bow
	 */
	public void setBowColumn(int column) { //set bow column
		bowColumn = column; //set bow column
	}

	/**
	 * Setter
	 * 
	 * @param horizontal set the horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;  //set ship to horizontal
	}

	/**
	 * Ship type, as determined in extended classes
	 * 
	 * @return the type of ship as a string
	 */
	abstract String getShipType(); //abstract class to set type of ship

	/**
	 * 
	 * input the ships length, bow and orientation ***Does not actually change
	 * either the ship or the Ocean, just says whether it is legal to do so
	 * 
	 * @param row inputed
	 * @param column inputed
	 * @param horizontal inputed
	 * @param ocean
	 * @return true is its okay to put ship of this length with this bow in this location with given orientation
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if ((row < 0 || row > 9) && (column < 0 || column > 9)) { // check if ship being placed outside board itself 
			System.out.println("Dimensions our of bounds. Please input correct dimensions");
		}
		int height = 0;
		if (horizontal == true) { //for horizontal placed ships, we will focus on particular columns since row is the same 
			for (int y = column; y <= (column + this.length - 1); y++) { //check if part of ship is moving outside bound of ocean 
				if ((column + this.length - 1 > 9) || (column + this.length - 1 < 0)) {
					return false; //if so return false
				} else {
					if(ocean.getShipArray()[row][y].getShipType().equals("empty")){ //else if this part of ocean equals empty
						/*	ocean.getShipArray()[row][y-1].getShipType().equals("empty") && 
							ocean.getShipArray()[row][y+1].getShipType().equals("empty") &&
							ocean.getShipArray()[row-1][y].getShipType().equals("empty") &&
							ocean.getShipArray()[row+1][y].getShipType().equals("empty")){
						 */
						height += 1;
						System.out.println(height);
					}
				}
			}
			if (height == this.length)
				return true;
			else
				return false;
		}

		else {
			int width = 0; 
			if (horizontal == false) { //ship is to be vertically placed
				for (int x = row; x <= (row + this.length - 1); x++) { //follows same method as above but checks for vertical placed ship
					if ((row + this.length - 1 > 9) || (row + this.length - 1 < 0)) {
						return false;
					} else {

						if (ocean.getShipArray()[x][column].getShipType().equals("empty")) {
							width += 1;
							System.out.println(width);

						}
					}
				}
				if (width == this.length)
					return true;
				else
					return false;
			}
			return false;
		}

	}

	/**
	 * puts the ship in the ocean by giving values to row, column, and horizontal instance variables puts reference to the ship in each of 1 or
	 * more locations (up to 4) in the ships array in the Ocean object
	 * 
	 * @param row of where the ship is going to be placed
	 * @param column of where the ship is going to be placed
	 * @param horizontal position
	 * @param ocean
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if ((row < 0 || row > 9) && (column < 0 || column > 9)) { // check if ship is being placed anywhere outside ocean itself
			System.out.println("Dimensions our of bounds. Please input correct dimensions");
		}
		// Updating the instance variables
		this.bowRow = row;
		this.bowColumn = column;
		this.horizontal = horizontal;

		// If the ship is to be placed horizontally, an array is made in the ocean with boolean horizontal as true.
		if (this.isHorizontal() == true) {
			for (int a = row, b = column; b <= (column + this.length - 1); b++) {
				ocean.getShipArray()[a][b] = this;
			}
		}
		// If the ship is to be placed vertically, an array is made in the ocean with boolean horizontal as false.
		else {
			for (int a = row, b = column; a <= (row + this.length - 1); a++) {
				ocean.getShipArray()[a][b] = this;
			}
		}
	}

	/**
	 * if part of the ship occupies given row and column and ship hasn't been sunk mark part of ship that is hit return true otherwise return false
	 * 
	 * @param row to shoot at
	 * @param column to shoot at
	 * @return
	 */
	public boolean shootAt(int row, int column) {
		if (this.isSunk()) { // if ship has been sunk do not allow 
			System.out.println("Ship has already sunk. Try again"); 
		}
		if (this.isHorizontal() == true) { 
			for (int j = 0; j < this.getLength(); j++) {
				if (this.bowRow == row && column == j + this.bowColumn) {
					hit[j] = true;
					return true;
				}
			}
		} else {
			for (int i = 0; i < this.getLength(); i++) {
				if (this.bowColumn == column && row == i + this.bowRow) {
					hit[i] = true;
					return true;
				}
			}
		}
		System.out.println("unable to pass");
		return false;
	}

	/**
	 * return true if every part of the ship has been hit, false otherwise
	 * 
	 * @return
	 */
	public boolean isSunk() {
		for(int i = 0; i < this.getLength(); i++){
			if(!hit[i]){
				return false;
			}
		}
		return true;
	}

	/*int limit = 0;
		for (int i = 0; i < this.getLength(); i++) {
			if (!hit[i]) {
			//	limit++;
			}
			if (limit == this.hit.length) {
				System.out.println("Boom! You just sank a " + this.getShipType());
				return true;
			}

		}
		return false;
	 */

	/**
	 * return single-character String to use in the Ocean's print method This
	 * method should return "x" if the ship has been sunk, "S" if it has not
	 * been sunk
	 */
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		} else {
			return "S";
		}
	}

}
