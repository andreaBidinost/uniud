package generics;

public class Main {
	public static void main(String[] args) {
		
		Hub<Google> googleHub = new Hub<Google>();
		
		GoogleLamp gLamp = new GoogleLamp();
		AmazonLamp aLamp = new AmazonLamp();
		
		googleHub.addDevice(gLamp);
		googleHub.addDevice(aLamp); //errore in compilazione
		
		Hub<Amazon> amazonHub = new Hub<Amazon>();
		
		amazonHub.addDevice(gLamp);
		amazonHub.addDevice(aLamp); //errore in compilazione
	}
}