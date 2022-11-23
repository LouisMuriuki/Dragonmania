package user;

import java.util.Random;
import java.util.Scanner;
import dragon.Dragoninfo;
import island.Farm;
import utils.Utilities;

public class Actions {
	Earnmoney money = new Earnmoney();
	Utilities utils = new Utilities();
	Scanner scanner = new Scanner(System.in);
	Farm farm = new Farm();

	public void pet() {
		System.out.println("Press Enter to pet dragon");
		utils.promptEnterKey();
		money.petDragon();
	}

	public void Feed() {
		System.out.println("Press Enter five times to feed dragon");
		int dragonFood = 10 * Player.dragons;
		if (Farm.fruits < dragonFood) {
			System.out.println("There is no enough food");
			farm.buildFarm();
		} else {
			money.feedDragon();
			Farm.fruits -= dragonFood;
		}
	}

	public void ClearIsland() {
		Player.money += 500;
		System.out.println("Rocks were removed");
		System.out.println("You have earned" + 500 + "coins");
	}

	public void BuyDragon() {
		System.out.println("Type 'buydragon' to buy a new dragon");
		int dragonPrice = 2000;
		if (scanner.nextLine().equals("buydragon")) {
			if (Player.money < dragonPrice) {
				System.out.println("You dont have enough coins");
			} else {
				Player.dragons += 1;
				System.out.println("You have successfully bought a dragon");
			}
		} else {
			BuyDragon();
		}
	}

	public static int enemyHealth = 100;

	public void EnemyAttack(int compmaxAttack) {
		Random random = new Random();
		int blow = random.nextInt(compmaxAttack);
		Dragoninfo.health -= blow;
		System.out.println("Enemy attack was " + blow);
		gotoWar();
	}

	public void Attack(int usermaxAttack, int compmaxAttack) {
		Random random = new Random();
		int blow = random.nextInt(usermaxAttack);
		enemyHealth -= blow;
		System.out.println("Your attack was " + blow);
		System.out.println("Press Enter for enemy attack");
		scanner.nextLine();
		EnemyAttack(compmaxAttack);
	}

	public void gotoWar() {
		if (enemyHealth > 0) {
			Player.numberofFights += 1;
			System.out.println("Type 'fightdragon' to launch an attack");
			String userInput = scanner.nextLine();
			if (userInput.equals("fightdragon")) {
				System.out.println("Attacking...");
				String userdifficulty = Player.difficulty;
				switch (userdifficulty) {
				case "beginner":
					if (enemyHealth > 0) {
						Attack(50, 30);
					} else if (Dragoninfo.health <= 0) {
						System.out.println("You have lost!You live to fight another day");
						lostFight();
					} else if (enemyHealth <= 0) {
						System.out.println("You have won!");
						wonFight();
					}

					break;
				case "intermediate":
					if (enemyHealth >= 0) {
						Attack(40, 40);
					} else if (Dragoninfo.health <= 0) {
						System.out.println("You have lost!You live to fight another day");
						lostFight();
					} else if (enemyHealth <= 0) {
						System.out.println("You have won!");
						wonFight();
					}

					break;
				case "hard":
					if (enemyHealth >= 0) {
						Attack(30, 50);
					} else if (Dragoninfo.health <= 0) {
						System.out.println("You have lost!You live to fight another day");
						lostFight();
					} else if (enemyHealth <= 0) {
						System.out.println("You have won!");
						wonFight();
					}
					break;
				}
			} else {
				System.out.println("You mispeled the word, your attacking strength will be low");
				System.out.println("Attacking...");
				String userdifficulty = Player.difficulty;
				switch (userdifficulty) {
				case "beginner":
					if (enemyHealth >= 0) {
						Attack(40, 50);
					} else if (Dragoninfo.health <= 0) {
						System.out.println("You have lost!You live to fight another day");
						lostFight();
					} else if (enemyHealth <= 0) {
						System.out.println("You have won!");
						wonFight();
					}

					break;
				case "intermediate":
					if (enemyHealth >= 0) {
						Attack(30, 50);
					} else if (Dragoninfo.health <= 0) {
						System.out.println("You have lost!You live to fight another day");
						lostFight();
					} else if (enemyHealth <= 0) {
						System.out.println("You have won!");
						wonFight();
					}

					break;
				case "hard":
					if (enemyHealth >= 0) {
						Attack(20, 50);
					} else if (Dragoninfo.health <= 0) {
						System.out.println("You have lost!You live to fight another day");
						lostFight();
					} else if (enemyHealth <= 0) {
						System.out.println("You have won!");
						wonFight();
					}

					break;
				}
			}
		} else if (Dragoninfo.health <= 0) {
			System.out.println("You have lost!You live to fight another day");
			lostFight();
		} else if (enemyHealth <= 0) {
			System.out.println("You have won!");
			wonFight();
		}
	}

	public int wins = 0;

	public void wonFight() {
		Player.fightswon += 1;
		enemyHealth = 100;
		Dragoninfo.health = 100;
		if (Player.mode.equals("campaign")) {
			System.out.println("That was amaizing! You won a fight!Lot's of Goodies coming your way ");
			utils.promptEnterKey();
			money.wonFight();
			utils.savePlayer();
			switch (Player.level) {
			case 2:
				GotoLevel2();
				break;
			case 3:
				GotoLevel3();
				break;
			case 4:
				GotoLevel4();
				break;
			}

		} else {
			wins += 1;
			System.out.println("That was amaizing! You won " + wins + " fights, more enemy dragons are comming");
			int wonFight = 500;
			Player.money += wonFight;
			System.out.println("You Earned " + wonFight + " coins");
			utils.promptEnterKey();
			gotoWar();
		}

	}

	public void lostFight() {
		Player.fightslost += 1;
		enemyHealth = 100;
		Dragoninfo.health = 100;
		if (Player.mode.equals("campaign")) {
			System.out.println("Type 'retry' to Retry the fight");
			if (scanner.nextLine().equals("retry")) {
				gotoWar();
			} else {
				System.out.println("You must win this fight to proceed,,Dont give up!!!");
				lostFight();
			}
		} else {
			System.out.println("Your winning Streak lasted " + wins + " wins");
			wins = 0;
			utils.promptEnterKey();
			retryorContinue();
		}

	}

	public void retryorContinue() {
		System.out.println("Type 'retry' to Retry bottomless Dungeon again,type 'continue' to continue with campaign");
		switch (scanner.nextLine()) {
		case "retry":
			if (Player.level >= 3) {
				Player.mode = "bottomless";
				gotoWar();
			} else {
				System.out.println("Level up to play this mode");
			}
			break;
		case "continue":
			switch (Player.level) {
			case 3:
				Player.mode="campaign";
				continuelevel3();
				break;
			case 4:
				Player.mode="campaign";
				GotoLevel4();
				break;
			// add level five
			default:
				System.out.println("Wrong input");
				retryorContinue();
			}
		}

	}

	public void GotoLevel2() {
		System.out.println("Congratulation you are now on level" + Player.level);
		utils.promptEnterKey();
		System.out.println("A player of your skills needs to have more than one dragon");
		BuyDragon();
		System.out.println("Your Dragons look hungry,feed them some fruits");
		utils.promptEnterKey();
		Feed();
		System.out.println("Your Dragons are now strong and health and ready for some action");
		System.out.println("Lets go fight the vikings");
		utils.promptEnterKey();
		gotoWar();

	}

	public void GotoLevel3() {
		System.out.println("Congratulation you are now on level " + Player.level);
		utils.promptEnterKey();
		System.out.println("Congratulations you have unlocked the 'Bottomless Dungeon Mode'");
		utils.promptEnterKey();
		System.out.println("in this mode, you battle a series dragons to eternity unless you lose ");
		utils.promptEnterKey();
		Bottomless();
	}

	public void Bottomless() {
		System.out.println("Would you like to try it out? Type 'bottomless' to try it, otherwise type 'continue'");
		switch (scanner.nextLine()) {
		case "bottomless":
			System.out.println("Only one dragon will be left standing!!! ");
			Player.mode = "bottomless";
			gotoWar();
			break;
		case "continue":
			continuelevel3();
			break;

		default:
			utils.promptEnterKey();
			Bottomless();
			break;
		}
	}

	public void continuelevel3() {
		System.out.println("Lets go get another Dragon");
		utils.promptEnterKey();
		System.out.println("But first, lets build a habitat to house your new dragon");
		System.out.println("Clear out the rocks on the Island to acquire more room");
		utils.promptEnterKey();
		ClearIsland();
		utils.promptEnterKey();
		BuyDragon();
		System.out
				.println("To make sure you never run out of fruits for your dragons, i advise you build another farm");
		utils.promptEnterKey();
		farm.buildFarm();
		System.out.println("amaizing we have plenty of fruits for the dragons,lets feed them");
		utils.promptEnterKey();
		Feed();
		System.out.println("The dragons are full  and charged");
		System.out.println("Battle your way towards the imposing ice dragon to rescue Dr dragonolist");
		utils.promptEnterKey();
		gotoWar();
	}

	public void GotoLevel4() {
		System.out.println("Look we've found the catle where they have hidden him");
		System.out.println("Let us defeat this set of dragons and leave with our mentor");
		if(Player.difficulty.equals("beginner")) {
			System.out.println("Just to make it intersting we have increased the difficulty to intermediate :)");
			Player.difficulty="intermediate";
		}
		gotoWar();
		System.out.println("You made it ! We rescued our mentor");
		Player.money+=10000;
		System.out.println("You have received 10000 coins");
		
	}
	
	
}
