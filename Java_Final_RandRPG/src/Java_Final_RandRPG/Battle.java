import java.util.*;

class Battle {
	private Player player;
	private Monster monster;
	
	public Battle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
	}
	
	public void Progress(Scanner sc) {
		monster.Show();
		while (true) {
			System.out.println("Choose one.");
			System.out.println("1. attack");
			System.out.println("2. skill");
			System.out.println("3. information");
			System.out.println("4. item");
			System.out.println("0. run");
			switch(sc.next().charAt(0)) {
			case '1':
				if (Attack()) return;
				break;
			case '2':
				Skill();
				break;
			case '3':
				player.Show();
				continue;
			case '4':
				player.ShowInventory();
				continue;
			case '0':
				if (Run(25)) return;
				break;
			default:
				System.out.println("Wrong input.");
				break;
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
			System.out.println("You ran away successfully.");
			return true;
		}
		System.out.println("You couldn't get away.");
		return false;
	}
	
	public void Result(ArrayList<Item> items) {
		System.out.println("Monster Die.");
		if (new Random().nextInt(100) < 40) {
			Item it = items.get(new Random().nextInt(items.size()));
			int i=0;
			while(player.hasItem(it) && i < items.size()) {
				it = items.get(new Random().nextInt(items.size()));
				i++;
			}
			if(!player.hasItem(it)) player.addItem(it);
		}
		if(monster instanceof Boss) player.PlusExp(monster.getStatus().level*10);
		else player.PlusExp(monster.getStatus().level*5);
	}
	//수정
	public void Skill() {
		player.ShowSkill();
	}
	//

}
