package com.mybitly.myapp.util;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	public static char generateNumber() {
		return (char) (Math.random() * 10 + 48);
	}
	
	public static char generateAlphabet(boolean isLower) {
		if (isLower) {
			return (char) (Math.random() * 26 + 97);
		} else {
			return (char) (Math.random() * 26 + 65);
		}
	}
	
	public static String createUrl() {
		char[] url = new char[8];
		url[0] = generateNumber();
		
		for(int i=1; i<8; i++) {
			boolean isLower = Math.random() < 0.5 ? true : false;
			url[i] = generateAlphabet(isLower);
		}
		
		return String.valueOf(url);
	}
}
