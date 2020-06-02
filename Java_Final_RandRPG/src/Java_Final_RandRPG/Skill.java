import java.util.*;
public class Skill {
	/*
	메인에서 선언
	skillStructure[] s=new skillStructure[5];
	  for(int i=0;i<s.length;i++) {
			s[i]=new skillStructure();
		}
	사용 예시:
	스킬 창 확인 - infoSkill(s);
	전투시 스킬 확인 - chooseSkill
	 */

	//lev_skillList로부터 호출, 스킬을 스킬 스트럭쳐에 기록함
	public void learnSkill(int trigger, SkillStructure[] s) {
		switch(trigger) {
		// trigger를 받아서 트리거에 해당하는 번호 스킬내용을 구조체에 기록
		case 1:
			System.out.println("Learn Heal");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=1;
					s[i].SkillName="Heal";
					s[i].ToolTip="HP를 회복한다";
					s[i].ChoiceTimes=1;
					s[i].UseMp=10;
					break;
				}
				else if(s[i].Skill_No==1 && s[i].ChoiceTimes>1) {
					s[i].ChoiceTimes=s[i].ChoiceTimes+1;
					s[i].UseMp+=1/2*s[i].UseMp;
					break;
				}
			}
			break;
			
		case 2:
			System.out.println("Learn Ignite");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=2;
					s[i].SkillName="Ignite";
					s[i].ToolTip="적에게 방어 무시 고정 피해를 입힌다";
					s[i].ChoiceTimes=1;
					s[i].UseMp=15;
					break;
				}
				else if(s[i].Skill_No==2 && s[i].ChoiceTimes>1) {
					s[i].ChoiceTimes=s[i].ChoiceTimes+1;
					s[i].UseMp+=1/2*s[i].UseMp;
					break;
				}
			}
			break;
			
		case 3:
			System.out.println("Learn Defence");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=3;
					s[i].SkillName="Defence";
					s[i].ToolTip="적의 공격을 방어한다";
					s[i].ChoiceTimes=1;
					s[i].UseMp=10;
					break;
				}
				else if(s[i].Skill_No==3 && s[i].ChoiceTimes>1) {
					s[i].ChoiceTimes=s[i].ChoiceTimes+1;
					s[i].UseMp+=1/2*s[i].UseMp;
					break;
				}
			}
			break;
			
		case 4:
			System.out.println("Learn Run");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=4;
					s[i].SkillName="Run";
					s[i].ToolTip="100% 확률로 도망친다";
					s[i].ChoiceTimes=1;
					s[i].UseMp=30;
					break;
				}
				else if(s[i].Skill_No==4 && s[i].ChoiceTimes>1) {
					s[i].ChoiceTimes=s[i].ChoiceTimes+1;
					System.out.println("메롱! Run은 성능이 증가하지 않습니다!");
					break;
				}
			}
			break;
			
		case 5:
			System.out.println("Learn Double Atack");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=5;
					s[i].SkillName="Double Atack";
					s[i].ToolTip="ATK의 2배로 공격한다";
					s[i].ChoiceTimes=1;
					s[i].UseMp=14;
					break;
				}
				else if(s[i].Skill_No==5 && s[i].ChoiceTimes>1) {
					s[i].ChoiceTimes=s[i].ChoiceTimes+1;
					s[i].UseMp+=1/2*s[i].UseMp;
					break;
				}
			}
			break;
			
		case 6:
			System.out.println(". ");
			break;
			
		case 7:
			System.out.println(". ");
			break;	
		}
	}
	
	// 비전투시 스킬 인포를 불러오는 창 메인에서 호출
	public void infoSkill(SkillStructure[] s) {
		if(s[0].Skill_No==-1) {
			System.out.println("습득한 스킬이 없습니다.");
			return;
		}
		for(int i=0; i<s.length;i++) {
			if(s[i].Skill_No==-1) {
				break;
			}
			System.out.println(i+". "+s[i].SkillName +"level: "+s[i].ChoiceTimes);
			System.out.println("소모 mp"+s[i].UseMp);
			System.out.println("효과: "+s[i].ToolTip);
		}
	}
	
	// 전투시 스킬의 사용, chooseSkill에서 번호와 중첩 횟수를 받아서 스킬 사용 함수를 호출
	public void useSkill(/*Player p,*/int Skill_Num, int Skill_ChoiceTimes) {
		switch(Skill_Num) {
		case 1:
			System.out.println("Heal");
			// 스킬 함수 호출
			Heal(/*p,*/Skill_ChoiceTimes);
			break;
		case 2:
			System.out.println("Ignite");
			Ignite(/*p,*/Skill_ChoiceTimes);
			break;
		case 3:
			System.out.println("Defence");
			Defence(/*p,*/Skill_ChoiceTimes);
			break;
		case 4:
			System.out.println("Run");
			Run(/*p,*/Skill_ChoiceTimes);
			break;
		case 5:
			System.out.println("Double atack");
			Double_atack(/*p,*/Skill_ChoiceTimes);
			break;
		case 6:
			System.out.println(". ");
			break;
		case 7:
			System.out.println(". ");
			break;	
		}
	}
	
	// 전투 시 스킬 사용 선택 시 불러오는 메소드 스킬 정보를 출력해주고 번호를 받아 useSkill로 넘겨준다
	public void chooseSkill(/*Player p,*/SkillStructure[] s) {
		int choose=-1;
		int Skill_Num=-1;
		int Skill_ChoiceTimes=0;
		Scanner sc= new Scanner(System.in);
		if(s[0].Skill_No==-1) {
			System.out.println("습득한 스킬이 없습니다.");
			sc.close();
			return;
		}
		for(int i=0; i<s.length;i++) {
			if(s[i].Skill_No==-1) {
				break;
			}
			System.out.println(i+". "+s[i].SkillName);
		}
		System.out.println("9.사용취소");
		choose=sc.nextInt();
		sc.close();
		if(choose==9)
			return;
		Skill_Num=s[choose-1].Skill_No;
		Skill_ChoiceTimes=s[choose-1].ChoiceTimes;
		useSkill(/*p,*/Skill_Num, Skill_ChoiceTimes);	
	}
	
	// 스킬 습득 가능 레벨에 메인에서 불러오기 랜덤하게 배울 스킬을 생성해줌
	public void lev_skillList(SkillStructure[] s) {
		int num_skill1= 0;
		int num_skill2= 0;
		int num_skill3= 0;
		int trigger= -1;
		boolean stop= false;
		Scanner sc= new Scanner(System.in);
		Random rand = new Random();
		
		while(!stop) {
				// Make random 3 integers 1 to 9
				num_skill1 = rand.nextInt(9)+1;
				num_skill2 = rand.nextInt(9)+1;
				num_skill3 = rand.nextInt(9)+1;
            
				// Make 3 integers different
				if((num_skill2==num_skill1) || (num_skill2==num_skill3)) {   
					num_skill2 = rand.nextInt(9)+1;
				}
				else if((num_skill3==num_skill1) || (num_skill3==num_skill2)) {
					num_skill3 = rand.nextInt(9)+1;     
				}      
				else {
					stop = true;
				}      
        	}
		
		showSkill(num_skill1, num_skill2, num_skill3);
		
		trigger=sc.nextInt();
		sc.close();
		if(trigger==9) {
			return;
		}
		learnSkill(trigger ,s);
	}
	
	// 랜덤 선택시 스킬 보여줌
	public void showSkill(int num_skill1, int num_skill2, int num_skill3) {
		System.out.println("습득할 스킬을 고르세요");
		System.out.println("-------------------------------");
		
		switch(num_skill1) {
		case 1:
			System.out.println("1. Heal");
			break;
		case 2:
			System.out.println("2. Ignite");
			break;
		case 3:
			System.out.println("3. Defence");
			break;
		case 4:
			System.out.println("4. Run");
			break;
		case 5:
			System.out.println("5. Double Attack");
			break;
		case 6:
			System.out.println("6. Ignite");
			break;
		case 7:
			System.out.println("7. Ignite");
			break;	
		}
		
		switch(num_skill2) {
		case 1:
			System.out.println("1. Heal");
			break;
		case 2:
			System.out.println("2. Ignite");
			break;
		case 3:
			System.out.println("3. Defence");
			break;
		case 4:
			System.out.println("4. Run");
			break;
		case 5:
			System.out.println("5. Double Attack");
			break;
		case 6:
			System.out.println("6. Ignite");
			break;
		case 7:
			System.out.println("7. Ignite");
			break;	
		}
		
		switch(num_skill3) {
		case 1:
			System.out.println("1. Heal");
			break;
		case 2:
			System.out.println("2. Ignite");
			break;
		case 3:
			System.out.println("3. Defence");
			break;
		case 4:
			System.out.println("4. Run");
			break;
		case 5:
			System.out.println("5. Double Attack");
			break;
		case 6:
			System.out.println("6. Ignite");
			break;
		case 7:
			System.out.println("7. Ignite");
			break;
		}
		System.out.println("9. 배우지 않는다");
		System.out.println("-------------------------------");
	}
	public void Heal(/*Player p,*/int Skill_ChoiceTimes) {
		/*
		 
		 p.hp += 1/2*Skill_ChoiceTimes*p.hp;
		 */
	}
	public void Ignite(/*Player p,*/int Skill_ChoiceTimes) {
		/*
		 monster_hp -= 1/2*Skill_ChoiceTimes*100;
		 */
	}
	public void Defence(/*Player p,*/int Skill_ChoiceTimes) {
		
	}
	public void Run(/*Player p,*/int Skill_ChoiceTimes) {
		
	}
	public void Double_atack(/*Player p,*/int Skill_ChoiceTimes) {
		
	}
}