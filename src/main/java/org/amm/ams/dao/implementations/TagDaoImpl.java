package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.TagDao;
import org.amm.ams.domain.Tag;
import org.springframework.stereotype.Repository;

@Repository
public class TagDaoImpl extends HibernateJpaDao<Tag> implements TagDao {

//	public TagsDaoImpl(Class<Tags> persistentClass) {
//		super(persistentClass);
//	}
//
//	public TagsDaoImpl() {
//		super(Tags.class);
//	}
	
}
