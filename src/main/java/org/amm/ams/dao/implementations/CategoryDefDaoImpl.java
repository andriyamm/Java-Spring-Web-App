package org.amm.ams.dao.implementations;

import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDefDao;
import org.amm.ams.domain.CategoryDef;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDefDaoImpl extends HibernateJpaDaoCriteria<CategoryDef> implements CategoryDefDao {
	
	public CategoryDefDaoImpl(Class<CategoryDef> persistentClass) {
		super(persistentClass);
	}

	public CategoryDefDaoImpl() {
		super(CategoryDef.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryDef> find(String langPrefix){
		
		Criteria criteria = getCriteria();
		
		criteria.createAlias("language", "language");
		criteria.createAlias("category", "category");
		criteria.add(Restrictions.isNull("category.parentCategory"));
		criteria.add(Restrictions.eq("language.prefix", langPrefix));
		
		return criteria.list();
	}
}