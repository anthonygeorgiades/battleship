package battleship;

public class Submarine extends Ship{

	//Constructor
	/**
	 * This class Battleship extends Ship
	 * It uses Ship as the parent class 
	 * Describes a ship of length 1
	 * Purpose of constructor is to set the inherited length variable to the correct value and initialize the hit array
	 */
	public Submarine(){
		super(); //inherits all constructor method from parent class
		this.length = 1;
		this.hit= new boolean []{false, false, false, false}; //inherit same array of boolean telling what part of ship has been hit
		
	}
		
	/**
	 * Must override this method
	 * Returns the appropriate string type of "Submarine"
	 */
	@Override
	public String getShipType(){
		return "Submarine";
	}
	
	
}


