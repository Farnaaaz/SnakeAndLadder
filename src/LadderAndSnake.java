/
/**
 * COMP249
 * Assignment # 1
 */
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LadderAndSnake {
	
	//declare the variables 
	private Scanner keyboard; 
	private String choice; //for the user input to roll the toss
	
	/**
	 * main class to test the class;
	 * declare the run object; 
	 * call the play method to start the game.
	 */
	public static void main(String[] args) {
		
		LadderAndSnake run = new LadderAndSnake(); // Initialize the game object of class LadderAndSnake
	       run.play();  // call the play method to start the game
	   }
		
	/**
	 * start the game;
	 * prompt the user for the number of players, and check if the number of players are between 2 and 4;
	 * 
	 * initialize the player object;
	 * given the number of players, the for loop creates a new player, give it a name and add it to the a list called players;
	 * 
	 * calls the method that decide the order in which players will roll the dice;
	 * 
	 * Initialize the board, and pass the created players List;
	 * 
	 * prompt the user to press R when they are ready for rolling, call the turnToPlay method for each player;
	 * until one player reaches the position=100 (check by calling the method that returns true/false)
	 */
	 private void play() {
		System.out.println("\t" + "Hi! Let’s play LADDERS and SNAKES!\n"); 
		
		keyboard = new Scanner(System.in); 
		
		int numPlayers = 0;
		
//		while (numPlayers <= 1  || numPlayers >= 5) {
//	    	 System.out.print("Please enter the number of players(between 2 and 4): "); //prompt the user to enter the number of players
//	    	 numPlayers = keyboard.nextInt();
//	    	 if (numPlayers < 2) 											   //if the input is less than 2								
//                 System.out.print("Number of players should be at least 2. "); //print the error message
//             else if (numPlayers > 4)										   //if the input is more than 4
//                 System.out.print("Number of players cannot be more than 4. ");//print the error message
//	     }
		 
		System.out.print("Please enter the number of players(between 2 and 4): "); //prompt the user to enter the number of players
		numPlayers = keyboard.nextInt(); 
		
		int attempts= 1;
		while(attempts <= 4){
			
			if(attempts == 4 && !(numPlayers >=2 && numPlayers <=4)){ // check if the input for the condition
				System.out.println("Bad Attempt " + attempts + " - You have exhausted all your chances. Program will terminate");
				System.exit(0);
			}
			
			else if(!(numPlayers >=2 && numPlayers <=4)){ 	// check the input for the condition
				System.out.print("Bad Attempt " + attempts + " - Invalid number of players."); // print the message and take another input from the user

				System.out.print(" Please enter the number of players(between 2 and 4): ");
				numPlayers = keyboard.nextInt(); //read the next input
			}else{
				break; // break the loop if input is correct 
			}
			attempts += 1;

		}
		
		
		 List<Player> players = new ArrayList<Player>(); //Initialize the players object 
		 
		  for(int index = 0 ; index < numPlayers ; index++) { //given the number of players
			 Player player = new Player("P.No" + (index+1)); //initialize players and give each player a name e.g. P.No.1
			 players.add(player); //add it to the "players" List
		 }
		 
		  
		 System.out.println("\nLet's decide in what order players will play: "); 
	     Map<Integer, Player> order = new HashMap<>(); //keeps the dice value for each player and the palyer's name
	     
	     playersInOrder(players, order); //call the method to decide the order for players to play
	     System.out.print("\nThe new order of playing is:");
	     for(Player player: players) { //for players in the player list
	      System.out.print( player.getName() + ", "); //print their name 
	     }
		 
	     
		Board board = new Board(players); //Initialize the board, and pass the created players List  
		 
		
		 boolean done = false; 
		 do{ // keep rolling until a player reaches position 100
			 
			System.out.println("\nPress \"R\" to roll the dice for the next round, press \"Q\" to quit the game: ");//prompt the user to press R when they are ready for rolling
			choice = keyboard.next();
			 
			if(choice.equalsIgnoreCase("R")){ //check if the user want to ROLL
				
				for(Player player: players){ //for any player in the players list
					 Player currentPlayer = player;
					 //System.out.print("\t" +currentPlayer + "\t");
					 int roll = currentPlayer.turnToPlay(); //call the method to flip the dice and print its value
						 
					 done = board.movePlayer(currentPlayer, roll); //check if the flag "done" is true by calling the method that returns true when position=100
						 
//				     System.out.println(board); // print the board after each players turn
//				     System.out.println("------------------------------------------------------------------------------------\n");
//			
				    	 
					 if(done) {
					   System.out.println("\n*********************** Congratulations! " + currentPlayer + " won! ************************\n\n");
					   break; // break when a player reaches position 100
					 }
				}
				
				System.out.println(board); // print the board after each players turn
			    System.out.println("------------------------------------------------------------------------------------\n");
			}
			else if(choice.equalsIgnoreCase("Q")){
				System.out.println("You quit the game!");
				break;
			}
			
			else {
			    System.out.println("The input is not valid\n");
			}
			
		 } while(!done);
		 
		 System.out.println("************************* Thanks You! ***************************");
	 }
	 
	 /**
	  * this method roll the dice by calling the Random method
	  * @return dice value (int)
	  */
	 public int flipDice() {
	        Random random = new Random(); 
	        int dice = random.nextInt(6)+1; // return number between 1 and 6
	        return dice;
		}
	 
	/**
	 * this method specifies the order in which players will roll the dice;
	 * it starts with calling the firstRoundTossing method that roll the toss for each players in the player list;
	 * at each steps it checks if a tie is achieved, if so it re-rolls, until there is no ties between the dice values;
	 * 
	 * 
	 * @param players: list of players
	 * @param playerRoll: Map containing players and the rolled dice 
	 */
	 public void playersInOrder(List<Player> playerList, Map<Integer, Player> playerRoll){
		 
	      for(Player player: playerList){

	         int roll = firstRoundTossing(player);	//calls the method          
	         while (playerRoll.containsKey(roll)){  //check a tie is achieved
	        	 
	        	Player otherPlayer = playerRoll.get(roll);
	            System.out.println("\nA tie was achieved between " + otherPlayer.getName() + " and " + player.getName() + ". Re-rolling for " + player.getName()  + ": ");
	            
		         roll = firstRoundTossing(player);	// repeat the first roll for the player with the repetitive roll          
	         }
	         
	        playerRoll.put(roll, player); //adds the players and their dice value to the playerRoll Map
	      }
	      //System.out.println(playerRoll.keySet());
     
	      playerList.clear(); //clear the list to be filled in new order
	      
	      TreeMap<Integer,Player > OrderedMap = new TreeMap<>(playerRoll); //The map is sorted according to the natural ordering of its keys
	      for (int key : OrderedMap.keySet()) { //for all the key
		      playerList.add(playerRoll.get(key)); //add their value to the players list
	      }
	      
	     reverse(playerList); //call the reverse method to change the order of the list
	      
	   }
	 
	 /**
	  * This method reverse the order in the players list output of the treeMap;
	  * removes the element from the last index in the list and adds it to the ith index
	  * 
	  * @param players list (ascending order of rolls)
	  * @return players ordered (descending order of rolls)
	  */
	 public List<Player> reverse(List<Player> playerList) {

		 int numPlayer = playerList.size()- 1;
	      for(int i = 0 ; i < numPlayer ; i++) { 
	    	 playerList.add(i, playerList.remove(numPlayer)); //take the element at the last index in the list and adds it to the ith index 
	      }
		 return playerList; 
	 }
	 
	 /**
	  * this method roll the the toss for the first round to assign the players' order accordingly
	  * @param player 
	  * @return
	  */
	 public int firstRoundTossing(Player player){
	      int roll = flipDice();
	      System.out.println( player.getName() + " got a dice value of " + roll);

	      return roll;
	   } 
	 
}


