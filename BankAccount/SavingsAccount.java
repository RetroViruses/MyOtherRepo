
public class SavingsAccount extends BankAccount{
	private double interestRate;
	private double balance;
	/**
	 * Constructs a new SavingsAccount with an initial balance,
	 * and an interest rate
	 */
	public SavingsAccount(double initialAmount, double rate){
		super(initialAmount);
		balance=getBalance();
		interestRate=rate;
	}
	/**
	 * returns the interest rate
	 * @return the interest rate
	 */
	public double getInterest(){
		return interestRate;
	}
	
	/**
	 * Calculates one month's interest and adds the amount to the balance
	 */
	public void calculateInterest(){
		balance=balance+(interestRate*balance);
	}
	
	/** 
	 * Returns a String representation of the account's 
	 * attributes (balance and interest rate)
	 */
	public String toString(){
		String accountInfo;
		accountInfo="The account balance is "+balance+" with an interest rate of "+interestRate;
		return accountInfo;
	}
}
