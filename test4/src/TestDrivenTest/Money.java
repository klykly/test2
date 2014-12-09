package TestDrivenTest;

	class Money {
	
	protected int amount;
	protected String currency;
	//abstract Money times(int multiplier);
	public String currency(){
		return currency;
	}
	static Money dollar(int amount){
		return new Money(amount, "USD");
	}
	static Money franc(int amount){
		return new Money(amount, "CHF");
	}
	Money(int amount, String currency){
		this.amount = amount;
		this.currency = currency;
	}
	
	Money(int amount){
		this.amount = amount;
	}
	public boolean equals(Object object){
		Money money = (Money) object;
		
		return amount == money.amount && money.currency().equals(currency());
	}
	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	Money times(int multiplier){
		return new Money(multiplier * this.amount, currency);
	}
	
	Money plus(Money money){
		return new Money(money.amount + amount, money.currency);
	}

}
