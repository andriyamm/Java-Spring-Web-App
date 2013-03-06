package org.amm.ams.dao.implementations;

import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDao;
import org.amm.ams.domain.Category;
import org.amm.ams.domain.Language;
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
	public List<Category> find(final Language lang){
		
		Criteria criteria = getCriteria();
		
		criteria.createAlias("category.categorydef", "categorydef");
		criteria.createAlias("categorydef.language", "language");
		criteria.add(Restrictions.eq("language.prefix", lang));
		
		return criteria.list();
	}
}
