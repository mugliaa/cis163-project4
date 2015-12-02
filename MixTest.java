package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MixTest {

	@Test // Tests remove at 0 position
	public void testRemoveAtZero() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		assertEquals("his is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests remove at end position
	public void testRemoveAtEnd() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 13");
		assertEquals("This is a tes", m.secretMessage.displayMessage());
	}
	
	@Test // Tests remove at middle position
	public void testRemoveInMiddle1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 3");
		assertEquals("Thi is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests remove at middle position
	public void testRemoveInMiddle2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 6");
		assertEquals("This i a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing a space character
	public void testRemovingSpace() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 4");
		assertEquals("Thisis a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing multiple
	public void testRemoveMultiple1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		m.processCommand("r 9");
		assertEquals("his is a est", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing multiple
	public void testRemoveMultiple2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 1");
		m.processCommand("r 5");
		assertEquals("Tis i a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing multiple
	public void testRemoveMultiple3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("r 2");
		assertEquals("isis a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing multiple with invalid included
	public void testRemoveMultipleWithInvalid1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		m.processCommand("r 3000");
		m.processCommand("r 2");
		assertEquals("hi is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing multiple with invalid included
	public void testRemoveMultipleWithInvalid2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 3000");
		m.processCommand("r 1");
		m.processCommand("r 5");
		assertEquals("Tis i a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid remove command
	public void testRemoveInvalid1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 3000");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid remove command
	public void testRemoveInvalid2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("R 3");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid remove command
	public void testRemoveInvalid3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r -5");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid remove command
	public void testRemoveInvalid4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand(" r 3000");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid remove command
	public void testRemoveInvalid5() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r  3");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

}
