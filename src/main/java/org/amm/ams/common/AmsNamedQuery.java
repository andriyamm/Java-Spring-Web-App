package org.amm.ams.common;

public interface AmsNamedQuery {

	interface Category { 
		String FIND_ALL_BY_LANG = "findAllByLang";
	}
	
	interface Language {
		String FIND_BY_PREFIX = "findByPrefix";
	}
	
	interface Article{
		String FIND_ALL_ARTICLES_BY_LANG = "findAllArticlesByLang";
	}
}
