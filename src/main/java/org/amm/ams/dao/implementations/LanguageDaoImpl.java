package org.amm.ams.dao.implementations;

import static org.amm.ams.common.AmsNamedQuery.Language.FIND_BY_PREFIX;
import static org.amm.ams.common.AmsConstants.QueryParam.PREFIX;

import java.util.HashMap;
import java.util.Map;

import org.amm.ams.dao.interfaces.LanguageDao;
import org.amm.ams.domain.Language;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class LanguageDaoImpl extends HibernateJpaDaoCriteria<Language>
		implements LanguageDao {

	public LanguageDaoImpl(Class<Language> persistentClass) {
		super(persistentClass);
	}

	public LanguageDaoImpl() {
		super(Language.class);
	}

	@Override
	public Language findByPrefix(String languagePrefix) {

		Map<String, String> params = new HashMap<String, String>();
		params.put(PREFIX, languagePrefix);

		return (Language) findByNamedQueryAndNamedParams(FIND_BY_PREFIX, params).get(0);
	}

}
