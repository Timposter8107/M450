package ch.schule.bank.junit5;

import ch.schule.Booking;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse Booking.
 *
 * @author Luigi Cavuoti
 * @version 1.1
 */
public class BookingTests
{

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
	 * Tests f�r die Erzeugung von Buchungen.
	 */
	@Test
	public void testInitialization()
	{
        final long amount = 100000;

		Booking booking = new Booking(15, amount);
        assertNotNull(booking, "Booking was not created");

        assertEquals(amount, booking.getAmount(), "Booking did not receive deposit");
	}

	/**
	 * Experimente mit print().
	 */
	@Test
	public void testPrint()
	{
        final long amount = 100000;

        Booking booking = new Booking(15, amount);

        booking.print(amount);

        assertEquals("16.01.1970       1.00       2.00",
                    outputStreamCaptor.toString().trim(),
                "Print failed");
	}
}
