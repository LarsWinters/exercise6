package com.practicalunittesting.chp09;

import com.practicalunittesting.chp07.Email;
import com.practicalunittesting.chp07.MailClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Practical Unit Testing with JUnit and Mockito - source code for exercises.
 * Visit http://practicalunittesting.com for more information.
 *
 * @author Tomek Kaczanowski
 */

/**
 * This class tests the setter and getter methods for the following attributes. Initially all values are not set so
 * before to test the getter the attributes have to be set (via setter)
 * 	private long id;
 * 	private State state;
 * 	private boolean retryAllowed;
 * 	private String message;
 * 	private String billingId;
 */
public class TransactionTest {

	Transaction transaction1;
	@BeforeEach
	public void init(){
		transaction1 = new Transaction();
	}

	@Test
	public void attributeId() {
		assertEquals(0,transaction1.getId());
		transaction1.setId(1551699);
		assertEquals(1551699,transaction1.getId());
		/*assertAll(
				()-> assertEquals(null,transaction1.getId()),
				()-> assertThrows(IllegalArgumentException.class,()-> new Item("Butter",0)),
				()-> assertThrows(IllegalArgumentException.class,()-> new Item("Butter",-80.25))
		);*/
	}

	@Test
	public void attributeState() {
		assertEquals(null,transaction1.getState());
		transaction1.setState(State.OK);
		assertEquals(State.OK,transaction1.getState());
	}

	@Test
	public void attributeRetry() {
		assertFalse(transaction1.isRetryAllowed());
		transaction1.setRetryAllowed(true);
		assertTrue(transaction1.isRetryAllowed());
	}

	@Test
	public void attributeMessage() {
		assertEquals(null,transaction1.getMessage());
		transaction1.setMessage("Hello World");
		assertEquals("Hello World",transaction1.getMessage());
	}

	@ParameterizedTest
	@CsvSource({"String1","ID: 123456789","Blabla BLLA"})
	public void attributeBillingId(String idToTest) {
		assertEquals(null,transaction1.getBillingId());
		transaction1.setBillingId(idToTest);
		assertEquals(idToTest,transaction1.getBillingId());
	}
}