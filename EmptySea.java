package battleship;

public class EmptySea extends Ship{

	//This class EmptySea is a type of ship because the Ocean contains a Ship array, every location of which is or can be a reference to some Ship	 * 
	
	//Constructor
	/**
	 * Sets the inherited length variable to 1
	 */
	public EmptySea(){
		super(); //inherits all constructor method from parent class
		this.length = 1; //set length to 1
		this.hit= new boolean []{false, false, false, false}; //inherit same array of boolean telling what part of ship has been hit
	}
	
	/**
	 * This method overrides shootAt(int row, int column) that is inherited from Ship
	 * It always returns false to indicate that nothing was hit
	 */
	@Override
	public boolean shootAt(int row, int column){ //boolean method overrides method inherited from ship
		this.hit[0]=true; //if part 1 was hit, we append to true 
		System.out.println("You hit an empty sea");
		return false; //always returns false to indicate that nothing was hit
	}
	
	/**
	 * This method overrides isSunk() that is inherited from Ship
	 * Always returns false to indicate that you didn't sink anything
	 */
	@Override
	public boolean isSunk(){ //boolean method overrides method inherited from ship
		return false; //always returns false to indicate that you didn't sink anything
	}
	
	/**
	 * Returns a single-character String to use in the Ocean's print method
	 * '-' to indicate a location that you have fired upon and found nothing there
	 * '.' (a period) to indicate a location that you have never fired upon
	 */
	@Override
	public String toString(){ 
		if (this.hit[0]){ //if you're shoot at element 1 returns true, then return - to indicate location that you have fired upon and found nothing there
			return "-";	//since this is Empty Sea we know that we have found nothing there, but we have still fired upon it 
		}
		else{
			return "."; //if we have not fired upon it, then return a period since we have never fired upon it
		}	
	}
	
	/**
	 * This method just returns the string "empty"
	 */
	@Override
	public String getShipType(){ //method to return string empty
		return "empty"; //return string empty
	}
	
}
