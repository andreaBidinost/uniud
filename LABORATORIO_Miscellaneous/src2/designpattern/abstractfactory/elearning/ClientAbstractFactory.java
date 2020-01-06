package designpattern.abstractfactory.elearning;

public class ClientAbstractFactory {
	public static void main(String[] args) {
//creating a brown dog
		FactoryProvider fp = new FactoryProvider();
		
		AbstractFactory theAnimalFactory = fp.getFactory("Animal");
		AbstractFactory theColorFactory = fp.getFactory("Color");
		
		Animal toy = theAnimalFactory.createAnimal("Dog");
		Color color = theColorFactory.createColor("Brown");
		
		System.out.format("\n%s (sound %s); %s", toy.getAnimalName(), toy.makeSound(), color.getColor());
		
		toy = theAnimalFactory.createAnimal("cat");
		color = theColorFactory.createColor("white");
		
		System.out.format("\n%s (sound %s); %s", toy.getAnimalName(), toy.makeSound(), color.getColor());
		/**
		 * il client deve solo sapere cosa dire per chiedere di ottenere una certa
		 * factory (es. fp.getFactory("Animal")) e cosa dire per chiedere un certo
		 * animale o un certo colore. Il client non sa quali tipi reali vengono usati
		 * per gli animali e per i colori. Non sa neppure quali sono le reali factory
		 * che vengono usate. Che quindi possono venir modificati senza dover richiedere
		 * modifiche al client.
		 *
		 * Abstract Factory e' comoda quando abbiamo varie gerarchie di tipo (animali e
		 * colori) che dobbiamo manipolare.
		 */
	}
}
