package org.amm.ams.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.amm.ams.service.interfaces.ArticleService;
import org.amm.ams.service.interfaces.CategoryDefService;
import org.amm.ams.service.interfaces.LanguageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("article")
public class ManageArticles {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryDefService categoriesDefService;
	
	@Autowired
	private LanguageService languagesService;
	
	@RequestMapping("list")
	public String listArticles(Map<String, Object> params, HttpSession sess){
		
		String langPrefix = LocaleContextHolder.getLocale().getLanguage();
		params.put("articles", articleService.findAllForLang(langPrefix));
		params.put("categories", categoriesDefService.find(langPrefix));
		
		return "articles/list";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createAddArticleForm(Map<String, Object> params, HttpSession sess){
		
		params.put("languages", languagesService.findAll());
		params.put("categories", categoriesDefService.findAll());
		
		return "articles/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String submitAddArticleForm(Map<String, Object> params, HttpSession sess){
		
		params.put("articles", articleService.findAll());
		
		return "articles/list";
	}
	
	@RequestMapping(value = "edit/{articleId}", method = RequestMethod.GET)
	public String createEditArticleForm(@PathVariable("articleId") Long articleId,
			Map<String, Object> params, HttpSession sess){
		
		params.put("articles", articleService.findAll());
		
		return "articles/list";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String submitEditArticleForm(Map<String, Object> params, HttpSession sess){
		
		params.put("articles", articleService.findAll());
		
		return "articles/list";
	}
	
	@RequestMapping(value = "view/{articleId}", method = RequestMethod.GET)
	public String viewArticle(@PathVariable("articleId") Long articleId,
			Map<String, Object> params, HttpSession sess){
		
		params.put("article", articleService.findByID(articleId));
		
		return "articles/view";
	}
}
