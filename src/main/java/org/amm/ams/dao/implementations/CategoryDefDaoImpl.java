package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.CategoryDefDao;
import org.amm.ams.domain.CategoryDef;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDefDaoImpl extends HibernateJpaDao<CategoryDef> implements CategoryDefDao{

	public CategoryDefDaoImpl(Class<CategoryDef> persistentClass) {
		super(persistentClass);
	}

	public CategoryDefDaoImpl() {
		super(CategoryDef.class);
	}

}