package generics;

public interface IotDevice<T extends IotProducer> {
	public boolean isEqual(IotDevice<T> other);
	
	public void receive(String msg);
	
}
