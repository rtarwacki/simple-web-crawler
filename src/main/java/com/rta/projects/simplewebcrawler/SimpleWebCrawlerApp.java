package com.rta.projects.simplewebcrawler;

public class SimpleWebCrawlerApp 
{
    public static void main( String[] args )
    {
		String url = "http://wiprodigital.com";
		String filter = "//wiprodigital.com";
		boolean isConnect = SimpleWebCrawlerEngine.checkUrlConnetion(url);

		if (isConnect) {
			SimpleWebCrawlerEngine.searchUrl(url, filter);
			int resultQuantity = SimpleWebCrawlerEngine.showUrlResult();
			int incorrectResultQuantity = SimpleWebCrawlerEngine.showIncorrectUrlResult();
			
			System.out.println("--- resultQuantity = " + resultQuantity);
			System.out.println("--- incorrectResultQuantity = " + incorrectResultQuantity);
		}
    }
}
