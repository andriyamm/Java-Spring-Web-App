package org.amm.ams.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.amm.ams.service.interfaces.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ListArticles {

	//@Autowired
	//private ArticlesService articlesService;
	
	public String list(Map<String, Object> params, HttpSession sess){
		
		//params.put("articles", articlesService.findAll());
		
		return "articles/list";
	}
}
