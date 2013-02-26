package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.LanguagesDao;
import org.amm.ams.domain.Languages;
import org.springframework.stereotype.Repository;

@Repository
public class LanguagesDaoImpl extends HibernateJpaDao<Languages> implements LanguagesDao{

	public LanguagesDaoImpl(Class<Languages> persistentClass) {
		super(persistentClass);
	}

	public LanguagesDaoImpl() {
		super(Languages.class);
	}
	
}
