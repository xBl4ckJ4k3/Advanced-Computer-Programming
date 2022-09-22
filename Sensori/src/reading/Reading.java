package reading;

public class Reading implements IReading{
	
	private static final long serialVersionUID = -6131263826838306852L;
	
	private String type;
	private int data;
	
	public Reading(String type, int data){
		this.type = type;
		this.data = data;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getData() {
		return this.data;
	}
	
}
