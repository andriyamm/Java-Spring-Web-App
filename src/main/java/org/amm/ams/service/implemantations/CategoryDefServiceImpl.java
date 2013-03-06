package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDao;
import org.amm.ams.dao.interfaces.CategoryDefDao;
import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.dao.interfaces.LanguageDao;
import org.amm.ams.domain.Category;
import org.amm.ams.domain.CategoryDef;
import org.amm.ams.domain.Language;
import org.amm.ams.service.interfaces.CategoryDefService;
import org.amm.ams.web.commands.CategoryCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryDefServiceImpl extends AmsServiceImpl<CategoryDef> implements CategoryDefService {

	@Autowired
	private CategoryDao categoriesDao;
	
	@Autowired
	private CategoryDefDao categoriesDefDao;
	
	@Autowired
	private LanguageDao languagesDao;
	
	@Override
	public Dao<CategoryDef> getDao() {
		return categoriesDefDao;
	}
	
	@Transactional
	@Override
	public void createCategory(CategoryCommand categoryCommand){

		Category category = new Category();
		category.setParentCategory(categoriesDao.findById(categoryCommand.getParentCategory()));
		categoriesDao.insert(category);
		
		Language lang = languagesDao.findById(categoryCommand.getLanguageId());
		
		CategoryDef categoriesDef = new CategoryDef();
		categoriesDef.setName(categoryCommand.getCategoryName());
		categoriesDef.setLang(lang);
		categoriesDef.setCategory(category);
		categoriesDefDao.insert(categoriesDef);
	}

	@Transactional
	@Override
	public void editCategory(CategoryCommand categoryCommand){

		Language lang = languagesDao.findById(categoryCommand.getLanguageId());

		Category category = categoriesDao.findById(categoryCommand.getCategoryId());
		category.setParentCategory(categoriesDao.findById(categoryCommand.getParentCategory()));
		categoriesDao.update(category);
		
		CategoryDef categoriesDef = new CategoryDef();
		categoriesDef.setName(categoryCommand.getCategoryName());
		categoriesDef.setLang(lang);
		categoriesDef.setCategory(category);
		
		categoriesDefDao.update(categoriesDef);
	}
	
	@Transactional
	@Override
	public List<CategoryDef> findDef(String langPrefix){
		//Language lang = languagesDao.findByPrefix(langPrefix);
		//return categoriesDao.find1(lang);
		//return categoriesDao.find(lang);
		return categoriesDefDao.find(langPrefix);
	}
	
	@Transactional
	@Override
	public List<Category> find(String langPrefix){
		//Language lang = languagesDao.findByPrefix(langPrefix);
		//return categoriesDao.find1(lang);
		//return categoriesDefDao.find(lang);
		return categoriesDao.find(langPrefix);
	}
	
	@Transactional
	@Override
	public  List<Category> findAllCategories() {
		return categoriesDao.findAll();
	}
}
