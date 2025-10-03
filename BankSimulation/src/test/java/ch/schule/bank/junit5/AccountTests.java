package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.SalaryAccount;
import ch.schule.SavingsAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        Account salaryAccount = new SalaryAccount("1", 10000);
        assertNotNull(salaryAccount, "Salary Account was not created");

        Account savingsAccount = new SavingsAccount("1");
        assertNotNull(savingsAccount, "Savings Account was not created");
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        final long amount = 100000;

        Account savingsAccount = new SavingsAccount("1");

        savingsAccount.deposit(1,amount);

        assertEquals(amount, savingsAccount.getBalance(), "Savings account did not receive deposit");
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        final long amount = 100000;
        final long withdrawAmount = 25000;
        final long remainingAmount = amount -  withdrawAmount;

        Account savingsAccount = new SavingsAccount("1");

        savingsAccount.deposit(1,amount);
        assertEquals(amount, savingsAccount.getBalance(), "Savings account did not receive deposit");

        savingsAccount.withdraw(2,withdrawAmount);
        assertEquals(remainingAmount, savingsAccount.getBalance(), "Savings account did not withdraw the requested amount");
    }

    /**
     * Tests the reference from SavingsAccount
     */
// MRA: No valid method to test
//    @Test
//    public void testReferences() {
//        fail("toDo");
//    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        Account savingsAccount = new SavingsAccount("1");
        assertTrue(savingsAccount.canTransact(5), "Savings account can not make a booking");

        savingsAccount.deposit(15,1000);

        assertFalse(savingsAccount.canTransact(10), "Savings account should not be able to make another booking before an existing booking is closed");

        assertTrue(savingsAccount.canTransact(20), "Savings account can not make a booking");
    }

    private static void extracted() {
        fail("toDo");
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Account savingsAccount = new SavingsAccount("1");

        savingsAccount.deposit(15,100000);
        savingsAccount.deposit(20,200000);

        savingsAccount.print();

        assertEquals("Kontoauszug '1'\r\n" +
                        "Datum          Betrag      Saldo\r\n" +
                        "16.01.1970       1.00       1.00\r\n" +
                        "21.01.1970       2.00       3.00",
                        outputStreamCaptor.toString().trim(),
                "Print failed");
    }

    /**
     * Experimente mit print(year,month).
     */
    @Test
    public void testMonthlyPrint() {
        Account savingsAccount = new SavingsAccount("1");

        savingsAccount.deposit(15,100000);
        savingsAccount.deposit(20,200000);

        savingsAccount.deposit(100,100000);
        savingsAccount.deposit(110,200000);

        savingsAccount.print(1970,4);

        assertEquals("Kontoauszug '1' Monat: 4.1970\r\n" +
                        "Datum          Betrag      Saldo\r\n" +
                        "11.04.1970       1.00       4.00\r\n" +
                        "21.04.1970       2.00       6.00",
                        outputStreamCaptor.toString().trim(),
                "Print failed");
    }

}
