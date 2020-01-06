package designpattern.builder.elearning;

public class BankAccount {
	private String name;
	private String accountNumber;
	private String email;
	private boolean newsletter;

	private BankAccount(BankAccountBuilder builder) {
		this.name = builder.name;
		this.accountNumber = builder.accountNumber;
		this.email = builder.email;
		this.newsletter = builder.newsletter;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}

	public static class BankAccountBuilder {
		public String name;
		public String accountNumber;
		public boolean newsletter;
		public String email;

		public BankAccountBuilder(String name, String accountNumber) {
			this.name = name;
			this.accountNumber = accountNumber;
		}

		public BankAccountBuilder withEmail(String email) {
			this.email = email;
			return this;
		}

		public BankAccountBuilder wantNewsletter(boolean newsletter) {
			this.newsletter = newsletter;
			return this;
		}

		//the actual build method that prepares and returns a BankAccount object
		public BankAccount build() {
			return new BankAccount(this);
		}
	}
}
