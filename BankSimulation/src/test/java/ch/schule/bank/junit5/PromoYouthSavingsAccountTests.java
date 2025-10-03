package ch.schule.bank.junit5;

import ch.schule.PromoYouthSavingsAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für das Promo-Jugend-Sparkonto.
 *
 * @author XXXX
 * @version 1.0
 */
public class PromoYouthSavingsAccountTests
{
	/**
	 * Der Test.
	 */
	@Test
	public void test()
	{
        final long amount = 100000;

        PromoYouthSavingsAccount promoYouthSavingsAccount = new PromoYouthSavingsAccount("1");
        assertNotNull(promoYouthSavingsAccount, "Youth Savings Account was not created");

        promoYouthSavingsAccount.deposit(15, amount);
        assertEquals((amount + 1000),promoYouthSavingsAccount.getBalance(), "Youth Savings Account balance did not receive deposit with bonus");
	}
}
