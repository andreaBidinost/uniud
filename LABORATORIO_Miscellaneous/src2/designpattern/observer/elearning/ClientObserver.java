package designpattern.observer.elearning;


//observer
//publisher-subscriber
//produttore-consumatore

public class ClientObserver {
	public static void main(String[] args) {
		// la news agency produce le notizie
		NewsAgency agency = new NewsAgency();
		
		// il canale televisivo le osserva, rilancia
		NewsChannel observer = new NewsChannel("rai1");
		agency.addObserver(observer);
		
		// altro observer
		agency.addObserver(new NewsChannel("rai2"));
		agency.setNews("news di oggi: 30 e lode a tutti");
		
		/**
		 * notare come l'oggetto Observable (la NewsAgency) non sa cosa fare dal punto
		 * di vista di come "usare" le news, che e' una responsabilita' demandata al
		 * canale (l'osservatore)
		 *
		 */
	}
}
