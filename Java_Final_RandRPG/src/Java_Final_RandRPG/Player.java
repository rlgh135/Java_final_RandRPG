import java.util.*; 

class Player {
	private Status status;
	private ArrayList<Item> item_status;
	private ArrayList<Set> set_status;
	public SkillStructure[] skillstructure = new SkillStructure[5];
	//private int money;

	Player(){//초기 캐릭터 설정값
		status = new Status(50, 50, 1, 5, 4, 4);
		item_status = new ArrayList<Item>();
		set_status = new ArrayList<Set>();
		for(int i=0;i<skillstructure.length;i++) skillstructure[i]=new SkillStructure();
	}
	Player(int _maxHp, int _hp, int _maxMp, int _mp, int _level, int _maxExp, int _exp, int _ad, int _dp, int _pmaxHp, int _pmaxMp, int _pad, int _pdp){
		status = new Status(0, 0, 0, 0, 0, 0);
		status.maxHp = _maxHp;
		status.hp = _hp;
		status.maxMp = _maxMp;
		status.mp = _mp;
		status.level = _level;
		status.maxExp = _maxExp;
		status.exp  = _exp;
		status.ad = _ad;
		status.dp = _dp;
		status.pmaxHp = _pmaxHp;
		status.pmaxMp = _pmaxMp;
		status.pad = _pad;
		status.pdp = _pdp;
		item_status = new ArrayList<Item>();
		set_status = new ArrayList<Set>();
		for(int i=0;i<skillstructure.length;i++) skillstructure[i]=new SkillStructure();
	}
	
	public void AddItem(Item item) {
		item_status.add(item);
	}
	public HashSet<Integer> getSetsNo() {
		HashSet<Integer> setsNo = new HashSet<Integer>();
		for(Set s : set_status) setsNo.add(s.getNo());
		return setsNo;
	}
	public HashSet<Integer> getItemsNo(){
		HashSet<Integer> itemsNo = new HashSet<Integer>();
		for(Item i : item_status) itemsNo.add(i.getNo());
		return itemsNo;
	}
	public HashSet<ArrayList<Integer>> getSkillsNo(){
		HashSet<ArrayList<Integer>> skillsNo = new HashSet<ArrayList<Integer>>();
		for(SkillStructure ss : skillstructure) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(ss.Skill_No);
			arr.add(ss.ChoiceTimes);
			skillsNo.add(arr);
		}
		return skillsNo;
	}
	public void PlusItem(Item item) {
		Status s = item.getStatus();
		status.pmaxHp += s.pmaxHp;
		status.pmaxMp += s.pmaxMp;
		status.pad += s.pad;
		status.pdp += s.pdp;
	}
	public void AddSet(Set set) {
		set_status.add(set);
	}
	public void PlusSet(Set set) {
		Status s = set.getStatus();
		status.pmaxHp += s.pmaxHp;
		status.pmaxMp += s.pmaxMp;
		status.pad += s.pad;
		status.pdp += s.pdp;
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
			if(status.level%3==0) {
				Skill.lev_skillList(skillstructure);
			}
			status.maxExp+=50;
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
		for (Item i : item_status) i.Show();
		System.out.println("==========================Set==============================");
		for (Set s : set_status) s.Show();
		System.out.println("===========================================================");
	}
	
	public Status getStatus() {
		return new Status(status);
	}
	
	public void ShowSkill() {
		Skill.chooseSkill(skillstructure);
	}
	
	
	public boolean hasItem(Item item) {
		for(Item i : item_status) {
			if (i.getNo() == item.getNo()) return true;
		}
		return false;
	}
	public boolean canAddSet(Set set) {
		HashSet<Integer> hash_set = new HashSet<Integer>();
		for(Item i : item_status) hash_set.add(i.getNo());
		for(Integer I : set.getCombi()) {
			if (!hash_set.contains(I)) return false;
		}
		for(Set s : set_status) {
			if (s.getNo() == set.getNo()) return false;
		}
		return true;	
	}
	public void loadSkill(int no, int times) {
		for(int i=0; i<times; i++)
		Skill.learnSkill(no, skillstructure, true);
	}
}