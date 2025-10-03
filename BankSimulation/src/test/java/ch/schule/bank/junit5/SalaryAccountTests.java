package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests der Klasse SalaryAccount.
 *
 * @author XXX
 * @version 1.1
 */
public class SalaryAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	public void test()
	{
        final long amount = 100000;

        Account salaryAccount = new SalaryAccount("1", 500000);
        assertNotNull(salaryAccount, "Savings Account was not created");

        salaryAccount.deposit(1,amount);
        assertEquals(amount, salaryAccount.getBalance(), "Salary account did not receive deposit");
	}
}
