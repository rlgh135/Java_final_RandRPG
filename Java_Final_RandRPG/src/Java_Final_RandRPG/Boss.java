import java.util.Random;

public class Boss extends Monster{    // [ 부보스, 준보스, 중간보스,최종보스]
  

	
  public Boss(String name,double hp,double maxHp,double strength,int exp, int level) {
  	super(name,hp,maxHp,strength,exp,level);
  }
	
 //Override
  public int attack(Status user) {
		 Random random = new Random();
	     double percentage = 0.1 * (random.nextInt(7)+8);	 //확률에 따른 치명타 혹은 빗맞기 80%~150%
		 int damage = 0;
		 
		 if(this.strength>user.getDefence()) {
			 damage = (int) ((int) (this.strength - user.getDefense()) * percentage); //방어구를 수치 적용 후 데미지 리턴 
		 }
		 user.setHp(user.getHp()-damage);
		 
		 //if (this.hp<0) {
		 //  전투쪽으로 불리언이나 신호 전
	      // }
		 
		 return damage;
	 }
  
  
  
  public int item_Exp(Status user) {
		 
		
		if (this.name.equals("부보스")) {//무기 획득
            //보스무기 획득 
		}
		
		else if (this.name.equals("준보스")) {//무기 획득
			//보스무기 획득 
		}
		
		else if (this.name.equals("중간보스")) {//무기 획득
			//보스무기 획득 
		}
		
		else {//무기 획득
			
			//보스무기 획득 
		}
		
		 int exp = (int) (this.exp*this.level);    //레벨에 비례한 경험치 
		 user.setExp(exp);  //경험치 세팅
		 
		 return exp; //표시용 
	 }
  
  
  
  
  
  
}
