package org.amm.ams.dao.implementations;

import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDao;
import org.amm.ams.domain.Category;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends HibernateJpaDaoCriteria<Category> implements CategoryDao{

	public CategoryDaoImpl(Class<Category> persistentClass) {
		super(persistentClass);
	}

	public CategoryDaoImpl() {
		super(Category.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> find(String lang){
		
		Criteria criteria = getCriteria();
		
		criteria.createAlias("categoryDef", "def");
		criteria.createAlias("def.language", "language");
		criteria.add(Restrictions.eq("language.prefix", lang));
		criteria.add(Restrictions.isNull("parentCategory"));
		
		return criteria.list();
	}
	
}
