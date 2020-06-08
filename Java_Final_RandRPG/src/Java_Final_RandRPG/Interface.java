package Java_Final_RandRPG;

import java.util.Scanner;

public class Interface {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void show_intro() {
		System.out.println("\t\t\t\tGame Story");
		System.out.println(" -------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t|");
		System.out.print("|  HGU was attacked by Digital Zombies..");
		System.out.println("\t\t\t\t\t|");
		System.out.print("|  The digital zombies who took over the school kidnapped professors..");
		System.out.println("\t\t|");
		System.out.print("|  Have to rescue the professors who are trapped in the tower..");
		System.out.println("\t\t\t|");
		System.out.print("|  I'm the only one who can save the kidnapped professors!!!");
		System.out.println("\t\t\t|");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t|");
		System.out.println(" -------------------------------------------------------------------------------");
		System.out.println();
		
		System.out.println(" -------------------------");
		System.out.print("|\tChoose One!");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|\t1. New Game");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|\t2. Game Load");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|\t0. Game OFF");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println(" -------------------------");
		
		System.out.print("Your Choice.. => ");
	}
	
	public static void show_description() {
		System.out.println("\t\t\t\t\t  Description");
		System.out.println(" -------------------------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t|");
		System.out.print("|  1. Professors are trapped at the top of the tower (5th floor).");
		System.out.println("\t\t\t\t\t|");
		System.out.print("|  2. To get to the next floor, you must destroy the Boss Monster at the exit (G) of each floor.");
		System.out.println("\t|");
		System.out.print("|  3. There are 25 rooms on each floor, and in each room there are Nomal Monsters randomly present.");
		System.out.println("\t|");
		System.out.print("|  4. If you catch monsters, you can get an item with a certain probability.");
		System.out.println("\t\t\t\t|");
		System.out.print("|  5. The item is a cherished item of professors and helps to kill monsters.");
		System.out.println("\t\t\t\t|");
		System.out.print("|  6. If you eliminate the Boss Monsters on each floor, you can obtain the core item.");
		System.out.println("\t\t\t|");
		System.out.print("|  7. When you reach a certain level, you can learn special skills.");
		System.out.println("\t\t\t\t\t|");
		System.out.print("|  8. Be strong through level-up and items and kill all Boss Monsters.");
		System.out.println("\t\t\t\t\t|");
		System.out.print("|  9. If you eliminate the Boss Monsters on the top floor, you can rescue the professors.");
		System.out.println("\t\t|");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t|");
		System.out.println(" -------------------------------------------------------------------------------------------------------");
		enterAnyKey();
	}
	
	public static void show_howToPlay() {
		System.out.println("\t\t\t\t  How To Play");
		System.out.println(" ---------------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t\t|");
		System.out.print("|  You can Move Up(w), Down(s), Right(d), Left(a) by keyboard.");
		System.out.println("\t\t\t\t|");
		System.out.print("|  HP : Heath Point. When this reaches zero, player dies and Game Over.");
		System.out.println("\t\t\t|");
		System.out.print("|  MP : Mana Point. This is used to use skills.");
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|  AD : Attack Damage. If you're attacked decrease your HP as much as AD.");
		System.out.println("\t\t|");
		System.out.print("|  DP : Defense Point. This much damage offset.");
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|  EXP : Experience points. Level up when a certain amount is obtained.");
		System.out.println("\t\t\t|");
		System.out.print("|  LEVEL : Basic stat increase as level. You can learn skills at a certain level.");
		System.out.println("\t|");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t\t|");
		System.out.println(" ---------------------------------------------------------------------------------------");
		enterAnyKey();
	}
	
	public static void show_play() {
		System.out.println("\t\tMove");
		System.out.println(" ---------------------------------");
		System.out.println("|\t\tw : up\t\t  |");
		System.out.println("| "+"\t\t\t\t  |");
		System.out.println("| a : left\t\td : right |");
		System.out.println("| "+"\t\t\t\t  |");
	    System.out.println("|\t\ts : down\t "+" |");
	    System.out.println("| "+"\t\t\t\t  |");
	    System.out.println(" ---------------------------------");
	    System.out.println("\t\tOption");
	    System.out.println(" ---------------------------------");
	    System.out.println("| \t 1. Game Save \t\t |");
	    System.out.println("| \t 2. Player Status \t |");
	    System.out.println("| \t 3. Inventory \t\t |");
	    System.out.println("| \t 0. Game OFF \t\t |");
	    System.out.println(" ---------------------------------");
	    
	    System.out.print("Your Choice.. => ");
	}
	
	public static void show_battle(boolean is_boss) {
		System.out.println("\n");
		System.out.println("\tBattle Menu");
		System.out.println(" -------------------------");
		System.out.println("|\t\t\t  |");
		System.out.print("|\t1. Attack");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|\t2. Skill");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|\t3. Player Status");
		System.out.println("  |");
		if(!is_boss) {
			System.out.println("|\t\t\t  |");
			System.out.print("|\t0. Run");
			System.out.println("\t\t  |");
		}
		System.out.println("|\t\t\t  |");
		System.out.println(" -------------------------");
		
		System.out.print("Your Choice.. => ");
	}
	
	public static void start_battle() {
		System.out.println();
		System.out.println(" -------------------------------");
		System.out.println("|\t\t\t\t|");
		System.out.println("|  Monster Appearance!!!\t|");
		System.out.println("|\t\t\t\t|");
		System.out.println("|  Let's Start the Battle!\t|");
		System.out.println("|\t\t\t\t|");
		System.out.println(" -------------------------------\n");
		enterAnyKey();
	}
	
	public static void show_attack() {
		System.out.println("\n\n -------------------------");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("| You Attacked the Monster!!");
		System.out.println("|");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println(" -------------------------");
	}
	
	public static void show_attacked() {
		System.out.println("\n\n ---------------------------------------");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.print("|  You're Attacked by the Monster!!");
		System.out.println("\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println(" ---------------------------------------");
	}
	
	public static void show_run(boolean run) {
		System.out.println();
		if(run) {
			System.out.println(" ---------------------------------------");
			System.out.println("|\t\t\t\t\t|");
			System.out.println("|\t\t\t\t\t|");
			System.out.print("|  You succeeded in running away.");
			System.out.println("\t|");
			System.out.println("|\t\t\t\t\t|");
			System.out.println("|\t\t\t\t\t|");
			System.out.println(" ---------------------------------------");
			enterAnyKey();
		}
		else {
			System.out.println(" ---------------------------------------");
			System.out.println("|\t\t\t\t\t|");
			System.out.println("|\t\t\t\t\t|");
			System.out.print("|  Oops..you failed to run away.");
			System.out.println("\t|");
			System.out.println("|\t\t\t\t\t|");
			System.out.println("|\t\t\t\t\t|");
			System.out.println(" ---------------------------------------");
		}
	}
	
	public static void HasNoItems() {
		System.out.println(" -------------------------");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|     Has No Any Items");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println(" -------------------------");
	}
	
	public static void inventory_description() {
		
		System.out.println(" -------------------------------------------------------");
		System.out.print("|\tTheme : If you have Items with the same theme, the Set effect could occur.");
		System.out.println("\t\t\t|");
		System.out.print("|\tGrade : N -> Normal Item, A -> Core Item");
		System.out.println("\t\t\t\t\t|");
		System.out.print("|\tHP : Increase MaxHP by number");
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|\tMP : Increase MaxMP by number");
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|\tAD : Increase AD by number");
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|\tDP : Increase DP by number");
		System.out.println("\t\t\t\t\t\t|");
		System.out.print(" -------------------------------------------------------");
	}
	
	public static void hasNoSkills() {
		System.out.println("\n\n ---------------------------------------");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.print("| You haven't learned any skills yet.");
		System.out.println("\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println(" ---------------------------------------");
		enterAnyKey();
	}
	
	public static void monster_die() {
		System.out.println(" -------------------------");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|     Monster Died");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println(" -------------------------");
	}
	public static void player_die() {
		System.out.println();
		System.out.println("\t\t\t\t    YOU DIED..");
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t|");
		System.out.print("|  Not only the HGU but the world has been destroyed by DIGITAL ZOMBIES...");
		System.out.println("\t|");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t|");
		System.out.print("|\t\t\tAnd No one could save the world...");
		System.out.println("\t\t\t|");
		System.out.println("|\t\t\t\t\t\t\t\t\t\t|");
		System.out.println(" ------------------------------------------------------------------------------");
		System.out.println();
	}
	
	public static void lv_up(int level) {
		System.out.println("\n\t    Level Up!");
		System.out.println(" -------------------------------");
		System.out.println("|\t\t\t\t|");
		System.out.printf("|\tCongratulations!!");
		System.out.println("\t|");
		System.out.println("|\t\t\t\t|");
		System.out.printf("|\tYou're Lv.%2d", level);
		System.out.println("\t\t|");
		System.out.println("|\t\t\t\t|");
		System.out.println(" -------------------------------");
		enterAnyKey();
	}
	
	public static void saved() {
		System.out.println("\n\n -------------------------");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.print("|     Game Saved..");
		System.out.println("\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println("|\t\t\t  |");
		System.out.println(" -------------------------");
	}
	public static void enterAnyKey() {
		System.out.println();
		System.out.print("Enter Any key to Continue..  ");
		sc.next();
		System.out.println();
	}
	
	public static void show_ending() {
		System.out.println();
		System.out.println("\t\t\tEnding Story");
		System.out.println(" -------------------------------------------------------");
		System.out.println("|\t\t\t\t\t\t\t|");
		System.out.print("|  All the digital zombies are gone...");
		System.out.println("\t\t\t|");
		System.out.print("|  Everything went back to normal life...");
		System.out.println("\t\t|");
		System.out.print("|  But I'm still fighting with many Homeworks...");
		System.out.println("\t|");
		System.out.print("|  Oh Noooooo!!!!");
		System.out.println("\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t\t\t|");
		System.out.println(" -------------------------------------------------------");
		System.out.println();
		System.exit(0);
	}
}