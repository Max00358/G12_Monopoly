import java.util.*;

public class Monopoly{
	
	//Construct variables
	static int restart = 1;
	static int unwon = 1;
	static Scanner userInput = new Scanner(System.in);
	static Scanner oneRoad = new Scanner(System.in);
	static Scanner twoRoad = new Scanner(System.in);
	static Scanner oneCompanyScan = new Scanner(System.in);
	static Scanner twoCompanyScan = new Scanner(System.in);
	static Board board = new Board(13, 13);//Build a Board object of 11 * 11 size.
	static Random random = new Random();
	static Random randomChest = new Random();
	static Random randomChance = new Random();
	static Random randomCompany = new Random();
	static int oneMoney = 1000;
	static int twoMoney = 1000;
	static int oneTotWalk = 0;
	static int twoTotWalk = 0;
	static int oneRepeat = 0;
	static int twoRepeat = 0;
	static int threeRepeat = 0;
	static int oneRow = 0;
	static int oneCol = 1;
	static int twoRow = 0;
	static int twoCol = 1;
	static int threeRow = 0;
	static int threeCol = 1;
	static int count = random.nextInt(2)+1;
	
	static int totChestCard = 10;
	static int totChance = 10;
	static boolean[] chestTrueFalse = new boolean[10];
	static boolean[] chanceTrueFalse = new boolean[10];
	static boolean freeMyHomiePassOne = false;
	static boolean freeMyHomiePassTwo = false;
	static boolean[] oneRailRoad = new boolean[4];
	static boolean[] twoRailRoad = new boolean[4];
	static boolean[] oneCompany = new boolean[2];
	static boolean[] twoCompany = new boolean[2];
	static int oneOwn = 0;
	static int twoOwn = 0;
	static int oneOwnCompany = 0;
	static int twoOwnCompany = 0;
	
	static boolean[] oneBrownAve = new boolean[2];
	static boolean[] twoBrownAve = new boolean[2];
	static int oneBrownHouse1 = 0;
	static int oneBrownHouse2 = 0;
	static int twoBrownHouse1 = 0;
	static int twoBrownHouse2 = 0;
	static Scanner oneBrownScan = new Scanner(System.in);
	static Scanner twoBrownScan = new Scanner(System.in);
	
	static boolean[] oneBabyAve = new boolean[3];
	static boolean[] twoBabyAve = new boolean[3];
	static int oneBabyHouse1 = 0;
	static int oneBabyHouse2 = 0;
	static int oneBabyHouse3 = 0;
	static int twoBabyHouse1 = 0;
	static int twoBabyHouse2 = 0;
	static int twoBabyHouse3 = 0;
	static Scanner oneBabyScan = new Scanner(System.in);
	static Scanner twoBabyScan = new Scanner(System.in);
	
	static boolean[] onePinkAve = new boolean[3];
	static boolean[] twoPinkAve = new boolean[3];
	static int onePinkHouse1 = 0;
	static int onePinkHouse2 = 0;
	static int onePinkHouse3 = 0;
	static int twoPinkHouse1 = 0;
	static int twoPinkHouse2 = 0;
	static int twoPinkHouse3 = 0;
	static Scanner onePinkScan = new Scanner(System.in);
	static Scanner twoPinkScan = new Scanner(System.in);
	
	static boolean[] oneOrangeAve = new boolean[3];
	static boolean[] twoOrangeAve = new boolean[3];
	static int oneOrangeHouse1 = 0;
	static int oneOrangeHouse2 = 0;
	static int oneOrangeHouse3 = 0;
	static int twoOrangeHouse1 = 0;
	static int twoOrangeHouse2 = 0;
	static int twoOrangeHouse3 = 0;
	static Scanner oneOrangeScan = new Scanner(System.in);
	static Scanner twoOrangeScan = new Scanner(System.in);
	
	static boolean[] oneRedAve = new boolean[3];
	static boolean[] twoRedAve = new boolean[3];
	static int oneRedHouse1 = 0;
	static int oneRedHouse2 = 0;
	static int oneRedHouse3 = 0;
	static int twoRedHouse1 = 0;
	static int twoRedHouse2 = 0;
	static int twoRedHouse3 = 0;
	static Scanner oneRedScan = new Scanner(System.in);
	static Scanner twoRedScan = new Scanner(System.in);
	
	static boolean[] oneYeAve = new boolean[3];
	static boolean[] twoYeAve = new boolean[3];
	static int oneYeHouse1 = 0;
	static int oneYeHouse2 = 0;
	static int oneYeHouse3 = 0;
	static int twoYeHouse1 = 0;
	static int twoYeHouse2 = 0;
	static int twoYeHouse3 = 0;
	static Scanner oneYeScan = new Scanner(System.in);
	static Scanner twoYeScan = new Scanner(System.in);
	
	static boolean[] oneGreenAve = new boolean[3];
	static boolean[] twoGreenAve = new boolean[3];
	static int oneGreenHouse1 = 0;
	static int oneGreenHouse2 = 0;
	static int oneGreenHouse3 = 0;
	static int twoGreenHouse1 = 0;
	static int twoGreenHouse2 = 0;
	static int twoGreenHouse3 = 0;
	static Scanner oneGreenScan = new Scanner(System.in);
	static Scanner twoGreenScan = new Scanner(System.in);
	
	static boolean[] oneBlueAve = new boolean[2];
	static boolean[] twoBlueAve = new boolean[2];
	static int oneBlueHouse1 = 0;
	static int oneBlueHouse2 = 0;
	static int twoBlueHouse1 = 0;
	static int twoBlueHouse2 = 0;
	static Scanner oneBlueScan = new Scanner(System.in);
	static Scanner twoBlueScan = new Scanner(System.in);
	
	//This method rolls the dice for player and add the resultant value to player's total steps walked
	public static void getPic(Die one){
		one = new Die();
		one.roll();
				
		try{
			if(one.getCurrentSide() == 1){
				board.putPeg(new Peg("DiceOne1.png"), 6, 5);
			}
			else if(one.getCurrentSide() == 2){
				board.putPeg(new Peg("DiceOne2.png"), 6, 5);
			}
			else if(one.getCurrentSide() == 3){
				board.putPeg(new Peg("DiceOne3.png"), 6, 5);
			}
			else if(one.getCurrentSide() == 4){
				board.putPeg(new Peg("DiceOne4.png"), 6, 5);
			}
			else if(one.getCurrentSide() == 5){
				board.putPeg(new Peg("DiceOne5.png"), 6, 5);
			}
			else if(one.getCurrentSide() == 6){
				board.putPeg(new Peg("DiceOne6.png"), 6, 5);
			}
			
			if(count%2 == 0){
				oneTotWalk = oneTotWalk + one.getCurrentSide();
			}
			else{
				twoTotWalk = twoTotWalk + one.getCurrentSide();
			}
			
			one.roll();
				
			if(one.getCurrentSide() == 1){
				board.putPeg(new Peg("DiceOne1.png"), 6, 6);
			}
			else if(one.getCurrentSide() == 2){
				board.putPeg(new Peg("DiceOne2.png"), 6, 6);
			}
			else if(one.getCurrentSide() == 3){
				board.putPeg(new Peg("DiceOne3.png"), 6, 6);
			}
			else if(one.getCurrentSide() == 4){
				board.putPeg(new Peg("DiceOne4.png"), 6, 6);
			}
			else if(one.getCurrentSide() == 5){
				board.putPeg(new Peg("DiceOne5.png"), 6, 6);
			}
			else if(one.getCurrentSide() == 6){
				board.putPeg(new Peg("DiceOne6.png"), 6, 6);
			}
			
			if(count%2 == 0){
				oneTotWalk = oneTotWalk + one.getCurrentSide();
			}
			else{
				twoTotWalk = twoTotWalk + one.getCurrentSide();
			}
		}
		catch(Exception e){
			System.out.println("There is something wrong");
		}
	}
	
	//This method puts player on their position after the dice is rolled
	public static void putPosition(int countMove){
		countMove = count;
		try{
			if(oneTotWalk != twoTotWalk){
				if(countMove % 2 == 0){//player 1's move
					//oneRepeat++;
					if(oneTotWalk > 40){
						oneTotWalk = oneTotWalk - 40;
						//oneRepeat = 1;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 just passed 'GO', collect 200");
						oneMoney = oneMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneTotWalk <= 10){
						board.removePeg(oneRow, oneCol);
						board.putPeg(new Peg("one.png"), 12, 11-oneTotWalk);
						oneRow = 12;
						oneCol = 11-oneTotWalk;
					}
					else if(oneTotWalk > 10 && oneTotWalk <= 20){
						board.removePeg(oneRow, oneCol);
						board.putPeg(new Peg("one.png"), 21-oneTotWalk, 0);
						oneRow = 21-oneTotWalk;
						oneCol = 0;
					}
					else if(oneTotWalk > 20 && oneTotWalk <= 30){
						board.removePeg(oneRow, oneCol);
						board.putPeg(new Peg("one.png"), 0, oneTotWalk-19);
						oneRow = 0;
						oneCol = oneTotWalk-19;
					}
					else if(oneTotWalk > 30 && oneTotWalk <= 40){
						board.removePeg(oneRow, oneCol);
						board.putPeg(new Peg("one.png"), oneTotWalk-29, 12);
						oneRow = oneTotWalk-29;
						oneCol = 12;
					}
				}
				else if(countMove % 2 == 1){//player 2's move
					//twoRepeat++;
					if(twoTotWalk > 40){
						twoTotWalk = twoTotWalk - 40;
						//twoRepeat = 1;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 just passed 'GO', collect 200");
						twoMoney = twoMoney + 200;
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoTotWalk <= 10){
						board.removePeg(twoRow, twoCol);
						board.putPeg(new Peg("two.png"), 12, 11-twoTotWalk);
						twoRow = 12;
						twoCol = 11-twoTotWalk;
					}
					else if(twoTotWalk > 10 && twoTotWalk <= 20){
						board.removePeg(twoRow, twoCol);
						board.putPeg(new Peg("two.png"), 21-twoTotWalk, 0);
						twoRow = 21-twoTotWalk;
						twoCol = 0;
					}
					else if(twoTotWalk > 20 && twoTotWalk <= 30){
						board.removePeg(twoRow, twoCol);
						board.putPeg(new Peg("two.png"), 0, twoTotWalk-19);
						twoRow = 0;
						twoCol = twoTotWalk-19;
					}
					else if(twoTotWalk > 30 && twoTotWalk <= 40){
						board.removePeg(twoRow, twoCol);
						board.putPeg(new Peg("two.png"), twoTotWalk-29, 12);
						twoRow = twoTotWalk-29;
						twoCol = 12;
					}
				}
			}
			else{//when player 1 and 2 both on the same square
				if(oneTotWalk > 40){
					oneTotWalk = oneTotWalk - 40;
					twoTotWalk = twoTotWalk - 40;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 and player 2 just passed 'GO', both collect 200");
					oneMoney = oneMoney + 200;
					twoMoney = twoMoney + 200;
					System.out.println("Player 1 now has " + oneMoney);
					System.out.println("Player 2 now has " + twoMoney);
				}
				else if(oneTotWalk <= 10){
					board.removePeg(oneRow, oneCol);
					board.removePeg(twoRow, twoCol);
					board.removePeg(threeRow, threeCol);
					board.putPeg(new Peg("three.png"), 12, 11-oneTotWalk);
					threeRow = 12;
					threeCol = 11-oneTotWalk;
				}
				else if(oneTotWalk > 10 && oneTotWalk <= 20){
					board.removePeg(oneRow, oneCol);
					board.removePeg(twoRow, twoCol);
					board.removePeg(threeRow, threeCol);
					board.putPeg(new Peg("three.png"), 21-oneTotWalk, 0);
					threeRow = 21-oneTotWalk;
					threeCol = 0;
				}
				else if(oneTotWalk > 20 && oneTotWalk <= 30){
					board.removePeg(oneRow, oneCol);
					board.removePeg(twoRow, twoCol);
					board.removePeg(threeRow, threeCol);
					board.putPeg(new Peg("three.png"), 0, oneTotWalk-19);
					threeRow = 0;
					threeCol = oneTotWalk-19;
				}
				else if(oneTotWalk > 30 && oneTotWalk <= 40){
					board.removePeg(oneRow, oneCol);
					board.removePeg(twoRow, twoCol);
					board.removePeg(threeRow, threeCol);
					board.putPeg(new Peg("three.png"), oneTotWalk-29, 12);
					threeRow = oneTotWalk-29;
					threeCol = 12;
				}
			}
		}
		catch(Exception e){
			System.out.println("There's something wrong");
		}
	}
	
	//The community chest method is used draws card and execute whatever is on the card
	public static void chest(int countMove2){
		countMove2 = count;
		//String answer;
		int chestIndex = 0;
		int loop = 1;
		//board.displayMessage("check both board and console for info");
		
		if(totChestCard > 1){
			if(countMove2 % 2 == 0){//player 1 move
				chestIndex = randomChest.nextInt(10);//generate chestIndex from 0 to 9
				
				while(loop == 1){
					if(chestTrueFalse[chestIndex] == true){
						chestIndex = randomChest.nextInt(10);
						loop = 1;
					}
					else{
						loop = 0;
					}
				}
				
				if(chestIndex == 0){
					board.displayMessage("Bank error in your favor. Collect 200");
					oneMoney = oneMoney + 200;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 1){
					board.displayMessage("Doctor's fees. Pay 50");
					oneMoney = oneMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 2){
					board.displayMessage("From sale of stock you get 50");
					oneMoney = oneMoney + 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 3){
					board.displayMessage("Grand Opera Night. Collect 50 from every player");
					oneMoney = oneMoney + 50;
					twoMoney = twoMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 4){
					board.displayMessage("Holiday Fund matures.(idk wat this means but go ahead and) Collect 100");
					oneMoney = oneMoney + 100;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 5){
					board.displayMessage("Income tax refund. Collect 20");
					oneMoney = oneMoney + 20;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 6){
					board.displayMessage("It is your bday! Collect 10 from every player");
					oneMoney = oneMoney + 10;
					twoMoney = twoMoney - 10;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 7){
					board.displayMessage("Life insurance matures. Collect 100");
					oneMoney = oneMoney + 100;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 8){
					board.displayMessage("Hospital Fees. Pay 50");
					oneMoney = oneMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 9){
					board.displayMessage("School Fees. Pay 50");
					oneMoney = oneMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game");
						unwon = 0;
					}
				}
			}
			else if(countMove2 % 2 == 1){//player 2 move
				chestIndex = randomChest.nextInt(10);
				
				while(loop == 1){
					if(chestTrueFalse[chestIndex] == true){
						chestIndex = randomChest.nextInt(10);
						loop = 1;
					}
					else{
						loop = 0;
					}
				}
				if(chestIndex == 0){
					board.displayMessage("Bank error in your favor. Collect 200");
					twoMoney = twoMoney + 200;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 1){
					board.displayMessage("Doctor's fees. Pay 50");
					twoMoney = twoMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 2){
					board.displayMessage("From sale of stock you get 50");
					twoMoney = twoMoney + 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 3){
					board.displayMessage("Grand Opera Night. Collect 50 from every player");
					twoMoney = twoMoney + 50;
					oneMoney = oneMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 4){
					board.displayMessage("Holiday Fund matures.(idk wat this means but go ahead and) Collect 100");
					twoMoney = twoMoney + 100;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 5){
					board.displayMessage("Income tax refund. Collect 20");
					twoMoney = twoMoney + 20;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 6){
					board.displayMessage("It is your bday! Collect 10 from every player");
					twoMoney = twoMoney + 10;
					oneMoney = oneMoney - 10;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					System.out.println("Player 1 now has " + oneMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 7){
					board.displayMessage("Life insurance matures. Collect 100");
					twoMoney = twoMoney + 100;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
				}
				else if(chestIndex == 8){
					board.displayMessage("Hospital Fees. Pay 50");
					twoMoney = twoMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game");
						unwon = 0;
					}
				}
				else if(chestIndex == 9){
					board.displayMessage("School Fees. Pay 50");
					twoMoney = twoMoney - 50;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 now has " + twoMoney);
					chestTrueFalse[chestIndex] = true;
					totChestCard--;
					
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game");
						unwon = 0;
					}
				}
			}
			System.out.println("There are a total of " + totChestCard + " community chest left");
		}
		else if(totChestCard == 1){
			System.out.print("\033[H\033[2J");
			System.out.println("There are no more community chests!");
				
			if(oneMoney == twoMoney){
				System.out.println("Two players have the same amount of money, it's a draw!");
				unwon = 0;
			}
			else if(oneMoney > twoMoney){
				System.out.println("Player 1 has more money. \nPlayer 1 wins the game!");
				board.displayMessage("Player 1 wins the game!");
				unwon = 0;
			}
			else if(oneMoney < twoMoney){
				System.out.println("Player 2 has more money. \nPlayer 2 wins the game!");
				board.displayMessage("Player 2 wins the game!");
				unwon = 0;
			}
		}
	}
	
	//This method is used when player lands on the railroad square
	public static void buyRoad(int countMove3){
		countMove3 = count;
		String buyOne;
		String buyTwo;
		
		System.out.print("\033[H\033[2J");
		
		//Player 1's turn
		if(countMove3 % 2 == 0){
			
			if((oneTotWalk == 5 && oneRailRoad[0] == true) || (oneTotWalk == 15 && oneRailRoad[1] == true) || (oneTotWalk == 25 && oneRailRoad[2] == true) || (oneTotWalk == 35 && oneRailRoad[3] == true)){
				System.out.println("Player 1 is in his/her own property, chilling");
			}
			else if(oneTotWalk == 5 && twoRailRoad[0] == false){
				System.out.println("Does player 1 wish to purchase this railroad for 200? (yes / no)");
				buyOne = oneRoad.nextLine();
				if(buyOne.equalsIgnoreCase("yes") && oneMoney >= 200){
					oneMoney = oneMoney - 200;
					oneRailRoad[0] = true;
					oneOwn++;
					System.out.println("Player 1 now has " + oneMoney + " with " + oneOwn + " railroad(s)");
				}
				else if(buyOne.equalsIgnoreCase("yes") && oneMoney <= 200){
					System.out.println("Player 1 has " + oneMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 1 did not purchase the property");
				}
			}
			else if(oneTotWalk == 15 && twoRailRoad[1] == false){
				System.out.println("Does player 1 wish to purchase this railroad for 200? (yes / no)");
				buyOne = oneRoad.nextLine();
				if(buyOne.equalsIgnoreCase("yes") && oneMoney >= 200){
					oneMoney = oneMoney - 200;
					oneRailRoad[1] = true;
					oneOwn++;
					System.out.println("Player 1 now has " + oneMoney + " with " + oneOwn + " railroad(s)");
				}
				else if(buyOne.equalsIgnoreCase("yes") && oneMoney <= 200){
					System.out.println("Player 1 has " + oneMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 1 did not purchase the property");
				}
			}
			else if(oneTotWalk == 25 && twoRailRoad[2] == false){
				System.out.println("Does player 1 wish to purchase this railroad for 200? (yes / no)");
				buyOne = oneRoad.nextLine();
				if(buyOne.equalsIgnoreCase("yes") && oneMoney >= 200){
					oneMoney = oneMoney - 200;
					oneRailRoad[2] = true;
					oneOwn++;
					System.out.println("Player 1 now has " + oneMoney + " with " + oneOwn + " railroad(s)");
				}
				else if(buyOne.equalsIgnoreCase("yes") && oneMoney <= 200){
					System.out.println("Player 1 has " + oneMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 1 did not purchase the property");
				}
			}
			else if(oneTotWalk == 35 && twoRailRoad[3] == false){
				System.out.println("Does player 1 wish to purchase this railroad for 200? (yes / no)");
				buyOne = oneRoad.nextLine();
				if(buyOne.equalsIgnoreCase("yes") && oneMoney >= 200){
					oneMoney = oneMoney - 200;
					oneRailRoad[3] = true;
					oneOwn++;
					System.out.println("Player 1 now has " + oneMoney + " with " + oneOwn + " railroad(s)");
				}
				else if(buyOne.equalsIgnoreCase("yes") && oneMoney <= 200){
					System.out.println("Player 1 has " + oneMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 1 did not purchase the property");
				}
			}
			else{
				if(twoOwn == 1){
					if((oneTotWalk == 5 && twoRailRoad[0] == true) || (oneTotWalk == 15 && twoRailRoad[1] == true) || (oneTotWalk == 25 && twoRailRoad[2] == true) || (oneTotWalk == 35 && twoRailRoad[3] == true)){
						System.out.println("This square is occupied by player 2. Player 1 pays 25 to player 2");
						oneMoney = oneMoney - 25;
						twoMoney = twoMoney + 25;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 1 isn't in player 2's property, no rent required");
					}
				}
				else if(twoOwn == 2){
					if((oneTotWalk == 5 && twoRailRoad[0] == true) || (oneTotWalk == 15 && twoRailRoad[1] == true) || (oneTotWalk == 25 && twoRailRoad[2] == true) || (oneTotWalk == 35 && twoRailRoad[3] == true)){
						System.out.println("This square is occupied by player 2. Player 1 pays 50 to player 2");
						oneMoney = oneMoney - 50;
						twoMoney = twoMoney + 50;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 1 isn't in player 2's property, no rent required");
					}
				}
				else if(twoOwn == 3){
					if((oneTotWalk == 5 && twoRailRoad[0] == true) || (oneTotWalk == 15 && twoRailRoad[1] == true) || (oneTotWalk == 25 && twoRailRoad[2] == true) || (oneTotWalk == 35 && twoRailRoad[3] == true)){
						System.out.println("This square is occupied by player 2. Player 1 pays 100 to player 2");
						oneMoney = oneMoney - 100;
						twoMoney = twoMoney + 100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 1 isn't in player 2's property, no rent required");
					}
				}
				else if(twoOwn == 4){
					System.out.println("This square is occupied by player 2. Player 1 pays 200 to player 2");
					oneMoney = oneMoney - 200;
					twoMoney = twoMoney + 200;
					System.out.println("Player 1 now has " + oneMoney);
					System.out.println("Player 2 now has " + twoMoney);
					
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game");
						unwon = 0;
					}
				}
			}
		}
		//Player 2's turn
		else if(countMove3 % 2 == 1){
			
			if((twoTotWalk == 5 && twoRailRoad[0] == true) || (twoTotWalk == 15 && twoRailRoad[1] == true) || (twoTotWalk == 25 && twoRailRoad[2] == true) || (twoTotWalk == 35 && twoRailRoad[3] == true)){
				System.out.println("Player 2 is in his/her own property, chilling");
			}
			else if(twoTotWalk == 5 && oneRailRoad[0] == false){
				System.out.println("Does player 2 wish to purchase this railroad for 200? (yes / no)");
				buyTwo = twoRoad.nextLine();
				if(buyTwo.equalsIgnoreCase("yes") && twoMoney >= 200){
					twoMoney = twoMoney - 200;
					twoRailRoad[0] = true;
					twoOwn++;
					System.out.println("Player 2 now has " + twoMoney + " with " + twoOwn + " railroad(s)");
				}
				else if(buyTwo.equalsIgnoreCase("yes") && twoMoney <= 200){
					System.out.println("Player 2 has " + twoMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 2 did not purchase the property");
				}
			}
			else if(twoTotWalk == 15 && oneRailRoad[1] == false){
				System.out.println("Does player 2 wish to purchase this railroad for 200? (yes / no)");
				buyTwo = twoRoad.nextLine();
				if(buyTwo.equalsIgnoreCase("yes") && twoMoney >= 200){
					twoMoney = twoMoney - 200;
					twoRailRoad[1] = true;
					twoOwn++;
					System.out.println("Player 2 now has " + twoMoney + " with " + twoOwn + " railroad(s)");
				}
				else if(buyTwo.equalsIgnoreCase("yes") && twoMoney <= 200){
					System.out.println("Player 2 has " + twoMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 2 did not purchase the property");
				}
			}
			else if(twoTotWalk == 25 && oneRailRoad[2] == false){
				System.out.println("Does player 2 wish to purchase this railroad for 200? (yes / no)");
				buyTwo = twoRoad.nextLine();
				if(buyTwo.equalsIgnoreCase("yes") && twoMoney >= 200){
					twoMoney = twoMoney - 200;
					twoRailRoad[2] = true;
					twoOwn++;
					System.out.println("Player 2 now has " + twoMoney + " with " + twoOwn + " railroad(s)");
				}
				else if(buyTwo.equalsIgnoreCase("yes") && twoMoney <= 200){
					System.out.println("Player 2 has " + twoMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 2 did not purchase the property");
				}
			}
			else if(twoTotWalk == 35 && oneRailRoad[3] == false){
				System.out.println("Does player 2 wish to purchase this railroad for 200? (yes / no)");
				buyTwo = twoRoad.nextLine();
				if(buyTwo.equalsIgnoreCase("yes") && twoMoney >= 200){
					twoMoney = twoMoney - 200;
					twoRailRoad[3] = true;
					twoOwn++;
					System.out.println("Player 2 now has " + twoMoney + " with " + twoOwn + " railroad(s)");
				}
				else if(buyTwo.equalsIgnoreCase("yes") && twoMoney <= 200){
					System.out.println("Player 2 has " + twoMoney + ". This is not enough to purchase the property");
				}
				else{
					System.out.println("Player 2 did not purchase the property");
				}
			}
			else{
				if(oneOwn == 1){
					//This checks if player 2 is on the property of player 1
					if((twoTotWalk == 5 && oneRailRoad[0] == true) || (twoTotWalk == 15 && oneRailRoad[1] == true) || (twoTotWalk == 25 && oneRailRoad[2] == true) || (twoTotWalk == 35 && oneRailRoad[3] == true)){
						System.out.println("This square is occupied by player 1. Player 2 pays 25 to player 1");
						twoMoney = twoMoney - 25;
						oneMoney = oneMoney + 25;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 2 isn't in player 1's property, no rent required");
					}
				}
				else if(oneOwn == 2){
					if((twoTotWalk == 5 && oneRailRoad[0] == true) || (twoTotWalk == 15 && oneRailRoad[1] == true) || (twoTotWalk == 25 && oneRailRoad[2] == true) || (twoTotWalk == 35 && oneRailRoad[3] == true)){
						System.out.println("This square is occupied by player 1. Player 2 pays 50 to player 1");
						twoMoney = twoMoney - 50;
						oneMoney = oneMoney + 50;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 2 isn't in player 1's property, no rent required");
					}
				}
				else if(oneOwn == 3){
					if((twoTotWalk == 5 && oneRailRoad[0] == true) || (twoTotWalk == 15 && oneRailRoad[1] == true) || (twoTotWalk == 25 && oneRailRoad[2] == true) || (twoTotWalk == 35 && oneRailRoad[3] == true)){
						System.out.println("This square is occupied by player 1. Player 2 pays 100 to player 1");
						twoMoney = twoMoney - 100;
						oneMoney = oneMoney + 100;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
						
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 2 isn't in player 1's property, no rent required");
					}
				}
				//We don't need to check since all 4 railroads are all owned by player 1, so player 2 is definitely on player 1's property
				else if(oneOwn == 4){
					System.out.println("This square is occupied by player 1. Player 2 pays 200 to player 1");
					twoMoney = twoMoney - 200;
					oneMoney = oneMoney + 200;
					System.out.println("Player 2 now has " + twoMoney);
					System.out.println("Player 1 now has " + oneMoney);
					
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game");
						unwon = 0;
					}
				}
			}
		}
	}
	
	//The chance card method is used draws card and execute whatever is on the card, similar to community chest
	public static void chance(int countMove4){
		countMove4 = count;
		int chanceIndex = 0;
		int loopChance = 1;
		
		try{
			if(totChance > 1){
				//Player 1's turn
				if(countMove4 % 2 == 0){
					chanceIndex = randomChest.nextInt(10);//generate chanceIndex from 0 to 9
					
					while(loopChance == 1){
						if(chanceTrueFalse[chanceIndex] == true){
							chanceIndex = randomChance.nextInt(10);
							loopChance = 1;
						}
						else{
							loopChance = 0;
						}
					}
					if(chanceIndex == 0 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Advance to 'GO' and collect 200");
						oneTotWalk = 0;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;	
						totChance--;
					
						if(oneTotWalk == twoTotWalk){
							board.putPeg(new Peg("three.png"), 12, 11);
						}
					}
					else if(chanceIndex == 1 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Player 1 won a crossworld competition. Collect 100");
						oneMoney = oneMoney + 100;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 2 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Player 1 had been elected Chairman of the Board. Pay each player 50");
						oneMoney = oneMoney - 50;
						twoMoney = twoMoney + 50;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 3 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Pay poor tax of 15 (poor tax??)");
						oneMoney = oneMoney - 15;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 4 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Go to Jail (& pay 50)");
						oneTotWalk = 10;
							oneMoney = oneMoney - 50;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 5 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Bank pays 50 to player 1");
						oneMoney = oneMoney + 50;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 6 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("House reparation. Pay 200");
						oneMoney = oneMoney - 200;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
						
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 7 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Receive 25 consultancy fee");
						oneMoney = oneMoney + 25;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 8 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Player 1's building & loan matures. Receive 150");
						oneMoney = oneMoney + 150;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 9 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Get out of Jail free (can save for future usage)");
						freeMyHomiePassOne = true;
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
				}
				//Player 2's turn
				else if(countMove4 % 2 == 1){
					chanceIndex = randomChest.nextInt(10);//generate chanceIndex from 0 to 9
				
					while(loopChance == 1){
						if(chanceTrueFalse[chanceIndex] == true){
							chanceIndex = randomChance.nextInt(10);
							loopChance = 1;
						}
						else{
							loopChance = 0;
						}
					}
					if(chanceIndex == 0 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Advance to 'GO' and collect 200");
						twoTotWalk = 0;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
						
						if(twoTotWalk == oneTotWalk){
							board.putPeg(new Peg("three.png"), 12, 11);
						}
					}
					else if(chanceIndex == 1 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Player 2 won a crossworld competition. Collect 100");
						twoMoney = twoMoney + 100;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 2 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Player 2 had been elected Chairman of the Board. Pay each player 50");
						twoMoney = twoMoney - 50;
						oneMoney = oneMoney + 50;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
						
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 3 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Pay poor tax of 15 (poor tax??)");
						twoMoney = twoMoney - 15;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 4 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Go to Jail");
						twoTotWalk = 10;
						twoMoney = twoMoney - 50;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 5 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Bank pays 50 to player 2");
						twoMoney = twoMoney + 50;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 6 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("House reparation. Pay 200");
						twoMoney = twoMoney - 200;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
						
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
					}
					else if(chanceIndex == 7 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Receive 25 consultancy fee");
						twoMoney = twoMoney + 25;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 8 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Player 2's building & loan matures. Receive 150");
						twoMoney = twoMoney + 150;
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 now has " + twoMoney);
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
					else if(chanceIndex == 9 && chanceTrueFalse[chanceIndex] == false){
						board.displayMessage("Get out of Jail free (can save for future usage)");
						freeMyHomiePassTwo = true;
						chanceTrueFalse[chanceIndex] = true;
						totChance--;
					}
				}
				System.out.println("There are a total of " + totChance + " chance card(s) left");
			}
			else if(totChance == 1){
				System.out.print("\033[H\033[2J");
				System.out.println("There are no more chance cards!");
				
				if(oneMoney == twoMoney){
					System.out.println("Two players have the same amount of money, it's a draw!");
					unwon = 0;
				}
				else if(oneMoney > twoMoney){
					System.out.println("Player 1 has more money. \nPlayer 1 wins the game!");
					board.displayMessage("Player 1 wins the game!");
					unwon = 0;
				}
				else if(oneMoney < twoMoney){
					System.out.println("Player 2 has more money. \nPlayer 2 wins the game!");
					board.displayMessage("Player 2 wins the game!");
					unwon = 0;
				}
			}
		}
		catch(Exception e){
			System.out.println("There is something wrong");
		}
	}
	
	//When player lands on water & electrical company square, execute this method
	public static void company(int countMove5){
		countMove5 = count;
		String buyCompanyOne;
		String buyCompanyTwo;
		int oneRollDice = 0;
		int twoRollDice = 0;
		int oneRent = 0;
		int twoRent = 0;
		int firstRoll = 0;
		int secRoll = 0;
		
		System.out.print("\033[H\033[2J");
		
		//Player 1's turn
		if(countMove5 % 2 == 0){
			if((oneTotWalk == 12 && oneCompany[0] == true) || (oneTotWalk == 28 && oneCompany[1] == true)){
				System.out.println("Player 1 is in his/her own company, chilling");
			}
			else if(oneTotWalk == 12 && twoCompany[0] == false){
				System.out.println("Does player 1 wish to purchase this company for 150? (yes / no)");
				buyCompanyOne = oneCompanyScan.nextLine();
				if(buyCompanyOne.equalsIgnoreCase("yes") && oneMoney >= 150){
					oneMoney = oneMoney - 150;
					oneCompany[0] = true;
					oneOwnCompany++;
					System.out.println("Player 1 now has " + oneMoney + " with " + oneOwnCompany + " facility(s)");
				}
				else if(buyCompanyOne.equalsIgnoreCase("yes") && oneMoney <= 150){
					System.out.println("Player 1 has " + oneMoney + ". This is not enough to purchase the facility");
				}
				else{
					System.out.println("Player 1 did not purchase the facility");
				}
			}
			else if(oneTotWalk == 28 && twoCompany[1] == false){
				System.out.println("Does player 1 wish to purchase this company for 150? (yes / no)");
				buyCompanyOne = oneCompanyScan.nextLine();
				if(buyCompanyOne.equalsIgnoreCase("yes") && oneMoney >= 150){
					oneMoney = oneMoney - 150;
					oneCompany[1] = true;
					oneOwnCompany++;
					System.out.println("Player 1 now has " + oneMoney + " with " + oneOwnCompany + " facility(s)");
				}
				else if(buyCompanyOne.equalsIgnoreCase("yes") && oneMoney <= 150){
					System.out.println("Player 1 has " + oneMoney + ". This is not enough to purchase the facility");
				}
				else{
					System.out.println("Player 1 did not purchase the facility");
				}
			}
			else{
				if(twoOwnCompany == 1){
					//if player 1 lands on player 2's facility and player 2 only has 1 facility in total, charge player 1 4 times the random gen values
					if((oneTotWalk == 12 && twoCompany[0] == true) || (oneTotWalk == 28 && twoCompany[1] == true)){
						oneRollDice = randomCompany.nextInt(6)+1;
						firstRoll = oneRollDice;
						oneRollDice = randomCompany.nextInt(6)+1;
						System.out.println("Player 1 stepped on player 2's property, \nthe random number generator outputs " + firstRoll + " and " + oneRollDice);
						oneRent = (firstRoll + oneRollDice) * 4;
						
						if(oneMoney <= oneRent){
							System.out.println("Player 1 went broke, player 2 wins the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
						else{
							System.out.println("\nPlayer 1 originally has " + oneMoney);
							System.out.println("Player 2 originally has " + twoMoney);
							oneMoney = oneMoney - oneRent;
							twoMoney = twoMoney + oneRent;
							System.out.println("\nPlayer 1 pays 4X the total number generated, which is " + oneRent);
							System.out.println("Player 1 now has " + oneMoney);
							System.out.println("Player 2 now has " + twoMoney);
						}
					}
				}
				else if(twoOwnCompany == 2){
					oneRollDice = randomCompany.nextInt(6)+1;
					firstRoll = oneRollDice;
					oneRollDice = randomCompany.nextInt(6)+1;
					System.out.println("Player 1 stepped on player 2's property, \nthe random number generator outputs " + firstRoll + " and " + oneRollDice);
					oneRent = (firstRoll + oneRollDice) * 10;
						
					if(oneMoney <= oneRent){
						System.out.println("Player 1 went broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
					else{
						System.out.println("\nPlayer 1 originally has " + oneMoney);
						System.out.println("Player 2 originally has " + twoMoney);
						oneMoney = oneMoney - oneRent;
						twoMoney = twoMoney + oneRent;
						System.out.println("\nPlayer 1 pays 10X the total number generated, which is " + oneRent);
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
				}
			}
		}
		//Player 2's turn
		else if(countMove5 % 2 == 1){
			if((twoTotWalk == 12 && twoCompany[0] == true) || (twoTotWalk == 28 && twoCompany[1] == true)){
				System.out.println("Player 2 is in his/her own property, chilling");
			}
			else if(twoTotWalk == 12 && oneCompany[0] == false){
				System.out.println("Does player 2 wish to purchase this company for 150? (yes / no)");
				buyCompanyTwo = twoCompanyScan.nextLine();
				if(buyCompanyTwo.equalsIgnoreCase("yes") && twoMoney >= 150){
					twoMoney = twoMoney - 150;
					twoCompany[0] = true;
					twoOwnCompany++;
					System.out.println("Player 2 now has " + twoMoney + " with " + twoOwnCompany + " facility(s)");
				}
				else if(buyCompanyTwo.equalsIgnoreCase("yes") && twoMoney <= 150){
					System.out.println("Player 2 has " + twoMoney + ". This is not enough to purchase the facility");
				}
				else{
					System.out.println("Player 2 did not purchase the facility");
				}
			}
			else if(twoTotWalk == 28 && oneCompany[1] == false){
				System.out.println("Does player 2 wish to purchase this company for 150? (yes / no)");
				buyCompanyTwo = twoCompanyScan.nextLine();
				if(buyCompanyTwo.equalsIgnoreCase("yes") && twoMoney >= 150){
					twoMoney = twoMoney - 150;
					twoCompany[1] = true;
					twoOwnCompany++;
					System.out.println("Player 2 now has " + twoMoney + " with " + twoOwnCompany + " facility(s)");
				}
				else if(buyCompanyTwo.equalsIgnoreCase("yes") && twoMoney <= 150){
					System.out.println("Player 2 has " + twoMoney + ". This is not enough to purchase the facility");
				}
				else{
					System.out.println("Player 2 did not purchase the facility");
				}
			}
			else{
				if(oneOwnCompany == 1){
					//if player 2 lands on player 1's facility and player 1 only has 1 facility in total, charge player 2 4 times the random gen values
					if((twoTotWalk == 12 && oneCompany[0] == true) || (twoTotWalk == 28 && oneCompany[1] == true)){
						twoRollDice = randomCompany.nextInt(6)+1;
						secRoll = twoRollDice;
						twoRollDice = randomCompany.nextInt(6)+1;
						System.out.println("Player 2 stepped on player 1's property, \nthe random number generator outputs " + secRoll + " and " + twoRollDice);
						twoRent = (secRoll + twoRollDice) * 4;
						
						if(twoMoney <= twoRent){
							System.out.println("Player 2 went broke, player 1 wins the game!");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
						else{
							System.out.println("\nPlayer 1 originally has " + oneMoney);
							System.out.println("Player 2 originally has " + twoMoney);
							twoMoney = twoMoney - twoRent;
							oneMoney = oneMoney + twoRent;
							System.out.println("\nPlayer 2 pays 4X the total number generated, which is " + twoRent);
							System.out.println("Player 1 now has " + oneMoney);
							System.out.println("Player 2 now has " + twoMoney);
						}
					}
				}
				else if(oneOwnCompany == 2){
					twoRollDice = randomCompany.nextInt(6)+1;
					secRoll = twoRollDice;
					twoRollDice = randomCompany.nextInt(6)+1;
					System.out.println("Player 2 stepped on player 1's property, \nthe random number generator outputs " + secRoll + " and " + twoRollDice);
					twoRent = (secRoll + twoRollDice) * 10;
						
					if(twoMoney <= twoRent){
						System.out.println("Player 2 went broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
					else{
						System.out.println("\nPlayer 1 originally has " + oneMoney);
						System.out.println("Player 2 originally has " + twoMoney);
						twoMoney = twoMoney - twoRent;
						oneMoney = oneMoney + twoRent;
						System.out.println("\nPlayer 2 pays 10X the total number generated, which is " + twoRent);
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
				}
			}
		}
	}
	
	//When player lands on any of the 2 brown Ave. execute this method
	//In this method, program asks user whether they need to pay rent or buy properties/houses
	public static void brownAvenue(int countMove6){
		countMove6 = count;
		String oneBrown;
		String twoBrown;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove6 % 2 == 0){
			
			//Check if player 1 has already bought one of the properties in Brown Ave.
			if(oneTotWalk == 1 && oneBrownAve[0] == true){
				if(oneBrownHouse1 >= 0 && oneBrownHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 50? (yes / no)");
					oneBrown = oneBrownScan.nextLine();
					
					if(oneBrown.equalsIgnoreCase("yes") && oneMoney > 50){
						oneBrownHouse1++;
						oneMoney = oneMoney - 50;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBrownHouse1 + " house(s) on this property");
					}
					else if(oneBrown.equalsIgnoreCase("yes") && oneMoney <= 50){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBrownHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 3 && oneBrownAve[1] == true){
				if(oneBrownHouse2 >= 0 && oneBrownHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 50? (yes / no)");
					oneBrown = oneBrownScan.nextLine();
					
					if(oneBrown.equalsIgnoreCase("yes") && oneMoney > 50){
						oneBrownHouse2++;
						oneMoney = oneMoney - 50;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBrownHouse2 + " house(s) on this property");
					}
					else if(oneBrown.equalsIgnoreCase("yes") && oneMoney <= 50){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBrownHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 1 && twoBrownAve[0] == false && oneBrownAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Brown Ave. for 60? (yes / no)");
				oneBrown = oneBrownScan.nextLine();
				
				if(oneBrown.equalsIgnoreCase("yes") && oneMoney > 60){
					oneMoney = oneMoney - 60;
					oneBrownAve[0] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneBrown.equalsIgnoreCase("yes") && oneMoney <= 60){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 3 && twoBrownAve[1] == false && oneBrownAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Brown Ave. for 60? (yes / no)");
				oneBrown = oneBrownScan.nextLine();
				
				if(oneBrown.equalsIgnoreCase("yes") && oneMoney > 60){
					oneMoney = oneMoney - 60;
					oneBrownAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneBrown.equalsIgnoreCase("yes") && oneMoney <= 60){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 1 && twoBrownAve[0] == true){
					if(twoBrownHouse1 == 0){
						System.out.println("Player 1 pays 4 to player 2");
						oneMoney = oneMoney - 4;
						twoMoney = twoMoney + 4;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse1 == 1){
						System.out.println("Player 1 pays 20 to player 2");
						oneMoney = oneMoney - 20;
						twoMoney = twoMoney + 20;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse1 == 2){
						System.out.println("Player 1 pays 60 to player 2");
						oneMoney = oneMoney - 60;
						twoMoney = twoMoney + 60;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse1 == 3){
						System.out.println("Player 1 pays 180 to player 2");
						oneMoney = oneMoney - 180;
						twoMoney = twoMoney + 180;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse1 == 4){
						System.out.println("Player 1 pays 320 to player 2");
						oneMoney = oneMoney - 320;
						twoMoney = twoMoney + 320;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 3 && twoBrownAve[1] == true){
					if(twoBrownHouse2 == 0){
						System.out.println("Player 1 pays 4 to player 2");
						oneMoney = oneMoney - 4;
						twoMoney = twoMoney + 4;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse2 == 1){
						System.out.println("Player 1 pays 20 to player 2");
						oneMoney = oneMoney - 20;
						twoMoney = twoMoney + 20;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse2 == 2){
						System.out.println("Player 1 pays 60 to player 2");
						oneMoney = oneMoney - 60;
						twoMoney = twoMoney + 60;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse2 == 3){
						System.out.println("Player 1 pays 180 to player 2");
						oneMoney = oneMoney - 180;
						twoMoney = twoMoney + 180;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBrownHouse2 == 4){
						System.out.println("Player 1 pays 320 to player 2");
						oneMoney = oneMoney - 320;
						twoMoney = twoMoney + 320;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		else if(countMove6 % 2 == 1){
			
			if(twoTotWalk == 1 && twoBrownAve[0] == true){
				if(twoBrownHouse1 >= 0 && twoBrownHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 50?  (yes / no)");
					twoBrown = twoBrownScan.nextLine();
					
					if(twoBrown.equalsIgnoreCase("yes") && twoMoney > 50){
						twoBrownHouse1++;
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBrownHouse1 + " house(s) on this property");
					}
					else if(twoBrown.equalsIgnoreCase("yes") && twoMoney <= 50){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBrownHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 3 && twoBrownAve[1] == true){
				if(twoBrownHouse2 >= 0 && twoBrownHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 50?  (yes / no)");
					twoBrown = twoBrownScan.nextLine();
					
					if(twoBrown.equalsIgnoreCase("yes") && twoMoney > 50){
						twoBrownHouse2++;
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBrownHouse2 + " house(s) on this property");
					}
					else if(twoBrown.equalsIgnoreCase("yes") && twoMoney <= 50){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBrownHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 1 && oneBrownAve[0] == false && twoBrownAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Brown Ave. for 60?  (yes / no)");
				twoBrown = twoBrownScan.nextLine();
				
				if(twoBrown.equalsIgnoreCase("yes") && twoMoney > 60){
					twoMoney = twoMoney - 60;
					twoBrownAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBrown.equalsIgnoreCase("yes") && twoMoney <= 60){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 3 && oneBrownAve[1] == false && twoBrownAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Brown Ave. for 60? (yes / no)");
				twoBrown = twoBrownScan.nextLine();
				
				if(twoBrown.equalsIgnoreCase("yes") && twoMoney > 60){
					twoMoney = twoMoney - 60;
					twoBrownAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBrown.equalsIgnoreCase("yes") && twoMoney <= 60){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 1 && oneBrownAve[0] == true){
					if(oneBrownHouse1 == 0){
						System.out.println("Player 2 pays 4 to player 1");
						twoMoney = twoMoney - 4;
						oneMoney = oneMoney + 4;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse1 == 1){
						System.out.println("Player 2 pays 20 to player 1");
						twoMoney = twoMoney - 20;
						oneMoney = oneMoney + 20;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse1 == 2){
						System.out.println("Player 2 pays 60 to player 1");
						twoMoney = twoMoney - 60;
						oneMoney = oneMoney + 60;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse1 == 3){
						System.out.println("Player 2 pays 180 to player 1");
						twoMoney = twoMoney - 180;
						oneMoney = oneMoney + 180;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse1 == 4){
						System.out.println("Player 2 pays 320 to player 1");
						twoMoney = twoMoney - 320;
						oneMoney = oneMoney + 320;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 3 && oneBrownAve[1] == true){
					if(oneBrownHouse2 == 0){
						System.out.println("Player 2 pays 4 to player 1");
						twoMoney = twoMoney - 4;
						oneMoney = oneMoney + 4;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse2 == 1){
						System.out.println("Player 2 pays 20 to player 1");
						twoMoney = twoMoney - 20;
						oneMoney = oneMoney + 20;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse2 == 2){
						System.out.println("Player 2 pays 60 to player 1");
						twoMoney = twoMoney - 60;
						oneMoney = oneMoney + 60;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse2 == 3){
						System.out.println("Player 2 pays 180 to player 1");
						twoMoney = twoMoney - 180;
						oneMoney = oneMoney + 180;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBrownHouse2 == 4){
						System.out.println("Player 2 pays 320 to player 1");
						twoMoney = twoMoney - 320;
						oneMoney = oneMoney + 320;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}			
		}
	}
	
	//When player lands on any of the 3 baby blue Ave. execute this method
	public static void babyAve(int countMove7){
		countMove7 = count;
		String oneBaby;
		String twoBaby;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove7 % 2 == 0){
			if(oneTotWalk == 6 && oneBabyAve[0] == true){
				if(oneBabyHouse1 >= 0 && oneBabyHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 50? (yes / no)");
					oneBaby = oneBabyScan.nextLine();
					
					if(oneBaby.equalsIgnoreCase("yes") && oneMoney > 50){
						oneBrownHouse1++;
						oneMoney = oneMoney - 50;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBabyHouse1 + " house(s) on this property");
					}
					else if(oneBaby.equalsIgnoreCase("yes") && oneMoney <= 50){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBabyHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 8 && oneBabyAve[1] == true){
				if(oneBabyHouse2 >= 0 && oneBabyHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 50? (yes / no)");
					oneBaby = oneBabyScan.nextLine();
					
					if(oneBaby.equalsIgnoreCase("yes") && oneMoney > 50){
						oneBabyHouse2++;
						oneMoney = oneMoney - 50;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBabyHouse2 + " house(s) on this property");
					}
					else if(oneBaby.equalsIgnoreCase("yes") && oneMoney <= 50){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBabyHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 9 && oneBabyAve[2] == true){
				if(oneBabyHouse3 >= 0 && oneBabyHouse3 < 4){
					System.out.println("Does player 1 wish to purchase a house with 50? (yes / no)");
					oneBaby = oneBabyScan.nextLine();
					
					if(oneBaby.equalsIgnoreCase("yes") && oneMoney > 50){
						oneBabyHouse3++;
						oneMoney = oneMoney - 50;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBabyHouse3 + " house(s) on this property");
					}
					else if(oneBaby.equalsIgnoreCase("yes") && oneMoney <= 50){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBabyHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 6 && twoBabyAve[0] == false && oneBabyAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Baby Blue Ave. for 100? (yes / no)");
				oneBaby = oneBabyScan.nextLine();
				
				if(oneBaby.equalsIgnoreCase("yes") && oneMoney > 100){
					oneMoney = oneMoney - 100;
					oneBabyAve[0] = true;
					System.out.println("Player 1 now owns 1st Baby Blue Ave. with an extra of " + oneMoney);
				}
				else if(oneBaby.equalsIgnoreCase("yes") && oneMoney <= 100){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 8 && twoBabyAve[1] == false && oneBabyAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Baby Ave. for 100? (yes / no)");
				oneBaby = oneBabyScan.nextLine();
				
				if(oneBaby.equalsIgnoreCase("yes") && oneMoney > 100){
					oneMoney = oneMoney - 100;
					oneBabyAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneBaby.equalsIgnoreCase("yes") && oneMoney <= 100){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 9 && twoBabyAve[2] == false && oneBabyAve[2] == false){
				System.out.println("Does player 1 wish to purchase 3rd Baby Ave. for 100? (yes / no)");
				oneBaby = oneBabyScan.nextLine();
				
				if(oneBaby.equalsIgnoreCase("yes") && oneMoney > 100){
					oneMoney = oneMoney - 100;
					oneBabyAve[2] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneBaby.equalsIgnoreCase("yes") && oneMoney <= 100){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 6 && twoBabyAve[0] == true){
					if(twoBabyHouse1 == 0){
						System.out.println("Player 1 pays 6 to player 2");
						oneMoney = oneMoney - 6;
						twoMoney = twoMoney + 6;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse1 == 1){
						System.out.println("Player 1 pays 30 to player 2");
						oneMoney = oneMoney - 30;
						twoMoney = twoMoney + 30;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse1 == 2){
						System.out.println("Player 1 pays 90 to player 2");
						oneMoney = oneMoney - 90;
						twoMoney = twoMoney + 90;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse1 == 3){
						System.out.println("Player 1 pays 270 to player 2");
						oneMoney = oneMoney - 270;
						twoMoney = twoMoney + 270;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse1 == 4){
						System.out.println("Player 1 pays 400 to player 2");
						oneMoney = oneMoney - 400;
						twoMoney = twoMoney + 400;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 8 && twoBabyAve[1] == true){
					if(twoBabyHouse2 == 0){
						System.out.println("Player 1 pays 6 to player 2");
						oneMoney = oneMoney - 6;
						twoMoney = twoMoney + 6;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse2 == 1){
						System.out.println("Player 1 pays 30 to player 2");
						oneMoney = oneMoney - 30;
						twoMoney = twoMoney + 30;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse2 == 2){
						System.out.println("Player 1 pays 90 to player 2");
						oneMoney = oneMoney - 90;
						twoMoney = twoMoney + 90;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse2 == 3){
						System.out.println("Player 1 pays 270 to player 2");
						oneMoney = oneMoney - 270;
						twoMoney = twoMoney + 270;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse2 == 4){
						System.out.println("Player 1 pays 400 to player 2");
						oneMoney = oneMoney - 400;
						twoMoney = twoMoney + 400;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 9 && twoBabyAve[2] == true){
					if(twoBabyHouse3 == 0){
						System.out.println("Player 1 pays 6 to player 2");
						oneMoney = oneMoney - 6;
						twoMoney = twoMoney + 6;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse3 == 1){
						System.out.println("Player 1 pays 30 to player 2");
						oneMoney = oneMoney - 30;
						twoMoney = twoMoney + 30;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse3 == 2){
						System.out.println("Player 1 pays 90 to player 2");
						oneMoney = oneMoney - 90;
						twoMoney = twoMoney + 90;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse3 == 3){
						System.out.println("Player 1 pays 270 to player 2");
						oneMoney = oneMoney - 270;
						twoMoney = twoMoney + 270;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBabyHouse3 == 4){
						System.out.println("Player 1 pays 400 to player 2");
						oneMoney = oneMoney - 400;
						twoMoney = twoMoney + 400;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		else if(countMove7 % 2 == 1){
			if(twoTotWalk == 6 && twoBabyAve[0] == true){
				if(twoBabyHouse1 >= 0 && twoBabyHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 50?  (yes / no)");
					twoBaby = twoBabyScan.nextLine();
					
					if(twoBaby.equalsIgnoreCase("yes") && twoMoney > 50){
						twoBabyHouse1++;
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBabyHouse1 + " house(s) on this property");
					}
					else if(twoBaby.equalsIgnoreCase("yes") && twoMoney <= 50){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBabyHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 8 && twoBabyAve[1] == true){
				if(twoBabyHouse2 >= 0 && twoBabyHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 50?  (yes / no)");
					twoBaby = twoBabyScan.nextLine();
					
					if(twoBaby.equalsIgnoreCase("yes") && twoMoney > 50){
						twoBabyHouse2++;
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBabyHouse2 + " house(s) on this property");
					}
					else if(twoBaby.equalsIgnoreCase("yes") && twoMoney <= 50){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBabyHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 9 && twoBabyAve[2] == true){
				if(twoBabyHouse3 >= 0 && twoBabyHouse3 < 4){
					System.out.println("Does player 2 wish to purchase a house with 50?  (yes / no)");
					twoBaby = twoBabyScan.nextLine();
					
					if(twoBaby.equalsIgnoreCase("yes") && twoMoney > 50){
						twoBabyHouse3++;
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBabyHouse3 + " house(s) on this property");
					}
					else if(twoBaby.equalsIgnoreCase("yes") && twoMoney <= 50){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBabyHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 6 && oneBabyAve[0] == false && twoBabyAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Baby Blue Ave. for 100?  (yes / no)");
				twoBaby = twoBabyScan.nextLine();
				
				if(twoBaby.equalsIgnoreCase("yes") && twoMoney > 100){
					twoMoney = twoMoney - 100;
					twoBabyAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBaby.equalsIgnoreCase("yes") && twoMoney <= 100){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 8 && oneBabyAve[1] == false && twoBabyAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Baby Blue Ave. for 100? (yes / no)");
				twoBaby = twoBabyScan.nextLine();
				
				if(twoBaby.equalsIgnoreCase("yes") && twoMoney > 100){
					twoMoney = twoMoney - 100;
					twoBabyAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBaby.equalsIgnoreCase("yes") && twoMoney <= 100){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 9 && oneBabyAve[2] == false && twoBabyAve[2] == false){
				System.out.println("Does player 2 wish to purchase 3rd Baby Blue Ave. for 100? (yes / no)");
				twoBaby = twoBabyScan.nextLine();
				
				if(twoBaby.equalsIgnoreCase("yes") && twoMoney > 100){
					twoMoney = twoMoney - 100;
					twoBabyAve[2] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBaby.equalsIgnoreCase("yes") && twoMoney <= 100){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 6 && oneBabyAve[0] == true){
					if(oneBabyHouse1 == 0){
						System.out.println("Player 2 pays 6 to player 1");
						twoMoney = twoMoney - 6;
						oneMoney = oneMoney + 6;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse1 == 1){
						System.out.println("Player 2 pays 30 to player 1");
						twoMoney = twoMoney - 30;
						oneMoney = oneMoney + 30;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse1 == 2){
						System.out.println("Player 2 pays 90 to player 1");
						twoMoney = twoMoney - 90;
						oneMoney = oneMoney + 90;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse1 == 3){
						System.out.println("Player 2 pays 270 to player 1");
						twoMoney = twoMoney - 270;
						oneMoney = oneMoney + 270;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse1 == 4){
						System.out.println("Player 2 pays 400 to player 1");
						twoMoney = twoMoney - 400;
						oneMoney = oneMoney + 400;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 8 && oneBabyAve[1] == true){
					if(oneBabyHouse2 == 0){
						System.out.println("Player 2 pays 6 to player 1");
						twoMoney = twoMoney - 6;
						oneMoney = oneMoney + 6;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse2 == 1){
						System.out.println("Player 2 pays 30 to player 1");
						twoMoney = twoMoney - 30;
						oneMoney = oneMoney + 30;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse2 == 2){
						System.out.println("Player 2 pays 90 to player 1");
						twoMoney = twoMoney - 90;
						oneMoney = oneMoney + 90;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse2 == 3){
						System.out.println("Player 2 pays 270 to player 1");
						twoMoney = twoMoney - 270;
						oneMoney = oneMoney + 270;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse2 == 4){
						System.out.println("Player 2 pays 400 to player 1");
						twoMoney = twoMoney - 400;
						oneMoney = oneMoney + 400;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 9 && oneBabyAve[2] == true){
					if(oneBabyHouse3 == 0){
						System.out.println("Player 2 pays 6 to player 1");
						twoMoney = twoMoney - 6;
						oneMoney = oneMoney + 6;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse3 == 1){
						System.out.println("Player 2 pays 30 to player 1");
						twoMoney = twoMoney - 30;
						oneMoney = oneMoney + 30;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse3 == 2){
						System.out.println("Player 2 pays 90 to player 1");
						twoMoney = twoMoney - 90;
						oneMoney = oneMoney + 90;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse3 == 3){
						System.out.println("Player 2 pays 270 to player 1");
						twoMoney = twoMoney - 270;
						oneMoney = oneMoney + 270;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneBabyHouse3 == 4){
						System.out.println("Player 2 pays 400 to player 1");
						twoMoney = twoMoney - 400;
						oneMoney = oneMoney + 400;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}		
		}
	}
	
	//When player lands on any of the 3 pink Ave. execute this method
	public static void pinkAve(int countMove8){
		countMove8 = count;
		String onePink;
		String twoPink;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove8 % 2 == 0){
			if(oneTotWalk == 11 && onePinkAve[0] == true){
				if(onePinkHouse1 >= 0 && onePinkHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 100? (yes / no)");
					onePink = onePinkScan.nextLine();
					
					if(onePink.equalsIgnoreCase("yes") && oneMoney > 100){
						onePinkHouse1++;
						oneMoney = oneMoney - 100;
						System.out.println("Player 1 has " + oneMoney + " and " + onePinkHouse1 + " house(s) on this property");
					}
					else if(onePink.equalsIgnoreCase("yes") && oneMoney <= 100){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(onePinkHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 13 && onePinkAve[1] == true){
				if(onePinkHouse2 >= 0 && onePinkHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 100? (yes / no)");
					onePink = onePinkScan.nextLine();
					
					if(onePink.equalsIgnoreCase("yes") && oneMoney > 100){
						onePinkHouse2++;
						oneMoney = oneMoney - 100;
						System.out.println("Player 1 has " + oneMoney + " and " + onePinkHouse2 + " house(s) on this property");
					}
					else if(onePink.equalsIgnoreCase("yes") && oneMoney <= 100){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(onePinkHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 14 && onePinkAve[2] == true){
				if(onePinkHouse3 >= 0 && onePinkHouse3 < 4){
					System.out.println("Does player 1 wish to purchase a house with 100? (yes / no)");
					onePink = onePinkScan.nextLine();
					
					if(onePink.equalsIgnoreCase("yes") && oneMoney > 100){
						onePinkHouse3++;
						oneMoney = oneMoney - 100;
						System.out.println("Player 1 has " + oneMoney + " and " + onePinkHouse3 + " house(s) on this property");
					}
					else if(onePink.equalsIgnoreCase("yes") && oneMoney <= 100){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(onePinkHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 11 && twoPinkAve[0] == false && onePinkAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Pink Ave. for 140? (yes / no)");
				onePink = onePinkScan.nextLine();
				
				if(onePink.equalsIgnoreCase("yes") && oneMoney > 140){
					oneMoney = oneMoney - 140;
					onePinkAve[0] = true;
					System.out.println("Player 1 now owns 1st Pink Ave. with an extra of " + oneMoney);
				}
				else if(onePink.equalsIgnoreCase("yes") && oneMoney <= 140){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 13 && twoBabyAve[1] == false && oneBabyAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Pink Ave. for 140? (yes / no)");
				onePink = onePinkScan.nextLine();
				
				if(onePink.equalsIgnoreCase("yes") && oneMoney > 140){
					oneMoney = oneMoney - 140;
					onePinkAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(onePink.equalsIgnoreCase("yes") && oneMoney <= 140){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 14 && twoPinkAve[2] == false && onePinkAve[2] == false){
				System.out.println("Does player 1 wish to purchase 3rd Pink Ave. for 140? (yes / no)");
				onePink = onePinkScan.nextLine();
				
				if(onePink.equalsIgnoreCase("yes") && oneMoney > 140){
					oneMoney = oneMoney - 140;
					onePinkAve[2] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(onePink.equalsIgnoreCase("yes") && oneMoney <= 140){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 11 && twoPinkAve[0] == true){
					if(twoPinkHouse1 == 0){
						System.out.println("Player 1 pays 10 to player 2");
						oneMoney = oneMoney - 10;
						twoMoney = twoMoney + 10;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse1 == 1){
						System.out.println("Player 1 pays 50 to player 2");
						oneMoney = oneMoney - 50;
						twoMoney = twoMoney + 50;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse1 == 2){
						System.out.println("Player 1 pays 150 to player 2");
						oneMoney = oneMoney - 150;
						twoMoney = twoMoney + 150;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse1 == 3){
						System.out.println("Player 1 pays 450 to player 2");
						oneMoney = oneMoney - 450;
						twoMoney = twoMoney + 450;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse1 == 4){
						System.out.println("Player 1 pays 625 to player 2");
						oneMoney = oneMoney - 625;
						twoMoney = twoMoney + 625;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 13 && twoPinkAve[1] == true){
					if(twoPinkHouse2 == 0){
						System.out.println("Player 1 pays 10 to player 2");
						oneMoney = oneMoney - 10;
						twoMoney = twoMoney + 10;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse2 == 1){
						System.out.println("Player 1 pays 50 to player 2");
						oneMoney = oneMoney - 50;
						twoMoney = twoMoney + 50;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse2 == 2){
						System.out.println("Player 1 pays 150 to player 2");
						oneMoney = oneMoney - 150;
						twoMoney = twoMoney + 150;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse2 == 3){
						System.out.println("Player 1 pays 450 to player 2");
						oneMoney = oneMoney - 450;
						twoMoney = twoMoney + 450;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse2 == 4){
						System.out.println("Player 1 pays 625 to player 2");
						oneMoney = oneMoney - 625;
						twoMoney = twoMoney + 625;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 14 && twoPinkAve[2] == true){
					if(twoPinkHouse3 == 0){
						System.out.println("Player 1 pays 10 to player 2");
						oneMoney = oneMoney - 10;
						twoMoney = twoMoney + 10;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse3 == 1){
						System.out.println("Player 1 pays 50 to player 2");
						oneMoney = oneMoney - 50;
						twoMoney = twoMoney + 50;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse3 == 2){
						System.out.println("Player 1 pays 150 to player 2");
						oneMoney = oneMoney - 150;
						twoMoney = twoMoney + 150;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse3 == 3){
						System.out.println("Player 1 pays 450 to player 2");
						oneMoney = oneMoney - 450;
						twoMoney = twoMoney + 450;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoPinkHouse3 == 4){
						System.out.println("Player 1 pays 625 to player 2");
						oneMoney = oneMoney - 625;
						twoMoney = twoMoney + 625;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		
		else if(countMove8 % 2 == 1){
			if(twoTotWalk == 11 && twoPinkAve[0] == true){
				if(twoPinkHouse1 >= 0 && twoPinkHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 100?  (yes / no)");
					twoPink = twoPinkScan.nextLine();
					
					if(twoPink.equalsIgnoreCase("yes") && twoMoney > 100){
						twoPinkHouse1++;
						twoMoney = twoMoney - 100;
						System.out.println("Player 2 has " + twoMoney + " and " + twoPinkHouse1 + " house(s) on this property");
					}
					else if(twoPink.equalsIgnoreCase("yes") && twoMoney <= 100){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoPinkHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 13 && twoPinkAve[1] == true){
				if(twoPinkHouse2 >= 0 && twoPinkHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 100?  (yes / no)");
					twoPink = twoPinkScan.nextLine();
					
					if(twoPink.equalsIgnoreCase("yes") && twoMoney > 100){
						twoPinkHouse2++;
						twoMoney = twoMoney - 100;
						System.out.println("Player 2 has " + twoMoney + " and " + twoPinkHouse2 + " house(s) on this property");
					}
					else if(twoPink.equalsIgnoreCase("yes") && twoMoney <= 100){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoPinkHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 14 && twoPinkAve[2] == true){
				if(twoPinkHouse3 >= 0 && twoPinkHouse3 < 4){
					System.out.println("Does player 2 wish to purchase a house with 100?  (yes / no)");
					twoPink = twoPinkScan.nextLine();
					
					if(twoPink.equalsIgnoreCase("yes") && twoMoney > 100){
						twoPinkHouse3++;
						twoMoney = twoMoney - 100;
						System.out.println("Player 2 has " + twoMoney + " and " + twoPinkHouse3 + " house(s) on this property");
					}
					else if(twoPink.equalsIgnoreCase("yes") && twoMoney <= 100){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoPinkHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 11 && onePinkAve[0] == false && twoPinkAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Pink Ave. for 140?  (yes / no)");
				twoPink = twoPinkScan.nextLine();
				
				if(twoPink.equalsIgnoreCase("yes") && twoMoney > 140){
					twoMoney = twoMoney - 140;
					twoPinkAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoPink.equalsIgnoreCase("yes") && twoMoney <= 140){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 13 && onePinkAve[1] == false && twoPinkAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Pink Ave. for 140? (yes / no)");
				twoPink = twoPinkScan.nextLine();
				
				if(twoPink.equalsIgnoreCase("yes") && twoMoney > 140){
					twoMoney = twoMoney - 140;
					twoPinkAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoPink.equalsIgnoreCase("yes") && twoMoney <= 140){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 14 && onePinkAve[2] == false && twoPinkAve[2] == false){
				System.out.println("Does player 2 wish to purchase 3rd Pink Ave. for 140? (yes / no)");
				twoPink = twoPinkScan.nextLine();
				
				if(twoPink.equalsIgnoreCase("yes") && twoMoney > 140){
					twoMoney = twoMoney - 140;
					twoPinkAve[2] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoPink.equalsIgnoreCase("yes") && twoMoney <= 140){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 11 && onePinkAve[0] == true){
					if(onePinkHouse1 == 0){
						System.out.println("Player 2 pays 10 to player 1");
						twoMoney = twoMoney - 10;
						oneMoney = oneMoney + 10;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse1 == 1){
						System.out.println("Player 2 pays 50 to player 1");
						twoMoney = twoMoney - 50;
						oneMoney = oneMoney + 50;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse1 == 2){
						System.out.println("Player 2 pays 150 to player 1");
						twoMoney = twoMoney - 150;
						oneMoney = oneMoney + 150;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse1 == 3){
						System.out.println("Player 2 pays 450 to player 1");
						twoMoney = twoMoney - 450;
						oneMoney = oneMoney + 450;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse1 == 4){
						System.out.println("Player 2 pays 625 to player 1");
						twoMoney = twoMoney - 625;
						oneMoney = oneMoney + 625;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 13 && onePinkAve[1] == true){
					if(onePinkHouse2 == 0){
						System.out.println("Player 2 pays 10 to player 1");
						twoMoney = twoMoney - 10;
						oneMoney = oneMoney + 10;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse2 == 1){
						System.out.println("Player 2 pays 50 to player 1");
						twoMoney = twoMoney - 50;
						oneMoney = oneMoney + 50;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse2 == 2){
						System.out.println("Player 2 pays 150 to player 1");
						twoMoney = twoMoney - 150;
						oneMoney = oneMoney + 150;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse2 == 3){
						System.out.println("Player 2 pays 450 to player 1");
						twoMoney = twoMoney - 450;
						oneMoney = oneMoney + 450;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse2 == 4){
						System.out.println("Player 2 pays 625 to player 1");
						twoMoney = twoMoney - 625;
						oneMoney = oneMoney + 625;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 14 && onePinkAve[2] == true){
					if(onePinkHouse3 == 0){
						System.out.println("Player 2 pays 10 to player 1");
						twoMoney = twoMoney - 10;
						oneMoney = oneMoney + 10;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse3 == 1){
						System.out.println("Player 2 pays 50 to player 1");
						twoMoney = twoMoney - 50;
						oneMoney = oneMoney + 50;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse3 == 2){
						System.out.println("Player 2 pays 150 to player 1");
						twoMoney = twoMoney - 150;
						oneMoney = oneMoney + 150;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse3 == 3){
						System.out.println("Player 2 pays 450 to player 1");
						twoMoney = twoMoney - 450;
						oneMoney = oneMoney + 450;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(onePinkHouse3 == 4){
						System.out.println("Player 2 pays 625 to player 1");
						twoMoney = twoMoney - 625;
						oneMoney = oneMoney + 625;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}
		}
	}
	
	//When player lands on any of the 3 orange Ave. execute this method
	public static void orangeAve(int countMove9){
		countMove9 = count;
		String oneOrange;
		String twoOrange;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove9 % 2 == 0){
			if(oneTotWalk == 16 && oneOrangeAve[0] == true){
				if(oneOrangeHouse1 >= 0 && oneOrangeHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 100? (yes / no)");
					oneOrange = oneOrangeScan.nextLine();
					
					if(oneOrange.equalsIgnoreCase("yes") && oneMoney > 100){
						oneOrangeHouse1++;
						oneMoney = oneMoney - 100;
						System.out.println("Player 1 has " + oneMoney + " and " + oneOrangeHouse1 + " house(s) on this property");
					}
					else if(oneOrange.equalsIgnoreCase("yes") && oneMoney <= 100){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneOrangeHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 18 && oneOrangeAve[1] == true){
				if(oneOrangeHouse2 >= 0 && oneOrangeHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 100? (yes / no)");
					oneOrange = oneOrangeScan.nextLine();
					
					if(oneOrange.equalsIgnoreCase("yes") && oneMoney > 100){
						oneOrangeHouse2++;
						oneMoney = oneMoney - 100;
						System.out.println("Player 1 has " + oneMoney + " and " + oneOrangeHouse2 + " house(s) on this property");
					}
					else if(oneOrange.equalsIgnoreCase("yes") && oneMoney <= 100){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneOrangeHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 19 && oneOrangeAve[2] == true){
				if(oneOrangeHouse3 >= 0 && oneOrangeHouse3 < 4){
					System.out.println("Does player 1 wish to purchase a house with 100? (yes / no)");
					oneOrange = oneOrangeScan.nextLine();
					
					if(oneOrange.equalsIgnoreCase("yes") && oneMoney > 100){
						oneOrangeHouse3++;
						oneMoney = oneMoney - 100;
						System.out.println("Player 1 has " + oneMoney + " and " + oneOrangeHouse3 + " house(s) on this property");
					}
					else if(oneOrange.equalsIgnoreCase("yes") && oneMoney <= 100){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneOrangeHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 16 && twoOrangeAve[0] == false && oneOrangeAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Orange Ave. for 180? (yes / no)");
				oneOrange = oneOrangeScan.nextLine();
				
				if(oneOrange.equalsIgnoreCase("yes") && oneMoney > 180){
					oneMoney = oneMoney - 180;
					oneOrangeAve[0] = true;
					System.out.println("Player 1 now owns 1st Orange Ave. with an extra of " + oneMoney);
				}
				else if(oneOrange.equalsIgnoreCase("yes") && oneMoney <= 180){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 18 && twoOrangeAve[1] == false && oneOrangeAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Orange Ave. for 180? (yes / no)");
				oneOrange = oneOrangeScan.nextLine();
				
				if(oneOrange.equalsIgnoreCase("yes") && oneMoney > 180){
					oneMoney = oneMoney - 180;
					oneOrangeAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneOrange.equalsIgnoreCase("yes") && oneMoney <= 180){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 19 && twoOrangeAve[2] == false && oneOrangeAve[2] == false){
				System.out.println("Does player 1 wish to purchase 3rd Orange Ave. for 180? (yes / no)");
				oneOrange = oneOrangeScan.nextLine();
				
				if(oneOrange.equalsIgnoreCase("yes") && oneMoney > 180){
					oneMoney = oneMoney - 180;
					oneOrangeAve[2] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneOrange.equalsIgnoreCase("yes") && oneMoney <= 180){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 16 && twoOrangeAve[0] == true){
					if(twoOrangeHouse1 == 0){
						System.out.println("Player 1 pays 14 to player 2");
						oneMoney = oneMoney - 14;
						twoMoney = twoMoney + 14;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse1 == 1){
						System.out.println("Player 1 pays 70 to player 2");
						oneMoney = oneMoney - 70;
						twoMoney = twoMoney + 70;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse1 == 2){
						System.out.println("Player 2 pays 200 to player 1");
						oneMoney = oneMoney - 200;
						twoMoney = twoMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse1 == 3){
						System.out.println("Player 1 pays 550 to player 2");
						oneMoney = oneMoney - 550;
						twoMoney = twoMoney + 550;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse1 == 4){
						System.out.println("Player 2 pays 725 to player 1");
						oneMoney = oneMoney - 725;
						twoMoney = twoMoney + 725;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 18 && twoOrangeAve[1] == true){
					if(twoOrangeHouse2 == 0){
						System.out.println("Player 1 pays 14 to player 2");
						oneMoney = oneMoney - 14;
						twoMoney = twoMoney + 14;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse2 == 1){
						System.out.println("Player 1 pays 70 to player 2");
						oneMoney = oneMoney - 70;
						twoMoney = twoMoney + 70;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse2 == 2){
						System.out.println("Player 2 pays 200 to player 1");
						oneMoney = oneMoney - 200;
						twoMoney = twoMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse2 == 3){
						System.out.println("Player 1 pays 550 to player 2");
						oneMoney = oneMoney - 550;
						twoMoney = twoMoney + 550;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse2 == 4){
						System.out.println("Player 2 pays 725 to player 1");
						oneMoney = oneMoney - 725;
						twoMoney = twoMoney + 725;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 19 && twoOrangeAve[2] == true){
					if(twoOrangeHouse3 == 0){
						System.out.println("Player 1 pays 14 to player 2");
						oneMoney = oneMoney - 14;
						twoMoney = twoMoney + 14;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse3 == 1){
						System.out.println("Player 1 pays 70 to player 2");
						oneMoney = oneMoney - 70;
						twoMoney = twoMoney + 70;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse3 == 2){
						System.out.println("Player 2 pays 200 to player 1");
						oneMoney = oneMoney - 200;
						twoMoney = twoMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse3 == 3){
						System.out.println("Player 1 pays 550 to player 2");
						oneMoney = oneMoney - 550;
						twoMoney = twoMoney + 550;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoOrangeHouse3 == 4){
						System.out.println("Player 2 pays 725 to player 1");
						oneMoney = oneMoney - 725;
						twoMoney = twoMoney + 725;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		
		else if(countMove9 % 2 == 1){
			if(twoTotWalk == 16 && twoOrangeAve[0] == true){
				if(twoOrangeHouse1 >= 0 && twoOrangeHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 100?  (yes / no)");
					twoOrange = twoOrangeScan.nextLine();
					
					if(twoOrange.equalsIgnoreCase("yes") && twoMoney > 100){
						twoOrangeHouse1++;
						twoMoney = twoMoney - 100;
						System.out.println("Player 2 has " + twoMoney + " and " + twoOrangeHouse1 + " house(s) on this property");
					}
					else if(twoOrange.equalsIgnoreCase("yes") && twoMoney <= 100){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoOrangeHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 18 && twoOrangeAve[1] == true){
				if(twoOrangeHouse2 >= 0 && twoOrangeHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 100?  (yes / no)");
					twoOrange = twoOrangeScan.nextLine();
					
					if(twoOrange.equalsIgnoreCase("yes") && twoMoney > 100){
						twoOrangeHouse2++;
						twoMoney = twoMoney - 100;
						System.out.println("Player 2 has " + twoMoney + " and " + twoOrangeHouse2 + " house(s) on this property");
					}
					else if(twoOrange.equalsIgnoreCase("yes") && twoMoney <= 100){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoOrangeHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 19 && twoOrangeAve[2] == true){
				if(twoOrangeHouse3 >= 0 && twoOrangeHouse3 < 4){
					System.out.println("Does player 2 wish to purchase a house with 100?  (yes / no)");
					twoOrange = twoOrangeScan.nextLine();
					
					if(twoOrange.equalsIgnoreCase("yes") && twoMoney > 100){
						twoOrangeHouse3++;
						twoMoney = twoMoney - 100;
						System.out.println("Player 2 has " + twoMoney + " and " + twoOrangeHouse3 + " house(s) on this property");
					}
					else if(twoOrange.equalsIgnoreCase("yes") && twoMoney <= 100){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoOrangeHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 16 && oneOrangeAve[0] == false && twoOrangeAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Orange Ave. for 180?  (yes / no)");
				twoOrange = twoOrangeScan.nextLine();
				
				if(twoOrange.equalsIgnoreCase("yes") && twoMoney > 180){
					twoMoney = twoMoney - 180;
					twoOrangeAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoOrange.equalsIgnoreCase("yes") && twoMoney <= 180){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 18 && oneOrangeAve[1] == false && twoOrangeAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Orange Ave. for 180? (yes / no)");
				twoOrange = twoOrangeScan.nextLine();
				
				if(twoOrange.equalsIgnoreCase("yes") && twoMoney > 180){
					twoMoney = twoMoney - 180;
					twoOrangeAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoOrange.equalsIgnoreCase("yes") && twoMoney <= 180){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 19 && oneOrangeAve[2] == false && twoOrangeAve[2] == false){
				System.out.println("Does player 2 wish to purchase 3rd Orange Ave. for 180? (yes / no)");
				twoOrange = twoOrangeScan.nextLine();
				
				if(twoOrange.equalsIgnoreCase("yes") && twoMoney > 180){
					twoMoney = twoMoney - 180;
					twoOrangeAve[2] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoOrange.equalsIgnoreCase("yes") && twoMoney <= 180){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 16 && oneOrangeAve[0] == true){
					if(oneOrangeHouse1 == 0){
						System.out.println("Player 2 pays 14 to player 1");
						twoMoney = twoMoney - 14;
						oneMoney = oneMoney + 14;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse1 == 1){
						System.out.println("Player 2 pays 70 to player 1");
						twoMoney = twoMoney - 70;
						oneMoney = oneMoney + 70;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse1 == 2){
						System.out.println("Player 2 pays 200 to player 1");
						twoMoney = twoMoney - 200;
						oneMoney = oneMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse1 == 3){
						System.out.println("Player 2 pays 550 to player 1");
						twoMoney = twoMoney - 550;
						oneMoney = oneMoney + 550;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse1 == 4){
						System.out.println("Player 2 pays 725 to player 1");
						twoMoney = twoMoney - 725;
						oneMoney = oneMoney + 725;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 18 && oneOrangeAve[1] == true){
					if(oneOrangeHouse2 == 0){
						System.out.println("Player 2 pays 14 to player 1");
						twoMoney = twoMoney - 14;
						oneMoney = oneMoney + 14;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse2 == 1){
						System.out.println("Player 2 pays 70 to player 1");
						twoMoney = twoMoney - 70;
						oneMoney = oneMoney + 70;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse2 == 2){
						System.out.println("Player 2 pays 200 to player 1");
						twoMoney = twoMoney - 200;
						oneMoney = oneMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse2 == 3){
						System.out.println("Player 2 pays 550 to player 1");
						twoMoney = twoMoney - 550;
						oneMoney = oneMoney + 550;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse2 == 4){
						System.out.println("Player 2 pays 725 to player 1");
						twoMoney = twoMoney - 725;
						oneMoney = oneMoney + 725;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 19 && oneOrangeAve[2] == true){
					if(oneOrangeHouse3 == 0){
						System.out.println("Player 2 pays 14 to player 1");
						twoMoney = twoMoney - 14;
						oneMoney = oneMoney + 14;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse3 == 1){
						System.out.println("Player 2 pays 70 to player 1");
						twoMoney = twoMoney - 70;
						oneMoney = oneMoney + 70;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse3 == 2){
						System.out.println("Player 2 pays 200 to player 1");
						twoMoney = twoMoney - 200;
						oneMoney = oneMoney + 200;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse3 == 3){
						System.out.println("Player 2 pays 550 to player 1");
						twoMoney = twoMoney - 550;
						oneMoney = oneMoney + 550;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneOrangeHouse3 == 4){
						System.out.println("Player 2 pays 725 to player 1");
						twoMoney = twoMoney - 725;
						oneMoney = oneMoney + 725;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}
		}
	}
	
	//When player lands on any of the 3 red Ave. execute this method
	public static void redAve(int countMove10){
		countMove10 = count;
		String oneRed;
		String twoRed;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove10 % 2 == 0){
			if(oneTotWalk == 21 && oneRedAve[0] == true){
				if(oneRedHouse1 >= 0 && oneRedHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 150? (yes / no)");
					oneRed = oneRedScan.nextLine();
					
					if(oneRed.equalsIgnoreCase("yes") && oneMoney > 150){
						oneRedHouse1++;
						oneMoney = oneMoney - 150;
						System.out.println("Player 1 has " + oneMoney + " and " + oneRedHouse1 + " house(s) on this property");
					}
					else if(oneRed.equalsIgnoreCase("yes") && oneMoney <= 150){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneRedHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 23 && oneRedAve[1] == true){
				if(oneRedHouse2 >= 0 && oneRedHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 150? (yes / no)");
					oneRed = oneRedScan.nextLine();
					
					if(oneRed.equalsIgnoreCase("yes") && oneMoney > 150){
						oneRedHouse2++;
						oneMoney = oneMoney - 150;
						System.out.println("Player 1 has " + oneMoney + " and " + oneRedHouse2 + " house(s) on this property");
					}
					else if(oneRed.equalsIgnoreCase("yes") && oneMoney <= 150){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneRedHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 24 && oneRedAve[2] == true){
				if(oneRedHouse3 >= 0 && oneRedHouse3 < 4){
					System.out.println("Does player 1 wish to purchase a house with 150? (yes / no)");
					oneRed = oneRedScan.nextLine();
					
					if(oneRed.equalsIgnoreCase("yes") && oneMoney > 150){
						oneRedHouse3++;
						oneMoney = oneMoney - 150;
						System.out.println("Player 1 has " + oneMoney + " and " + oneRedHouse3 + " house(s) on this property");
					}
					else if(oneRed.equalsIgnoreCase("yes") && oneMoney <= 150){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneRedHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 21 && twoRedAve[0] == false && oneRedAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Red Ave. for 220? (yes / no)");
				oneRed = oneRedScan.nextLine();
				
				if(oneRed.equalsIgnoreCase("yes") && oneMoney > 220){
					oneMoney = oneMoney - 220;
					oneRedAve[0] = true;
					System.out.println("Player 1 now owns the property with an extra of " + oneMoney);
				}
				else if(oneRed.equalsIgnoreCase("yes") && oneMoney <= 220){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 23 && twoRedAve[1] == false && oneRedAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Red Ave. for 220? (yes / no)");
				oneRed = oneRedScan.nextLine();
				
				if(oneRed.equalsIgnoreCase("yes") && oneMoney > 220){
					oneMoney = oneMoney - 220;
					oneRedAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneRed.equalsIgnoreCase("yes") && oneMoney <= 220){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 24 && twoRedAve[2] == false && oneRedAve[2] == false){
				System.out.println("Does player 1 wish to purchase 3rd Red Ave. for 220? (yes / no)");
				oneRed = oneRedScan.nextLine();
				
				if(oneRed.equalsIgnoreCase("yes") && oneMoney > 220){
					oneMoney = oneMoney - 220;
					oneRedAve[2] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneRed.equalsIgnoreCase("yes") && oneMoney <= 220){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 21 && twoRedAve[0] == true){
					if(twoRedHouse1 == 0){
						System.out.println("Player 1 pays 18 to player 2");
						oneMoney = oneMoney - 18;
						twoMoney = twoMoney + 18;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse1 == 1){
						System.out.println("Player 1 pays 90 to player 2");
						oneMoney = oneMoney - 90;
						twoMoney = twoMoney + 90;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse1 == 2){
						System.out.println("Player 1 pays 250 to player 2");
						oneMoney = oneMoney - 250;
						twoMoney = twoMoney + 250;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse1 == 3){
						System.out.println("Player 1 pays 700 to player 2");
						oneMoney = oneMoney - 700;
						twoMoney = twoMoney + 700;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse1 == 4){
						System.out.println("Player 1 pays 875 to player 2");
						oneMoney = oneMoney - 875;
						twoMoney = twoMoney + 875;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 23 && twoRedAve[1] == true){
					if(twoRedHouse2 == 0){
						System.out.println("Player 1 pays 18 to player 2");
						oneMoney = oneMoney - 18;
						twoMoney = twoMoney + 18;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse2 == 1){
						System.out.println("Player 1 pays 90 to player 2");
						oneMoney = oneMoney - 90;
						twoMoney = twoMoney + 90;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse2 == 2){
						System.out.println("Player 1 pays 250 to player 2");
						oneMoney = oneMoney - 250;
						twoMoney = twoMoney + 250;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse2 == 3){
						System.out.println("Player 1 pays 700 to player 2");
						oneMoney = oneMoney - 700;
						twoMoney = twoMoney + 700;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse2 == 4){
						System.out.println("Player 1 pays 875 to player 2");
						oneMoney = oneMoney - 875;
						twoMoney = twoMoney + 875;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 24 && twoRedAve[2] == true){
					if(twoRedHouse3 == 0){
						System.out.println("Player 1 pays 18 to player 2");
						oneMoney = oneMoney - 18;
						twoMoney = twoMoney + 18;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse3 == 1){
						System.out.println("Player 1 pays 90 to player 2");
						oneMoney = oneMoney - 90;
						twoMoney = twoMoney + 90;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse3 == 2){
						System.out.println("Player 1 pays 250 to player 2");
						oneMoney = oneMoney - 250;
						twoMoney = twoMoney + 250;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse3 == 3){
						System.out.println("Player 1 pays 700 to player 2");
						oneMoney = oneMoney - 700;
						twoMoney = twoMoney + 700;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoRedHouse3 == 4){
						System.out.println("Player 1 pays 875 to player 2");
						oneMoney = oneMoney - 875;
						twoMoney = twoMoney + 875;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		else if(countMove10 % 2 == 1){
			if(twoTotWalk == 21 && twoRedAve[0] == true){
				if(twoRedHouse1 >= 0 && twoRedHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 150?  (yes / no)");
					twoRed = twoRedScan.nextLine();
					
					if(twoRed.equalsIgnoreCase("yes") && twoMoney > 150){
						twoRedHouse1++;
						twoMoney = twoMoney - 150;
						System.out.println("Player 2 has " + twoMoney + " and " + twoRedHouse1 + " house(s) on this property");
					}
					else if(twoRed.equalsIgnoreCase("yes") && twoMoney <= 150){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoRedHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 23 && twoRedAve[1] == true){
				if(twoRedHouse2 >= 0 && twoRedHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 150?  (yes / no)");
					twoRed = twoRedScan.nextLine();
					
					if(twoRed.equalsIgnoreCase("yes") && twoMoney > 150){
						twoRedHouse2++;
						twoMoney = twoMoney - 150;
						System.out.println("Player 2 has " + twoMoney + " and " + twoRedHouse2 + " house(s) on this property");
					}
					else if(twoRed.equalsIgnoreCase("yes") && twoMoney <= 150){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoRedHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 24 && twoRedAve[2] == true){
				if(twoRedHouse3 >= 0 && twoRedHouse3 < 4){
					System.out.println("Does player 2 wish to purchase a house with 150?  (yes / no)");
					twoRed = twoRedScan.nextLine();
					
					if(twoRed.equalsIgnoreCase("yes") && twoMoney > 150){
						twoRedHouse3++;
						twoMoney = twoMoney - 150;
						System.out.println("Player 2 has " + twoMoney + " and " + twoRedHouse3 + " house(s) on this property");
					}
					else if(twoRed.equalsIgnoreCase("yes") && twoMoney <= 150){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoRedHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 21 && oneRedAve[0] == false && twoRedAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Red Ave. for 220?  (yes / no)");
				twoRed = twoRedScan.nextLine();
				
				if(twoRed.equalsIgnoreCase("yes") && twoMoney > 220){
					twoMoney = twoMoney - 220;
					twoRedAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoRed.equalsIgnoreCase("yes") && twoMoney <= 220){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 23 && oneRedAve[1] == false && twoRedAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Red Ave. for 220? (yes / no)");
				twoRed = twoRedScan.nextLine();
				
				if(twoRed.equalsIgnoreCase("yes") && twoMoney > 220){
					twoMoney = twoMoney - 220;
					twoRedAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoRed.equalsIgnoreCase("yes") && twoMoney <= 220){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 24 && oneRedAve[2] == false && twoRedAve[2] == false){
				System.out.println("Does player 2 wish to purchase 3rd Red Ave. for 220? (yes / no)");
				twoRed = twoRedScan.nextLine();
				
				if(twoRed.equalsIgnoreCase("yes") && twoMoney > 220){
					twoMoney = twoMoney - 220;
					twoRedAve[2] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoRed.equalsIgnoreCase("yes") && twoMoney <= 220){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 21 && oneRedAve[0] == true){
					if(oneRedHouse1 == 0){
						System.out.println("Player 2 pays 18 to player 1");
						twoMoney = twoMoney - 18;
						oneMoney = oneMoney + 18;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse1 == 1){
						System.out.println("Player 2 pays 90 to player 1");
						twoMoney = twoMoney - 90;
						oneMoney = oneMoney + 90;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse1 == 2){
						System.out.println("Player 2 pays 250 to player 1");
						twoMoney = twoMoney - 250;
						oneMoney = oneMoney + 250;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse1 == 3){
						System.out.println("Player 2 pays 700 to player 1");
						twoMoney = twoMoney - 700;
						oneMoney = oneMoney + 700;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse1 == 4){
						System.out.println("Player 2 pays 875 to player 1");
						twoMoney = twoMoney - 875;
						oneMoney = oneMoney + 875;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 23 && oneRedAve[1] == true){
					if(oneRedHouse2 == 0){
						System.out.println("Player 2 pays 18 to player 1");
						twoMoney = twoMoney - 18;
						oneMoney = oneMoney + 18;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse2 == 1){
						System.out.println("Player 2 pays 90 to player 1");
						twoMoney = twoMoney - 90;
						oneMoney = oneMoney + 90;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse2 == 2){
						System.out.println("Player 2 pays 250 to player 1");
						twoMoney = twoMoney - 250;
						oneMoney = oneMoney + 250;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse2 == 3){
						System.out.println("Player 2 pays 700 to player 1");
						twoMoney = twoMoney - 700;
						oneMoney = oneMoney + 700;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse2 == 4){
						System.out.println("Player 2 pays 875 to player 1");
						twoMoney = twoMoney - 875;
						oneMoney = oneMoney + 875;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 24 && oneRedAve[2] == true){
					if(oneRedHouse3 == 0){
						System.out.println("Player 2 pays 18 to player 1");
						twoMoney = twoMoney - 18;
						oneMoney = oneMoney + 18;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse3 == 1){
						System.out.println("Player 2 pays 90 to player 1");
						twoMoney = twoMoney - 90;
						oneMoney = oneMoney + 90;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse3 == 2){
						System.out.println("Player 2 pays 250 to player 1");
						twoMoney = twoMoney - 250;
						oneMoney = oneMoney + 250;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse3 == 3){
						System.out.println("Player 2 pays 700 to player 1");
						twoMoney = twoMoney - 700;
						oneMoney = oneMoney + 700;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					else if(oneRedHouse3 == 4){
						System.out.println("Player 2 pays 875 to player 1");
						twoMoney = twoMoney - 875;
						oneMoney = oneMoney + 875;
						System.out.println("Player 2 now has " + twoMoney);
						System.out.println("Player 1 now has " + oneMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}
		}
	}
	
	//When player lands on any of the 3 yellow Ave. execute this method
	public static void yeAve(int countMove11){
		countMove11 = count;
		String oneYe;
		String twoYe;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove11 % 2 == 0){
			if(oneTotWalk == 26 && oneYeAve[0] == true){
				if(oneYeHouse1 >= 0 && oneYeHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 150? (yes / no)");
					oneYe = oneYeScan.nextLine();
					
					if(oneYe.equalsIgnoreCase("yes") && oneMoney > 150){
						oneYeHouse1++;
						oneMoney = oneMoney - 150;
						System.out.println("Player 1 has " + oneMoney + " and " + oneYeHouse1 + " house(s) on this property");
					}
					else if(oneYe.equalsIgnoreCase("yes") && oneMoney <= 150){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneYeHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 27 && oneYeAve[1] == true){
				if(oneYeHouse2 >= 0 && oneYeHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 150? (yes / no)");
					oneYe = oneYeScan.nextLine();
					
					if(oneYe.equalsIgnoreCase("yes") && oneMoney > 150){
						oneYeHouse2++;
						oneMoney = oneMoney - 150;
						System.out.println("Player 1 has " + oneMoney + " and " + oneYeHouse2 + " house(s) on this property");
					}
					else if(oneYe.equalsIgnoreCase("yes") && oneMoney <= 150){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneYeHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 29 && oneYeAve[2] == true){
				if(oneYeHouse3 >= 0 && oneYeHouse3 < 4){
					System.out.println("Does player 1 wish to purchase a house with 150? (yes / no)");
					oneYe = oneYeScan.nextLine();
					
					if(oneYe.equalsIgnoreCase("yes") && oneMoney > 150){
						oneYeHouse3++;
						oneMoney = oneMoney - 150;
						System.out.println("Player 1 has " + oneMoney + " and " + oneYeHouse3 + " house(s) on this property");
					}
					else if(oneYe.equalsIgnoreCase("yes") && oneMoney <= 150){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneYeHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 26 && twoYeAve[0] == false && oneYeAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Yellow Ave. for 260? (yes / no)");
				oneYe = oneYeScan.nextLine();
				
				if(oneYe.equalsIgnoreCase("yes") && oneMoney > 260){
					oneMoney = oneMoney - 260;
					oneYeAve[0] = true;
					System.out.println("Player 1 now owns the property with an extra of " + oneMoney);
				}
				else if(oneYe.equalsIgnoreCase("yes") && oneMoney <= 260){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 27 && twoYeAve[1] == false && oneYeAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Yellow Ave. for 260? (yes / no)");
				oneYe = oneYeScan.nextLine();
				
				if(oneYe.equalsIgnoreCase("yes") && oneMoney > 260){
					oneMoney = oneMoney - 260;
					oneYeAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneYe.equalsIgnoreCase("yes") && oneMoney <= 260){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 29 && twoYeAve[2] == false && oneYeAve[2] == false){
				System.out.println("Does player 1 wish to purchase 3rd Yellow Ave. for 260? (yes / no)");
				oneYe = oneYeScan.nextLine();
				
				if(oneYe.equalsIgnoreCase("yes") && oneMoney > 260){
					oneMoney = oneMoney - 260;
					oneYeAve[2] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneYe.equalsIgnoreCase("yes") && oneMoney <= 260){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 26 && twoYeAve[0] == true){
					if(twoYeHouse1 == 0){
						System.out.println("Player 1 pays 22 to player 2");
						oneMoney = oneMoney - 22;
						twoMoney = twoMoney + 22;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse1 == 1){
						System.out.println("Player 1 pays 110 to player 2");
						oneMoney = oneMoney - 110;
						twoMoney = twoMoney + 110;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse1 == 2){
						System.out.println("Player 1 pays 330 to player 2");
						oneMoney = oneMoney - 330;
						twoMoney = twoMoney + 330;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse1 == 3){
						System.out.println("Player 1 pays 800 to player 2");
						oneMoney = oneMoney - 800;
						twoMoney = twoMoney + 800;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse1 == 4){
						System.out.println("Player 1 pays 975 to player 2");
						oneMoney = oneMoney - 975;
						twoMoney = twoMoney + 975;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 27 && twoYeAve[1] == true){
					if(twoYeHouse2 == 0){
						System.out.println("Player 1 pays 22 to player 2");
						oneMoney = oneMoney - 22;
						twoMoney = twoMoney + 22;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse2 == 1){
						System.out.println("Player 1 pays 110 to player 2");
						oneMoney = oneMoney - 110;
						twoMoney = twoMoney + 110;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse2 == 2){
						System.out.println("Player 1 pays 330 to player 2");
						oneMoney = oneMoney - 330;
						twoMoney = twoMoney + 330;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse2 == 3){
						System.out.println("Player 1 pays 800 to player 2");
						oneMoney = oneMoney - 800;
						twoMoney = twoMoney + 800;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse2 == 4){
						System.out.println("Player 1 pays 975 to player 2");
						oneMoney = oneMoney - 975;
						twoMoney = twoMoney + 975;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 29 && twoYeAve[2] == true){
					if(twoYeHouse3 == 0){
						System.out.println("Player 1 pays 22 to player 2");
						oneMoney = oneMoney - 22;
						twoMoney = twoMoney + 22;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse3 == 1){
						System.out.println("Player 1 pays 110 to player 2");
						oneMoney = oneMoney - 110;
						twoMoney = twoMoney + 110;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse3 == 2){
						System.out.println("Player 1 pays 330 to player 2");
						oneMoney = oneMoney - 330;
						twoMoney = twoMoney + 330;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse3 == 3){
						System.out.println("Player 1 pays 800 to player 2");
						oneMoney = oneMoney - 800;
						twoMoney = twoMoney + 800;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoYeHouse3 == 4){
						System.out.println("Player 1 pays 975 to player 2");
						oneMoney = oneMoney - 975;
						twoMoney = twoMoney + 975;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		
		else if(countMove11 % 2 == 1){
			if(twoTotWalk == 26 && twoYeAve[0] == true){
				if(twoYeHouse1 >= 0 && twoYeHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 150?  (yes / no)");
					twoYe = twoYeScan.nextLine();
					
					if(twoYe.equalsIgnoreCase("yes") && twoMoney > 150){
						twoYeHouse1++;
						twoMoney = twoMoney - 150;
						System.out.println("Player 2 has " + twoMoney + " and " + twoYeHouse1 + " house(s) on this property");
					}
					else if(twoYe.equalsIgnoreCase("yes") && twoMoney <= 150){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoYeHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 27 && twoYeAve[1] == true){
				if(twoYeHouse2 >= 0 && twoYeHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 150?  (yes / no)");
					twoYe = twoYeScan.nextLine();
					
					if(twoYe.equalsIgnoreCase("yes") && twoMoney > 150){
						twoYeHouse2++;
						twoMoney = twoMoney - 150;
						System.out.println("Player 2 has " + twoMoney + " and " + twoYeHouse2 + " house(s) on this property");
					}
					else if(twoYe.equalsIgnoreCase("yes") && twoMoney <= 150){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoYeHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 29 && twoYeAve[2] == true){
				if(twoYeHouse3 >= 0 && twoYeHouse3 < 4){
					System.out.println("Does player 2 wish to purchase a house with 150?  (yes / no)");
					twoYe = twoYeScan.nextLine();
					
					if(twoYe.equalsIgnoreCase("yes") && twoMoney > 150){
						twoYeHouse3++;
						twoMoney = twoMoney - 150;
						System.out.println("Player 2 has " + twoMoney + " and " + twoYeHouse3 + " house(s) on this property");
					}
					else if(twoYe.equalsIgnoreCase("yes") && twoMoney <= 150){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoYeHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 26 && oneYeAve[0] == false && twoYeAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Yellow Ave. for 260?  (yes / no)");
				twoYe = twoYeScan.nextLine();
				
				if(twoYe.equalsIgnoreCase("yes") && twoMoney > 260){
					twoMoney = twoMoney - 260;
					twoYeAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoYe.equalsIgnoreCase("yes") && twoMoney <= 260){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 27 && oneYeAve[1] == false && twoYeAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Yellow Ave. for 260? (yes / no)");
				twoYe = twoYeScan.nextLine();
				
				if(twoYe.equalsIgnoreCase("yes") && twoMoney > 260){
					twoMoney = twoMoney - 260;
					twoYeAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoYe.equalsIgnoreCase("yes") && twoMoney <= 260){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 29 && oneYeAve[2] == false && twoYeAve[2] == false){
				System.out.println("Does player 2 wish to purchase 3rd Yellow Ave. for 260? (yes / no)");
				twoYe = twoYeScan.nextLine();
				
				if(twoYe.equalsIgnoreCase("yes") && twoMoney > 260){
					twoMoney = twoMoney - 260;
					twoYeAve[2] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoYe.equalsIgnoreCase("yes") && twoMoney <= 260){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 26 && oneYeAve[0] == true){
					if(oneYeHouse1 == 0){
						System.out.println("Player 2 pays 22 to player 1");
						twoMoney = twoMoney - 22;
						oneMoney = oneMoney + 22;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse1 == 1){
						System.out.println("Player 2 pays 110 to player 1");
						twoMoney = twoMoney - 110;
						oneMoney = oneMoney + 110;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse1 == 2){
						System.out.println("Player 2 pays 330 to player 1");
						twoMoney = twoMoney - 330;
						oneMoney = oneMoney + 330;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse1 == 3){
						System.out.println("Player 2 pays 800 to player 1");
						twoMoney = twoMoney - 800;
						oneMoney = oneMoney + 800;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse1 == 4){
						System.out.println("Player 2 pays 975 to player 1");
						twoMoney = twoMoney - 975;
						oneMoney = oneMoney + 975;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 27 && oneYeAve[1] == true){
					if(oneYeHouse2 == 0){
						System.out.println("Player 2 pays 22 to player 1");
						twoMoney = twoMoney - 22;
						oneMoney = oneMoney + 22;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse2 == 1){
						System.out.println("Player 2 pays 110 to player 1");
						twoMoney = twoMoney - 110;
						oneMoney = oneMoney + 110;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse2 == 2){
						System.out.println("Player 2 pays 330 to player 1");
						twoMoney = twoMoney - 330;
						oneMoney = oneMoney + 330;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse2 == 3){
						System.out.println("Player 2 pays 800 to player 1");
						twoMoney = twoMoney - 800;
						oneMoney = oneMoney + 800;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse2 == 4){
						System.out.println("Player 2 pays 975 to player 1");
						twoMoney = twoMoney - 975;
						oneMoney = oneMoney + 975;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 29 && oneYeAve[2] == true){
					if(oneYeHouse3 == 0){
						System.out.println("Player 2 pays 22 to player 1");
						twoMoney = twoMoney - 22;
						oneMoney = oneMoney + 22;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse3 == 1){
						System.out.println("Player 2 pays 110 to player 1");
						twoMoney = twoMoney - 110;
						oneMoney = oneMoney + 110;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse3 == 2){
						System.out.println("Player 2 pays 330 to player 1");
						twoMoney = twoMoney - 330;
						oneMoney = oneMoney + 330;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse3 == 3){
						System.out.println("Player 2 pays 800 to player 1");
						twoMoney = twoMoney - 800;
						oneMoney = oneMoney + 800;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneYeHouse3 == 4){
						System.out.println("Player 2 pays 975 to player 1");
						twoMoney = twoMoney - 975;
						oneMoney = oneMoney + 975;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}
		}
	}
	
	//When player lands on any of the 3 green Ave. execute this method
	public static void greenAve(int countMove12){
		countMove12 = count;
		String oneGreen;
		String twoGreen;
		
		System.out.print("\033[H\033[2J");
		
		if(countMove12 % 2 == 0){
			if(oneTotWalk == 31 && oneGreenAve[0] == true){
				if(oneGreenHouse1 >= 0 && oneGreenHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 200? (yes / no)");
					oneGreen = oneGreenScan.nextLine();
					
					if(oneGreen.equalsIgnoreCase("yes") && oneMoney > 200){
						oneGreenHouse1++;
						oneMoney = oneMoney - 200;
						System.out.println("Player 1 has " + oneMoney + " and " + oneGreenHouse1 + " house(s) on this property");
					}
					else if(oneGreen.equalsIgnoreCase("yes") && oneMoney <= 200){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneGreenHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 32 && oneGreenAve[1] == true){
				if(oneGreenHouse2 >= 0 && oneGreenHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 200? (yes / no)");
					oneGreen = oneGreenScan.nextLine();
					
					if(oneGreen.equalsIgnoreCase("yes") && oneMoney > 200){
						oneGreenHouse2++;
						oneMoney = oneMoney - 200;
						System.out.println("Player 1 has " + oneMoney + " and " + oneGreenHouse2 + " house(s) on this property");
					}
					else if(oneGreen.equalsIgnoreCase("yes") && oneMoney <= 200){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneGreenHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 34 && oneGreenAve[2] == true){
				if(oneGreenHouse3 >= 0 && oneGreenHouse3 < 4){
					System.out.println("Does player 1 wish to purchase a house with 200? (yes / no)");
					oneGreen = oneGreenScan.nextLine();
					
					if(oneGreen.equalsIgnoreCase("yes") && oneMoney > 200){
						oneGreenHouse3++;
						oneMoney = oneMoney - 200;
						System.out.println("Player 1 has " + oneMoney + " and " + oneGreenHouse3 + " house(s) on this property");
					}
					else if(oneGreen.equalsIgnoreCase("yes") && oneMoney <= 200){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneGreenHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 31 && twoGreenAve[0] == false && oneGreenAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Green Ave. for 300? (yes / no)");
				oneGreen = oneGreenScan.nextLine();
				
				if(oneGreen.equalsIgnoreCase("yes") && oneMoney > 300){
					oneMoney = oneMoney - 300;
					oneGreenAve[0] = true;
					System.out.println("Player 1 now owns the property with an extra of " + oneMoney);
				}
				else if(oneGreen.equalsIgnoreCase("yes") && oneMoney <= 300){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 32 && twoGreenAve[1] == false && oneGreenAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Green Ave. for 300? (yes / no)");
				oneGreen = oneGreenScan.nextLine();
				
				if(oneGreen.equalsIgnoreCase("yes") && oneMoney > 300){
					oneMoney = oneMoney - 300;
					oneGreenAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneGreen.equalsIgnoreCase("yes") && oneMoney <= 260){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 34 && twoGreenAve[2] == false && oneGreenAve[2] == false){
				System.out.println("Does player 1 wish to purchase 3rd Green Ave. for 300? (yes / no)");
				oneGreen = oneGreenScan.nextLine();
				
				if(oneGreen.equalsIgnoreCase("yes") && oneMoney > 300){
					oneMoney = oneMoney - 300;
					oneGreenAve[2] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneGreen.equalsIgnoreCase("yes") && oneMoney <= 300){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 31 && twoGreenAve[0] == true){
					if(twoGreenHouse1 == 0){
						System.out.println("Player 1 pays 26 to player 2");
						oneMoney = oneMoney - 26;
						twoMoney = twoMoney + 26;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse1 == 1){
						System.out.println("Player 1 pays 130 to player 2");
						oneMoney = oneMoney - 130;
						twoMoney = twoMoney + 130;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse1 == 2){
						System.out.println("Player 1 pays 390 to player 2");
						oneMoney = oneMoney - 390;
						twoMoney = twoMoney + 390;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse1 == 3){
						System.out.println("Player 1 pays 900 to player 2");
						oneMoney = oneMoney - 900;
						twoMoney = twoMoney + 900;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse1 == 4){
						System.out.println("Player 1 pays 1100 to player 2");
						oneMoney = oneMoney - 1100;
						twoMoney = twoMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 32 && twoGreenAve[1] == true){
					if(twoGreenHouse2 == 0){
						System.out.println("Player 1 pays 26 to player 2");
						oneMoney = oneMoney - 26;
						twoMoney = twoMoney + 26;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse2 == 1){
						System.out.println("Player 1 pays 130 to player 2");
						oneMoney = oneMoney - 130;
						twoMoney = twoMoney + 130;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse2 == 2){
						System.out.println("Player 1 pays 390 to player 2");
						oneMoney = oneMoney - 390;
						twoMoney = twoMoney + 390;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse2 == 3){
						System.out.println("Player 1 pays 900 to player 2");
						oneMoney = oneMoney - 900;
						twoMoney = twoMoney + 900;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse2 == 4){
						System.out.println("Player 1 pays 1100 to player 2");
						oneMoney = oneMoney - 1100;
						twoMoney = twoMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 34 && twoGreenAve[2] == true){
					if(twoGreenHouse3 == 0){
						System.out.println("Player 1 pays 26 to player 2");
						oneMoney = oneMoney - 26;
						twoMoney = twoMoney + 26;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse3 == 1){
						System.out.println("Player 1 pays 130 to player 2");
						oneMoney = oneMoney - 130;
						twoMoney = twoMoney + 130;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse3 == 2){
						System.out.println("Player 1 pays 390 to player 2");
						oneMoney = oneMoney - 390;
						twoMoney = twoMoney + 390;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse3 == 3){
						System.out.println("Player 1 pays 900 to player 2");
						oneMoney = oneMoney - 900;
						twoMoney = twoMoney + 900;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoGreenHouse3 == 4){
						System.out.println("Player 1 pays 1100 to player 2");
						oneMoney = oneMoney - 1100;
						twoMoney = twoMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		else if(countMove12 % 2 == 1){
			if(twoTotWalk == 31 && twoGreenAve[0] == true){
				if(twoGreenHouse1 >= 0 && twoGreenHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house priced 200?  (yes / no)");
					twoGreen = twoGreenScan.nextLine();
					
					if(twoGreen.equalsIgnoreCase("yes") && twoMoney > 200){
						twoGreenHouse1++;
						twoMoney = twoMoney - 200;
						System.out.println("Player 2 has " + twoMoney + " and " + twoGreenHouse1 + " house(s) on this property");
					}
					else if(twoGreen.equalsIgnoreCase("yes") && twoMoney <= 200){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoGreenHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 32 && twoGreenAve[1] == true){
				if(twoGreenHouse2 >= 0 && twoGreenHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house priced 200?  (yes / no)");
					twoGreen = twoGreenScan.nextLine();
					
					if(twoGreen.equalsIgnoreCase("yes") && twoMoney > 200){
						twoGreenHouse2++;
						twoMoney = twoMoney - 200;
						System.out.println("Player 2 has " + twoMoney + " and " + twoGreenHouse2 + " house(s) on this property");
					}
					else if(twoGreen.equalsIgnoreCase("yes") && twoMoney <= 200){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoGreenHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 34 && twoGreenAve[2] == true){
				if(twoGreenHouse3 >= 0 && twoGreenHouse3 < 4){
					System.out.println("Does player 2 wish to purchase a house priced 200?  (yes / no)");
					twoGreen = twoGreenScan.nextLine();
					
					if(twoGreen.equalsIgnoreCase("yes") && twoMoney > 200){
						twoGreenHouse3++;
						twoMoney = twoMoney - 200;
						System.out.println("Player 2 has " + twoMoney + " and " + twoGreenHouse3 + " house(s) on this property");
					}
					else if(twoGreen.equalsIgnoreCase("yes") && twoMoney <= 200){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoGreenHouse3 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 31 && oneGreenAve[0] == false && twoGreenAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Green Ave. for 300?  (yes / no)");
				twoGreen = twoGreenScan.nextLine();
				
				if(twoGreen.equalsIgnoreCase("yes") && twoMoney > 300){
					twoMoney = twoMoney - 300;
					twoGreenAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoGreen.equalsIgnoreCase("yes") && twoMoney <= 300){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 32 && oneGreenAve[1] == false && twoGreenAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Green Ave. for 300? (yes / no)");
				twoGreen = twoGreenScan.nextLine();
				
				if(twoGreen.equalsIgnoreCase("yes") && twoMoney > 300){
					twoMoney = twoMoney - 300;
					twoGreenAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoGreen.equalsIgnoreCase("yes") && twoMoney <= 300){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 34 && oneGreenAve[2] == false && twoGreenAve[2] == false){
				System.out.println("Does player 2 wish to purchase 3rd Green Ave. for 300? (yes / no)");
				twoGreen = twoGreenScan.nextLine();
				
				if(twoGreen.equalsIgnoreCase("yes") && twoMoney > 300){
					twoMoney = twoMoney - 300;
					twoGreenAve[2] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoGreen.equalsIgnoreCase("yes") && twoMoney <= 300){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 31 && oneGreenAve[0] == true){
					if(oneGreenHouse1 == 0){
						System.out.println("Player 2 pays 26 to player 1");
						twoMoney = twoMoney - 26;
						oneMoney = oneMoney + 26;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse1 == 1){
						System.out.println("Player 2 pays 130 to player 1");
						twoMoney = twoMoney - 130;
						oneMoney = oneMoney + 130;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse1 == 2){
						System.out.println("Player 2 pays 390 to player 1");
						twoMoney = twoMoney - 390;
						oneMoney = oneMoney + 390;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse1 == 3){
						System.out.println("Player 2 pays 800 to player 1");
						twoMoney = twoMoney - 900;
						oneMoney = oneMoney + 900;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse1 == 4){
						System.out.println("Player 2 pays 975 to player 1");
						twoMoney = twoMoney - 1100;
						oneMoney = oneMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 32 && oneGreenAve[1] == true){
					if(oneGreenHouse2 == 0){
						System.out.println("Player 2 pays 26 to player 1");
						twoMoney = twoMoney - 26;
						oneMoney = oneMoney + 26;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse2 == 1){
						System.out.println("Player 2 pays 130 to player 1");
						twoMoney = twoMoney - 130;
						oneMoney = oneMoney + 130;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse2 == 2){
						System.out.println("Player 2 pays 390 to player 1");
						twoMoney = twoMoney - 390;
						oneMoney = oneMoney + 390;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse2 == 3){
						System.out.println("Player 2 pays 800 to player 1");
						twoMoney = twoMoney - 900;
						oneMoney = oneMoney + 900;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse2 == 4){
						System.out.println("Player 2 pays 975 to player 1");
						twoMoney = twoMoney - 1100;
						oneMoney = oneMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 34 && oneGreenAve[2] == true){
					if(oneGreenHouse3 == 0){
						System.out.println("Player 2 pays 26 to player 1");
						twoMoney = twoMoney - 26;
						oneMoney = oneMoney + 26;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse3 == 1){
						System.out.println("Player 2 pays 130 to player 1");
						twoMoney = twoMoney - 130;
						oneMoney = oneMoney + 130;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse3 == 2){
						System.out.println("Player 2 pays 390 to player 1");
						twoMoney = twoMoney - 390;
						oneMoney = oneMoney + 390;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse3 == 3){
						System.out.println("Player 2 pays 800 to player 1");
						twoMoney = twoMoney - 900;
						oneMoney = oneMoney + 900;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneGreenHouse3 == 4){
						System.out.println("Player 2 pays 975 to player 1");
						twoMoney = twoMoney - 1100;
						oneMoney = oneMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}
		}
	}
	
	//When player lands on any of the 2 blue Ave. execute this method
	public static void blueAve(int countMoveLast){
		countMoveLast = count;
		String oneBlue;
		String twoBlue;
		
		System.out.print("\033[H\033[2J");
		
		if(countMoveLast % 2 == 0){
			if(oneTotWalk == 37 && oneBlueAve[0] == true){
				if(oneBlueHouse1 >= 0 && oneBlueHouse1 < 4){
					System.out.println("Does player 1 wish to purchase a house with 400? (yes / no)");
					oneBlue = oneBlueScan.nextLine();
					
					if(oneBlue.equalsIgnoreCase("yes") && oneMoney > 200){
						oneBlueHouse1++;
						oneMoney = oneMoney - 200;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBlueHouse1 + " house(s) on this property");
					}
					else if(oneBlue.equalsIgnoreCase("yes") && oneMoney <= 200){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBlueHouse1 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 39 && oneBlueAve[1] == true){
				if(oneBlueHouse2 >= 0 && oneBlueHouse2 < 4){
					System.out.println("Does player 1 wish to purchase a house with 200? (yes / no)");
					oneBlue = oneBlueScan.nextLine();
					
					if(oneBlue.equalsIgnoreCase("yes") && oneMoney > 200){
						oneBlueHouse2++;
						oneMoney = oneMoney - 200;
						System.out.println("Player 1 has " + oneMoney + " and " + oneBlueHouse2 + " house(s) on this property");
					}
					else if(oneBlue.equalsIgnoreCase("yes") && oneMoney <= 200){
						System.out.println("Player 1 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 1 didn't purchase the house");
					}
				}
				else if(oneBlueHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(oneTotWalk == 37 && twoBlueAve[0] == false && oneBlueAve[0] == false){
				System.out.println("Does player 1 wish to purchase 1st Blue Ave. for 400? (yes / no)");
				oneBlue = oneBlueScan.nextLine();
				
				if(oneBlue.equalsIgnoreCase("yes") && oneMoney > 400){
					oneMoney = oneMoney - 400;
					oneBlueAve[0] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneBlue.equalsIgnoreCase("yes") && oneMoney <= 400){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else if(oneTotWalk == 39 && twoBlueAve[1] == false && oneBlueAve[1] == false){
				System.out.println("Does player 1 wish to purchase 2nd Blue Ave. for 400? (yes / no)");
				oneBlue = oneBlueScan.nextLine();
				
				if(oneBlue.equalsIgnoreCase("yes") && oneMoney > 400){
					oneMoney = oneMoney - 400;
					oneBlueAve[1] = true;
					System.out.println("Player 1 now owns this property with an extra of " + oneMoney);
				}
				else if(oneBlue.equalsIgnoreCase("yes") && oneMoney <= 400){
					System.out.println("Player 1 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 1 didn't purchase the house");
				}
			}
			else{
				if(oneTotWalk == 37 && twoBlueAve[0] == true){
					if(twoBlueHouse1 == 0){
						System.out.println("Player 1 pays 35 to player 2");
						oneMoney = oneMoney - 35;
						twoMoney = twoMoney + 35;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse1 == 1){
						System.out.println("Player 1 pays 175 to player 2");
						oneMoney = oneMoney - 175;
						twoMoney = twoMoney + 175;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse1 == 2){
						System.out.println("Player 1 pays 500 to player 2");
						oneMoney = oneMoney - 500;
						twoMoney = twoMoney + 500;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse1 == 3){
						System.out.println("Player 1 pays 1100 to player 2");
						oneMoney = oneMoney - 1100;
						twoMoney = twoMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse1 == 4){
						System.out.println("Player 1 pays 1300 to player 2");
						oneMoney = oneMoney - 1300;
						twoMoney = twoMoney + 1300;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
				else if(oneTotWalk == 39 && twoBlueAve[1] == true){
					if(twoBlueHouse2 == 0){
						System.out.println("Player 1 pays 4 to player 2");
						oneMoney = oneMoney - 4;
						twoMoney = twoMoney + 4;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse2 == 1){
						System.out.println("Player 1 pays 20 to player 2");
						oneMoney = oneMoney - 20;
						twoMoney = twoMoney + 20;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse2 == 2){
						System.out.println("Player 1 pays 60 to player 2");
						oneMoney = oneMoney - 60;
						twoMoney = twoMoney + 60;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse2 == 3){
						System.out.println("Player 1 pays 180 to player 2");
						oneMoney = oneMoney - 180;
						twoMoney = twoMoney + 180;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(twoBlueHouse2 == 4){
						System.out.println("Player 1 pays 320 to player 2");
						oneMoney = oneMoney - 320;
						twoMoney = twoMoney + 320;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(oneMoney <= 0){
						System.out.println("Player 1 is now broke, player 2 wins the game!");
						board.displayMessage("Player 2 wins the game!");
						unwon = 0;
					}
				}
			}
		}
		else if(countMoveLast % 2 == 1){
			if(twoTotWalk == 37 && twoBlueAve[0] == true){
				if(twoBlueHouse1 >= 0 && twoBlueHouse1 < 4){
					System.out.println("Does player 2 wish to purchase a house with 200?  (yes / no)");
					twoBlue = twoBlueScan.nextLine();
					
					if(twoBlue.equalsIgnoreCase("yes") && twoMoney > 200){
						twoBlueHouse1++;
						twoMoney = twoMoney - 200;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBlueHouse1 + " house(s) on this property");
					}
					else if(twoBlue.equalsIgnoreCase("yes") && twoMoney <= 200){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBlueHouse1 == 4){
					System.out.println("Player 2 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 39 && twoBlueAve[1] == true){
				if(twoBlueHouse2 >= 0 && twoBlueHouse2 < 4){
					System.out.println("Does player 2 wish to purchase a house with 200?  (yes / no)");
					twoBlue = twoBlueScan.nextLine();
					
					if(twoBlue.equalsIgnoreCase("yes") && twoMoney > 200){
						twoBlueHouse2++;
						twoMoney = twoMoney - 200;
						System.out.println("Player 2 has " + twoMoney + " and " + twoBlueHouse2 + " house(s) on this property");
					}
					else if(twoBlue.equalsIgnoreCase("yes") && twoMoney <= 200){
						System.out.println("Player 2 doesn't have enough money to purchase the house");
					}
					else{
						System.out.println("Player 2 didn't purchase the house");
					}
				}
				else if(twoBlueHouse2 == 4){
					System.out.println("Player 1 got all 4 houses on the property");
				}
			}
			else if(twoTotWalk == 37 && oneBlueAve[0] == false && twoBlueAve[0] == false){
				System.out.println("Does player 2 wish to purchase 1st Blue Ave. for 400?  (yes / no)");
				twoBlue = twoBlueScan.nextLine();
				
				if(twoBlue.equalsIgnoreCase("yes") && twoMoney > 400){
					twoMoney = twoMoney - 400;
					twoBlueAve[0] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBlue.equalsIgnoreCase("yes") && twoMoney <= 400){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else if(twoTotWalk == 39 && oneBlueAve[1] == false && twoBlueAve[1] == false){
				System.out.println("Does player 2 wish to purchase 2nd Blue Ave. for 400? (yes / no)");
				twoBlue = twoBlueScan.nextLine();
				
				if(twoBlue.equalsIgnoreCase("yes") && twoMoney > 400){
					twoMoney = twoMoney - 400;
					twoBlueAve[1] = true;
					System.out.println("Player 2 now owns this property with an extra of " + twoMoney);
				}
				else if(twoBlue.equalsIgnoreCase("yes") && twoMoney <= 400){
					System.out.println("Player 2 doesn't have enough to purchase the house");
				}
				else{
					System.out.println("Player 2 didn't purchase the house");
				}
			}
			else{
				if(twoTotWalk == 37 && oneBlueAve[0] == true){
					if(oneBlueHouse1 == 0){
						System.out.println("Player 2 pays 35 to player 1");
						twoMoney = twoMoney - 35;
						oneMoney = oneMoney + 35;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse1 == 1){
						System.out.println("Player 2 pays 175 to player 1");
						twoMoney = twoMoney - 175;
						oneMoney = oneMoney + 175;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse1 == 2){
						System.out.println("Player 2 pays 500 to player 1");
						twoMoney = twoMoney - 500;
						oneMoney = oneMoney + 500;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse1 == 3){
						System.out.println("Player 2 pays 1100 to player 1");
						twoMoney = twoMoney - 1100;
						oneMoney = oneMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse1 == 4){
						System.out.println("Player 2 pays 1300 to player 1");
						twoMoney = twoMoney - 1300;
						oneMoney = oneMoney + 1300;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
				else if(twoTotWalk == 39 && oneBlueAve[1] == true){
					if(oneBlueHouse2 == 0){
						System.out.println("Player 2 pays 35 to player 1");
						twoMoney = twoMoney - 35;
						oneMoney = oneMoney + 35;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse2 == 1){
						System.out.println("Player 2 pays 175 to player 1");
						twoMoney = twoMoney - 175;
						oneMoney = oneMoney + 175;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse2 == 2){
						System.out.println("Player 2 pays 500 to player 1");
						twoMoney = twoMoney - 500;
						oneMoney = oneMoney + 500;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse2 == 3){
						System.out.println("Player 2 pays 1100 to player 1");
						twoMoney = twoMoney - 1100;
						oneMoney = oneMoney + 1100;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					else if(oneBlueHouse2 == 4){
						System.out.println("Player 2 pays 1300 to player 1");
						twoMoney = twoMoney - 1300;
						oneMoney = oneMoney + 1300;
						System.out.println("Player 1 now has " + oneMoney);
						System.out.println("Player 2 now has " + twoMoney);
					}
					if(twoMoney <= 0){
						System.out.println("Player 2 is now broke, player 1 wins the game!");
						board.displayMessage("Player 1 wins the game!");
						unwon = 0;
					}
				}
			}	
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		//Construct variables
		Die dieOne = new Die();
		int order = (count % 2) + 1;
		
		//Introduce player to monopoly and present the most basic info on console
		System.out.print("\033[H\033[2J");
		System.out.println("Welcome to Monopoly, click the board to roll the dice");
		board.displayMessage("Welcome to Monopoly, watch both the board & console for info");
		System.out.println("Player 1 has " + oneMoney);
		System.out.println("Player 2 has " + twoMoney);
		System.out.println("The random number generator decided that player " + order + " will start first");
		
		//Create a series of for loops to set the boolean values of these arrays that represent 
		//player's possession of the properties or the card usage to false
		for(int i = 0; i < 10; i++){
			chestTrueFalse[i] = false;
		}
			
		for(int i = 0; i < 4; i++){
			oneRailRoad[i] = false;
		}
		for(int i = 0; i < 4; i++){
			twoRailRoad[i] = false;
		}
			
		for(int i = 0; i < 2; i++){
			oneCompany[i] = false;
		}
		for(int i = 0; i < 2; i++){
			twoCompany[i] = false;
		}
			
		for(int i = 0; i < 2; i++){
			oneBrownAve[i] = false;
		}
		for(int i = 0; i < 2; i++){
			twoBrownAve[i] = false;
		}
			
		for(int i = 0; i < 3; i++){
			oneBabyAve[i] = false;
		}
		for(int i = 0; i < 3; i++){
			twoBabyAve[i] = false;
		}
			
		for(int i = 0; i < 3; i++){
			onePinkAve[i] = false;
		}
		for(int i = 0; i < 3; i++){
			twoPinkAve[i] = false;
		}
			
		for(int i = 0; i < 3; i++){
			oneOrangeAve[i] = false;
		}
		for(int i = 0; i < 3; i++){
			twoOrangeAve[i] = false;
		}
			
		for(int i = 0; i < 3; i++){
			oneRedAve[i] = false;
		}
		for(int i = 0; i < 3; i++){
			twoRedAve[i] = false;
		}
			
		for(int i = 0; i < 3; i++){
			oneYeAve[i] = false;
		}
		for(int i = 0; i < 3; i++){
			twoYeAve[i] = false;
		}
			
		for(int i = 0; i < 3; i++){
			oneGreenAve[i] = false;
		}
		for(int i = 0; i < 3; i++){
			twoGreenAve[i] = false;
		}
			
		for(int i = 0; i < 2; i++){
			oneBlueAve[i] = false;
		}
		for(int i = 0; i < 2; i++){
			twoBlueAve[i] = false;
		}
		
		//Create a nested for loop to put white pegs on the center of the board, leave 2 empty space for the dice
		for(int i = 1; i < 12; i++){
			for(int j = 1; j < 12; j++){
				if(i == 6 && (j == 5 || j == 6)){
					//do nothing
				}
				else{
					board.putPeg(new Peg("white.jpg"), i, j);
				}
			}
		}
		
		//Decorate the board with icons
		board.putPeg(new Peg("white.jpg"), 0, 0);
		board.putPeg(new Peg("white.jpg"), 0, 12);
		board.putPeg(new Peg("white.jpg"), 12, 0);
		board.putPeg(new Peg("white.jpg"), 12, 12);
		board.putPeg(new Peg("brown.png"), 11, 10);
		board.putPeg(new Peg("brown.png"), 11, 8);
		board.putPeg(new Peg("babyBlue.png"), 11, 2);
		board.putPeg(new Peg("babyBlue.png"), 11, 3);
		board.putPeg(new Peg("babyBlue.png"), 11, 5);
		board.putPeg(new Peg("pink.png"), 10, 1);
		board.putPeg(new Peg("pink.png"), 8, 1);
		board.putPeg(new Peg("pink.png"), 7, 1);
		board.putPeg(new Peg("orange.png"), 5, 1);
		board.putPeg(new Peg("orange.png"), 3, 1);
		board.putPeg(new Peg("orange.png"), 2, 1);
		board.putPeg(new Peg("red.png"), 1, 2);
		board.putPeg(new Peg("red.png"), 1, 4);
		board.putPeg(new Peg("red.png"), 1, 5);
		board.putPeg(new Peg("yellow.jpg"), 1, 7);
		board.putPeg(new Peg("yellow.jpg"), 1, 8);
		board.putPeg(new Peg("yellow.jpg"), 1, 10);
		board.putPeg(new Peg("green.png"), 2, 11);
		board.putPeg(new Peg("green.png"), 3, 11);
		board.putPeg(new Peg("green.png"), 5, 11);
		board.putPeg(new Peg("blue.png"), 8, 11);
		board.putPeg(new Peg("blue.png"), 10, 11);
		board.putPeg(new Peg("chest.png"), 11, 9);
		board.putPeg(new Peg("chest.png"), 4, 1);
		board.putPeg(new Peg("chest.png"), 4, 11);
		board.putPeg(new Peg("tax.png"), 11, 7);
		board.putPeg(new Peg("tax.png"), 9, 11);
		board.putPeg(new Peg("railroad.png"), 11, 6);
		board.putPeg(new Peg("railroad.png"), 6, 1);
		board.putPeg(new Peg("railroad.png"), 1, 6);
		board.putPeg(new Peg("railroad.png"), 6, 11);
		board.putPeg(new Peg("chance.png"), 11, 4);
		board.putPeg(new Peg("chance.png"), 1, 3);
		board.putPeg(new Peg("chance.png"), 7, 11);
		board.putPeg(new Peg("bulb.png"), 9, 1);
		board.putPeg(new Peg("tap.png"), 1, 9);
			
		board.putPeg(new Peg("go.png"), 11, 11);
		board.putPeg(new Peg("goJail.png"), 1, 11);
		board.putPeg(new Peg("parking.png"), 1, 1);
		board.putPeg(new Peg("jail.png"), 11, 1);
			
		board.putPeg(new Peg("three.png"), 12, 11);
		
		//Create a while loop to loop the game continuously
		while(unwon == 1){
			Coordinate currentClick = board.getClick();//Get the coordinate where the user clicked (the mouse) on the board
			int currentCol = currentClick.getCol();
			int currentRow = currentClick.getRow();
			
			//If user clicks on any of the blocks, display the info about the blocks onto the console
			if(currentRow == 11 && (currentCol == 8 || currentCol == 10)){
				System.out.print("\033[H\033[2J");
				System.out.println("Brown Avenue cost: 60 each");
				System.out.println("House costs: 50 each");
				System.out.println("Rent with no house: 4");
				System.out.println("Rent with 1 house: 20");
				System.out.println("Rent with 2 house: 60");
				System.out.println("Rent with 3 house: 180");
				System.out.println("Rent with 4 house: 320");
			}
			else if(currentRow == 11 && (currentCol == 2 || currentCol == 3 || currentCol == 5)){
				System.out.print("\033[H\033[2J");
				System.out.println("Baby Blue Avenue cost: 100 each");
				System.out.println("House costs: 50 each");
				System.out.println("Rent with no house: 6");
				System.out.println("Rent with 1 house: 30");
				System.out.println("Rent with 2 house: 90");
				System.out.println("Rent with 3 house: 270");
				System.out.println("Rent with 4 house: 400");
			}
			else if((currentRow == 7 || currentRow == 8 || currentRow == 10) && currentCol == 1){
				System.out.print("\033[H\033[2J");
				System.out.println("Pink Avenue cost: 140 each");
				System.out.println("House costs: 100 each");
				System.out.println("Rent with no house: 10");
				System.out.println("Rent with 1 house: 50");
				System.out.println("Rent with 2 house: 150");
				System.out.println("Rent with 3 house: 450");
				System.out.println("Rent with 4 house: 625");
			}
			else if((currentRow == 2 || currentRow == 3 || currentRow == 5) && currentCol == 1){
				System.out.print("\033[H\033[2J");
				System.out.println("Orange Avenue cost: 180 each");
				System.out.println("House costs: 100 each");
				System.out.println("Rent with no house: 14");
				System.out.println("Rent with 1 house: 70");
				System.out.println("Rent with 2 house: 200");
				System.out.println("Rent with 3 house: 550");
				System.out.println("Rent with 4 house: 725");
			}
			else if(currentRow == 1 && (currentCol == 2 || currentCol == 4 || currentCol == 5)){
				System.out.print("\033[H\033[2J");
				System.out.println("Red Avenue cost: 220 each");
				System.out.println("House costs: 150 each");
				System.out.println("Rent with no house: 18");
				System.out.println("Rent with 1 house: 90");
				System.out.println("Rent with 2 house: 250");
				System.out.println("Rent with 3 house: 700");
				System.out.println("Rent with 4 house: 875");
			}
			else if(currentRow == 1 && (currentCol == 7 || currentCol == 8 || currentCol == 10)){
				System.out.print("\033[H\033[2J");
				System.out.println("Yellow Avenue cost: 260 each");
				System.out.println("House costs: 150 each");
				System.out.println("Rent with no house: 22");
				System.out.println("Rent with 1 house: 110");
				System.out.println("Rent with 2 house: 330");
				System.out.println("Rent with 3 house: 800");
				System.out.println("Rent with 4 house: 975");
			}
			else if((currentRow == 2 || currentRow == 3 || currentRow == 5) && currentCol == 11){
				System.out.print("\033[H\033[2J");
				System.out.println("Green Avenue cost: 300 each");
				System.out.println("House costs: 200 each");
				System.out.println("Rent with no house: 26");
				System.out.println("Rent with 1 house: 130");
				System.out.println("Rent with 2 house: 390");
				System.out.println("Rent with 3 house: 900");
				System.out.println("Rent with 4 house: 1100");
			}
			else if((currentRow == 8 || currentRow == 10) && currentCol == 11){
				System.out.print("\033[H\033[2J");
				System.out.println("Blue Avenue cost: 400 each");
				System.out.println("House costs: 200 each");
				System.out.println("Rent with no house: 35");
				System.out.println("Rent with 1 house: 175");
				System.out.println("Rent with 2 house: 500");
				System.out.println("Rent with 3 house: 1100");
				System.out.println("Rent with 4 house: 1300");
			}
			else if((currentRow == 11 && currentCol == 9) || (currentRow == 4 && currentCol == 1) || (currentRow == 4 && currentCol == 11)){
				System.out.print("\033[H\033[2J");
				System.out.println("Community Chest");
			}
			else if(currentRow == 11 && currentCol == 7){
				System.out.print("\033[H\033[2J");
				System.out.println("Income tax: 200");
			}
			else if(currentRow == 9 && currentCol == 11){
				System.out.print("\033[H\033[2J");
				System.out.println("Luxury tax: 100");
			}
			else if((currentRow == 11 && currentCol == 6) || (currentRow == 6 && currentCol == 1) || (currentRow == 1 && currentCol == 6) || (currentRow == 6 && currentCol == 11)){
				System.out.print("\033[H\033[2J");
				System.out.println("Railroad system cost: 200 each");
				System.out.println("Rent with 1 R.R: 25");
				System.out.println("Rent with 2 R.R: 50");
				System.out.println("Rent with 3 R.R: 100");
				System.out.println("Rent with 4 R.R: 200");
			}
			else if((currentRow == 11 && currentCol == 4) || (currentRow == 1 && currentCol == 3) || (currentRow == 7 && currentCol == 11)){
				System.out.print("\033[H\033[2J");
				System.out.println("Chance Card");
			}
			else if((currentRow == 9 && currentCol == 1) || (currentRow == 1 && currentCol == 9)){
				System.out.print("\033[H\033[2J");
				System.out.println("Electric & Water Company cost: 150 each");
				System.out.println("Rent if 1 owned: 4X the amount shown on dices");
				System.out.println("Rent if 2 owned: 10X the amount shown on dices");
			}
			else if(currentRow == 11 && currentCol == 11){
				System.out.print("\033[H\033[2J");
				System.out.println("GO: collect 200 as you pass by");
			}
			else if(currentRow == 11 && currentCol == 1){
				System.out.print("\033[H\033[2J");
				System.out.println("Jail: you lose your round and you paying 50 lol");
			}
			else if(currentRow == 1 && currentCol == 1){
				System.out.print("\033[H\033[2J");
				System.out.println("Free Parking: what else do you want it's free!");
			}
			else if(currentRow == 1 && currentCol == 11){
				System.out.print("\033[H\033[2J");
				System.out.println("You are going to jail");
			}
			//player 1 move
			if(count%2 == 0){
				putPosition(count);
				getPic(dieOne);
				putPosition(count);
				
				//when player 1's total steps is above or equal to 40, execute putPosition method to maintain it within 40
				if(oneTotWalk >= 40){
					putPosition(count);
					count++;
				}
				//Player 1 steps on community chest square
				else if(oneTotWalk == 2 || oneTotWalk == 17 || oneTotWalk == 33){
					putPosition(count);
					chest(count);
					count++;
					putPosition(count);
				}
				//player 1 steps on tax square
				else if(oneTotWalk == 4 || oneTotWalk == 38){
					if(oneTotWalk == 4){//player 1 steps on income tax square
						if(oneMoney <= 200){
							System.out.println("Player 1 went broke, player 2 won the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
						else{
							board.displayMessage("Income Tax: pay 200");
							oneMoney = oneMoney - 200;
							System.out.println("Pay 200 income tax, player 1 now has " + oneMoney);
							putPosition(count);
							count++;
							putPosition(count);
						}
					}
					//player 1 steps on luxury tax square
					else{
						if(oneMoney <= 100){
							System.out.println("Player 1 went broke, player 2 won the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
						else{
							board.displayMessage("Luxury Tax: pay 100");
							oneMoney = oneMoney - 100;
							System.out.println("Pay 100 luxury tax, player 1 now has " + oneMoney);
							putPosition(count);
							count++;
							putPosition(count);
						}
					}
				}
				//Player 1 steps on railroad square
				else if(oneTotWalk == 5 || oneTotWalk == 15 || oneTotWalk == 25 || oneTotWalk == 35){
					putPosition(count);
					buyRoad(count);
					count++;
					putPosition(count);
				}
				//Player 1 steps on chances square
				else if(oneTotWalk == 7 || oneTotWalk == 22 || oneTotWalk == 36){
					putPosition(count);
					chance(count);
					count++;
					putPosition(count);
				}
				//Player 1 lands on go to jail square
				else if(oneTotWalk == 30){
					oneTotWalk = 10;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 stepped on 'go to jail' square. Too bad");
					putPosition(count);
					if(freeMyHomiePassOne == false){
						System.out.println("Player 1 is in jail for one round, pay 50");
						oneMoney = oneMoney - 50;
						count++;
						System.out.println("Player 1 now has " + oneMoney);
					
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 1 got outta jail with da free my homie pass");
						freeMyHomiePassOne = false;
						count++;
					}
				}
				//Player 1 lands on jail square
				else if(oneTotWalk == 10){
					putPosition(count);
					if(freeMyHomiePassOne == false){
						System.out.print("\033[H\033[2J");
						System.out.println("Player 1 is in jail for one round, pay 50");
						oneMoney = oneMoney - 50;
						count++;
						System.out.println("Player 1 now has " + oneMoney);
						
						if(oneMoney <= 0){
							System.out.println("Player 1 is now broke, player 2 wins the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
					}
					else{
						System.out.println("Player 1 got outta jail with da free my homie pass");
						freeMyHomiePassOne = false;
						count++;
					}
				}
				
				//Player 1 steps on Electric & Water Company square
				else if(oneTotWalk == 12 || oneTotWalk == 28){
					putPosition(count);
					company(count);
					count++;
					putPosition(count);
				}
				//Player 1 is parking for free
				else if(oneTotWalk == 20){
					System.out.print("\033[H\033[2J");
					System.out.println("Player 1 parks here for free");
					count++;
				}
				//When player 1 steps on the Avenues
				else{
					if(oneTotWalk == 1 || oneTotWalk == 3){
						putPosition(count);
						brownAvenue(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 6 || oneTotWalk == 8 || oneTotWalk == 9){
						putPosition(count);
						babyAve(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 11 || oneTotWalk == 13 || oneTotWalk == 14){
						putPosition(count);
						pinkAve(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 16 || oneTotWalk == 18 || oneTotWalk == 19){
						putPosition(count);
						orangeAve(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 21 || oneTotWalk == 23 || oneTotWalk == 24){
						putPosition(count);
						redAve(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 26 || oneTotWalk == 27 || oneTotWalk == 29){
						putPosition(count);
						yeAve(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 31 || oneTotWalk == 32 || oneTotWalk == 34){
						putPosition(count);
						greenAve(count);
						count++;
						putPosition(count);
					}
					else if(oneTotWalk == 37 || oneTotWalk == 39){
						putPosition(count);
						blueAve(count);
						count++;
						putPosition(count);
					}
				}
			}
			//player 2 move
			else if(count%2 == 1){
				putPosition(count);
				getPic(dieOne);
				putPosition(count);
				
				if(twoTotWalk >= 40){
					putPosition(count);
					count++;
				}
				//Player 2 steps on community chest square
				else if(twoTotWalk == 2 || twoTotWalk == 17 || twoTotWalk == 33){
					putPosition(count);
					chest(count);
					count++;
					putPosition(count);
				}
				//Player 2 steps on tax square
				else if(twoTotWalk == 4 || twoTotWalk == 38){
					if(twoTotWalk == 4){//player 2 steps on income tax square
						if(twoMoney <= 200){
							System.out.println("Player 1 went broke, player 2 wins the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
						else{
							board.displayMessage("Income Tax: pay 200");
							twoMoney = twoMoney - 200;
							System.out.println("Pay 200 income tax, player 2 now has " + twoMoney);
							putPosition(count);
							count++;
							putPosition(count);
						}
					}
					//player 2 land on luxury tax square
					else{
						if(twoMoney <= 100){
							System.out.println("Player 1 went broke, player 2 wins the game!");
							board.displayMessage("Player 2 wins the game!");
							unwon = 0;
						}
						else{
							board.displayMessage("Luxury Tax: pay 100");
							twoMoney = twoMoney - 100;
							System.out.println("Pay 100 luxury tax, player 2 now has " + twoMoney);
							putPosition(count);
							count++;
							putPosition(count);
						}
					}
				}
				//Player 2 steps on railroad square
				else if(twoTotWalk == 5 || twoTotWalk == 15 || twoTotWalk == 25 || twoTotWalk == 35){
					putPosition(count);
					buyRoad(count);
					count++;
					putPosition(count);
				}
				//Player 2 steps on chances square
				else if(twoTotWalk == 7 || twoTotWalk == 22 || twoTotWalk == 36){
					putPosition(count);
					chance(count);
					count++;
					putPosition(count);
				}
				//Player 2 lands on go to jail square
				else if(twoTotWalk == 30){
					twoTotWalk = 10;
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 stepped on 'go to jail' square. Too bad");
					putPosition(count);
					if(freeMyHomiePassTwo == false){
						System.out.println("Player 2 is in jail for one round, pay 50");
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 now has " + twoMoney);
					
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game!");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
						count++;
					}
					else{
						System.out.println("Player 2 got outta jail with da free my homie pass");
						freeMyHomiePassTwo = false;
						count++;
					}
				}
				//Player 2 lands on jail square
				else if(twoTotWalk == 10){
					putPosition(count);
					if(freeMyHomiePassTwo == false){
						System.out.print("\033[H\033[2J");
						System.out.println("Player 2 is in jail for one round, pay 50");
						twoMoney = twoMoney - 50;
						System.out.println("Player 2 now has " + twoMoney);
					
						if(twoMoney <= 0){
							System.out.println("Player 2 is now broke, player 1 wins the game!");
							board.displayMessage("Player 1 wins the game!");
							unwon = 0;
						}
						count++;
					}
					else{
						System.out.println("Player 2 got outta jail with da free my homie pass");
						freeMyHomiePassTwo = false;
						count++;
					}
				}
				//Player 2 steps on Electric & Water Company square
				else if(twoTotWalk == 12 || twoTotWalk == 28){
					putPosition(count);
					company(count);
					count++;
					putPosition(count);
				}
				//Player 2 parks for free
				else if(twoTotWalk == 20){
					System.out.print("\033[H\033[2J");
					System.out.println("Player 2 parks here for free");
					count++;
				}
				//When player 2 lands on the Avenues of different colors
				else{
					if(twoTotWalk == 1 || twoTotWalk == 3){
						putPosition(count);
						brownAvenue(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 6 || twoTotWalk == 8 || twoTotWalk == 9){
						putPosition(count);
						babyAve(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 11 || twoTotWalk == 13 || twoTotWalk == 14){
						putPosition(count);
						pinkAve(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 16 || twoTotWalk == 18 || twoTotWalk == 19){
						putPosition(count);
						orangeAve(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 21 || twoTotWalk == 23 || twoTotWalk == 24){
						putPosition(count);
						redAve(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 26 || twoTotWalk == 27 || twoTotWalk == 29){
						putPosition(count);
						yeAve(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 31 || twoTotWalk == 32 || twoTotWalk == 34){
						putPosition(count);
						greenAve(count);
						count++;
						putPosition(count);
					}
					else if(twoTotWalk == 37 || twoTotWalk == 39){
						putPosition(count);
						blueAve(count);
						count++;
						putPosition(count);
					}
				}
			}
		}
		//When the game ends, thank the user and give player some time to figure out why the game ends before end program
		System.out.println("Thanks for playing, goodbye!");
		Thread.sleep(6000);
		System.exit(0);
	}
}