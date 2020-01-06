package generics;

import java.util.List;

public class Hub<T extends IotProducer> {
	
	List<IotDevice<T>> devices;
	
	public void addDevice(IotDevice<T> device) {
		devices.add(device);
	}
	
	public void sendMessage(String msg, IotDevice<T> receiver) {
		for(IotDevice<T> dev:devices) {
			if(dev.isEqual(receiver)) {
				dev.receive(msg);
			}
		}
	}

}
