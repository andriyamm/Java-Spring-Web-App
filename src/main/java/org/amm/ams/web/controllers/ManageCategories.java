package org.amm.ams.web.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.service.interfaces.CategoriesService;
import org.amm.ams.web.commands.CategoryCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category")
public class ManageCategories {

	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createAddCategoryForm(Map<String, Object> params,
			HttpSession session) {

		return "createCategory";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView submitAddCategoryForm(
			@ModelAttribute("categoryCommand") CategoryCommand categoryCommand,
			BindingResult result, Map<String, Object> params,
			HttpSession session) {

		categoriesService.create();
		return null;
	}

	@RequestMapping("list")
	public String listCategory(Map<String, Object> params, HttpSession session) {

		return "listCategory";
	}

}
