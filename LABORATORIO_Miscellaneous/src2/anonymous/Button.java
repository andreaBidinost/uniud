package anonymous;

public class Button {

	private Exectutable action;
	
	public Button(Exectutable action) {
		this.action = action;
	}
	
	public void click() {
		action.execute();//callback ("Hollywood")
	}
}
