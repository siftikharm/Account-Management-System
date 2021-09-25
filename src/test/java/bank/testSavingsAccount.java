package bank;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testSavingsAccount {
	
	private Customer customer;
	private Customer customer1;
	private SavingsAccount Saccount;
	private SavingsAccount Saccount1;

	
	@Before
	public void setUp() throws Exception {
		customer = new Customer(123456 , "Customer0" , "customer0Address" , 1232342);
		customer1 = new Customer(123457 , "customer1" , "Customer1Address" , 214124);
	    Saccount = new SavingsAccount(customer);
	    Saccount1 = new SavingsAccount(customer1);
		
	}
	
	
	@Test
	public void testMakeWithdrawlPositive() {
		Saccount.customer.addBalance(10000);
		assertEquals("Withdrawl from the balance" , 5000 , Saccount.makeWithdrawl(5000) , 0);
		Saccount.customer.setBalance(0);
		assertEquals("withdrawl within credit limit" , 5000 , Saccount.makeWithdrawl(5000) , 0);
		Saccount.customer.setBalance(0);
		assertEquals("withdrawl exceeding credit limit", -1 , Saccount.makeWithdrawl(5001) , 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMakeWithdrawlNegative() {
		Saccount.customer.setBalance(5000);;
		assertEquals(5000 , Saccount.makeWithdrawl(-5000) , 0);
	}

	
	@Test
	public void testCalculateZakat() {
		Saccount.customer.setBalance(20000);
		assertEquals("Zakaat greater than 20000" , 500 , Saccount.calculateZakaat() , 0);
		Saccount.customer.setBalance(1000);
		assertEquals("Zakaat less than 20000" , 0 , Saccount.calculateZakaat() , 0);
	}
	
	
	@Test
	public void testDeductZakat() {
		Saccount.customer.setBalance(20000);
		assertEquals( 19500 , Saccount.deductZakaat() , 0);
	}
	
	@Test
	public void testCalculateInterest() {
		Saccount.customer.setBalance(20000);
		assertEquals( 1400 , Saccount.calculateInterest() , 0);
		Saccount.setInterestRate(0.1f);
		assertEquals(2000 , Saccount.calculateInterest() , 0);
	}
	
	@Test
	public void testaddInterest() {
		Saccount.customer.setBalance(20000);
		Saccount.addInterest();
		assertEquals( 21400 , Saccount.customer.getBalance() , 0);
		Saccount.customer.setBalance(20000);
		Saccount.setInterestRate(0.1f);
		Saccount.addInterest();
		assertEquals(22000 , Saccount.customer.getBalance() , 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTransferAmount() {
		Saccount1.customer.setBalance(10000);
		Saccount.customer.setBalance(15000);
		Saccount.transferAmount(5000, customer1, 123457);
		Saccount1.transferAmount(-5000, customer, 123457);
		assertEquals( 15000 , Saccount1.customer.getBalance() , 0);
		assertEquals( 10000 , Saccount.customer.getBalance() , 0);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testMakeDeposit() {
		Saccount.customer.setBalance(1000);
		Saccount.makeDeposit(5000);
		Saccount.makeDeposit(-5000);
		assertEquals(6000 , Saccount.customer.getBalance() , 0);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	

}
