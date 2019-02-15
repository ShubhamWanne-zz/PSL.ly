package com.psl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.psl.dao.URLRepo;
import com.psl.model.URL;

@RestController
public class URLController {
	
	@Autowired
	private URLRepo urlRepo;
	
	@RequestMapping(value="/psl.ly/create", method=RequestMethod.POST)
	public URL createShortURL(@RequestBody @Valid URL url){
		URL url_ = urlRepo.findByUrl(url.getUrl());
		
		if(url_ == null) {
			url_ = new URL(url.getUrl());
			url_ = urlRepo.save(url_);
		}
		url_.setKey(url_.getKey());
		return url_;
	}
	
	@RequestMapping(value="/psl.ly/{key}", method=RequestMethod.GET)
	public RedirectView redirectToURL(@PathVariable String key){
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(urlRepo.findById(key).orElse(null).getUrl());
		return redirectView;
	}
	
}
