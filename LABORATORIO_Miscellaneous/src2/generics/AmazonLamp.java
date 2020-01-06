package generics;

public class AmazonLamp implements IotDevice<Amazon>{
		
		public void turnOn() {}
		
		public void turnOff() {}

		@Override
		public boolean isEqual(IotDevice<Amazon> other) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void receive(String msg) {
			// TODO Auto-generated method stub
			
		}
}
