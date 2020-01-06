package designpattern.builder.elearning;

public class ClientBuilder {
	public static void main(String[] args) {
		BankAccount newAccount = new BankAccount.BankAccountBuilder("John", "22738022275")
				.withEmail("john@example.com")
				.wantNewsletter(true).build();
		
		System.out.println("Name: " + newAccount.getName());
		System.out.println("AccountNumber:" + newAccount.getAccountNumber());
		System.out.println("Email: " + newAccount.getEmail());
		System.out.println("Want News letter?: " + newAccount.isNewsletter());
		/**
		 * notare l'uso dello stile fluent per costruire incrementalmente l'istanza e la
		 * distinzione tra campi obbligatori (name e accountNumber) e campi opzionali
		 * (email e newsletter).
		 *
		 * Ovviamente il metodo chiave e' build(), altrimenti le informazioni non
		 * vengono trasferite dal builder all'account.
		 */
	}
}
