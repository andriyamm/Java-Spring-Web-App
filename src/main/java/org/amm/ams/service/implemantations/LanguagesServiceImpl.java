package org.amm.ams.service.implemantations;

import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.dao.interfaces.LanguagesDao;
import org.amm.ams.domain.Languages;
import org.amm.ams.service.interfaces.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LanguagesServiceImpl extends AmsServiceImpl<Languages> implements LanguagesService{

	@Autowired
	private LanguagesDao languagesDao;
	
	@Override
	public Dao<Languages> getDao() {
		return languagesDao;
	}

}
