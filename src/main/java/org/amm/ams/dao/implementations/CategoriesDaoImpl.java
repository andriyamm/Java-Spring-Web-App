package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.CategoriesDao;
import org.amm.ams.domain.Categories;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesDaoImpl extends HibernateJpaDao<Categories> implements CategoriesDao{

	public CategoriesDaoImpl(Class<Categories> persistentClass) {
		super(persistentClass);
	}

	public CategoriesDaoImpl() {
		super(Categories.class);
	}

}
