package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SavingsAccount;



/**
 * Tests f�r die Klasse SavingsAccount.
 *
 * @author Roger H. J&ouml;rg
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests für die Klasse SavingsAccount.
 *
 * @author XXX
 * @version 1.0
 */
public class SavingsAccountTests
{
	@Test
	public void test()
	{
        final long amount = 100000;

        Account savingsAccount = new SavingsAccount("1");
        assertNotNull(savingsAccount, "Salary Account was not created");

        savingsAccount.deposit(1,amount);
        assertEquals(amount, savingsAccount.getBalance(), "Savings account did not receive deposit");
	}
}

