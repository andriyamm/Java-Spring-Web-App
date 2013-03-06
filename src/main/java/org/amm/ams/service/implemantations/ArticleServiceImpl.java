package org.amm.ams.service.implemantations;

import java.util.List;

import org.amm.ams.domain.Article;
import org.amm.ams.service.interfaces.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Override
	public List<Article> findAll() {
		// TODO Auto-generated method stub
		return null;
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
