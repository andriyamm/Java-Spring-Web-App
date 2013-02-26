package org.amm.ams.web.controllers;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.amm.ams.service.interfaces.CategoriesService;
import org.amm.ams.service.interfaces.LanguagesService;
import org.amm.ams.web.commands.CategoryCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("category")
public class ManageCategories {

	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private LanguagesService languagesService;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createAddCategoryForm(Map<String, Object> params,
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			HttpSession session) {
		
		//String temp = DOMAIN + "/category/create"; //TODO
		//params.put("action", "category/create");
		
		params.put("languages", languagesService.findAll());
		params.put("categories", categoriesService.findAll());
		
		return "categories/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String submitAddCategoryForm(
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			BindingResult result, Map<String, Object> params, Locale locale,
			HttpSession session) {

		categoriesService.createCategory(categoryCommand);
		
		return locale.getDisplayLanguage();
	}

	@RequestMapping("list")
	public String listCategory(Map<String, Object> params, HttpSession session) {
		
		params.put("categories", categoriesService.findAll());
		
		return "categories/list";
	}

}
