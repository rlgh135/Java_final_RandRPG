package Java_Final_RandRPG;

public class Item {
	private int no;
	private String name;
	private String desc;
	private Status status;
	private char grade;
	private String theme;
	
	public Item(int no, String name, String desc, int pmaxHp, int pmaxMp, int pad, int pdp, char grade, String theme){
		this.no = no;
		this.name = name;
		this.desc = desc;
		this.grade = grade;
		this.theme = theme;
		status = new Status(pmaxHp, pmaxMp, pad, pdp);
	}
	
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return new String(name);
	}
	
	public String getDescription() {
		return new String(desc);
	}
	
	public void Show() {
		System.out.println(" -------------------------------------------------------");
		System.out.print("|\tItem name : " + name);
		System.out.println("\t\t\t\t|");
		System.out.print("|\tItem description : " + String.format("%-20s", desc));
		System.out.println("\t\t|");
		System.out.print("|\tTheme : " + String.format("%-20s", theme));
		System.out.println("\t\t\t|");
		System.out.print("|\tGrade : " + grade);
		System.out.println("\t\t\t\t\t|");
		System.out.print("|\tHp : " + status.pmaxHp);
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|\tMp : " + status.pmaxMp);
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|\tAd : " + status.pad);
		System.out.println("\t\t\t\t\t\t|");
		System.out.print("|\tDp : " + status.pdp);
		System.out.println("\t\t\t\t\t\t|");
		System.out.print(" -------------------------------------------------------");
		System.out.println();
	}
	
	public Status getStatus() {
		return new Status(status);
	}
}