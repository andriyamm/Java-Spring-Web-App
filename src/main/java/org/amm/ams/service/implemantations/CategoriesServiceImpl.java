package org.amm.ams.service.implemantations;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.dao.interfaces.LanguagesDao;
import org.amm.ams.domain.Categories;
import org.amm.ams.domain.Languages;
import org.amm.ams.service.interfaces.CategoriesService;
import org.amm.ams.web.commands.CategoryCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl extends AmsServiceImpl<Categories> implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;

	@Autowired
	private LanguagesDao languagesDao;
	
	@Override
	public Dao<Categories> getDao() {
		return categoriesDao;
	}
	
	public void createCategory(CategoryCommand categoryCommand){
		
		//TODO
		// 0. create categories
		// 1. create categoriesdef
		
		Categories category = new Categories();
		category.setParent(0l);
		categoriesDao.insert(category);
		
		Languages lang = new Languages();
		lang.setName("qwerty");
		lang.setPrefix("qw");
		
		languagesDao.insert(lang);
		
	}
}
