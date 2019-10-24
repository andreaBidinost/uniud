package exceptions.phoneAdmin;


enum Promotions {
	MINUTI_ILLIMITATI(15.0),
	CHIAMA_E_RICHIAMA(10.0),
	DATI_UNLIMITED(0.0);
	
	private double cost;
	
	private Promotions(double cost) {
		this.cost = cost;
	}
	
	double getCost() {
		return this.cost;
	}
	
	/*
	 * Solo se la coppia NOME-VALORE è 1 a 1 (non è questo il caso)
	 */
	static Promotions valueOf(double cost) {
		for(Promotions promo:values()) {
			if(promo.getCost() == cost) {
				return promo;
			}
		}
		
		return null;
	}
	
	
}
