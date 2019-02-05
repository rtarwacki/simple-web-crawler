package com.rta.projects.simplewebcrawler;

public class SimpleWebCrawlerApp {
	public static void main(String[] args) {
		SimpleWebCrawlerEngine engine = new SimpleWebCrawlerEngine();

		String url = "http://wiprodigital.com";
		String filter = "//wiprodigital.com";
		boolean isConnect = engine.checkUrlConnetion(url);

		if (isConnect) {
			engine.searchUrl(url, filter);
			int resultQuantity = engine.showUrlResult();
			int incorrectResultQuantity = engine.showIncorrectUrlResult();

			System.out.println("--- resultQuantity = " + resultQuantity);
			System.out.println("--- incorrectResultQuantity = " + incorrectResultQuantity);
		}
	}
}
