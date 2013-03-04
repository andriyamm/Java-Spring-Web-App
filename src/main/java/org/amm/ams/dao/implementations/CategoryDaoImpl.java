package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.CategoryDao;
import org.amm.ams.domain.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends HibernateJpaDao<Category> implements CategoryDao{

	public CategoryDaoImpl(Class<Category> persistentClass) {
		super(persistentClass);
	}

	public CategoryDaoImpl() {
		super(Category.class);
	}

}
