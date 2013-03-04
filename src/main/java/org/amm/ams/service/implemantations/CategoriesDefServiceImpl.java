package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.dao.interfaces.CategoriesDefDao;
import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.dao.interfaces.LanguagesDao;
import org.amm.ams.domain.Categories;
import org.amm.ams.domain.CategoriesDef;
import org.amm.ams.domain.Languages;
import org.amm.ams.service.interfaces.CategoriesDefService;
import org.amm.ams.web.commands.CategoryCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriesDefServiceImpl extends AmsServiceImpl<CategoriesDef> implements CategoriesDefService {

	@Autowired
	private CategoriesDao categoriesDao;
	
	@Autowired
	private CategoriesDefDao categoriesDefDao;
	
	@Autowired
	private LanguagesDao languagesDao;
	
	@Override
	public Dao<CategoriesDef> getDao() {
		return categoriesDefDao;
	}
	
	@Transactional
	@Override
	public void createCategory(CategoryCommand categoryCommand){

		Categories category = new Categories();
		category.setParentCategory(categoriesDao.findById(categoryCommand.getParentCategory()));
		categoriesDao.insert(category);
		
		Languages lang = languagesDao.findById(categoryCommand.getLanguageId());
		
		CategoriesDef categoriesDef = new CategoriesDef();
		categoriesDef.setName(categoryCommand.getCategoryName());
		categoriesDef.setLang(lang);
		categoriesDef.setCategories(category);
		categoriesDefDao.insert(categoriesDef);
	}

	@Transactional
	@Override
	public void editCategory(CategoryCommand categoryCommand){

		Languages lang = languagesDao.findById(categoryCommand.getLanguageId());

		Categories category = categoriesDao.findById(categoryCommand.getCategoryId());
		category.setParentCategory(categoriesDao.findById(categoryCommand.getParentCategory()));
		categoriesDao.update(category);
		
		CategoriesDef categoriesDef = new CategoriesDef();
		categoriesDef.setName(categoryCommand.getCategoryName());
		categoriesDef.setLang(lang);
		categoriesDef.setCategories(category);
		
		categoriesDefDao.update(categoriesDef);
	}
	
	@Transactional
	@Override
	public void findCategories(Long languageId){
		
		Languages lang = languagesDao.findById(languageId);
		
		List<Categories> categories = categoriesDao.findAll();
		
		for(Categories category : categories){
			categoriesDefDao.findById(category.getId());
		}
		
	}
	
	private void find(){
		
	}
}
