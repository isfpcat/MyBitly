package com.mybitly.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mybitly.myapp.entity.Link;
import com.mybitly.myapp.service.LinkService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	LinkService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/createUrl", method = RequestMethod.GET)
	public String createUrl(Locale locale, Model model, @RequestParam(required=true) String destUrl) {
		logger.info("createUrl for {}.", destUrl);
		
		Link link = new Link(destUrl);
		service.add(link);
		model.addAttribute("shortenUrl", link.getShortenUrl());
		return "home";
	}
	
	@RequestMapping(value = "/redirectUrl", method = RequestMethod.GET)
	public String redirectUrl(Locale locale, Model model, @RequestParam(required=true) String shortenUrl) {
		logger.info("shortenUrl for {}.", shortenUrl);
		
		Link link = service.search(shortenUrl);
		String destUrl = "";
		if (link != null) {
			destUrl = link.getDestUrl();
			link.increaseRedirectCount();
		}
		logger.info("redirect for {}.", destUrl);
		model.addAttribute("destUrl", destUrl);
		return "redirect:" + destUrl;
	}
	
	@RequestMapping(value = "/redirectCount", method = RequestMethod.GET)
	public String redirectCount(Locale locale, Model model, @RequestParam(required=true) String shortenUrl) {
		logger.info("redirectCount for {}.", shortenUrl);
		
		Link link = service.search(shortenUrl);
		int redirectCount = 0;
		if (link != null) {
			redirectCount = link.getRedirectCount();
		}
		model.addAttribute("redirectCount", redirectCount);
		return "home";
	}
	
}
