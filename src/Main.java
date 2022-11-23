import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import island.Island;
import user.Actions;
import user.Friend;
import user.Player;
import utils.Utilities;

public class Main {
	Friend friend = new Friend();
	Utilities utils = new Utilities();
	Scanner scanner = new Scanner(System.in);
	Actions action = new Actions();

	public static void main(String[] args) {
		Main main = new Main();
		main.Start();
	}

	public void Start() {
		File newFile = new File("player.txt");
		if (newFile.length() == 0) {
			friend.Welcome();
			friend.BuildIslandHelper();
			friend.StarterCampaignHelper();
			restart();

		} else {
			utils.loadPlayer();
			utils.loadIsland();
			ResumeGame();
			restart();
		}

	}

	public void ResumeGame() {
		System.out.println("Welcome back to dragon Mania Lengends " + Player.name);
		utils.promptEnterKey();
		FirstPrompt();

	}

	public void FirstPrompt() {
		System.out.println(
				"What do you want to do?/n 1.continue with Campaign? 2.Play Bottomless Dungeon 3.Change Game Difficulty 4.view your Island property 5.View Friends 6.view your previous fights  ");
		System.out.println("Choose a number i.e 1");
		switch (scanner.nextInt()) {
		case 1:
			Player.mode = "campaign";
			ContinueCampaign();
			break;
		case 2:
			if (Player.level >= 3) {
				Player.mode = "bottomless";
				action.gotoWar();
			} else {
				System.out.println("You must reach level 3 to play this mode");
				FirstPrompt();
			}
			break;

		case 3:
			ChooseDifficulty();
			GoBack();
			break;

		case 4:
			viewProgress();
			break;
		case 5:
			Friends();
			break;
		case 6:
			viewFights();
			break;
		default:
			FirstPrompt();
			break;
		}
	}

	public void ContinueCampaign() {
		switch (Player.level) {
		case 2:
			action.GotoLevel2();
			break;
		case 3:
			action.GotoLevel3();
			break;
		case 4:
			action.GotoLevel4();
			break;
		case 5:
			restart();
			break;

		default:
			System.out.println("Wrong input!");
			ContinueCampaign();
			break;
		}
	}

	public void Friends() {
		System.out.println("connecting...");
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("We are having trouble connecting to the internet..");
		System.out.println("Please play the offline modes as our team fixes this glitch");
		utils.promptEnterKey();
		GoBack();
	}

	public void ChooseDifficulty() {
		System.out.println("Select your game difficulty./n 1.beginner/n 2.intermediate/n 3.hard");
		System.out.println("Choose a number i.e 1");
		switch (scanner.nextInt()) {
		case 1:
			Player.difficulty = "beginner";
			System.out.println("Difficulty set to beginner,Noobes always have the most fun ;)");
			utils.promptEnterKey();
			break;
		case 2:
			Player.difficulty = "intermediate";
			System.out.println("Difficulty set to intermediate,lets go!!)");
			utils.promptEnterKey();
			break;
		case 3:
			Player.difficulty = "hard";
			System.out.println("Difficulty set to hard, hold on to your dragon :)");
			utils.promptEnterKey();
			break;

		default:
			System.out.println("Invalid choice try again");
			ChooseDifficulty();
			break;
		}
	}

	public void viewProgress() {
		System.out.println("Here is your ScoreBoard");
		System.out.println("Player Name: " + Player.name);
		System.out.println("Dragons owned: " + Player.dragons);
		System.out.println("Remaining Coins: " + Player.money);
		System.out.println("Dragon habitats: " + Island.habitats);
		System.out.println("Number of Farms: " + Island.farms);
		System.out.println("Player level: " + Player.level);
		System.out.println("Game Difficulty: " + Player.difficulty);
		System.out.println("Number of Fights: " + Player.numberofFights);
		System.out.println("Fights Won: " + Player.fightswon);
		System.out.println("Fights Lost: " + Player.fightslost);
		GoBack();
	}

	public void GoBack() {
		System.out.println("Type 'back' to go to the mainScreen");
		if (scanner.nextLine().equals("back")) {
			FirstPrompt();
		} else {
			GoBack();
		}

	}

	public void restart() {
		System.out.println("Game has ended,Type 'restart' to play new game,type 'continue' to go to main screen");
		switch (scanner.nextLine()) {
		case "restart":
			try {
				utils.startnew();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Start();
			break;
		case "continue":
			FirstPrompt();
			break;

		default:
			restart();
			break;
		}
	}
	public void viewFights() {
		System.out.println("You have played "+ Player.numberofFights);
		System.out.println("You have won "+ Player.fightswon);
		System.out.println("You have lost "+ Player.fightslost);
		GoBack();
	}
}
