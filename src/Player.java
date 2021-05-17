//***********************************************************************************************************************************
//Assignment 1
// Question: Ladders and Snakes game: 
// 
// This program includes one driver class and 2 classes (Board and Player) to simulate the Ladders&Snakes game between 2 to 4 players
// The Driver class start the program by running the play method that first asks for users input for the number of players, it checks if the numbers are between 2 and 4
// Then accordingly creates the list of players. the first round of dice tossing verifies the order of playing among players. 
// The user will be prompted to press R for each round of dice rolling. At each round, players will take turn by moving on the board based on the the rolled dice, 
// After any move, the method movePlayer checks if they faced ladders and snakes, if so the new position will be defined.
// If a if the position is > 100, the player moves backward with the excessive amount. After each round board with new positions of players will be printed
// This will continue until a player reaches position 100.
//
// Written by: Farnaz Zaveh, ID: 40032389
// For COMP 249-S - Winter 2021  
//************************************************************************************************************************************

/**
 * Name and ID: Farnaz Zaveh - 40032389
 * COMP249
 * Assignment # 1
 * Due Date Feb 8th, 2021
 */

import java.util.Random;

/**
 * The player class has a name (String) attribute; 
 * it has a constructor method, an accessor method and methods: turnToPlay, flipDice and toString;
 * 
 * this class take turn for each players and can get their name 
 * 
 */
public class Player {
	
	public String name;
	
	/**
	 * The constructor method for the Player class
	 * @param name (String)
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * the accessor method for the Player class
	 * @return player's name (String)
	 */
	public String getName(){
        return name;
     }
	
	
	/**
	 * this method plays each players' turn by rolling the dice for the player and print its value
	 * @return roll (dice value) 
	 */
	public int turnToPlay() {
		int roll = rollDice();
   	 	System.out.println(name + " got dice value of " + roll + ".");
   	 	return roll;
	}
	
	/**
	 * this method roll the dice by calling the Random method
	 * @return dice value (int)
	 */
	public int rollDice() {
        Random random = new Random();
        int dice = random.nextInt(6)+1;
        return dice;
	}
	
	/**
	 * overridden toString 
	 * @return the name of players
	 */
	public String toString() {
		return name;
	}

}
