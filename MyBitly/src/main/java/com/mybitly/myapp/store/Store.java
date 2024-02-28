package com.mybitly.myapp.store;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mybitly.myapp.entity.Link;

@Component
public class Store {
	private Map<String, Link> linkList;
	
	public Store() {
		linkList = new HashMap<String, Link>();
	}
	
	public void add(Link link) {
		String shortenUrl = link.getShortenUrl();
		linkList.put(shortenUrl, link);
	}
	
	public Link search(String shortenUrl) {
		return linkList.get(shortenUrl);
	}
	
	public int getLinkListSize() {
		return linkList.size();
	}
}
