package org.amm.ams.service.implemantations;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.domain.Categories;
import org.amm.ams.service.interfaces.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;
	
	@Override
	@Transactional
	public void create(){
		Categories entity = null;
		categoriesDao.create(entity);
	}
}
