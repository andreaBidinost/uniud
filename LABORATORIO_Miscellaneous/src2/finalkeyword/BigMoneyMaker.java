package finalkeyword;

/**
 * Example of "final" keyword usage.
 * 
 * - final variable: once initialized nevermore changed (runtime error)
 * - final method: no one can override it (compile-time error)
 * - final class: no one can extend it (compile-time error)
 **/

/*
 * Think this class as a producer of lot of money directly to the bank account
 * of its author (prof. Bidinost pheraps...).
 * The author doesn't allow an extension for modification
 * 
 */
final class BigMoneyMaker {
	//final class: I don't want anyone can extends that, just use it
	
	
	private String IBAN = "IT.........";
	//I decide that IBAN field can't be shown outside
	
	
	/*
	 * This method is visible outside and, once used, add some money to the
	 * bank account of the class author
	 */
	public void doStuffsAndMakeMoney() {
		//TODO...AND DO IT WELL PLEASE		
	}
}

/*
 * Same meaning of the previous example using final keyword in other way.
 */
class AnotherBigMoneyMaker {
	//extendable (not final) class: I allow class extension
	
	
	public final String IBAN = "IT.........";
	//final: I decided that IBAN field could be shown outside but never changed more
	
	
	/*this method is visible outside and, once used, add some money to the
	 * bank account of the class author.
	 * 
	 * I decided it's final so everyone can use it but no one can change it.
	 */
	public final void doStuffsAndMakeMoney() {
		//TODO...AND DO IT WELL PLEASE		
	}
}

/*
 * Look out: final and abstract can't be used together:
 * - final: "don't change!"
 * - abstract: "please implement me!"
*/
final abstract class NonSenseClass{
	
}