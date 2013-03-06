package org.amm.ams.dao.interfaces;

import org.amm.ams.domain.Language;

public interface LanguageDao extends Dao<Language>,
		FindableDaoCriteria<Language>, FindableDaoNamedQuery<Language> {

	Language findByPrefix(String languagePrefix);
}
