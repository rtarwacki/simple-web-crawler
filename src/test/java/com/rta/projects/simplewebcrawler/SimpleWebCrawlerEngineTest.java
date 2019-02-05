package com.rta.projects.simplewebcrawler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple web crawler.
 */
public class SimpleWebCrawlerEngineTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public SimpleWebCrawlerEngineTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SimpleWebCrawlerEngineTest.class);
	}

	/**
	 * Tests
	 */
	public void testCorrectConnetion() {
		SimpleWebCrawlerEngine engine = new SimpleWebCrawlerEngine();
		String url = "http://wiprodigital.com";
		assertTrue(engine.checkUrlConnetion(url));
	}

	public void testIncorrectConnetion() {
		SimpleWebCrawlerEngine engine = new SimpleWebCrawlerEngine();
		String url = "http://wipro12345digital.com";
		assertFalse(engine.checkUrlConnetion(url));
	}

	public void testShowUrlResult() {
		SimpleWebCrawlerEngine engine = new SimpleWebCrawlerEngine();
		engine.urlResult.add("https://wiprodigital.com/who-we-are");
		engine.urlResult.add("https://wiprodigital.com/what-we-think");
		engine.urlResult.add("https://wiprodigital.com/privacy-policy");
		engine.urlResult.add("https://wiprodigital.com/designit-approach");
		assertEquals(4, engine.showUrlResult());
	}

	public void testShowIncorrectUrlResult() {
		SimpleWebCrawlerEngine engine = new SimpleWebCrawlerEngine();
		engine.incorrectUrlResult.add("https://www.linkedin.com/in/sandhyararun");
		engine.incorrectUrlResult.add("https://twitter.com/kiran_minnas");
		engine.incorrectUrlResult.add("https://twitter.com/georgeioannou");
		assertEquals(3, engine.showIncorrectUrlResult());
	}
}
