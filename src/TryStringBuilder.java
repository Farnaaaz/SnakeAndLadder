import java.lang.StringBuilder;

public class TryStringBuilder {
    public static void main(String[] args) {

//        // Part 1: create a new StringBuilder.
//        StringBuilder builder = new StringBuilder();
//        // ... Loop and append values.
//        for (int i = 0; i < 10; i++) {
//            builder.append(i).append(" ");
//        }
//
//        // Part 2: convert to string.
//        String result = builder.toString();
//        // ... Print result.
//        System.out.println(result);
    	
    	int[][] gameBoard = new int[10][10]; //initialize the game board of size ROWSXCOLS
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				gameBoard[row][col] = row*10 + col +1;
				System.out.print(gameBoard);

			}
			
			System.out.println();
		}
    }
    
//	public String toString() {
//	
//	StringBuilder blocks = new StringBuilder(); //initialize the StringBuilder object
//	boolean oddRow = true; // 
//	
//	//
//	//
//	//
//	
//	for (int row = ROWS-1 ; row >= 0 ; row--) { 
//		for ( int col = 0 ; col < COLS ; col++) {
//			
//			if (oddRow) {
//				
//				String playerLocation = "";
//				boolean occupied = false;
//				for (Player tempPosition : playerPositions.keySet()) {
//					if ( playerPositions.get(tempPosition) == gameBoard[row][COLS-1-col]) {
//						
//						occupied = true;
//						playerLocation += tempPosition + " ";
//					}
//				}
//				
//				if (occupied) {
//					
//					playerLocation += "\t";
//					blocks.append(playerLocation);
//					
//				} else {
//					
//					blocks.append(gameBoard[row][COLS-1-col] + "\t");
//				} 
//				
//			}else { //even rows
//					
//					boolean occupied = false;
//					String playerLocation = "";
//					for (Player tempPosition : playerPositions.keySet()) {
//						if (playerPositions.get(tempPosition) == gameBoard[row][col]) {
//							
//							occupied = true;
//							playerLocation += (tempPosition + " ");
//						}
//					}
//					
//					if (occupied) {
//						
//						playerLocation += "\t";
//						blocks.append(playerLocation);
//					} else {
//						
//						blocks.append(gameBoard[row][col]+ "\t");
//					}
//				}
//			}
//			
//			oddRow = !oddRow;
//			blocks.append("\n");
//		}
//		
//	blocks.append("\n");
//		
//		return blocks.toString();
//}
    
}