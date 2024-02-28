package com.mybitly.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybitly.myapp.entity.Link;
import com.mybitly.myapp.store.Store;

@Service
public class LinkService {
	
	@Autowired
	Store store;
	
	public void add(Link link) {
		store.add(link);
	}
	
	public Link search(String shortenUrl) {
		return store.search(shortenUrl);
	}
}
