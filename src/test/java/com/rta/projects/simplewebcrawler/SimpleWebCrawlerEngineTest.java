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
		String url = "http://wiprodigital.com";
		assertTrue(SimpleWebCrawlerEngine.checkUrlConnetion(url));
	}

	public void testIncorrectConnetion() {
		String url = "http://wipro12345digital.com";
		assertFalse(SimpleWebCrawlerEngine.checkUrlConnetion(url));
	}

}
