package org.amm.ams.service.implemantations;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.dao.interfaces.CategoriesDefDao;
import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.dao.interfaces.LanguagesDao;
import org.amm.ams.domain.Categories;
import org.amm.ams.domain.CategoriesDef;
import org.amm.ams.domain.Languages;
import org.amm.ams.service.interfaces.CategoriesService;
import org.amm.ams.web.commands.CategoryCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriesServiceImpl extends AmsServiceImpl<Categories> implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;

	@Autowired
	private CategoriesDefDao categoriesDefDao;
	
	@Autowired
	private LanguagesDao languagesDao;
	
	@Override
	public Dao<Categories> getDao() {
		return categoriesDao;
	}
	
	@Transactional
	@Override
	public void createCategory(CategoryCommand categoryCommand){
		
		Categories category = new Categories();
		category.setParent(categoryCommand.getParentCategory());
		categoriesDao.insert(category);
		
		//Languages lang = languagesDao.findById(categoryCommand.getLanguageId());
		
		Languages lang = new Languages();
		lang.setId(categoryCommand.getLanguageId());
		
		CategoriesDef categoriesDef = new CategoriesDef();
		categoriesDef.setName(categoryCommand.getCategoryName());
		categoriesDef.setLang(lang);
		
		categoriesDefDao.insert(categoriesDef);
		
	}
	
}
