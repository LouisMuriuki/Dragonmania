package island;

import java.util.Scanner;

import user.Player;

public class Habitat {
	 Scanner myObj = new Scanner(System.in); 

	  public void checkInput(){
	    System.out.println("Type 'habitat' to build a habitat");
	    String userInput = myObj.nextLine();
	    if (userInput.equals("habitat")) {
	      Island.habitats+=1; 
	      System.out.println("Congratulation you now have "+Island.habitats+" dragon habitats");
	      }else{
	        checkInput();
	      } 
	  }
	    public void buildHabitat(){
	        int buildcost=1000;
	        if (Player.money<buildcost) {
	          System.out.println("You do not have enough coins");
	        } else {
	          checkInput();  
	        }
	        
	      }
}
