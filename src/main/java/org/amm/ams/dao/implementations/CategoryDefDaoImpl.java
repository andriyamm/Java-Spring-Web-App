package org.amm.ams.dao.implementations;

import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDefDao;
import org.amm.ams.domain.Category;
import org.amm.ams.domain.CategoryDef;
import org.amm.ams.domain.Language;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDefDaoImpl extends HibernateJpaDaoCriteria<CategoryDef> implements CategoryDefDao {
	
	private static final String LANG = "language_id";
	
	public CategoryDefDaoImpl(Class<CategoryDef> persistentClass) {
		super(persistentClass);
	}

	public CategoryDefDaoImpl() {
		super(CategoryDef.class);
	}

	@Override
	public List<CategoryDef> findAllByLang(final Language lang) {
		return findByParameter(LANG, lang);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> find(final Language lang){
		Criteria criteria = getCriteria();
		
		criteria.createAlias("categorydef.language", "language");
		criteria.add(Restrictions.eq("language.prefix", lang));
		criteria.createAlias("categorydef.category", "category");
		
		return criteria.list();
	}
}