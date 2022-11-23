package user;

import java.util.Scanner;

import island.Farm;
import island.Habitat;
import utils.Utilities;

public class Friend {
	Utilities Enter=new Utilities();  
    Actions action=new Actions();
    Habitat habitat=new Habitat();
    Earnmoney money=new Earnmoney();

    Farm farm=new Farm();
    Scanner scanner = new Scanner(System.in);
    static String friend="Goodwill";
    public void Welcome(){
        System.out.println("Hello welcome to Dragon Mania Legends");
        System.out.println("Your lontime friend Dr dragonolist has been kidnapped by the Vikings together with his dragons");
        Enter.promptEnterKey();
        System.out.println("My name is "+ friend+" and i will be your guide through this journey as we try to rescue Dr dragonolist ");
        Enter.promptEnterKey();
        System.out.println("What is your Name?");
        Player.name=scanner.nextLine();
        System.out.println("Nice to meet you "+Player.name+", I am his apprentice and managed to hide with one little dragon");
        Enter.promptEnterKey();
        System.out.println("Lets go meet him....");
        System.out.print("Pet him so he likes you :)");
        action.pet(); 
        System.out.println("He looks hungry");
        System.out.println("Feed him some fruits so he can get bigger.Dragon grow very fast!He can Mature just after only five meals");
        action.Feed();
        System.out.println("Your Dragon has Matured and will occasinally shed gold coins");
        Enter.promptEnterKey();
        System.out.println("Here is some gold coins to get you going");
        money.welcomeMoney();
    }
    public void BuildIslandHelper(){
        System.out.println("Build habitats that will house other dragons that you will buy or breed");
        System.out.println("A habitat costs only 1000 coins");
        Enter.promptEnterKey();
        habitat.buildHabitat();
        System.out.println("To keep your dragons Strong and health,you need to have a farm ");
        System.out.println("A farm costs only 1000 coins");
        farm.buildFarm();
        System.out.println("Your dragons are strong and health and can learn some fighting skills. Follow me through the portal...");
    }
    public void StarterCampaignHelper(){
        System.out.println("This Islands were filled with the best dragon trainers,However there has been peace for so long people stopped practicing!");
        Enter.promptEnterKey();
        System.out.println("Training dragons requires special skill are you ready for a crash course?");
        Enter.promptEnterKey();
        System.out.println("To fight an enemy dragon type 'fightdragon'.If you mispell, thats a miss and your attack will be lowered!");
        System.out.println("Then you have to wait for the enemy to make a move. Game difficulty will depend on your player difficulty");
        System.out.println("Whoever goes above 100 points wins, if your health goes below 100 you lose");
        Enter.promptEnterKey();
        System.out.println("You current level is 1 ");
        Enter.promptEnterKey();
        action.gotoWar();
    }
    

    
    

}
