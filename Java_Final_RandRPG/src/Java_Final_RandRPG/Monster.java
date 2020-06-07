package Java_Final_RandRPG;

public class Monster {
	
	public String name;
	
	private Status status;
	
	public Monster(Monster m) {
		name = new String(m.name);
		status = new Status(m.getStatus());
	}
	
	public void Show() {
		System.out.printf("\n      Monster : %s\n", name);
		status.Show();
	}
	
	public Monster getMosnter(Monster monster) {
		Monster m = new Monster(monster);
		return m;
	}
	
	public Status getStatus() {
		Status s = new Status(status);
		return s;
	}
	
	public Monster(String _name, int _hp, int _mp, int _level, int _exp, int _ad, int _dp) {
		name = _name;
		status = new Status(_hp, _mp, _level, _exp, _ad, _dp);
	}
	
	public boolean Attacked(int damage) {
		if(damage - status.dp - status.pdp <= 0)
			status.hp -= 1;
		else
			status.hp -= damage - status.dp - status.pdp;
		if (status.hp <= 0)
			return true;
		return false;
	}
	
	public int Damage() {
		return status.ad + status.pad;
	}
	public void levelUp() {
		this.status.level += 1;
		this.status.maxHp += 10;
		this.status.ad += 2;
		this.status.dp += 1;
	}
}
