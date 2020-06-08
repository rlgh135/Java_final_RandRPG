package Java_Final_RandRPG;

import java.util.*;

class Battle {
	private Player player;
	private Monster monster;
	private boolean isboss;
	Scanner sc = new Scanner(System.in);
	private int skilltrigger=0;
	public Battle(Player player, Monster monster) {
		this.player = player;
		this.monster = monster;
		isboss = monster instanceof Boss;
	}
	
	public boolean Progress(Scanner sc) {
		monster.Show();
		player.Show();
		
		while (true) {
			if(skilltrigger==1) {
				return true;
			}
			Interface.show_battle(isboss);
			switch(sc.next().charAt(0)) {
			case '1':
				if (Attack()) return true;
				break;
			case '2':
				if(!ShowSkill())
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
		
		this.skilltrigger=0;
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
		if(!ShowSkill()) { return false; }//skill이 없거나 사용 취소하면 바로 배틀메뉴로 돌아가게
		return true;
	}
	public int chooseSkill(skillStructure[] s, Scanner sc) {
		int choose=-1;
		int Skill_Num=-1;
		int Skill_ChoiceTimes=0;
		if(s[0].Skill_No==-1&&s[1].Skill_No==-1&&s[2].Skill_No==-1) {
			Interface.hasNoSkills();
			return -1;
		}
		for(int i=0; i<s.length;i++) {
			if(s[i].Skill_No!=-1) {
			System.out.println(i+1+". "+s[i].SkillName);
			}
		}
		System.out.println("0. Cancel");
		System.out.println("Your Choice .. => ");
		choose=sc.nextInt();
		if(choose==0)
			return 0;
		Skill_Num=s[choose-1].Skill_No;
		Skill_ChoiceTimes=s[choose-1].ChoiceTimes;
		useSkill(Skill_Num, Skill_ChoiceTimes);
		return 1;
	}
	
	public boolean ShowSkill() {
		int result = chooseSkill(Player.skillstructure, sc);
		if(result == -1 || result == 0) return false;
		return true;
	}
	public boolean Multiattack(int Skill_ChoiceTimes) {
		for(int i=0; i<Skill_ChoiceTimes; i++) {
			Interface.show_attacked();
			player.Attacked(monster.Damage());
			
		}
		if (player.Attacked(monster.Damage())) {
			return true;
		}
		player.Show();
		return false;
	
	}
	public boolean useSkill(int Skill_Num, int Skill_ChoiceTimes) {
		
		switch(Skill_Num) {
		case 1:
			System.out.println("Heal");
			// 스킬 함수 호출
			player.Heal();
			break;
		case 2:
			
			for(int i=0; i<player.skillstructure[1].ChoiceTimes; i++) {
				System.out.println("Multiattack"+i+1+"hit!");
				if (monster.Attacked(player.Damage())) {
					this.skilltrigger=1;
				}
			}
			break;
		case 3:
			System.out.println("Run");
			Run(100);
			break;	
		}
		return false;
	}
}
