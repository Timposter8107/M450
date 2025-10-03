package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests f�r die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {

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
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {

        Bank bank = new Bank();

        assertNotNull(bank, "Bank was not created");
    }
    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {

        Bank bank = new Bank();

        final String accountId = bank.createSavingsAccount();

        assertTrue(bank.deposit(accountId, 15, 100000), "Deposit failed");
    }
    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {

        final long amount = 100000;
        final long withdrawnAmount = 25000;
        final long remainingAmount = amount - withdrawnAmount;

        Bank bank = new Bank();

        final String accountId = bank.createSavingsAccount();

        bank.deposit(accountId, 15, amount);

        assertTrue(bank.withdraw(accountId, 20, withdrawnAmount), "Withdrawal failed");

        assertEquals(remainingAmount, bank.getBalance(accountId), "Remaining amount is incorrect");
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        Bank bank = new Bank();

        final String accountId = bank.createSavingsAccount();

        bank.deposit(accountId, 15, 100000);
        bank.deposit(accountId, 17, 100000);

        bank.print(accountId);

        assertEquals("Kontoauszug 'S-1000'\r\n" +
                    "Datum          Betrag      Saldo\r\n" +
                    "16.01.1970       1.00       1.00\r\n" +
                    "18.01.1970       1.00       2.00",
                    outputStreamCaptor.toString().trim(),
                "Print failed");

    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        Bank bank = new Bank();

        final String accountId = bank.createSavingsAccount();

        bank.deposit(accountId, 15, 100000);
        bank.deposit(accountId, 20, 200000);

        bank.deposit(accountId, 100, 100000);
        bank.deposit(accountId, 110, 200000);

        bank.print(accountId, 1970,4);

        assertEquals("Kontoauszug 'S-1000' Monat: 4.1970\r\n" +
                        "Datum          Betrag      Saldo\r\n" +
                        "11.04.1970       1.00       4.00\r\n" +
                        "21.04.1970       2.00       6.00",
                        outputStreamCaptor.toString().trim(),
                "Print failed");
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        final long amount = 100000;

        Bank bank = new Bank();

        final String accountId = bank.createSavingsAccount();

        bank.deposit(accountId, 15, amount);

        assertEquals(amount, bank.getBalance(accountId), "Deposited amount is incorrect");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        final long amount = 100000;

        Bank bank = new Bank();

        for (int i = 1; i <= 10; i++) {
            String accountId = bank.createSavingsAccount();

            bank.deposit(accountId, 15, (amount * i) );
        }

        bank.printTop5();

        assertEquals("S-1009: 1000000\r\n" +
                    "S-1008: 900000\r\n" +
                    "S-1007: 800000\r\n" +
                    "S-1006: 700000\r\n" +
                    "S-1005: 600000",
                    outputStreamCaptor.toString().trim(),
                "Print failed");
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        final long amount = 100000;

        Bank bank = new Bank();

        for (int i = 1; i <= 10; i++) {
            String accountId = bank.createSavingsAccount();

            bank.deposit(accountId, 15, (amount * i) );
        }

        bank.printBottom5();

        assertEquals("S-1000: 100000\r\n" +
                        "S-1001: 200000\r\n" +
                        "S-1002: 300000\r\n" +
                        "S-1003: 400000\r\n" +
                        "S-1004: 500000",
                outputStreamCaptor.toString().trim(),
                "Print failed");
    }

}
