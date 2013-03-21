package org.amm.ams.dao.interfaces;

import java.util.List;

import org.amm.ams.domain.Article;
import org.amm.ams.dto.ArticleDto;

public interface ArticleDao extends Dao<Article>{

	List<ArticleDto> findAllByLang(String langPrefix);
	ArticleDto findByIdAndLang(Long articleId, String langPrefix);
	List<ArticleDto> findAllByLangNamedQuery(String languagePrefix);

}
