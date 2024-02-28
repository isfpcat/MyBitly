package com.mybitly.myapp.entity;

import com.mybitly.myapp.util.Utils;

public class Link {
	private String shortenUrl;
	private String destUrl;
	private int redirectCount;
	
	public Link(String destUrl) {
		this.destUrl = destUrl;
		this.shortenUrl = Utils.createUrl();
	}
	
	public String getShortenUrl() {
		return shortenUrl;
	}
	public void setShortenUrl(String shortenUrl) {
		this.shortenUrl = shortenUrl;
	}
	public String getDestUrl() {
		return destUrl;
	}
	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}
	public int getRedirectCount() {
		return redirectCount;
	}
	public void increaseRedirectCount() {
		this.redirectCount++;
	}
	
}
