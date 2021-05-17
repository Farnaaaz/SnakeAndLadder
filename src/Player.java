
/**
 * COMP249
 * Assignment # 1
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
