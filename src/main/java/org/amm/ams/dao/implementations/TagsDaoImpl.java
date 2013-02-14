package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Tags;
import org.springframework.stereotype.Repository;

@Repository
public class TagsDaoImpl extends HibernateDao<Tags> {

	public TagsDaoImpl(Class<Tags> persistentClass) {
		super(persistentClass);
	}

	public TagsDaoImpl() {
		super(Tags.class);
	}
	
	
}
