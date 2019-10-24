package exceptions.phoneAdmin;

//unchecked --> eredito da RuntimeException
public class InvalidCallDataParameter extends RuntimeException {
	
	public InvalidCallDataParameter() {
		super();
	}
	
	public InvalidCallDataParameter(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		
		return "Some call data parameter are wrong";
	}

}
