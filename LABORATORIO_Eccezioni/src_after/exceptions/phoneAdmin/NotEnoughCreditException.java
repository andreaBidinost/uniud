package exceptions.phoneAdmin;

//Checked --> eredito da Exception
public class NotEnoughCreditException extends Exception {
	public NotEnoughCreditException( String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		
		return "Not enough credit for call";
	}
}
