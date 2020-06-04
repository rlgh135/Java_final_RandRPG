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
		System.out.println("Set : " + name);
		System.out.println("Hp : " + status.pmaxHp);
		System.out.println("Mp : " + status.pmaxMp);
		System.out.println("Ad : " + status.pad);
		System.out.println("Dp : " + status.pdp);
	}
	public Status getStatus() {
		return new Status(status);
	}
	public ArrayList<Integer> getCombi(){
		return new ArrayList<Integer>(combi);
	}
}
