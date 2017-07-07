package battleship;

import java.util.Random;

/**
 * Class for Ocean
 * Begin with Instance Variables, and then with methods
 *
 */
public class Ocean {
	//Instance Variables for Class Ocean
	//This contains a 10x10 array of Ships, representing the "ocean," and some methods to manipulate it.
	Ship[][] ships = new Ship [10][10]; //Used to quickly determine which ship is in any given location
	int shotsFired; //The total number of shots red by the user.
	int hitCount; //The number of times a shot hit a ship
	int shipsSunk; //The number of ships sunk (10 ships in all)
	boolean[][] newocean = new boolean[10][10]; //helper instance variable to record if specific spot has been shot at


	//The Constructor
	/**
	 *Creates an empty ocean (fills the ships array with EmptySeas)
	 *Also initializes any game variables, such as how many shots have been red.
	 */
	public Ocean(){
		for(int x=0; x < 10; x++){
			for(int y = 0; y < 10; y++){
				newocean[x][y] = false;
			}
		}
		shotsFired = 0; //initializes game variable
		hitCount = 0; //initializes game variable
		shipsSunk =0; //initializes game variable
		for(int i=0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				this.ships[i][j] = new EmptySea(); //fills ships array with EmptySeas
				this.ships[i][j].setBowRow(i); //place bowrow
				this.ships[i][j].setBowColumn(j);//place bowcolumn
			}
		}
	}


	/**
	 *Places all 10 ships randomly on the empty ocean-larger ships before smaller-import random package
	 *Place larger ships before smaller ones
	 *Use random generator, use the Random class in the java.util package,
	 *Start by randomly placing battleship
	 */
	public void placeAllShipsRandomly(){
		Random generator = new Random(); //random class generator
		Battleship battleship = new Battleship();
		Cruiser cruiser1 = new Cruiser();
		Cruiser cruiser2= new Cruiser();
		Destroyer destroyer1 = new Destroyer();
		Destroyer destroyer2 = new Destroyer();
		Destroyer destroyer3 = new Destroyer();
		Submarine submarine1 = new Submarine();
		Submarine submarine2 = new Submarine();
		Submarine submarine3 = new Submarine();
		Submarine submarine4 = new Submarine();
		int randomRow = generator.nextInt(9);
		int randomColumn = generator.nextInt(9);
		boolean isHorizontal = generator.nextBoolean();
		while (battleship.okToPlaceShipAt(randomRow, randomColumn, isHorizontal, this)==false){
			randomRow = generator.nextInt(9);
			randomColumn = generator.nextInt(9);
			isHorizontal = generator.nextBoolean();
		}
		battleship.placeShipAt(randomRow, randomColumn, isHorizontal, this);
		System.out.println("placed battleship");

		//Placing two cruisers
		Cruiser[] cruisers = new Cruiser[2];
		cruisers[0]=cruiser1;
		cruisers[1]=cruiser2;
		for(int i =0; i < 2; i ++){
			randomRow = generator.nextInt(9);
			randomColumn = generator.nextInt(9);
			isHorizontal = generator.nextBoolean();
			System.out.println(randomRow);
			System.out.println(randomColumn);
			System.out.println(isHorizontal);
			while (cruisers[i].okToPlaceShipAt(randomRow, randomColumn, isHorizontal, this)==false){
				randomRow = generator.nextInt(9);
				randomColumn = generator.nextInt(9);
				isHorizontal = generator.nextBoolean();
			}
			System.out.println("making ships");
			cruisers[i].placeShipAt(randomRow, randomColumn, isHorizontal, this);
		}
		System.out.println("placed cruisers");

		Destroyer[] destroyers = new Destroyer[3];
		destroyers[0]=destroyer1;
		destroyers[1]=destroyer2;
		destroyers[2]=destroyer3;
		for(int i =0; i < 3; i ++){
			randomRow = generator.nextInt(9);
			randomColumn = generator.nextInt(9);
			isHorizontal = generator.nextBoolean();
			while (destroyers[i].okToPlaceShipAt(randomRow, randomColumn, isHorizontal, this)==false){
				randomRow = generator.nextInt(9);
				randomColumn = generator.nextInt(9);
				isHorizontal = generator.nextBoolean();
			}
			destroyers[i].placeShipAt(randomRow, randomColumn, isHorizontal, this);
		}
		System.out.println("placed destroyers");

		Submarine[] submarines = new Submarine[4];
		submarines[0]=submarine1;
		submarines[1]=submarine2;
		submarines[2]=submarine3;
		submarines[3]=submarine4;
		for(int i =0; i < 4; i ++){
			randomRow = generator.nextInt(9);
			randomColumn = generator.nextInt(9);
			isHorizontal = generator.nextBoolean();
			while (submarines[i].okToPlaceShipAt(randomRow, randomColumn, isHorizontal, this)==false){
				randomRow = generator.nextInt(9);
				randomColumn = generator.nextInt(9);
				isHorizontal = generator.nextBoolean();
			}
			submarines[i].placeShipAt(randomRow, randomColumn, isHorizontal, this);
		}
		System.out.println("placed all ships");
	}

	/**
	 * @param row
	 * @param column
	 * @return true if a given location contains a ship, false if it doesn't
	 * 
	 */
	public boolean isOccupied(int row, int column){
		//If position is occupied by ship return true and false if not
		if(this.ships[row][column].getShipType().equals("empty")){
			return false;
		}
		else{
			return true;
		}
	}


	/**
	 * 
	 * @param row
	 * @param column
	 * @return true if given location contains a "real" ship still afloat (not empty sea)
	 * false if it doesn't
	 * this method updates the number of shots that have been fired, and the number of hits
	 * If a location contains a "real" ship, shootAt should return true every time the user shoots at that same location.
	 * Once a ship has been "sunk", additional shots at its location should return false.
	 */
	public boolean shootAt(int row, int column){
		//if position is occupied by ship, after ship sinks, updates variables
		//if(this.ships.)
		this.shotsFired++;
		newocean[row][column] = true;
		if(this.ships[row][column].getShipType().equals("empty")){
			this.ships[row][column].shootAt(row, column);
			return false;
		}
		else{
			this.hitCount++;
			this.ships[row][column].shootAt(row, column);
			if (this.ships[row][column].isSunk()){
				//this.ships[row][column] = new EmptySea();
			}
			return true;			
		}
	}

	/**
	 * 
	 * @return the number of shots red (in this game).
	 */
	public int getShotsFired(){
		return this.shotsFired;
	}

	/**
	 * 
	 * @return the number of hits recorded
	 * All hits are counted,not just the first time a given square is hit
	 */
	public int getHitCount(){
		return this.hitCount;
	}


	/**
	 * @return number of ships sunk (in this game)
	 */
	public int getShipsSunk(){
		return shipsSunk;	
	}

	/**
	 * 
	 * @return true if all ships have been sunk, otherwise false
	 */
	public boolean isGameOver(){
		if(this.shipsSunk ==10){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * 
	 * @return the 10x10 array of ships
	 */
	public Ship[][] getShipArray(){
		return this.ships;
	}

	/**
	 * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array
	 * Column numbers should be displayed along the top
	 * Numbers should be 0 to 9
	 */
	void print() {
		String[][] disp = new String[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(newocean[i][j]){
					disp[i][j] = ships[i][j].toString();
				}
				else{
					disp[i][j]=".";
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(disp[i][j]);
			}
			System.out.print("\n");
		}
	}


}