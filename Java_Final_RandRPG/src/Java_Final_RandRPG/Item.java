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
		System.out.println("Item name : " + name);
		System.out.println("Item description : " + desc);
		System.out.println("Theme : " + theme);
		System.out.println("Grade : " + grade);
		System.out.println("Hp : " + status.pmaxHp);
		System.out.println("Mp : " + status.pmaxMp);
		System.out.println("Ad : " + status.pad);
		System.out.println("Dp : " + status.pdp);
	}
	
	public Status getStatus() {
		return new Status(status);
	}
}