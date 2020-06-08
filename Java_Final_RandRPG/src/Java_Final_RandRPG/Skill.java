package Java_Final_RandRPG;

import java.util.*;

public class Skill {
	/*
	메인에서 선언
	SkillStructure[] s=new SkillStructure[5];
	  for(int i=0;i<s.length;i++) {
			s[i]=new SkillStructure();
		}
	사용 예시:
	전투시 스킬 확인 - chooseSkill
	 */


	/*
	// 비전투시 스킬 인포를 불러오는 창 메인에서 호출
	public void infoSkill(skillStructure[] s) {
		if(s[0].Skill_No==-1) {
			System.out.println("No skill you learned.");
			return;
		}
		for(int i=0; i<s.length;i++) {
			if(s[i].Skill_No==-1) {
				break;
			}
			System.out.println(i+". "+s[i].SkillName +"level: "+s[i].ChoiceTimes);
			System.out.println("Use Mp"+s[i].UseMp);
			System.out.println("Option: "+s[i].ToolTip);
		}
	}*/
	
	// 전투 시 스킬 사용 선택 시 불러오는 메소드 스킬 정보를 출력해주고 번호를 받아 useSkill로 넘겨준다
	public static int chooseSkill(SkillStructure[] s, Scanner sc) {
		int choose=-1;
		int Skill_Num=-1;
		int Skill_ChoiceTimes=0;
		if(s[0].Skill_No==-1) {
			Interface.hasNoSkills();
			return -1;
		}
		for(int i=0; i<s.length;i++) {
			if(s[i].Skill_No==-1) {
				break;
			}
			System.out.println(i+1+". "+s[i].SkillName);
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
	
	// 전투시 스킬의 사용, chooseSkill에서 번호와 중첩 횟수를 받아서 스킬 사용 함수를 호출
	public static void useSkill(int Skill_Num, int Skill_ChoiceTimes) {
		switch(Skill_Num) {
		case 1:
			System.out.println("Heal");
			// 스킬 함수 호출
			Heal(Skill_ChoiceTimes);
			break;
		case 2:
			System.out.println("Smite");
			Smite(Skill_ChoiceTimes);
			break;
		case 3:
			System.out.println("Ignite");
			Ignite(Skill_ChoiceTimes);
			break;
		case 4:
			System.out.println("Run");
			Run(Skill_ChoiceTimes);
			break;	
		}
	}
	
	// 스킬 습득 가능 레벨에 메인에서 불러오기 랜덤하게 배울 스킬을 생성해줌
	public static void lev_skillList(SkillStructure[] s) {
		int num_skill1= 0;
		int num_skill2= 0;
		int num_skill3= 0;
		int trigger= -1;
		boolean stop= false;
		Scanner sc = Main.sc;
		Random rand = new Random();
		
		while(!stop) {
				// Make random 3 integers 1 to 9
				num_skill1 = rand.nextInt(4)+1;
				num_skill2 = rand.nextInt(4)+1;
				num_skill3 = rand.nextInt(4)+1;
            
				// Make 3 integers different
				if((num_skill2==num_skill1) || (num_skill2==num_skill3)) {   
					num_skill2 = rand.nextInt(4)+1;
				}
				else if((num_skill3==num_skill1) || (num_skill3==num_skill2)) {
					num_skill3 = rand.nextInt(4)+1;     
				}      
				else {
					stop = true;
				}      
        	}
		
		showSkill(num_skill1, num_skill2, num_skill3);
		trigger=sc.nextInt();
		if(trigger==9) {
			return;
		}
		learnSkill(trigger, s, false);
	}
	
	// 랜덤 선택시 스킬 보여줌
	public static void showSkill(int num_skill1, int num_skill2, int num_skill3) {
		System.out.println("\tChoose A Skill you want.");
		System.out.println("-------------------------------");
		
		switch(num_skill1) {
		case 1:
			System.out.println("1. Heal");
			break;
		case 2:
			System.out.println("2. Smite");
			break;
		case 3:
			System.out.println("3. Ignite");
			break;
		case 4:
			System.out.println("4. Run");
			break;	
		}
		
		switch(num_skill2) {
		case 1:
			System.out.println("1. Heal");
			break;
		case 2:
			System.out.println("2. Smite");
			break;
		case 3:
			System.out.println("3. Ignite");
			break;
		case 4:
			System.out.println("4. Run");
			break;	
		}
		
		switch(num_skill3) {
		case 1:
			System.out.println("1. Heal");
			break;
		case 2:
			System.out.println("2. Smite");
			break;
		case 3:
			System.out.println("3. Ignite");
			break;
		case 4:
			System.out.println("4. Run");
			break;
		}
		System.out.println("0. Cancel");
		System.out.println("-------------------------------");
	}
	
	//lev_skillList로부터 호출, 스킬을 스킬 스트럭쳐에 기록함
	public static void learnSkill(int trigger, SkillStructure[] s, boolean isload) {
		switch(trigger) {
		// trigger를 받아서 트리거에 해당하는 번호 스킬내용을 구조체에 기록
		case 1:
			if (!isload) System.out.println("You Have Learnt Heal!");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=1;
					s[i].SkillName="Heal";
					s[i].ToolTip="Recover HP";
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
			if (!isload) System.out.println("You Have Learnt Smite");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=2;
					s[i].SkillName="Smite";
					s[i].ToolTip="Damage to enemy ignore defence";
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
			if (!isload) System.out.println("You Have Learnt Ignite");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=3;
					s[i].SkillName="Ignite";
					s[i].ToolTip="Drop Enemy's defence";
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
			if (!isload) System.out.println("You Have Learnt Run");
			for(int i=0; i<s.length;i++) {
				if(s[i].Skill_No==-1) {
					s[i].Skill_No=4;
					s[i].SkillName="Run";
					s[i].ToolTip="Run away 100%";
					s[i].ChoiceTimes=1;
					s[i].UseMp=30;
					break;
				}
				else if(s[i].Skill_No==4 && s[i].ChoiceTimes>1) {
					s[i].ChoiceTimes=s[i].ChoiceTimes+1;
					System.out.println("HaHa run cannot upgrade! You throw out your chance!");
					break;
				}
			}
			break;	
		}
	}
	public static void Heal(/*Player p,*/ int Skill_ChoiceTimes) {
		// p.hp += 1/2*Skill_ChoiceTimes*p.hp;
		 
		// player.hp += 1/2*Skill_ChoiceTimes*p.hp;
	}
	public static void Smite(/*Player p,*/int Skill_ChoiceTimes) {
		/*
		 monster_hp -= 1/2*Skill_ChoiceTimes*10;
		 */
	}
	public static void Ignite(/*Player p,*/int Skill_ChoiceTimes) {
		/*
		 * monster_def -= 1/2*Skill_ChoiceTimes*2;
		 */
	}
	public static void Run(/*Player p,*/int Skill_ChoiceTimes) {
		Battle.Run(100);
	}	
}