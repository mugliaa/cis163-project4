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
	
	@Test // Tests invalid remove command - 1 under lower bound
	public void testRemoveInvalid6() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r -1");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid remove command - 1 above upper bound
	public void testRemoveInvalid7() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 14");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests removing the final character of message - invalid
	public void testRemoveFinalCharacter() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("AM");
		m.processCommand("r 0");
		m.processCommand("r 0");
		assertEquals("M", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut starting at 0 position
	public void testCutAtZero() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 3");
		assertEquals(" is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut starting at middle position
	public void testCutAtMiddle1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 3 6");
		assertEquals("Thi a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut starting at middle position
	public void testCutAtMiddle2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 6 8");
		assertEquals("This i test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid cut
	public void testCutInvalid1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 12 15");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid cut
	public void testCutInvalid2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x -5 6");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid cut
	public void testCutInvalid3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 14");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests invalid cut
	public void testCutInvalid4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 3000");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut starting at middle position
	public void testCutAtEnd() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 13");
		assertEquals("This is a ", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut using the same position
	public void testCutAtSamePositions() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 10");
		assertEquals("This is a est", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut using inverted positions - invalid
	public void testCutAtInvertedPositions1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 13 10");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut using inverted positions - invalid
	public void testCutAtInvertedPositions2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 5 1");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut using the entire message - invalid
	public void testCutFullMessage() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 13");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}
	
	@Test // Tests cut and paste
	public void testCutAndPaste1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 4");
		m.processCommand("p 1");
		assertEquals("iThis s a test", m.secretMessage.displayMessage());
	}
	

}
