package org.amm.ams.dao.implementations;

import static org.amm.ams.common.AmsNamedQuery.Language.FIND_BY_PREFIX;

import java.util.HashMap;
import java.util.Map;

import org.amm.ams.dao.interfaces.LanguageDao;
import org.amm.ams.domain.Language;
import org.springframework.stereotype.Repository;

@Repository
public class LanguageDaoImpl extends HibernateJpaDaoCriteria<Language>
		implements LanguageDao {

	public static final String PREFIX = "prefix";

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

		return findByNamedQueryAndNamedParams(FIND_BY_PREFIX, params).get(0);
	}

}
