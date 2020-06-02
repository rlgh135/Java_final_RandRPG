import java.util.*;
import java.io.*;

public class Main {
	public static Scanner sc;
	public static Scanner inputStream;
	public static char input;
	public static Map map;
	public static Player player;
	public static ArrayList<Monster> monsters;
	public static ArrayList<Item> items;
	public static ArrayList<Boss> bosses;
	
	public static void main(String[] args) {
		
		load_GameSystem();
		
		menu_Main();
		
		menu_GameOff();
	}
	
	public static void menu_Main() {
		System.out.println("Choose one.");
		System.out.println("1. start");
		System.out.println("2. load");
		System.out.println("0. game off");
		system_Input();
		switch(input) {
		case '1':
			menu_Start();
			break;
		case '2':
			menu_Load();
		case '0':
			break;
		default:
			menu_Main();
			break;
		}
	}
	
	public static void system_Input() {
		input = sc.next().charAt(0);
	}
	
	public static void menu_Start() {
		map = new Map();
		while(true) {
			map.print_map();
			system_Input();
			if (map.move(input)){
				menu_Boss();
				system_StageUp();
				continue;
			}
			if (map.is_there_m) {
				menu_Battle();
			}
		}
	}
	
	public static void menu_Load() {
		
	}
	
	public static void menu_GameOff() {
		sc.close();
	}
	
	public static void menu_Battle() {
		Random rand = new Random();
		Monster monster = new Monster(monsters.get(rand.nextInt(monsters.size())));
		Battle battle = new Battle(player, monster);
		
		battle.Progress(sc);
		
		battle.Result(items);
	}
	
	public static void menu_Boss() {
		Random rand = new Random();
		Boss boss = new Boss(bosses.get(rand.nextInt(bosses.size())));
		Battle battle = new Battle(player, boss);
		
		battle.Progress(sc);
		
		battle.Result(items);
	}
	
	public static void load_GameSystem() {
		player = new Player();
		sc = new Scanner(System.in);
		
		load_Monsters();
		load_Bosses();
		load_Items();
	}
	
	public static void load_Monsters() {
		try {
			inputStream = new Scanner(new File("monster.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		}
		monsters = new ArrayList<Monster>();
		String line = inputStream.nextLine();
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			String[] ary = line.split(",");
			int _hp = Integer.parseInt(ary[1]);
			int _mp = Integer.parseInt(ary[2]);
			int _level = Integer.parseInt(ary[3]);
			int _ad = Integer.parseInt(ary[4]);
			int _dp = Integer.parseInt(ary[5]);
			
			monsters.add(new Monster(ary[0], _hp, _mp, _level, 0, _ad, _dp));
		}
		inputStream.close();
	}
	
	public static void load_Items() {
		try {
			inputStream = new Scanner(new File("item.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		}
		items = new ArrayList<Item>();
		String line = inputStream.nextLine();
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			String[] ary = line.split(",");
			int _hp = Integer.parseInt(ary[2]);
			int _mp = Integer.parseInt(ary[3]);
			int _ad = Integer.parseInt(ary[4]);
			int _dp = Integer.parseInt(ary[5]);
			
			items.add(new Item(ary[0], ary[1], _hp, _mp, _ad, _dp));
		}
		inputStream.close();
	}
	
	public static void load_Bosses() {
		try {
			inputStream = new Scanner(new File("boss.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		}
		bosses = new ArrayList<Boss>();
		String line = inputStream.nextLine();
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			String[] ary = line.split(",");
			int _hp = Integer.parseInt(ary[1]);
			int _mp = Integer.parseInt(ary[2]);
			int _level = Integer.parseInt(ary[3]);
			int _ad = Integer.parseInt(ary[4]);
			int _dp = Integer.parseInt(ary[5]);
			
			bosses.add(new Boss(ary[0], _hp, _mp, _level, 0, _ad, _dp));
		}
		inputStream.close();
	}
	
	public static void system_StageUp() {
		for(int i=0; i < monsters.size(); i++) monsters.get(i).levelUp();
		for(int i=0; i < bosses.size(); i++) bosses.get(i).levelUp();	
	}

}
