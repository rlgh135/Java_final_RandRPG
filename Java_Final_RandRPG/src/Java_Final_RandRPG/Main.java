import java.util.*;
import java.io.*;

public class Main {
	public static Scanner sc;
	public static Scanner inputStream;
	public static PrintWriter outputStream;
	public static char input;
	public static Map map;
	public static Player player;
	public static ArrayList<Monster> monsters;
	public static ArrayList<Item> items;
	public static ArrayList<Boss> bosses;
	public static ArrayList<Set> sets;
	
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
			break;
		case '0':
			System.exit(0);
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
		while(true) {
			map.print_map();
			system_Input();
			switch(input) {
			case 'w':
			case 'a':
			case 's':
			case 'd':
				break;
			case '1':
				menu_Save();
				continue;
			case '2':
				player.Show();
				continue;
			case '3':
				player.ShowInventory();
				continue;
			case '0':
				System.exit(0);
			default:
				continue;
			}
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
	
	public static void menu_Save() {
		save_Player();
		save_Map();
		save_Inventory();
		save_Skill();
	}
	
	public static void save_Player() {
		try{outputStream = new PrintWriter("save_player.txt");}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		Status s = player.getStatus();
		outputStream.println(s.maxHp);
		outputStream.println(s.hp);
		outputStream.println(s.maxMp);
		outputStream.println(s.mp);
		outputStream.println(s.level);
		outputStream.println(s.maxExp);
		outputStream.println(s.exp);
		outputStream.println(s.ad);
		outputStream.println(s.dp);
		outputStream.println(s.pmaxHp);
		outputStream.println(s.pmaxMp);
		outputStream.println(s.pad);
		outputStream.println(s.pdp);
		outputStream.close();
	}
	
	public static void save_Map() {
		try{outputStream = new PrintWriter("save_map.txt");}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		ArrayList<Integer> l = map.Info();
		outputStream.println(l.get(0));
		outputStream.println(l.get(1));
		outputStream.println(l.get(2));
		outputStream.println(l.get(3));
		outputStream.println(l.get(4));
		outputStream.close();
	}

	public static void save_Inventory() {
		try{outputStream = new PrintWriter("save_item.txt");}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		for(Integer i : player.getItemsNo()) outputStream.println(i.intValue());
		outputStream.close();
		try{outputStream = new PrintWriter("save_set.txt");}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		for(Integer i : player.getSetsNo()) outputStream.println(i.intValue());
		outputStream.close();
	}

	public static void save_Skill() {
		try{outputStream = new PrintWriter("save_skill.txt");}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		for(ArrayList<Integer> l : player.getSkillsNo()) {
			System.out.println(l.get(0) +" " + l.get(1));
			outputStream.println(l.get(0) + " " + l.get(1));
		}
		outputStream.close();
	}
	
	public static void menu_Load() {
		saveLoad_Player();
		saveLoad_Map();
		saveLoad_Inventory();
		saveLoad_Skill();
		menu_Start();
	}
	
	public static void saveLoad_Player() {
		try {
			inputStream = new Scanner(new File("save_player.txt"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		int _maxHp = Integer.parseInt(inputStream.nextLine());
		int _hp = Integer.parseInt(inputStream.nextLine());
		int _maxMp = Integer.parseInt(inputStream.nextLine());
		int _mp = Integer.parseInt(inputStream.nextLine());
		int _level = Integer.parseInt(inputStream.nextLine());
		int _maxExp = Integer.parseInt(inputStream.nextLine());
		int _exp = Integer.parseInt(inputStream.nextLine());
		int _ad = Integer.parseInt(inputStream.nextLine());
		int _dp = Integer.parseInt(inputStream.nextLine());
		int _pmaxHp = Integer.parseInt(inputStream.nextLine());
		int _pmaxMp = Integer.parseInt(inputStream.nextLine());
		int _pad = Integer.parseInt(inputStream.nextLine());
		int _pdp = Integer.parseInt(inputStream.nextLine());
		player = new Player(_maxHp, _hp, _maxMp, _mp, _level, _maxExp, _exp, _ad, _dp, _pmaxHp, _pmaxMp, _pad, _pdp);
		inputStream.close();
	}
	
	public static void saveLoad_Map() {
		try {
			inputStream = new Scanner(new File("save_map.txt"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		int _col = Integer.parseInt(inputStream.nextLine());
		int _row = Integer.parseInt(inputStream.nextLine());
		int _g_col = Integer.parseInt(inputStream.nextLine());
		int _g_row = Integer.parseInt(inputStream.nextLine());
		int _level = Integer.parseInt(inputStream.nextLine());
		map = new Map(_col, _row, _g_col, _g_row, _level);
		inputStream.close();
	}
	
	public static void saveLoad_Inventory() {
		try {
			inputStream = new Scanner(new File("save_item.txt"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		HashSet<Integer> hs = new HashSet<Integer>();
		while (inputStream.hasNext()) {
			hs.add(Integer.parseInt(inputStream.nextLine()));
		}
		for(Integer i : hs) {
			for(Item item : items) {
				if (i.intValue() == item.getNo()) player.AddItem(item);
			}
		}
		inputStream.close();
		try {
			inputStream = new Scanner(new File("save_set.txt"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		hs = new HashSet<Integer>();
		while (inputStream.hasNext()) {
			hs.add(Integer.parseInt(inputStream.nextLine()));
		}
		for(Integer i : hs) {
			for(Set set : sets) {
				if (i.intValue() == set.getNo()) player.AddSet(set);
			}
		}
		inputStream.close();
	}
	
	public static void saveLoad_Skill() {
		try {
			inputStream = new Scanner(new File("save_skill.txt"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		int _no;
		int _times;
		while(inputStream.hasNext()) {
			String line = inputStream.nextLine();
			String[] arr = line.split(" ");
			_no = Integer.parseInt(arr[0]);
			_times = Integer.parseInt(arr[1]);
			player.loadSkill(_no, _times);
		}
		inputStream.close();
	}
	
	public static void menu_GameOff() {
		sc.close();
	}
	
	public static void menu_Battle() {
		Random rand = new Random();
		Monster monster = new Monster(monsters.get(rand.nextInt(monsters.size())));
		Battle battle = new Battle(player, monster);
		ArrayList<Item> I = new ArrayList<Item>();
		for(Item i : items) {
			if (i.getNo()%5 != 0) I.add(i);
		}
		
		if (battle.Progress(sc)) battle.Result(I, sets, 100);
	}
	
	public static void menu_Boss() {
		Random rand = new Random();
		Boss boss = new Boss(bosses.get(rand.nextInt(bosses.size())));
		Battle battle = new Battle(player, boss);
		ArrayList<Item> I = new ArrayList<Item>();
		for(Item i : items) {
			if (i.getNo()%5 == 0) I.add(i);
		}
		
		battle.Progress(sc);
		
		battle.Result(I, sets, 100);
	}
	
	public static void load_GameSystem() {
		map = new Map();
		player = new Player();
		sc = new Scanner(System.in);
		
		load_Monster();
		load_Bosse();
		load_Item();
		load_Set();
	}
	
	public static void load_Monster() {
		try {
			inputStream = new Scanner(new File("monster.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
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
	
	public static void load_Item() {
		try {
			inputStream = new Scanner(new File("item.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		items = new ArrayList<Item>();
		String line = inputStream.nextLine();
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			String[] ary = line.split(",");
			int _no = Integer.parseInt(ary[0]);
			int _hp = Integer.parseInt(ary[3]);
			int _mp = Integer.parseInt(ary[4]);
			int _ad = Integer.parseInt(ary[5]);
			int _dp = Integer.parseInt(ary[6]);
			
			items.add(new Item(_no, ary[1], ary[2], _hp, _mp, _ad, _dp, ary[7].charAt(0), ary[8]));
		}
		inputStream.close();
	}
	
	public static void load_Bosse() {
		try {
			inputStream = new Scanner(new File("boss.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
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
	
	public static void load_Set() {
		try {
			inputStream = new Scanner(new File("set.csv"));
		}
		catch(FileNotFoundException e) {
		      System.out.println(e.getMessage());
		      System.exit(0);
		}
		sets = new ArrayList<Set>();
		String line = inputStream.nextLine();
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			String[] ary1 = line.split(",");
			int _no = Integer.parseInt(ary1[0]);
			ArrayList<Integer> _combi = new ArrayList<Integer>();
			String[] ary2 = ary1[2].split(" ");
			for(String str : ary2) _combi.add(Integer.parseInt(str));
			int _hp = Integer.parseInt(ary1[3]);
			int _mp = Integer.parseInt(ary1[4]);
			int _ad = Integer.parseInt(ary1[5]);
			int _dp = Integer.parseInt(ary1[6]);
			
			sets.add(new Set(_no, ary1[1], _combi, _hp, _mp, _ad, _dp));
		}
		inputStream.close();
	}
	
	public static void system_StageUp() {
		for(int i=0; i < monsters.size(); i++) monsters.get(i).levelUp();
		for(int i=0; i < bosses.size(); i++) bosses.get(i).levelUp();	
	}

}
