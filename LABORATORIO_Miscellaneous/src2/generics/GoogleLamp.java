package generics;

public class GoogleLamp implements IotDevice<Google>{
	
	public void turnOn() {}
	
	public void turnOff() {}

	@Override
	public boolean isEqual(IotDevice<Google> other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void receive(String msg) {
		// TODO Auto-generated method stub
		
	}
}
