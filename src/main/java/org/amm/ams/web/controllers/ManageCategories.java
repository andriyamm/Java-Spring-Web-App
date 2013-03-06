package org.amm.ams.web.controllers;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.amm.ams.service.interfaces.CategoryDefService;
import org.amm.ams.service.interfaces.LanguageService;
import org.amm.ams.web.commands.CategoryCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("category")
public class ManageCategories {

	@Autowired
	private CategoryDefService categoriesDefService;
	
	@Autowired
	private LanguageService languagesService;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createAddCategoryForm(Map<String, Object> params,
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			HttpSession session) {
		
		params.put("languages", languagesService.findAll());
		params.put("categories", categoriesDefService.findAll());
		
		return "categories/create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String submitAddCategoryForm(
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			BindingResult result, Map<String, Object> params, Locale locale,
			HttpSession session) {

		categoriesDefService.createCategory(categoryCommand);
		
		return "categories/create";//TODO: redirect
	}
	
	
	@RequestMapping(value = "edit/{categoryId}", method = RequestMethod.GET)
	public String createEditCategoryForm(@PathVariable("categoryId") Long categoryId,
			Map<String, Object> params,
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			HttpSession session) {

		params.put("category_id", categoriesDefService.findByID(categoryId));
		params.put("languages", languagesService.findAll());
		params.put("categories", categoriesDefService.findAll());

		return "categories/edit";
	}

	@RequestMapping(value = "edit/{categoryId}", method = RequestMethod.POST)
	public String submitEditCategoryForm(@PathVariable("categoryId") Long categoryId,
			Map<String, Object> params,
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			HttpSession session) {

		categoriesDefService.editCategory(categoryCommand);

		return "categories/create";
	}

	@RequestMapping("list")
	public String listCategory(@RequestParam("lang") String langPrefix,
			Map<String, Object> params, HttpSession session) {

		//params.put("categories", categoriesDefService.findAll());
		//params.put("categories", categoriesDefService.findAllCategories());
		params.put("categories", categoriesDefService.find(langPrefix));
		
		return "categories/list";
	}

}
