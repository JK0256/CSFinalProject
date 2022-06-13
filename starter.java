import pkg.*;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;


class starter {
	
	public static void waiting(int num) {	//(Only) use for METHODS
		try {
			TimeUnit.MILLISECONDS.sleep(num);
		}
		catch (Exception e) {
				
		}
	}
	
	public static void print(String output) {
		for (int i = 0; i<output.length(); i++) {
			char c = output.charAt(i);
			System.out.print(c);
			waiting(1);		//30
	    }
	}
	public static void println(String output) {
		for (int i = 0; i<output.length(); i++) {
			char c = output.charAt(i);
			System.out.print(c);
			waiting(1);		//30
	    }
	    System.out.println();
	    waiting(1);		//500
	}
	
	public static void hold(int num) {		//(Only) use for MAIN
		try {
			TimeUnit.SECONDS.sleep(num);
		}
		catch (Exception e) {
			
		}
	}
	public static void attack(Pokemon atker, Pokemon enemy) {
		enemy.minusHP(atker.getAtk());
		println(atker + " attacked " + enemy + "!");
	}
	public static void protect(Pokemon pkmn) {
		pkmn.isProtecting(true);
		println(pkmn + " used Protect!");
	}
	public static void buff(Pokemon pkmn) {
		pkmn.buff();
		println(pkmn + " buffed itself!");
	}
	// Pokemon 1stPokemon = new Pokemon(getParty().get(1));
	public static void battle(Pokemon firstPkmn, Pokemon enemy) {
		Scanner scan = new Scanner(System.in);
		if(enemy.equals("wild")) {
			int wildMon = (int)(Math.random()*3);
			if (wildMon == 0) {
				enemy.setName("Ratata");
			}
			else if (wildMon == 1) {
				enemy.setName("Magikarp");
			}
			else {
				enemy.setName("Mewtwo");
			}
		}
		while(!((firstPkmn.hasFainted())||(enemy.hasFainted()))) {
			println("What should " + firstPkmn + " do?");
			println("1: Attack, 2: Protect, or 3: Buff?");
			int action = scan.nextInt();
			if(action==1) {
				attack(firstPkmn, enemy);
			}
			if(action==2) {
				protect(firstPkmn);
			}
			if(action==3) {
				buff(firstPkmn);
			}
			println(enemy + " has " + enemy.getHP() + " HP!");
			int enemyAct = (int)(Math.random()*3);
			if(enemyAct==0) {
				attack(enemy, firstPkmn);
			}
			if(enemyAct==1) {
				protect(enemy);
			}
			if(enemyAct==2) {
				buff(enemy);
			}
			println(firstPkmn + " has " + firstPkmn.getHP() + " HP!");
		}
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		println("Hello! I'm Professor Java!");
		println("Welcome to my Pokemon spin-off!");
		hold(1);
		print("So, before anything else, what's your name? ");
		Person player = new Person(sc.nextLine());
		println(player + ", is it?");
		print("Also, what's your rival's name? ");
		Person rival = new Person(sc.nextLine());	//Rival's name
		Person rMom = new Person(rival + "'s Mom");	//Rival's Mom's name
		println("Is that so? Then you and " + rival + " have fun!");
		println("Now, get ready to explore the wild world of Pokemon!");
		println("\n...\n");
		hold(1);
		println("Rumble... rumble... The truck comes to a stop. ");
		println("Mom: " + player + ", we've arrived!");
		println("You step out of the truck. \nNew town: JavaTea Town\n");
		boolean javaTown = true;
		int home = 0;
		int neighbor = 0;
		int lab = 0;
		Pokemon starter = new Pokemon("", 5);
		Pokemon rstarter = new Pokemon("", 5);
		while(javaTown){
			println("Where would you like to visit?");
			println("House, Rival, or Professor?");
			String javaChoice = sc.nextLine();
			if (javaChoice.equals("House")){
				if(home==0){
					println("You step into your house. A burly pokemon is moving boxes.");
					println("Mom: " + player + ", do you like your new home?");
					println("Mom: These mover Pokemon are really convenient, aren't they?");
					println("Mom: In the meanwhile, how about you visit the rest of the town?");
					home = 1;
				}
				else if(home==1){
					println("Mom: I can't coddle you forever. Go visit the rest of the town.");
				}
				else if(home==2){
					println("Mom: Hello " + player + ", would you and your pokemon like to take a rest?");
					println("You close your eyes, taking a deep rest.");
					//Pokemon health is fully restored
					println("Mom: Alright, good luck on your adventures!");
				}
			}
			else if (javaChoice.equals("Rival")){
				if(neighbor==0){
					println("You step into " + rival + "'s house.");
					println(rMom + ": Hello there, " + player + "!");
					println(rMom + ": " + rival + " has been waiting for you!");
					println("On cue, a boy comes down from upstairs.");
					println(rival + ": Hey there, " + player + "!");
					println(rival + ": Did you come to JavaTea Town to become a pokemon trainer as well?");
					println(rival + ": Well, I'll become one first!");
					println(rival + " rushes out of the house.");
					println(rMom + ": Oh geez, there he goes again.");
					println(rMom + ": Well, what are you waiting for?");
					println(rMom + ": He'll be at the Professor's lab.");
					neighbor = 1;
					lab = 1;
				}
				else if (neighbor==1){		//After coming once
					println(rMom + ": You're back?");
					println(rMom + ": Well, as I said, he'll be at the Professor's lab.");
				}
				else if (neighbor==2){		//After encounter at lab
					println(rMom + ": Hello " + player + ", " + rival + " isn't home now.");
					println(rMom + ": Maybe come back another time?");
				}
			}
			else if (javaChoice.equals("Professor")){
				if(lab==0){
					println("The professor isn't here. Maybe check out the other parts of town?");
				}
				else if(lab==1){
					println(rival + ": Hey " + player + ", what took you so long?");
					println("Profesor: Hello " + player + ", are you here to get your Pokemon?");
					println("Profesor: As you can see, " + rival + " wanted to get his Pokemon first, but I had him wait for you.");
					println(rival + ": Wait... actually, I'd like " + player + " to get his starter first.");
					println("Profesor: Really? Well then, " + player + ", choose first!");
					println("Which starter would you like to choose? 1, 2, or 3?");
					println("1: Bulbasaur, the Grass type");
					println("2: Squirtle, the Water type");
					println("3: Charmander, the Fire type");
					int choice = sc.nextInt();
					if(choice==1||choice==2||choice==3){
						if(choice==1){
							starter.setName("Bulbasaur");
							rstarter.setName("Charmander");
						}
						else if(choice==2){
							starter.setName("Squirtle");
							rstarter.setName("Bulbasaur");
						}
						else if(choice==3){
							starter.setName("Charmander");
							rstarter.setName("Squirtle");
						}
					}
					println(rival + ": Ha! Then I'll pick " + rstarter + "!");
					println("Profesor: Your starter will stay with you for the rest of your journey, and probably become you best friend.");
					// println("Profesor: Would you like to name it? (Otherwise it'll stay as " + starter + ".) y/n");
					// if(sc.nextLine().equals("y")){
					// 	println("Enter a name for your " + starter + ": ");
					// 	String starterNickname = sc.nextLine();
					// 	starter.setName(starterNickname);
					// }
					println("Professor: Congratulations! I can already see you and " + starter + " getting along together nicely!");
					println("Professor: Then now, how about-");
					println(rival + ": How about a battle! " + player + ", I challenge you to a Pokemon battle!" );
					println("Professor: ... So this is why you asked to choose your starter after " + player + ".");
					println("Professor: Well, I guess this can be a good experience for both of you.");
					javaTown = false;
				}
			}
		}
		battle(starter, rstarter);
	}
}
