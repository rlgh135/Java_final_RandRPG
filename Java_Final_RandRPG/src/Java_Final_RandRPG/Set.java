package Java_Final_RandRPG;

import java.util.*;

public class Set {
	private String name;
	private int no;
	private ArrayList<Integer> combi;
	private Status status;
	
	public Set(int no, String name, ArrayList<Integer> combi, int pmaxHp, int pmaxMp, int pad, int pdp){
		this.no = no;
		this.name = name;
		this.combi = combi;
		status = new Status(pmaxHp, pmaxMp, pad, pdp);
	}
	public int getNo() {
		return no;
	}
	public void Show() {
		System.out.println(" -------------------------------------------------------");
		System.out.println("\tSet : " + name);
		System.out.println("\t\t\t\t\t|");
		System.out.println("\tHp : " + status.pmaxHp);
		System.out.println("\t\t\t\t\t\t|");
		System.out.println("\tMp : " + status.pmaxMp);
		System.out.println("\t\t\t\t\t\t|");
		System.out.println("\tAd : " + status.pad);
		System.out.println("\t\t\t\t\t\t|");
		System.out.println("\tDp : " + status.pdp);
		System.out.println("\t\t\t\t\t\t|");
		System.out.println(" -------------------------------------------------------");
		System.out.println();
	}
	public Status getStatus() {
		return new Status(status);
	}
	public ArrayList<Integer> getCombi(){
		return new ArrayList<Integer>(combi);
	}
}
