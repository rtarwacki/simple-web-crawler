package com.rta.projects.simplewebcrawler;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SimpleWebCrawlerEngine {
	
	public static Set<String> urlResult = new HashSet<>();
	public static Set<String> incorrectUrlResult = new HashSet<>();
	
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
	
	public static int showUrlResult() {
		System.out.println("--- url result");
		for (String url : urlResult) {
			System.out.println(url);
		}
		return urlResult.size();
	}

	public static int showIncorrectUrlResult() {
		System.out.println("--- incorrect url result");
		for (String url : incorrectUrlResult) {
			System.out.println(url);
		}
		return incorrectUrlResult.size();
	}
}
