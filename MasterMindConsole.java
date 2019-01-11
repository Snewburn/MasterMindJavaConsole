/*
 Program is a simulation of the game "master mind"
Spencer Newburn - January 7th, 2019
 */


package mastermind2;


public class MasterMindConsole 
{

    public static void main(String[] args) 
    {
        //Welcome message and collect first choice
        System.out.print("Welcome to Master Mind\nEnter 'S' to start a new game"
                + " or 'E' to exit: ");
        
        char seChoice = GetInput.getChoice();
                        
        //main game loop
        while(seChoice == 'S')
        {
            //get random target sequence
            char[] targetSequence = GetInput.generateTarget();

            //game
            boolean win = GamePlay.aGame(targetSequence);
            
            //end of game message
            if (win == true)
            {
            	System.out.println("Congrats! you won. The correct answer was: ");
            	for(int i = 0; i < 4; i++)
            	{
            		System.out.print(targetSequence[i] + " ");
            	}
            }else
            {
            	System.out.println("You lost. Better luck next time. The correct answer was: ");
            	for(int i = 0; i < 4; i++)
            	{
            		System.out.print(targetSequence[i] + " ");;
            	}
            }
            
            //ask to play again or exist
            System.out.print("\n\nWould you like to play another game (S/E)? ");
            seChoice = GetInput.getChoice();
        }
        
        //exit message
        System.out.println("Thank you for playing");
        
    }
    
   
    
}
