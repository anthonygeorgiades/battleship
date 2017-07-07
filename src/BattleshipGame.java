package battleship;

import java.util.*;

public class BattleshipGame {
	//This is the "main" class, containing the main method and an instance variable of type Ocean
	Ocean ocean = new Ocean();
	public static Scanner s;
	
		public static void main(String[] args){
				s = new Scanner(System.in);
				System.out.println("Let's start playing battleship!");
				Ocean ocean = new Ocean();
				ocean.placeAllShipsRandomly();
				Scanner reader = new Scanner(System.in);
				int shipsSunk = 0;
				while(shipsSunk != 10){
				ocean.print();
				System.out.print("Enter a row number: ");
				int row1 = reader.nextInt();
				System.out.print("Enter a column number: ");
				int column1 = reader.nextInt();
				if (ocean.shootAt(row1, column1)==true){
					System.out.println("You hit a ship!");
					//System.out.println(ocean.getShipArray()[row1][column1].isSunk());
					if (ocean.getShipArray()[row1][column1].isSunk()==true){	
						shipsSunk++;
						System.out.println("You just sank a " + ocean.getShipArray()[row1][column1].getShipType());
						System.out.println("Number of ships sunk is " + shipsSunk);
						if (shipsSunk==10){
							ocean.isGameOver();
							System.out.println("Your score is" + ocean.getShotsFired());
						}
					}			
				}
				else{
					System.out.println("You missed!....Try again.");{
						
					}
				}
			}	
		}
}


 