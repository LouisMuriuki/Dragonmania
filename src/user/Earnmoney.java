package user;

import utils.Utilities;

public class Earnmoney {
	 Utilities Enter = new Utilities();

	    public void welcomeMoney() {
	        int welcomemoney = 2000;
	        Player.money += welcomemoney;
	        System.out.println("You Earned " + welcomemoney + " coins");
	    }

	    public void petDragon() {
	        int petdragon = 1000;
	        Player.money += petdragon;
	        System.out.println("You Earned " + petdragon + " coins");
	    }

	    public void feedDragon() {
	        int feeddragon = 100;
	        Enter.promptEnterKey();
	        Enter.promptEnterKey();
	        Enter.promptEnterKey();
	        Enter.promptEnterKey();
	        Enter.promptEnterKey();
	        Player.money -= feeddragon;
	    }
	    public void wonFight(){
	        int wonFight = 5000;
	        Player.money += wonFight;
	        System.out.println("You Earned " + wonFight + " coins");
	        Player.level+=1;
	        System.out.println("You have levelled up");
	    }
}
