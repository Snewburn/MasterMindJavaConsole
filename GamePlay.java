/*
GamePlay contains methods for running a single Game 
 */
package mastermind2;


public class GamePlay 
{
    //aGame is the basic loop for a single game 
    public static boolean aGame(char[] targetSequence)
    {
    	//return win [false] after ten guesses or [true] a winning guess. 
        boolean win = false;
        int gameCount = 0;	//tracks guess number
        
        //New Game starting
        System.out.println("\nGAME STARTING\nEnter Four Colors (R, G, B, Y, W, O)\n");
        
        //game loop drops out with a win or after ten guesses
        while (win == false && gameCount < 10)
        {
            //get user input
            System.out.print("Guess " + (gameCount + 1) +": ");
            char[] userGuess = GetInput.getGuess();
            
            //compare to target sequence and get peg grade            
            int[] pegs = gradeGuess(userGuess, targetSequence);
                        
            //print grade pegs
            System.out.print("R: " + pegs[0] + " W: " + pegs[1] + "\n\n");
            
            //check for win
            if (pegs[0] == 4)
            {
            	win = true;
            	break;
            }
            
            //increment gameCount
            gameCount++;
        }
        return win;     
    }
    
    //gradeGuess compares the target and the guess and 
    // returns a peg array [0]Red pegs, [1]White pegs 
    public static int[] gradeGuess(char[] userGuess, char[] targetSequence)
    {
       int[] pegs = new int[] {0, 0};	//array to return
       
       //these arrays track if a symbol has been matched.        
       char[] playerSymbolMatched = new char[] {' ', ' ', ' ', ' '};      
       char[] targetSymbolMatched = new char[] {' ', ' ', ' ', ' '};	
       
       //First look for red pegs - compare each player guess with corresponding target
       for(int i = 0; i < 4; i++)
       {
    	   //if a match is found: mark each match array with 'M' and increment the red peg count (pegs[0]) 
    	   if (userGuess[i] == targetSequence[i])
    	   {
    		   playerSymbolMatched[i] = 'M';
    		   targetSymbolMatched[i] = 'M';
    		   pegs[0]++;
    	   }
       }               
       
       //Look for white pegs
       //compare each guess symbol with each target symbol
       for(int i = 0; i < 4; i++)	//outer loop iterates through player symbols
       {
    	   for (int j = 0; j < 4; j++)	//inner loop iterates through target symbols
    	   {
    		   //if symbol has been matched already, do nothing    		   
    		   boolean symbolTakenCondition = false;
    		       		   
    		   if (playerSymbolMatched[i] == 'M' || targetSymbolMatched[j] == 'M')
    		   {
    			   symbolTakenCondition = true;
    		   }
    		   
    		   //if there is a match and symbol has not bee taken,
    		   //increment white pegs and mark both symbols as matched.  
    		   if (userGuess[i] == targetSequence[j] && symbolTakenCondition == false) //player symbol matches a target symbol
    		   {    			  
    			   pegs[1]++;
    			   playerSymbolMatched[i] = 'M';
    			   targetSymbolMatched[j] = 'M';    			   
    		   }    		   
    	   }
       }       
       
       return pegs;
    }
    
}
