package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Articles;
import org.springframework.stereotype.Repository;

@Repository
public class ArticlesDaoImpl extends HibernateDao<Articles>{

	public ArticlesDaoImpl(Class<Articles> persistentClass) {
		super(persistentClass);
	}
	
	public ArticlesDaoImpl() {
		super(Articles.class);
	}

}
