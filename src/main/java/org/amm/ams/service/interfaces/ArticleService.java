package org.amm.ams.service.interfaces;

import java.util.List;

import org.amm.ams.domain.Article;
import org.amm.ams.dto.ArticleDto;

public interface ArticleService extends AmsService<Article> {

	List<Article> find();

	List<ArticleDto> findAllByLang(String langPrefix);
}
