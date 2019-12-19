package designpattern.decorator;

public class ClientDecorator {
	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		
		System.out.println("\n*****");
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
		
		/**
		 * in pratica si riesce a fare un mix-in di 2+ sotto-classi cosa che non si puo'
		 * fare con una tipologa basata solo sulla gerarchia
		 *
		 * NB il client puo' decidere quali decoratori usare e anche l'ordine con cui
		 * applicarli.
		 *
		 */
		
		System.out.println("\n*****");
		
		Car luxurySportsCar = new LuxuryCar(new SportsCar(new BasicCar()));
		luxurySportsCar.assemble();
	}
}
