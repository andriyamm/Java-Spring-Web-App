package org.amm.ams.service.implemantations;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.domain.Categories;
import org.amm.ams.service.interfaces.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl extends ServiceImpl<Categories> implements CategoriesService {

	@Autowired
	private CategoriesDao categoriesDao;

	@Override
	public Dao<Categories> getDao() {
		return categoriesDao;
	}
}
