package org.amm.ams.dao.implementations;

import static org.amm.ams.common.AmsConstants.QueryParam.PREFIX;
import static org.amm.ams.common.AmsNamedQuery.Article.FIND_ALL_ARTICLES_BY_LANG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.amm.ams.dao.interfaces.ArticleDao;
import org.amm.ams.domain.Article;
import org.amm.ams.dto.ArticleDto;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
//import org.hibernate.Query;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.HibernateEntityManager;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BooleanType;
import org.hibernate.type.DateType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl extends HibernateJpaDaoCriteria<Article> implements ArticleDao{

	public ArticleDaoImpl(Class<Article> persistentClass) {
		super(persistentClass);
	}
	
	public ArticleDaoImpl() {
		super(Article.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Article> findAllForLang(String langPrefix) {
		Criteria criteria = getCriteria();
		
	
		criteria.createAlias("articlesDef", "def");
		criteria.createAlias("def.articleLang", "language");
		criteria.add(Restrictions.eq("language.prefix", langPrefix));
		
		return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleDto> findAllByLang(String langPrefix) {
		
		Criteria criteria = getCriteria();
	
		criteria.createAlias("articlesDef", "def", CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("def.articleLang", "language", CriteriaSpecification.LEFT_JOIN);
		criteria.add(Restrictions.eq("language.prefix", langPrefix));
		criteria.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));
		
		return criteria.list();
	}

//	@Override
//	public ArticleDto findByIdAndLang(Long articleId, String langPrefix) {
//		
//		Criteria criteria = getCriteria();
//		
//		criteria.createAlias("articlesDef", "def");
//		criteria.createAlias("def.articleLang", "language");
//		criteria.add(Restrictions.eq("language.prefix", langPrefix));
//		criteria.add(Restrictions.eq("id", articleId));
//		criteria.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));
//
//		return (ArticleDto) criteria.list().get(0);
//	}
	
	@Override
	public ArticleDto findByIdAndLang(Long articleId, String langPrefix) {
		
		String s = "SELECT article.article_id as id, article.creationDate as creationDate, article.publishDate as publishDate, article.is_tmp as is_tmp, articledef.title as title, articledef.body as body, articledef.articledef_id as articledefId, language.prefix as langPrefix FROM ams.article as article LEFT JOIN ams.articledef as articledef ON article.article_id = articledef.article_id LEFT JOIN ams.language as language ON articledef.language_id = language.language_id WHERE language.prefix = :prefix AND article.article_id = :articleId";
		
		Session session = (Session) getEntityManager().getDelegate();
		ArticleDto res = (ArticleDto) session.createSQLQuery(s)
				.addScalar("id", LongType.INSTANCE)
				.addScalar("creationDate", DateType.INSTANCE)
				.addScalar("publishDate", DateType.INSTANCE)
				.addScalar("is_tmp", BooleanType.INSTANCE)
				.addScalar("title", StringType.INSTANCE)
				.addScalar("body", StringType.INSTANCE)
				.addScalar("articledefId", LongType.INSTANCE)
				.addScalar("langPrefix", StringType.INSTANCE)
				.setParameter("prefix", langPrefix)
				.setParameter("articleId", articleId)
				.setResultTransformer(Transformers.aliasToBean(ArticleDto.class))
				.list().get(0);
				
		return res;
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ArticleDto> findAllByLangNamedQuery(String languagePrefix) {
//
//		Map<String, String> params = new HashMap<String, String>();
//		params.put(PREFIX, languagePrefix);
//
//		return (List<ArticleDto>)findByNamedQueryAndNamedParams(FIND_ALL_ARTICLES_BY_LANG, params);
//	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ArticleDto> findAllByLangNamedQuery(String languagePrefix) {
		String s = "SELECT article.article_id as id, article.creationDate as creationDate, article.publishDate as publishDate, article.is_tmp as is_tmp, articledef.title as title, articledef.body as body, articledef.articledef_id as articledefId, language.prefix as langPrefix FROM ams.article as article LEFT JOIN ams.articledef as articledef ON article.article_id = articledef.article_id LEFT JOIN ams.language as language ON articledef.language_id = language.language_id WHERE language.prefix = :prefix";
		
		Session session = (Session) getEntityManager().getDelegate();
		List<ArticleDto> res = session.createSQLQuery(s)
				.addScalar("id", LongType.INSTANCE)
				.addScalar("creationDate", DateType.INSTANCE)
				.addScalar("publishDate", DateType.INSTANCE)
				.addScalar("is_tmp", BooleanType.INSTANCE)
				.addScalar("title", StringType.INSTANCE)
				.addScalar("body", StringType.INSTANCE)
				.addScalar("articledefId", LongType.INSTANCE)
				.addScalar("langPrefix", StringType.INSTANCE)
				.setParameter("prefix", languagePrefix)
				.setResultTransformer(Transformers.aliasToBean(ArticleDto.class))
				.list();
				
		return res;
	}
	
	
}
