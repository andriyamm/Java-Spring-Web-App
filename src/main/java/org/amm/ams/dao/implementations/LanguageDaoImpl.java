package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.LanguageDao;
import org.amm.ams.domain.Category;
import org.amm.ams.domain.Language;
import org.springframework.stereotype.Repository;

@Repository
public class LanguageDaoImpl extends HibernateJpaDaoCriteria<Language> implements LanguageDao{

	public LanguageDaoImpl(Class<Language> persistentClass) {
		super(persistentClass);
	}

	public LanguageDaoImpl() {
		super(Language.class);
	}

	@Override
	public Language findByPrefix(String languagePrefix) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
