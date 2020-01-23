package newgui.panels.addfacture;

public class TowarData {

	private int id;
	private int amount;
	
	public TowarData(int id, int amount) {
		super();
		this.id = id;
		this.amount = amount;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
