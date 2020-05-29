import java.util.HashMap; 


class Character {
	public int HP,MP,EXP,Level,OP,DP,Money;//체력 마나량 경험치 레벨 공격력 방어력 돈
	int MaxHP,MaxMP,MaxEXP;//최대체력,최대마나량,레벨업되기 위해 필요한 경험치량
	HashMap<String,Integer> item= new HashMap<String,Integer>();//아이템이름과 수량
	Character(){//초기 캐릭터 설정값
		MaxHP=50;
		MaxMP=50;
		HP=MaxHP;
		MP=MaxMP;
		EXP=0;
		Level=1;
		OP=4;
		DP=4;
		MaxEXP=100;
		Money=0;
	}
	public void PlusHp(int n) {
		HP+=n;
		if(HP>MaxHP)
			HP=MaxHP;
	}
	public void PlusMp(int n) {
		MP+=n;
		if(MP>MaxMP)
			MP=MaxMP;
	}
	public void PlusExp(int n) {
		EXP+=n;
		if(EXP>=MaxEXP) {//레벨업할때마다 오를것들
			EXP=EXP%MaxEXP;
			Level++;
			MaxEXP+=50;
			MaxHP+=10;
			MaxMP+=10;
			HP=MaxHP;
			MP=MaxMP;
			OP+=2;
			DP+=2;
			System.out.println("축하합니다!! Lv."+Level+"이 되셨습니다.");
			this.ShowMyStatus();
		}
	}
	public void ShowMyStatus() {
		System.out.println("==========================케릭터 정보 ==========================");
        System.out.println("레벨: " + Level);
        System.out.println("hp: " + HP+ "/" + MaxHP);
        System.out.println("mp: " + MP + "/" + MaxMP);
        System.out.println("공격력: " + OP);
        System.out.println("방어력: " + DP);
        System.out.println("돈: " + Money + "원");
        System.out.println("경험치: " + EXP+ "/" + MaxEXP);
        System.out.println("===========================================================");
	}
	public void GetItem(String name,int n) {
		item.put(name,n);
	}
	public void ShowInventory() {
		System.out.println("==========================인벤토리===========================");
		for (String keyItemName : item.keySet()){ 
		System.out.println(keyItemName + "\t" + item.get(keyItemName) + "개"); 
		} 
		System.out.println("===========================================================");
	}	
}
