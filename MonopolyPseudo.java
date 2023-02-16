//START program
//CONSTRUCT variables
//GENERATE a random number of either 1 or 2
//IF the random number is 1, then set int count value to 1. (This means player 1 starts first)
//ELSE set int count value to 2
//CONSTRUCT a while loop to loop through the entire program
	//IF int count value divide by 2 has a remainder of 1, player 1 roll dice
		//CALL roll method in another file to roll 2 dices
		//MOVE player the number of steps that equal to the sum of the result of dice roll
		//ADD the total steps player steps forward to int playerOneStep
		//IF playerOneStep >= 40, decrease playerOneStep value by 40 and give the player 200 dollars (player finished lap 1) 
		//ELSE if playerOneStep == 2 or 17 or 33, this means player steps on the community card square
			//DRAW a community card and execute the order
			//SUBTRACT community card number by 1
			//IF community card number == 0, compare the money that the two players have, whoever has the most money wins the game
				//END program
			//ELSE count++
		//ELSE if playerOneStep == 4, subtract 200 from playerOneMoney
		//ELSE if playerOneStep == 5 or 15 or 25 or 35
			//IF the place is occupied, pay fee
				//SUBTRACT fee from playerOneMoney, count++
			//ELSE ask user whether they want to purchase the property
				//IF player answered yes, check if player has enough money before subtracting fee from playerOneMoney
				//ELSE count++
		//ELSE if playerOneStep == 7 or 22 or 36, this means player steps on the chance square
			//DRAW a chance card and execute the order
			//SUBTRACT chance card number by 1
			//IF community card number == 0, compare the money that the two players have, whoever has the most money wins the game
				//END program
			//ELSE count++
		//ELSE if playerOneStep == 10, keep player in jail for a round
			//TAKE away 50 dollars from player
				//IF player has no money left, the other player wins the game
				//ELSE count++
		//ELSE if playerOneStep == 12 or 28
			//IF square is occupied, take away player's money
			//ELSE ask player whether they want to purchase the property
				//IF player answered yes, check if player has enough money before subtracting fee from playerOneMoney
				//ELSE count++
		//ELSE if playerOneStep == 20, free parking, counter++
		//ELSE if playerOneStep == 30, go to jail
			//TAKE away 50 dollars from player
				//IF player has no money left, the other player wins the game
				//ELSE count++
		//ELSE if playerOneStep == 38, check if the player has enough money to pay before taking 100 dollars away from player (luxury tax)
		//ELSE the player is stepped on the houses square
			//IF the place is occupied, pay fee
				//SUBTRACT fee from playerOneMoney, count++
			//ELSE ask user whether they want to purchase the property
				//IF player answered yes, then subtract fee from playerOneMoney
				//ELSE count++
	//ELSE if int count value divide by 2 has a remainder of 0, player 2 roll dice
		//IF int count value divide by 2 has a remainder of 1, player 1 roll dice
		//CALL roll method in another file to roll 2 dices
		//MOVE player the number of steps that equal to the sum of the result of dice roll
		//ADD the total steps player steps forward to int playerOneStep
		//IF playerOneStep >= 40, decrease playerOneStep value by 40 and give the player 200 dollars (player finished lap 1) 
		//ELSE if playerOneStep == 2 or 17 or 33, this means player steps on the community card square
			//DRAW a community card and execute the order
			//SUBTRACT community card number by 1
			//IF community card number == 0, compare the money that the two players have, whoever has the most money wins the game
				//END program
			//ELSE count++
		//ELSE if playerOneStep == 4, subtract 200 from playerOneMoney
		//ELSE if playerOneStep == 5 or 15 or 25 or 35
			//IF the place is occupied, pay fee
				//SUBTRACT fee from playerOneMoney, count++
			//ELSE ask user whether they want to purchase the property
				//IF player answered yes, check if player has enough money before subtracting fee from playerOneMoney
				//ELSE count++
		//ELSE if playerOneStep == 7 or 22 or 36, this means player steps on the chance square
			//DRAW a chance card and execute the order
			//SUBTRACT chance card number by 1
			//IF community card number == 0, compare the money that the two players have, whoever has the most money wins the game
				//END program
			//ELSE count++
		//ELSE if playerOneStep == 10, keep player in jail for a round
			//TAKE away 50 dollars from player
				//IF player has no money left, the other player wins the game
				//ELSE count++
		//ELSE if playerOneStep == 12 or 28
			//IF square is occupied, take away player's money
			//ELSE ask player whether they want to purchase the property
				//IF player answered yes, check if player has enough money before subtracting fee from playerOneMoney
				//ELSE count++
		//ELSE if playerOneStep == 20, free parking, counter++
		//ELSE if playerOneStep == 30, go to jail
			//TAKE away 50 dollars from player
				//IF player has no money left, the other player wins the game
				//ELSE count++
		//ELSE if playerOneStep == 38, check if the player has enough money to pay before taking 100 dollars away from player (luxury tax)
		//ELSE the player is stepped on the houses square
			//IF the place is occupied, pay fee
				//SUBTRACT fee from playerOneMoney, count++
			//ELSE ask user whether they want to purchase the property
				//IF player answered yes, then subtract fee from playerOneMoney
				//ELSE count++