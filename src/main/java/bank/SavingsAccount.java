/**
 * @author Iftikhar Mehdi , 19I-0657
 * Advanced Programming Task 01 : Account Management System
 * Class : Savings Account
 * Date: 12th Sept , 2021
 */

package bank;

public class SavingsAccount extends BankAccount{
	
	private float Zakaat;
	private float InterestRate;
	
	public SavingsAccount() {
		InterestRate = 0.07f;
		Zakaat = 0;
	}
	
	public SavingsAccount(Customer customer) {
		super(customer);
		this.customer = customer;
		InterestRate = 0.07f;
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
	public float makeWithdrawl(float amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Withdrawing Amount cannot be negative");
		}
		
		if(amount == 0) {
			System.out.println("You are wasting your time");
		}
		
		if(amount > this.customer.getBalance() && amount <= 5000) {
			System.out.println("You are requesting an amount > your balance :" + this.customer.getBalance() + "\nThis will be added in your credit");
			this.customer.subBalance(amount);
			return amount;
		}
		
		if(amount > 5000 && amount > this.customer.getBalance()) {
			System.out.println("You cannot withdraw more than PKR5000 credit Limit");
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
		this.Zakaat = zakaat;
		return zakaat;
	}
	
	public float deductZakaat() {
		this.customer.subBalance(calculateZakaat()); 
		return this.customer.getBalance();
	}
	
	public float calculateInterest() {
		float interest = this.customer.getBalance() * this.InterestRate * 1;
		return interest;
	}
	
	public void addInterest() {
		this.customer.addBalance(calculateInterest());
	}
	
}

