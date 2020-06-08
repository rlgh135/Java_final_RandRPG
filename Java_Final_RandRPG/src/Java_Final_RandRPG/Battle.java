package Java_Final_RandRPG;

import java.util.*;

class Battle {
	private Player player;
	private Monster monster;
	private boolean isboss;
	
	public Battle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
		isboss = monster instanceof Boss;
	}
	
	public boolean Progress(Scanner sc) {
		monster.Show();
		player.Show();
		while (true) {
			Interface.show_battle(isboss);
			switch(sc.next().charAt(0)) {
			case '1':
				if (Attack()) return true;
				break;
			case '2':
				if(!Skill()) { continue; }
				break;
			case '3':
				player.Show();
				continue;
			case '4':
				player.ShowInventory();
				continue;
			case '0':
				if (!isboss) {
					if(Run(25))	return false; //Run 했을 때 도망치는데 성공해도 map으로 돌아가지 않아서 수정함.
					break;
					
				}
				System.out.println("Wrong input.");
				continue;
			default:
				System.out.println("Wrong input.");
				continue;
			}
			if (Attacked()) System.exit(0);
		}
	}
	
	public boolean Attack() {
		Interface.show_attack();
		if (monster.Attacked(player.Damage())) {
			return true;
		}
		monster.Show();
		Interface.enterAnyKey();
		return false;
	}
	
	public boolean Attacked() {
		Interface.show_attacked();
		if (player.Attacked(monster.Damage())) {
			return true;
		}
		player.Show();
		Interface.enterAnyKey();
		return false;
	}
	
	public static boolean Run(int percent) {
		Random rand = new Random();
		if (rand.nextInt(100) < percent) {
			Interface.show_run(true);
			return true;
		}
		Interface.show_run(false);
		return false;
	}
	
	public void Result(ArrayList<Item> items, ArrayList<Set> sets, int percent) {

		Interface.monster_die();
		if (new Random().nextInt(100) < percent) {
			Item it = items.get(new Random().nextInt(items.size()));
			int i=0;
			while(player.hasItem(it) && i < items.size()*10 && it.getNo()%5 == 0) {
				it = items.get(new Random().nextInt(items.size()));
				i++;
			}
			if(!player.hasItem(it)) {
				System.out.println("\n\t\t\tYou get a item.");
				it.Show();
				
				player.AddItem(it);
				player.PlusItem(it);
				
				for(Set set : sets) {
					if (player.canAddSet(set)) {
						System.out.println("\t\t\tThe set has been added.");
						set.Show();
						player.AddSet(set);
						player.PlusSet(set);
					}
				}
			}
			Interface.enterAnyKey();
		}
		int temp = 0;
		if(isboss) temp = monster.getStatus().level*10;
		else temp = monster.getStatus().level*5;
		player.PlusExp(temp);
	}
	
	public boolean Skill() {
		if(!player.ShowSkill()) { return false; } //skill이 없거나 사용 취소하면 바로 배틀메뉴로 돌아가게
		
		return true;
	}
}
