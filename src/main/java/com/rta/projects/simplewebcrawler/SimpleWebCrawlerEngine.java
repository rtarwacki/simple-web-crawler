package com.rta.projects.simplewebcrawler;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SimpleWebCrawlerEngine {
	public static boolean checkUrlConnetion(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			return true;
		} catch (UnknownHostException e) {
			System.out.println(e);
			return false;
		} catch (IOException e) {
			System.out.println(e);
			return false;
		}
	}
}
