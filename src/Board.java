
/**
 * COMP249
 * Assignment # 1
 */

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * This class creates the game board;
 * it contains  methods: movePlayer, setSnakes, setLadders and toString;
 * 
 * The movePlayer change the position for each player according to the dice value;
 * by calling the methods setSnakes and setLadders it checks if the new position has a snake or ladder set;
 * after each new position, the movePlayer method check if a player has won.
 *
 */
public class Board {
	
	// size of the board row and columns + numbers of snakes and ladders 
	private final int ROWS = 10;
	private final int COLS = 10;
	private final int NUM_SNAKES = 8;
	private final int NUM_LADDERS = 8;
	
	// Board variables
	private int[][] gameBoard;
	private int[][] snakes; //variable used in setSnake method
	private int[][] ladders; //variable used in setLadder method
	
	
	Map<Player, Integer> playerPositions; //Map of player positions, @key Player, @value playerPositions 
	
	/**
	 * the constructor method initialize the board object (int[][]);
	 * set the starting put zero for all players;
	 * initialize the game board of size {ROWSXCOLS};
	 * calls the method to set the snakes and ladders (int[][])
	 * 
	 * @param players list 
	 */
	public Board(List<Player> players) {
		
		this.playerPositions = new HashMap<Player, Integer>(); //initialize the board object
		
		for (Player player : players){
			this.playerPositions.put(player, 0); //set the starting put zero for all players
		}
		
		gameBoard = new int[ROWS][COLS]; //initialize the game board of size ROWSXCOLS
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				gameBoard[row][col] = row*ROWS + col +1;
			}
		}
		setSnakes(); 
		setLadders();
	}
	
	/**
	 * Moves the current player based on the given dice value; 
	 * 
	 * @param player is the current player that is expected to move;
	 * @param value is the result of dice rolling, and the amount that the player go forward on the board;
	 * 
	 * update the position of players by the new passed dice value ;
	 * check if the new position =100 to return true and game ends; 
	 * check if player new position is where snakes or ladders are set, the position will be updated accordingly;
	 * if the position is > 100, the player moves backward with the excessive amount;
	 * 
	 * @return false unless one player reaches the position 100
	 */
	public boolean movePlayer(Player player, int value) {
		
		int position = playerPositions.get(player); //get the position for each player
		position = position + value; //update the position by the new dice value
		
		//Position = 100
		if (position == 100) { 
			playerPositions.put(player, 100); //add the new position
			System.out.println(player +" is now at " + position + "\n");
			return true;
		}
		
		//position = 80 = 100
		else if(position == 80) {
				playerPositions.put(player, 100); //add the new position
				System.out.println("Yay! "+ player + " took ladder from 80 to 100.\n");
				return true;
		
		//Position > 100
		}else if( position > 100 ) {
			System.out.println(player + " went out of the board and came back!");
			position = 200 - position; //100 - (position - 100)
			playerPositions.put(player, position);
			
			for (int i = 0; i < NUM_SNAKES; i++) { //check for snakes
				if(snakes[i][0] == position) { 
					position = snakes[i][1]; 
					playerPositions.put(player, position); //add the new position
					System.out.println("Oops! " + "Snake took " + player + " from " + snakes[i][0] + " to " + snakes[i][1] + "\n");
					return false;
				}
			}
			
			for (int i = 0; i < NUM_LADDERS; i++) { // check for ladders
				if(ladders[i][0] == position) {
					position = ladders[i][1];
					playerPositions.put(player, position); //add the new position
					System.out.println("Yay! "+ player + " took ladder from " + ladders[i][0] + " to " + ladders[i][1]+ "\n");
					return false; 
				}
			}
			playerPositions.put(player, position); // add the new position
			System.out.println(player +" is now at " + position + "\n");
			return false;

			
		}else {
			
			for (int i = 0; i < NUM_SNAKES; i++) {//check for snakes
				if(snakes[i][0] == position) {
					position = snakes[i][1];
					playerPositions.put(player, position); //add the new position
					System.out.println("Oops! " + "Snake took " + player + " from " + snakes[i][0] + " to " + snakes[i][1] + "\n");
					return false;
				}
			}
			
			for (int i = 0; i < NUM_LADDERS; i++) {//check for ladders
				if(ladders[i][0] == position) {
					position = ladders[i][1];
					playerPositions.put(player, position); //add the new position
					System.out.println("Yay! "+ player + " took ladder from " + ladders[i][0] + " to " + ladders[i][1]+ "\n");
					return false; 
				}
			}
			
			playerPositions.put(player, position);  //add the new position
			System.out.println(player +" is now at " + position + "\n");
			return false;
		}
	}
	
	/**
	 * Set the position of snakes on the board
	 * the position snakes[][0] is the starting point and the snakes[][1] is the end point 
	 */
	private void setSnakes() {
		
		snakes = new int[NUM_SNAKES][2];
		
		snakes[0][0] = 16; 
		snakes[0][1] = 6;
		snakes[1][0] = 48;
		snakes[1][1] = 30;
		snakes[2][0] = 64;
		snakes[2][1] = 60;
		snakes[3][0] = 79;
		snakes[3][1] = 19;
		snakes[4][0] = 86;
		snakes[4][1] = 24;
		snakes[5][0] = 93;
		snakes[5][1] = 68;
		snakes[6][0] = 97;
		snakes[6][1] = 76;
		snakes[7][0] = 98;
		snakes[7][1] = 78;
	}
	
	/**
	 * Set the position of Ladders on the board;
	 * the position Ladders[][0] is the starting point and the Ladders[][1] is the end point for each ladder
	 */
	private void setLadders() {
		
		ladders = new int[NUM_LADDERS][2];
		
		ladders[0][0] = 3;
		ladders[0][1] = 38;
		ladders[1][0] = 4;
		ladders[1][1] = 14;
		ladders[2][0] = 9;
		ladders[2][1] = 31;
		ladders[3][0] = 21;
		ladders[3][1] = 42;
		ladders[4][0] = 28;
		ladders[4][1] = 84;
		ladders[5][0] = 36;
		ladders[5][1] = 44;
		ladders[6][0] = 51;
		ladders[6][1] = 67;
		ladders[7][0] = 71;
		ladders[7][1] = 91;
		//ladders[8][0] = 80;
		//ladders[8][1] = 100;
	}
	
	
	/**
	 * Overridden toString method to print the board;
	 * {The board (from top to bottom) starts from 100 to 1 and in every other row numbers switched direction from right to left and vice versa;
	 * if at least one player has occupied a position, the board will reflect their name, not the position number, otherwise the block number  
	 * 
	 */
	
public String toString() {
		
		String blocks = new String(); // initialize the StringBuilder object
		boolean oddRow = true; // to detect the odd and even rows 
		
		for (int row = ROWS-1 ; row >= 0 ; row--) { //starts from 100 to 1 
			for ( int col = 0 ; col < COLS ; col++) {
				
				if (oddRow) { //for odd rows reflecting 11-20, 31-40, 51-60, ... , 91-100 
					String space = ""; 
					boolean occupied = false;
					for (Player tempPlayer : playerPositions.keySet()) { // check each players position
						if ( playerPositions.get(tempPlayer) == gameBoard[row][COLS-1-col]) { // if a player has occupied a position
							occupied = true; //update the occupied flag
							space = space + tempPlayer + " "; //update the variable space with the players name, instead of the block number
						}
					}
					
					if (occupied) { //if a player has occupied a position,
						space = space + "\t"; //adds tab to the players name to be readable
						blocks = blocks + space; // set the block to print the player name (space is updated with players name) {can be more than one}
					} else {
						blocks = blocks + gameBoard[row][COLS-1-col] + "\t"; // if no players in the position, print the block number
					} 
					
				}else { // for even rows reflecting 1-10, 21-30, 41-50, ... , 81-90
						
						boolean occupied = false;
						String space = "";
						for (Player tempPlayer : playerPositions.keySet()) { // check each players position
							if (playerPositions.get(tempPlayer) == gameBoard[row][col]) { // if a player has occupied a position
								occupied = true; //update the occupied flag
								space = space + (tempPlayer + " ");//update the space with the players name
							}
						}
						if (occupied) { //if a player has occupied a position,
							space += "\t";
							blocks = blocks + space; // set the block to print the player name (space is updated with players name) {can be more than one}
						} else {
							blocks = blocks + gameBoard[row][col]+ "\t"; // if no players in the position, print the block number
						}
					}
				}
				oddRow = !oddRow; // update the row flag
				blocks = blocks + "\n"; //go to the next line
			}
		blocks = blocks + "\n";
		return blocks.toString(); //print the 
	}
}
