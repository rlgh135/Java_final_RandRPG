package Java_Final_RandRPG;

import java.util.*;

public class Skill {
	
	// 스킬 습득 가능 레벨에 메인에서 불러오기 랜덤하게 배울 스킬을 생성해줌
	public static void lev_skillList(SkillStructure[] s) {
		
		int trigger= -1;
		Scanner sc = Main.sc;
		
		showSkill(1,2,3);
		trigger=sc.nextInt();
		if(trigger==9) {
			return;
		}
		learnSkill(trigger, s, false);
	}
	
	// 랜덤 선택시 스킬 보여줌
	public static void showSkill(int num_skill1, int num_skill2, int num_skill3) {
		System.out.println("\tChoose 1 Skill No. you want learn.");
		System.out.println("-------------------------------");
		
		switch(num_skill1) {
		case 1:
			System.out.println("No 1. Heal");
			break;
		case 2:
			System.out.println("No 2. MultiAttack");
			break;
		case 3:
			System.out.println("No 3. Run");
			break;
		}
		
		switch(num_skill2) {
		case 1:
			System.out.println("No 1. Heal");
			break;
		case 2:
			System.out.println("No 2. MultiAttack");
			break;
		case 3:
			System.out.println("No 3. Run");
			break;	
		}
		
		switch(num_skill3) {
		case 1:
			System.out.println("No 1. Heal");
			break;
		case 2:
			System.out.println("No 2. MultiAttack");
			break;
		case 3:
			System.out.println("No 3. Run");
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
			if (!isload) System.out.println("You Have Learn Heal!");
			
				if(s[0].Skill_No==-1) {
					s[0].Skill_No=1;
					s[0].SkillName="Heal";
					s[0].ToolTip="Recover HP";
					s[0].ChoiceTimes=1;
					s[0].UseMp=10;
					break;
				}
				else if(s[0].Skill_No==1 && s[0].ChoiceTimes>1) {
					s[0].ChoiceTimes=s[0].ChoiceTimes+1;
					s[0].UseMp+=1/2*s[0].UseMp;
					break;
				}
			
			break;
			
		case 2:
			if (!isload) System.out.println("You Have Learn Multiattack");
			
				if(s[1].Skill_No==-1) {
					s[1].Skill_No=2;
					s[1].SkillName="Multiattack";
					s[1].ToolTip="Attack many times";
					s[1].ChoiceTimes=1;
					s[1].UseMp=15;
					break;
				}
				else if(s[1].Skill_No==2 && s[1].ChoiceTimes>1) {
					s[1].ChoiceTimes=s[1].ChoiceTimes+1;
					s[1].UseMp+=1/2*s[1].UseMp;
					break;
				}
			
			break;
			
		case 3:
			if (!isload) System.out.println("You Have Learn Run");
			
				if(s[2].Skill_No==-1) {
					s[2].Skill_No=4;
					s[2].SkillName="Run";
					s[2].ToolTip="Run away 100%";
					s[2].ChoiceTimes=1;
					s[2].UseMp=30;
					break;
				}
				else if(s[2].Skill_No==4 && s[2].ChoiceTimes>1) {
					s[2].ChoiceTimes=s[2].ChoiceTimes+1;
					System.out.println("HaHa run cannot upgrade! You throw out your chance!");
					break;
				}
			
			break;	
		}
	}
}
