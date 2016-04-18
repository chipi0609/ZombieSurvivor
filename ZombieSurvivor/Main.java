import java.util.Arrays;
import java.util.Scanner;

public class Main {
  
  private static void playTurn(Turn turn) {
    Outcome[] outcome = turn.drawAndGetOutcomes();
    
    // check if the population has been exceeded
    if(outcome.length == 0) {
    	System.out.println("The population has been exceeded");
    }
    
    // display the outcomes
    System.out.print("You got: ");
    
    System.out.print(Arrays.toString(outcome) + "\n");
    
    // display the three piles of zombies
    System.out.println("Current piles:");
    System.out.println(turn);
    
    // check if there are too many bites
    if(turn.hasBeenBittenTooManyTimes()) {
    	System.out.println("Has been bitten too many times!");
    	return;
    }
    
    // ask the user if they want to score or draw again  
    Scanner reader = new Scanner(System.in); 
    System.out.println("Enter s to score, or anything else to draw again:");
    String s = reader.next();
    
    if(s.equals("s")){
    	System.out.println("You scored: " + turn.getCurrentScore());
    } else {
    	playTurn(turn);
    }
  }

  public static void main(String[] args) {
	  // welcome the user
	  System.out.println(" O  Welcome to Zombie Survivor! O");
	  System.out.println(" |= -------------------------- =|");
	  System.out.println("/ \\                            / \\");
	  
	  System.out.println();
	  Scanner reader = new Scanner(System.in);
	  System.out.println("How many survivors?");
	  int num = reader.nextInt();
	  
	  ZombieSurvivor zs = new ZombieSurvivor(num);
	  int[] score = new int[num];
	  
	  while(! zs.isGameOver()) {
		  int currentPlayer = zs.getCurrentPlayer();
		  System.out.println("It's Player " + currentPlayer + "'s turn!");
		  playTurn(zs.startPlayerTurn());
	  }
  }

}
