package TestDrivenTest;

	class Money implements Expression {
	
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
	
	public Expression times(int multiplier){
		return new Money(multiplier * this.amount, currency);
	}
	
	public Expression plus(Expression addend){
		return new Sum(this, addend);
	}
	
	
	public Money reduce(Bank bank, String to){
		int rate = bank.rate(currency, to);
		return new Money(amount/rate, to);
	}

}
