package com.rta.projects.simplewebcrawler;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SimpleWebCrawlerEngine {
	private static final int MAX_NUMBER_OF_PAGES_FOUND = 50;
	private static final int MAX_QUEUE_SAFE_SIZE = 500;

	public static Queue<String> queueResult = new LinkedList<>();
	public static Set<String> urlResult = new HashSet<>();
	public static Set<String> incorrectUrlResult = new HashSet<>();

	public static void searchUrl(String url, String filter) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();

			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if ((urlResult.size() == MAX_NUMBER_OF_PAGES_FOUND) || (queueResult.size() == MAX_QUEUE_SAFE_SIZE)) {
					return;
				}

				String href = link.attr("href");
				if (href.contains(filter)) {
					queueResult.add(href);
					urlResult.add(href);
				} else {
					incorrectUrlResult.add(href);
				}
			}

			searchUrl(queueResult.remove(), filter);

		} catch (UnknownHostException e) {
			System.out.println(e);
			return;
		} catch (IOException e) {
			System.out.println(e);
			return;
		}
	}

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
