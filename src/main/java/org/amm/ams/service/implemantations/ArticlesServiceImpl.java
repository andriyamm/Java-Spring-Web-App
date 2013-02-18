package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.dao.interfaces.ArticlesDao;
import org.amm.ams.domain.Articles;
import org.amm.ams.service.interfaces.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticlesServiceImpl implements ArticlesService{

	@Autowired
	private ArticlesDao articlesDao;

	public ArticlesDao getArticlesDao() {
		return articlesDao;
	}

	public void setArticlesDao(ArticlesDao articlesDao) {
		this.articlesDao = articlesDao;
	}

	@Override
	@Transactional
	public List<Articles> findAll() {
		return articlesDao.findAll();
	}
	
}
