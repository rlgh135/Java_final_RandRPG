package Java_Final_RandRPG;

public class Boss extends Monster{
	
	Boss(String _name, int _hp, int _mp, int _level, int _exp, int _ad, int _dp){
		super(_name, _hp, _mp, _level, _exp, _ad, _dp);
	}
	public Boss getMosnter(Boss boss) {
		Boss b = new Boss(boss);
		return b;
	}
	public Boss(Boss b) { 
		super(b);
	}
}