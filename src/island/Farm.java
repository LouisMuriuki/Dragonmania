package island;

import java.util.Scanner;

import user.Player;

public class Farm {
	public static int fruits = 10;
	  Scanner myObj = new Scanner(System.in);

	  public void checkInput(){
	    System.out.println("Type 'farm' to build a farm");
	    String userInput = myObj.nextLine();
	    if (userInput.equals("farm")) {
	      Island.farms+=1; 
	      fruits+=40;
	      System.out.println("Congratulation you now have "+Island.farms+" dragon farms");
	      }else{
	        checkInput();
	      } 
	  }

	    public void buildFarm(){
	      int buildcost=1000;
	      if (Player.money<buildcost) {
	        System.out.println("You do not have enough coins");
	      } else {
	        checkInput();
	      }
	      
	    }
}
