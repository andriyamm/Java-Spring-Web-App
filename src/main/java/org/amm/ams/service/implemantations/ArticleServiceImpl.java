package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.dao.interfaces.ArticleDao;
import org.amm.ams.dao.interfaces.Dao;
import org.amm.ams.domain.Article;
import org.amm.ams.service.interfaces.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends AmsServiceImpl<Article> implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dao<Article> getDao() {
		return articleDao;
	}

	//@Autowired
	//private ArticlesDao articlesDao;

//	public ArticlesDao getArticlesDao() {
//		return articlesDao;
//	}
//
//	public void setArticlesDao(ArticlesDao articlesDao) {
//		this.articlesDao = articlesDao;
//	}

//	@Override
//	@Transactional
//	public List<Articles> findAll() {
//		return articlesDao.findAll();
//	}
	
}
