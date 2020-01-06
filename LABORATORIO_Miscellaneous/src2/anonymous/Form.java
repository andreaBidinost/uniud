package anonymous;

public class Form {
	private String title = "Form1";
	
	public Form() {
		Button btn = new Button(new Exectutable() {
			
			@Override
			public void execute() {
				Form newForm = new Form();
				newForm.show();
			}
		});
		
		show();
	}

	protected void show() {
		// TODO Auto-generated method stub
		
	}
}
