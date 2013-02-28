package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.CategoriesDefDao;
import org.amm.ams.domain.CategoriesDef;
import org.springframework.stereotype.Repository;

@Repository
public class CategoriesDefDaoImpl extends HibernateJpaDao<CategoriesDef> implements CategoriesDefDao{

	public CategoriesDefDaoImpl(Class<CategoriesDef> persistentClass) {
		super(persistentClass);
	}

	public CategoriesDefDaoImpl() {
		super(CategoriesDef.class);
	}

}