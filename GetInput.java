/*
getChoice gathers an S or E from User with verification built in. 
getGuess gathers a char array that is only 4 long and RGBYWO
 */
package mastermind2;

import java.util.Scanner;

public class GetInput 
{
    public static char getChoice()
    {
        //scan entry and store in 'selection' 
        Scanner sc = new Scanner(System.in);
        char selection = sc.next().charAt(0);
        
        //loop until User enters S or E
        while(selection != 'S' && selection != 'E')
        {
            System.out.print("That was not a valid choice. Enter 'S' or 'E': ");
            selection = sc.next().charAt(0);
        }
        
        //return once S or E
        
        return selection;
    }
    
    public static char[] getGuess()
    {
        
        Scanner sc = new Scanner(System.in);
        char[] userGuess = sc.next().toCharArray();
        boolean validColors = false;
        boolean correctLength = false;
        
        //loop until a valid guess is entered
        while(validColors == false || correctLength == false)
        {
            //check for valid color symbols 
            validColors = true;
            for(char c : userGuess)
            {
                if (c != 'R')
                    if (c != 'B')
                        if (c != 'G')
                            if (c != 'W')
                                if (c != 'Y')
                                    if (c != 'O')
                                    {
                                        validColors = false;
                                        break;
                                    }
            }
            
            //check for correct length
            correctLength = false;
            if (userGuess.length == 4)
            {
                correctLength = true;
            }
            
            //if guess is not valid, ask again and get another guess
            if (correctLength == false || validColors == false)
            {
                System.out.println("Your guess is an incorrect length or uses an invalid symbol."
                        + "\nGuess: ");
                userGuess = sc.next().toCharArray();            
            }
        }
        
        
        return userGuess;
    }
    
    public static char[] generateTarget()
    {
    	//method generates a random sequence of valid colors and returns as a char[]
    	char[] computersChoice = new char[] {' ', ' ', ' ', ' '};
    	
    	for(int i = 0 ; i < 4; i++)
    	{
    		int randomNum = (int)(Math.random() * 6) + 1;    		
    		
    		switch (randomNum) 
    		{
    			case (1):
    				computersChoice[i] = 'R';
    				break;
    			case (2):
    				computersChoice[i] = 'G';
					break;
    			case (3):
    				computersChoice[i] = 'B';
				 	break;
    			case (4):
    				computersChoice[i] = 'W';
					break;
    			case (5):
    				computersChoice[i] = 'Y';
					break;
    			case (6):
    				computersChoice[i] = 'O';
					break;    			
    		}
    	}    	
    	return computersChoice;    	
    }
}
