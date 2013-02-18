package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.TagsDao;
import org.amm.ams.domain.Tags;
import org.springframework.stereotype.Repository;

@Repository
public class TagsDaoImpl extends HibernateJpaDao<Tags> implements TagsDao {

//	public TagsDaoImpl(Class<Tags> persistentClass) {
//		super(persistentClass);
//	}
//
//	public TagsDaoImpl() {
//		super(Tags.class);
//	}
	
}
