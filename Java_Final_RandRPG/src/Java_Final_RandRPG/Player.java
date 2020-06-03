import java.util.*; 

class Player {
	private Status status;
	private ArrayList<Item> item_status;
	private ArrayList<Skill> skill_status;
	//수정
	public skillStructure[] skillstrucure= new skillStructure[5];
	//

	Player(){//초기 캐릭터 설정값
		status = new Status(50, 50, 1, 5, 4, 4);
		item_status = new ArrayList<Item>();
		skill_status = new ArrayList<Skill>();
		//수정
		for(int i=0;i<skillstrucure.length;i++) {
			skillstrucure[i]=new skillStructure();
		}
		//
	}
	Player(int _hp, int _mp, int _level, int _exp, int _ad, int _dp, boolean[] have_items){
		status = new Status(_hp, _mp, _level, _exp, _ad, _dp);
		item_status = new ArrayList<Item>();
		skill_status = new ArrayList<Skill>();
	}
	public void addItem(Item item) {
		item_status.add(item);
		Status s = item.getStatus();
		status.pmaxHp += s.pmaxHp;
		status.pmaxMp += s.pmaxMp;
		status.pad += s.pad;
		status.pdp += s.pdp;
	}
	public void addSkill(Skill skill) {
		skill_status.add(skill);
	}
	public void Show() {
		System.out.println("Player information\n");
		status.Show();
	}
	public boolean Attacked(int damage) {
		if(damage - status.dp - status.pdp <= 0)
			status.hp -= 1;
		else
			status.hp -= damage - status.dp - status.pdp;
		if (status.hp <= 0) {
			System.out.println("YOU DIE.");
			return true;
		}
		return false;
	}
	public int Damage() {
		return status.ad + status.pad;
	}
	public void PlusHp(int n) {
		status.hp+=n;
		if(status.hp>status.maxHp+status.pmaxHp)
			status.hp=status.maxHp+status.pmaxHp;
	}
	public void PlusMp(int n) {
		status.mp+=n;
		if(status.mp>status.maxMp+status.pmaxMp)
			status.mp=status.maxMp+status.pmaxMp;
	}
	public void PlusExp(int n) {
		status.exp+=n;
		if(status.exp>=status.maxExp) {//레벨업할때마다 오를것들
			status.exp=status.exp%status.maxExp;
			status.level++;
			//수정
			if(status.level%3==0) {
				Skill.lev_skillList(skillstrucure);
			}
			//끗
			status.maxExp+=10;
			//수치
			status.maxHp+=10;
			status.maxMp+=10;
			status.hp=status.maxHp+status.pmaxHp;
			status.mp=status.maxMp+status.pmaxMp;
			status.ad+=2;
			status.dp+=2;
			System.out.println("Congratulations!! Lv."+status.level);
			this.status.Show();
		}
	}
	
	public void ShowInventory() {
		System.out.println("========================Inventory==========================");
		for (Item i : item_status){ 
			i.Show();
		}
		System.out.println("===========================================================");
	}
	//수정
	public void ShowSkill() {
		Skill.chooseSkill(skillstrucure);
		/*
		System.out.println("==========================Skill============================");
		for (Skill s : skill_status){ 
			s.Show();
		}
		System.out.println("===========================================================");
		*/
	}
	//
	
	public boolean hasItem(Item item) {
		for(Item i : item_status) {
			if (i.getName().equals(item.getName())) return true;
		}
		return false;
	}
}
