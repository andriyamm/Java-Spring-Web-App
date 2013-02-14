package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Categories;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesDaoImpl extends HibernateDao<Categories> {

	public CategoriesDaoImpl(Class<Categories> persistentClass) {
		super(persistentClass);
	}

	public CategoriesDaoImpl() {
		super(Categories.class);
	}

}
