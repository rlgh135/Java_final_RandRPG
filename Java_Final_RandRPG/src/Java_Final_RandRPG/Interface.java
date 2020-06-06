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
		System.out.print("|  2. To get to the next floor, you must destroy the Bosmonster at the exit (G) of each floor.");
		System.out.println("\t\t|");
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
	
	public static void show_invenDescription() {
		
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
	}
	
	public static void attack() {
		
	}
	
	public static void attacked() {
		
	}
	
	public static void Run() {
		
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
		System.out.print("|  디지털 좀비들은 모두 사라졌고...");
		System.out.println("\t\t\t\t|");
		System.out.print("|  모두 다시 평범한 일상으로 돌아갔다...");
		System.out.println("\t\t\t\t|");
		System.out.print("|  하지만 나는 다시 강력한 과제들과 싸움을 하고 있다..");
		System.out.println("\t\t|");
		System.out.print("|  Oh Noooooo!!!!");
		System.out.println("\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t\t\t|");
		System.out.println(" -------------------------------------------------------");
		System.out.println();
		System.exit(0);
	}
}
