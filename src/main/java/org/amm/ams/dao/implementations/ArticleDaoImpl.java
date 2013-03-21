package org.amm.ams.dao.implementations;

import static org.amm.ams.common.AmsConstants.QueryParam.PREFIX;
import static org.amm.ams.common.AmsNamedQuery.Article.FIND_ALL_ARTICLES_BY_LANG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.amm.ams.dao.interfaces.ArticleDao;
import org.amm.ams.domain.Article;
import org.amm.ams.dto.ArticleDto;
import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
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

	@Override
	public ArticleDto findByIdAndLang(Long articleId, String langPrefix) {
		
		Criteria criteria = getCriteria();
		
		criteria.createAlias("articlesDef", "def");
		criteria.createAlias("def.articleLang", "language");
		criteria.add(Restrictions.eq("language.prefix", langPrefix));
		criteria.add(Restrictions.eq("id", articleId));
		criteria.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));

		return (ArticleDto) criteria.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleDto> findAllByLangNamedQuery(String languagePrefix) {

		Map<String, String> params = new HashMap<String, String>();
		params.put(PREFIX, languagePrefix);

		return (List<ArticleDto>)findByNamedQueryAndNamedParams(FIND_ALL_ARTICLES_BY_LANG, params);
	}

}
