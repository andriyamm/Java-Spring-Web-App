package org.amm.ams.dao.implementations;

import java.util.List;

import org.amm.ams.dao.interfaces.ArticleDao;
import org.amm.ams.domain.Article;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
	@Override
	public List<ArticleDto> findAllByLang(String langPrefix) {
		
		Criteria criteria = getCriteria();
		
		criteria.createAlias("articlesDef", "def");
		criteria.createAlias("def.articleLang", "language");
		criteria.add(Restrictions.eq("language.prefix", langPrefix));
		criteria.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArticleDto findByIdAndLang(Long articleId, String langPrefix) {
		
		Criteria criteria = getCriteria();
		
		criteria.createAlias("articlesDef", "def");
		criteria.createAlias("def.articleLang", "language");
		criteria.add(Restrictions.eq("language.prefix", langPrefix));
		criteria.add(Restrictions.eq("id", articleId));
		criteria.setResultTransformer(Transformers.aliasToBean(ArticleDto.class));

		return criteria.list();
	}

}
