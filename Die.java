import java.util.*;

	//The Die class represents a gaming die, which shows a range of integer values on its faces.

public class Die{
	//attributes
	int currentSide;
	int numOfSides;
	
	Random numGen = new Random();
	
	//constructors
	public Die(){									//the empty constructor will often hold default values
		numOfSides = 6;
		currentSide = 1;
	}
	
	public Die(int numOfSides){						//Constructor taking a number of sides from the user
		this.numOfSides = numOfSides;
		currentSide = 1;
	}
	
	public Die(int numOfSides, int currentSide){		//Constructor with all attributes as input parameters
		this.numOfSides = numOfSides;
		this.currentSide = currentSide;
	}
	
	//methods
	
	public void roll(){//generate a random number from 1 to numOfSides, and set currentSide to that, returning that value
		currentSide = numGen.nextInt(numOfSides)+1;
	}
	
	public int getNumOfSides(){						//accessor method for currentSide
		return numOfSides;
	}
	
	public void setNumOfSides(int newSides){		//mutator method for currentSide
		if(newSides > 0)
			numOfSides = newSides;
		
	}
	
	public int getCurrentSide(){					//accessor method for currentSide
		return currentSide;
	}
	
	public void setCurrentSide(int newCurrent){		//mutator method for currentSide
		if( (newCurrent > 0) && (newCurrent <= numOfSides) ){
			currentSide = newCurrent;
		}
	}
	/*
	public void getPic(Die one, Board board){
		one = new Die();
		one.roll();
		
		if(one.getCurrentSide() == 1){
			board.putPeg(new Peg("DiceOne1.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 2){
			board.putPeg(new Peg("DiceOne2.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 3){
			board.putPeg(new Peg("DiceOne3.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 4){
			board.putPeg(new Peg("DiceOne4.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 5){
			board.putPeg(new Peg("DiceOne5.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 6){
			board.putPeg(new Peg("DiceOne6.png"), 5, 5);
		}
				
		one.roll();
				
		if(one.getCurrentSide() == 1){
			board.putPeg(new Peg("DiceOne1.png"), 5, 6);
		}
		else if(one.getCurrentSide() == 2){
			board.putPeg(new Peg("DiceOne2.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 3){
			board.putPeg(new Peg("DiceOne3.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 4){
			board.putPeg(new Peg("DiceOne4.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 5){
			board.putPeg(new Peg("DiceOne5.png"), 5, 5);
		}
		else if(one.getCurrentSide() == 6){
			board.putPeg(new Peg("DiceOne6.png"), 5, 5);
		}
	}
	*/
	
	public String toString(){//overide Object's toString method
		
		return (numOfSides + " sided die. Current value: " + currentSide);
		
	}
}