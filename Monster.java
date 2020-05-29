import java.util.Random;

public class Monster extends Status{
	
	public String name;//몬스터 이름 스테이지별 객체 생성시 넣어주기 [ 고블린, 골렘, 좀비,]
    public double hp;//현재 hp
	public double maxHp;//최대 hp
	public double strength;//공격력
	public int exp; //경험
	public int level; //스테이지에 따른 레벨   경험치 드랍을 위한 변수 
	
 public Monster(String name,double hp,double maxHp,double strength,int exp, int level) {
	    this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.strength = strength;
		this.exp = exp;
		this.level = level;
 }




public int attack(Status user) {
	 Random random = new Random();
     double percentage = 0.1 * (random.nextInt(4)+7);	 //확률에 따른 치명타 혹은 빗맞기 70%~100%
	 int damage = 0;
	 
	 if(this.strength>=user.getDefence()) {
		 damage = (int) ((int) (this.strength - user.getDefense()) * percentage); //방어구 수치 적용 후 데미지 리턴
		 user.setDefence(0); // 크거나 같으니까 방어구 수치 0 
		 user.setHp(user.getHp()-damage);
	 }
	 else {
	    damage = (int) ((int) (user.getDefense()-this.strength) * percentage);
	    user.setDefence(damage); // 방어구가 상쇄하고 남은 방어력 세팅
	    
	 }
	 
	 //if (this.hp<0) {
	 //  전투쪽으로 불리언이나 신호 전
      // }
	 
	 return damage; //표시용 
 }
 
 public int item_Exp(Status user) {
	 
	 Random random = new Random();
	double random_number = random.nextInt(100)+1;
	
	if(1<=random_number && random_number<=40) { //40% 확률로 아이템 드랍
		//라이브러리 import 해서 아이템 Status에 셋 해주기 
	}
	else {
		System.out.println("아무것도 떨어지지 않았습니다.");
	}
	 int exp = (int) (this.exp*this.level);    //레벨에 비례한 경험치 (비율조정가능) 
	 user.setExp(exp);  //경험치 세팅
	 
	 return exp; //표시용 
 }
 
 public void levelUp() { //레벨업 
	 this.maxHp += 200;
	 this.strength +=100;
	 
 }
 

	

}
