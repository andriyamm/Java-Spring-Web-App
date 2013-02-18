package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.ArticlesDao;
import org.amm.ams.domain.Articles;
import org.springframework.stereotype.Repository;

@Repository
public class ArticlesDaoImpl extends HibernateJpaDao<Articles> implements ArticlesDao{

	public ArticlesDaoImpl(Class<Articles> persistentClass) {
		super(persistentClass);
	}
	
	public ArticlesDaoImpl() {
		super(Articles.class);
	}

}
