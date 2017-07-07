package battleship;

public class Cruiser extends Ship{

	//Constructor
	/**
	 * This class Cruiser extends Ship
	 * It uses Ship as the parent class 
	 * Describes a ship of length 3
	 * Purpose of constructor is to set the inherited length variable to the correct value and initialize the hit array
	 */
	public Cruiser(){
		super(); //inherits all constructor method from parent class
		this.length = 3; //set length of ship to 3
		this.hit= new boolean []{false, false, false, false}; //inherit same array of boolean telling what part of ship has been hit

	}

	/**
	 * Must override this method
	 * Returns the appropriate string type of "Cruiser"
	 */
	@Override
	public String getShipType(){ //get string type of ship 
		return "Cruiser"; //return string type as cruiser
	}
}
