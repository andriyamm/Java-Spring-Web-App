package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.ArticleDao;
import org.amm.ams.domain.Article;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl extends HibernateJpaDao<Article> implements ArticleDao{

	public ArticleDaoImpl(Class<Article> persistentClass) {
		super(persistentClass);
	}
	
	public ArticleDaoImpl() {
		super(Article.class);
	}

}
