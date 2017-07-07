package battleship;

public class Destroyer extends Ship{

	//Constructor
	/**
	 * This class Destroyer extends Ship
	 * It uses Ship as the parent class 
	 * Describes a ship of length 2
	 * Purpose of constructor is to set the inherited length variable to the correct value and initialize the hit array
	 */
	public Destroyer(){
		super(); //inherits all constructor method from parent class
		this.length = 2;
		this.hit= new boolean []{false, false, false, false}; //inherit same array of boolean telling what part of ship has been hit

	}
	/**
	 * 
	 * Must override this method
	 * Returns the appropriate string type of "Destroyer"
	 */
	@Override 
	public String getShipType(){ //get string type of ship 
		return "Destroyer"; //return string type as destroyer
	}



}
