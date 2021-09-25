package bank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testCheckingsAccount {
	
	private CheckingsAccount Caccount;
	private CheckingsAccount Caccount1;
	private Customer customer;
	private Customer customer1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customer = new Customer(123456 , "Customer0" , "customer0Address" , 1232342);
		Caccount = new CheckingsAccount(customer);
		customer1 = new Customer(123457 , "customer1" , "Customer1Address" , 214124);
	    Caccount1 = new CheckingsAccount(customer1);
	}
	

	@Test
	public void testMakeWithdrawlPositive() {
		Caccount.customer.addBalance(10000);
		assertEquals("Withdrawl from the balance" , 5000 , Caccount.makeWithdrawl(5000) , 0);
		Caccount.customer.setBalance(0);
		assertEquals( 0 , Caccount.makeWithdrawl(5000) , 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMakeWithdrawlNegative() {
		Caccount.customer.addBalance(10000);
		assertEquals("Withdrawl from the balance" , 5000 , Caccount.makeWithdrawl(-5000) , 0);
	}
	
	@Test
	public void testMakeTransfer() {
		Caccount1.customer.setBalance(10000);
		Caccount.customer.setBalance(15000);
		Caccount1.transferAmount(5000, customer, 123456);
		assertEquals( 5000 , Caccount1.customer.getBalance() , 0);
		assertEquals( 20000 , Caccount.customer.getBalance() , 0);
		Caccount1.transferAmount(2000, customer, 123456);
		assertEquals( 3000 , Caccount1.customer.getBalance() , 0);
		Caccount1.transferAmount(1000, customer, 123456);
		assertEquals( 1990 , Caccount1.customer.getBalance() , 0);
		Caccount1.printStatement();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMakeTransferNegative() {
		Caccount.customer.setBalance(10000);
		Caccount1.customer.setBalance(20000);
		Caccount.transferAmount(-5000, customer1, 123457);
		assertEquals(10000 , Caccount.customer.getBalance() , 0);
		assertEquals(20000 , Caccount1.customer.getBalance() , 0);
	}
	
	@After
	public void tearDown() throws Exception {
	}


}
