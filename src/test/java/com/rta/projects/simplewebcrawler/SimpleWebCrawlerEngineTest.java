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

    public void testShowUrlResult()
    {
    	SimpleWebCrawlerEngine.urlResult.add("https://wiprodigital.com/who-we-are");
    	SimpleWebCrawlerEngine.urlResult.add("https://wiprodigital.com/what-we-think");
    	SimpleWebCrawlerEngine.urlResult.add("https://wiprodigital.com/privacy-policy");
    	SimpleWebCrawlerEngine.urlResult.add("https://wiprodigital.com/designit-approach");
        assertEquals(4,  SimpleWebCrawlerEngine.showUrlResult() );
    }
    
    public void testShowIncorrectUrlResult()
    {
    	SimpleWebCrawlerEngine.incorrectUrlResult.add("https://www.linkedin.com/in/sandhyararun");
    	SimpleWebCrawlerEngine.incorrectUrlResult.add("https://twitter.com/kiran_minnas");
    	SimpleWebCrawlerEngine.incorrectUrlResult.add("https://twitter.com/georgeioannou");
        assertEquals(3,  SimpleWebCrawlerEngine.showIncorrectUrlResult() );
    }
}
