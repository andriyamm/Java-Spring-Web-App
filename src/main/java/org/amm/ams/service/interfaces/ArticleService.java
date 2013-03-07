package org.amm.ams.service.interfaces;

import java.util.List;

import org.amm.ams.domain.Article;

public interface ArticleService extends AmsService<Article> {

	List<Article> find();
}
