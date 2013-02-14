package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Categories;

public class CategoriesDaoImpl extends HibernateDao<Categories> {

	public CategoriesDaoImpl(Class<Categories> persistentClass) {
		super(persistentClass);
	}

	public CategoriesDaoImpl() {
		super(Categories.class);
	}

}
