public class Item {
	private String name;
	private String desc;
	private Status status;
	
	public Item(String name, String desc, int pmaxHp, int pmaxMp, int pad, int pdp){
		this.name = name;
		this.desc = desc;
		status = new Status(pmaxHp, pmaxMp, pad, pdp);
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
		System.out.println("Hp : " + status.pmaxHp);
		System.out.println("Mp : " + status.pmaxMp);
		System.out.println("Ad : " + status.pad);
		System.out.println("Dp : " + status.pdp);
	}
	
	public Status getStatus() {
		return new Status(status);
	}
}