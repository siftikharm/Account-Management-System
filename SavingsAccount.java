/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Class : Savings Account
 * Date: 12th Sept , 2021
 */

package Bank;

class SavingsAccount extends BankAccount{
	
	private float Zakaat;
	private float InterestRate;
	
	public SavingsAccount() {
		InterestRate = 0.0f;
		Zakaat = 0;
	}
	
	public SavingsAccount(Customer customer) {
		this.customer = customer;
		InterestRate = 0.0f;
		Zakaat = 0.0f;
	}
	
	public SavingsAccount(float interestRate) {
		InterestRate = interestRate;
	}

	public float getZakaat() {
		return this.Zakaat;
	}

	public void setZakaat(float zakaat) {
		this.Zakaat = zakaat;
	}
	
	public float getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(float interestRate) {
		InterestRate = interestRate;
	}

	@Override
	protected float makeWithdrawl(float amount) {
		if(amount > this.customer.getBalance() && amount <= 5000) {
			System.out.println("You are requesting an amount > your balance :" + this.customer.getBalance() + "\n This will be added in your credit");
			this.customer.subBalance(amount);
			return amount;
		}
		
		if(amount > 5000 && amount > this.customer.getBalance()) {
			System.out.println("You cannot withdraw more than PKR5000 Limit");
			return -1;
		}
		
		this.customer.subBalance(amount);
		System.out.println("Remaining Balance : " + this.customer.getBalance());
		return amount;
	}
	
	public float calculateZakaat() {
		float zakaat = 0.0f;
		if(this.customer.getBalance() >= 20000) {
			zakaat = this.customer.getBalance() * 2.5f / 100;
		}
		return zakaat;
	}
	
	public void deductZakaar() {
		this.customer.subBalance(calculateZakaat()); 
	}
	
	public void calculateInterest() {
		
	}
	
}

