package battleship;

public class Battleship extends Ship {

	//Constructor
	/**
	 * This class Battleship extends Ship
	 * It uses Ship as the parent class 
	 * Describes a ship of length 4
	 * Purpose of constructor is to set the inherited length variable to the correct value and initialize the hit array
	 */
	public Battleship(){
		super(); //inherits all constructor method from parent class
		this.length = 4; //set length to 4
		this.hit= new boolean []{false, false, false, false}; //inherit same array of boolean telling what part of ship has been hit

	}

	/**
	 * Must override this method
	 * Returns the appropriate string type of "Battleship"
	 */
	@Override
	public String getShipType(){ //get type of ship
		return "Battleship"; //return ship type as string
	}



}
