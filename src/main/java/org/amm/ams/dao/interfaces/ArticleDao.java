package org.amm.ams.dao.interfaces;

import java.util.List;

import org.amm.ams.domain.Article;

public interface ArticleDao extends Dao<Article>{

	List<Article> findAllForLang(String langPrefix);

}
