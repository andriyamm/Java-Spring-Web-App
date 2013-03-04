package org.amm.ams.service.implemantations;

import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.dao.interfaces.LanguageDao;
import org.amm.ams.domain.Language;
import org.amm.ams.service.interfaces.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LanguageServiceImpl extends AmsServiceImpl<Language> implements LanguageService{

	@Autowired
	private LanguageDao languagesDao;
	
	@Override
	public Dao<Language> getDao() {
		return languagesDao;
	}

}
