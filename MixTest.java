package project4;

import static org.junit.Assert.*;

import org.junit.Test;

public class MixTest {

	@Test
	// Tests remove at 0 position
	public void testRemoveAtZero() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		assertEquals("his is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests remove at end position
	public void testRemoveAtEnd() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 13");
		assertEquals("This is a tes", m.secretMessage.displayMessage());
	}

	@Test
	// Tests remove at middle position
	public void testRemoveInMiddle1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 3");
		assertEquals("Thi is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests remove at middle position
	public void testRemoveInMiddle2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 6");
		assertEquals("This i a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing a space character
	public void testRemovingSpace() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 4");
		assertEquals("Thisis a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing multiple
	public void testRemoveMultiple1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		m.processCommand("r 9");
		assertEquals("his is a est", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing multiple
	public void testRemoveMultiple2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 1");
		m.processCommand("r 5");
		assertEquals("Tis i a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing multiple
	public void testRemoveMultiple3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("r 2");
		assertEquals("isis a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing multiple with invalid included
	public void testRemoveMultipleWithInvalid1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0");
		m.processCommand("r 3000");
		m.processCommand("r 2");
		assertEquals("hi is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing multiple with invalid included
	public void testRemoveMultipleWithInvalid2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 3000");
		m.processCommand("r 1");
		m.processCommand("r 5");
		assertEquals("Tis i a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command
	public void testRemoveInvalid1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 3000");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command
	public void testRemoveInvalid2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("R 3");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command
	public void testRemoveInvalid3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r -5");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command
	public void testRemoveInvalid4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand(" r 3000");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command
	public void testRemoveInvalid5() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r  3");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command - 1 under lower bound
	public void testRemoveInvalid6() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r -1");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid remove command - 1 above upper bound
	public void testRemoveInvalid7() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 14");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests removing the final character of message - invalid
	public void testRemoveFinalCharacter() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("AM");
		m.processCommand("r 0");
		m.processCommand("r 0");
		assertEquals("M", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBefore() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("b c 4");
		assertEquals("Thisc is a test", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBefore2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("b 7 8");
		assertEquals("This is 7a test", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeError() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("b 72222 8123");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeError2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("b 8123");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeError3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeError4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("B c 4");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeError5() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("B  c  4");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeMultiple() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("b s 4");
		m.processCommand("b i 5");
		m.processCommand("b s 6");
		m.processCommand("b t 7");
		assertEquals("Thissist is a test", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the add before function
	public void testAddBeforeNull() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("");
		m.processCommand("b  c  4");
		assertEquals("", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPaste() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 3");
		m.processCommand("p 0");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPaste2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 3");
		m.processCommand("p 6");
		assertEquals(" is a Thistest", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPaste3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("c 0 13");
		m.processCommand("p 0");
		assertEquals("This is a testThis is a test",
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPaste4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 11");
		m.processCommand("p 1");
		assertEquals("sThis is a tet", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testMultiple() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 3");
		m.processCommand("x 0 3");
		m.processCommand("p 0");
		m.processCommand("c 0 9");
		m.processCommand("p 1");
		assertEquals("  is a testis a test", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteError() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x  0  11");
		m.processCommand("p     1");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteError2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("X  0  11");
		m.processCommand("p     1");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteError3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 11");
		m.processCommand("p");
		assertEquals("st", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteError4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand(" 0 11");
		m.processCommand("P");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteError5() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("");
		m.processCommand("P");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteWithOtherCommands() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 1");
		m.processCommand("c 0 3");
		m.processCommand("p 0");
		assertEquals("Tis Tis is a test", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteWithOtherCommands2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 1");
		m.processCommand("c 0 3");
		m.processCommand("p 0");
		m.processCommand("r 4");
		m.processCommand("r 8");
		m.processCommand("b 5 3");
		assertEquals("Tis5 is i a test", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteWithOtherCommands3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 1");
		m.processCommand("c 0 3");
		m.processCommand("p 0");
		m.processCommand("r 4");
		m.processCommand("r 8");
		m.processCommand("b 5 3");
		m.processCommand("w 0 15");
		assertEquals("tis5 is i a tesT", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteWithOtherCommands4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 13");
		m.processCommand("");
		m.processCommand("p 0");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteWithOtherCommands5() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 12 2");
		m.processCommand("");
		m.processCommand("p 0");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteNull() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("");
		m.processCommand("");
		assertEquals("", m.secretMessage.displayMessage());
	}

	@Test
	// Testing the paste function
	public void testPasteNull2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("");
		assertEquals("Hello World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testMultCommands() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("r 0");
		m.processCommand("r 1");
		m.processCommand("r 3");
		m.processCommand("r 5");
		assertEquals("eloWold", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testMultCommands2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("r 0");
		m.processCommand("r 1");
		m.processCommand("r 3");
		m.processCommand("r 5");
		m.processCommand("r 5");
		m.processCommand("w 0 5");
		m.processCommand("x 1 4");
		m.processCommand("p 1");
		assertEquals("dloWoe", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwap() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 10");
		m.processCommand("");
		assertEquals("dello WorlH", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwap2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 10");
		m.processCommand("w 4 6");
		assertEquals("dellW oorlH", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwap3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 10");
		m.processCommand("w 4 6");
		m.processCommand("w 1 7");
		assertEquals("dollW oerlH", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwapError() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 100 900");
		assertEquals("Hello World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwapError2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w  0  0");
		assertEquals("Hello World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwapError3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w asd asd");
		assertEquals("Hello World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwapWithOther() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 1"); // eHllo World
		m.processCommand("w 0 2"); // lHelo World
		m.processCommand("c 0 4");
		m.processCommand("p 2"); // lHlHeloelo World
		assertEquals("lHlHeloelo World", 
				m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwapWithOther2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 1"); // eHllo World
		m.processCommand("w 0 2"); // lHelo World
		m.processCommand("r 4"); // lHel World
		assertEquals("lHel World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testSwapWithOther3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 1"); // eHllo World
		m.processCommand("w 0 2"); // lHelo World
		m.processCommand("r 4"); // lHel World
		m.processCommand("x 0 4"); // World
		assertEquals("World", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut starting at 0 position
	public void testCutAtZero() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 3");
		assertEquals(" is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut starting at middle position
	public void testCutAtMiddle1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 3 6");
		assertEquals("Thi a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut starting at middle position
	public void testCutAtMiddle2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 6 8");
		assertEquals("This i test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid cut
	public void testCutInvalid1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 12 15");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid cut
	public void testCutInvalid2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x -5 6");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid cut
	public void testCutInvalid3() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 14");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests invalid cut
	public void testCutInvalid4() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 3000");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut starting at middle position
	public void testCutAtEnd() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 13");
		assertEquals("This is a ", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut using the same position
	public void testCutAtSamePositions() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 10 10");
		assertEquals("This is a est", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut using inverted positions - invalid
	public void testCutAtInvertedPositions1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 13 10");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut using inverted positions - invalid
	public void testCutAtInvertedPositions2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 5 1");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut using the entire message - invalid
	public void testCutFullMessage() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 13");
		assertEquals("This is a test", m.secretMessage.displayMessage());
	}

	@Test
	// Tests cut and paste
	public void testCutAndPaste1() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("x 0 4");
		m.processCommand("p 1");
		assertEquals("iThis s a test", m.secretMessage.displayMessage());
	}

	// Decrypting

	@Test
	// Tests a series of commands and decryption
	public void testDecryption1() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Adam Muglia");
		m.processCommand("r 0"); // dam Muglia
		m.processCommand("x 4 6"); // dam lia
		m.processCommand("w 0 4"); // lam dia
		m.processCommand("s testit");
		m.processCommand("Q");

		assertEquals("Adam Muglia", 
				u.UnMixUsingFile("testit", "lam dia"));
	}

	@Test
	// Tests a series of commands and decryption
	public void testDecryption2() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 10"); // This is a est
		m.processCommand("x 4 6"); // This a est
		m.processCommand("w 0 4"); // hisTa est
		m.processCommand("s testit");
		m.processCommand("Q");

		assertEquals("This is a test", 
				u.UnMixUsingFile("testit", " hisTa est"));
	}

	@Test
	// Tests a series of commands and decryption
	public void testDecryption3() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello world");
		m.processCommand("c 0 4"); // Hello world
		m.processCommand("x 3 4"); // Hel world
		m.processCommand("p 4"); // Hel loworld
		m.processCommand("r 4"); // Hel oworld
		m.processCommand("s testit");
		m.processCommand("Q");

		assertEquals("Hello world", 
				u.UnMixUsingFile("testit", "Hel oworld"));
	}

	@Test
	// Tests invalid file
	public void testDecryptionUsingInvalidFile() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hi everyone");
		m.processCommand("r 0"); // i everyone
		m.processCommand("w 0 2"); // e iveryone
		m.processCommand("s testit");
		m.processCommand("Q");

		assertEquals(null, u.UnMixUsingFile("test", "e iveryone"));
	}

	@Test
	// Tests file being used on different message
	public void testDecryptionWithWrongMessage() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("This is a test");
		m.processCommand("r 0"); // his is a test
		m.processCommand("w 0 4"); // iis hs a test
		m.processCommand("s testit");
		m.processCommand("Q");

		u.UnMixUsingFile("testit", "Hi");
	}

	@Test
	// Testing for general errors
	public void testError() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("p 0");
		m.processCommand("x 99 09");
		m.processCommand("p 54");
		assertEquals("Hello World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing for errors
	public void testError2() {
		Mix m = new Mix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("p 0");
		m.processCommand("x 99 09");
		m.processCommand("p 54");
		assertEquals("Hello World", m.secretMessage.displayMessage());
	}

	@Test
	// Testing
	public void testErrorandUnmix() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("p 0");
		m.processCommand("x 99 09");
		m.processCommand("p 54");
		m.processCommand("s dsafhsauipuadshfiuh.sadasfdasf");
		assertEquals("Hello World", u.UnMixUsingFile
								("dsafhsauipuadshfiuh.sadasfdasf", 
												"Hello World"));
	}
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionality() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("r 0");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "ello World" ));
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionality2() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("w 0 1");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "eHllo World" ));
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionality3() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("c 0 1");
		m.processCommand("p 3");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "HelHelo World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionality4() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("x 0 1");
		m.processCommand("p 3");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "lloHe World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionality5() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "H0ello World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionality6() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "H0ello World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionalityMultiple() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("b Q 4");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "H0elQlo World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionalityMultiple2() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("b Q 4");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "elQlo World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionalityMultiple3() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("b Q 4");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("x 0 4");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", " World" ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionalityMultiple4() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("b Q 4");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("x 0 4");
		m.processCommand("p 5");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", " WorlelQlod" ));
	
	}
	
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionalityMultiple5() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("b Q 4");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("x 0 4");
		m.processCommand("p 5");
		m.processCommand("w 0 10");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "dWorlelQlo " ));
	
	}
	
	@Test
	// Testing Unmix with commands
	public void testUnmixFunctionalityMultiple6() {
		Mix m = new Mix();
		UnMix u = new UnMix();
		m.testing = true;
		m.setInitialMessage("Hello World");
		m.processCommand("b 0 1");
		m.processCommand("b Q 4");
		m.processCommand("r 0");
		m.processCommand("r 0");
		m.processCommand("x 0 4");
		m.processCommand("p 5");
		m.processCommand("w 0 10");
		m.processCommand("c 0 10");
		m.processCommand("p 10");
		m.processCommand("s filename");
		assertEquals("Hello World", 
				u.UnMixUsingFile("filename", "dWorlelQlo dWorlelQlo " ));
	
	}
}
