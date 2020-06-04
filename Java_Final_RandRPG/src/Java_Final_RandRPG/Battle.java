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
		while (true) {
			System.out.println("Choose one.");
			System.out.println("1. attack");
			System.out.println("2. skill");
			System.out.println("3. information");
			System.out.println("4. item");
			if (!isboss) System.out.println("0. run");
			switch(sc.next().charAt(0)) {
			case '1':
				if (Attack()) return true;
				break;
			case '2':
				Skill();
				continue;
			case '3':
				player.Show();
				continue;
			case '4':
				player.ShowInventory();
				continue;
			case '0':
				if (!isboss) {
					if (Run(25)) return false;
					break;
				}
			default:
				System.out.println("Wrong input.");
				continue;
			}
			if (Attacked()) System.exit(0);
		}
	}
	
	public boolean Attack() {
		System.out.println("You attack.");
		if (monster.Attacked(player.Damage())) {
			return true;
		}
		monster.Show();
		return false;
	}
	
	public boolean Attacked() {
		System.out.println("You're attacked.");
		if (player.Attacked(monster.Damage())) {
			return true;
		}
		player.Show();
		return false;
	}
	
	public static boolean Run(int percent) {
		Random rand = new Random();
		if (rand.nextInt(100) < percent) {
			System.out.println("You ran away successfully.\n");
			return true;
		}
		System.out.println("You couldn't get away.\n");
		return false;
	}
	
	public void Result(ArrayList<Item> items, ArrayList<Set> sets, int percent) {

		System.out.println("Monster Die.\n");
		if (new Random().nextInt(100) < percent) {
			Item it = items.get(new Random().nextInt(items.size()));
			int i=0;
			while(player.hasItem(it) && i < items.size()*10 && it.getNo()%5 == 0) {
				it = items.get(new Random().nextInt(items.size()));
				i++;
			}
			if(!player.hasItem(it)) {
				System.out.println("You get a item.\n");
				it.Show();
				
				player.AddItem(it);
				player.PlusItem(it);
				
				for(Set set : sets) {
					if (player.canAddSet(set)) {
						System.out.println("The set has been added.\n");
						set.Show();
						player.AddSet(set);
						player.PlusSet(set);
					}
				}
			}
		}
		int temp = 0;
		if(isboss) temp = monster.getStatus().level*10;
		else temp = monster.getStatus().level*5;
		player.PlusExp(temp);
	}
	
	public void Skill() {
		System.out.println("Choose one.");
		player.ShowSkill();
	}

}