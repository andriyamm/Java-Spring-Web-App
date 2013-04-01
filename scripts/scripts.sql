select *
from category as c left join categorydef as cd on c.category_id = cd.category_id
where cd.language_id = 1

---
SELECT 
	article.article_id as id,  
    article.creationDate as creationDate,
    article.publishDate as publishDate,
    article.is_tmp as is_tmp,
    articledef.title as title,
    articledef.body as body,
	articledef.articledef_id as articledef_id,
    language.prefix as langPrefix      
FROM article
	LEFT JOIN articledef ON article.article_id = articledef.article_id
	LEFT JOIN language ON articledef.language_id = language.language_id
WHERE language.prefix =  :prefix

---
SELECT 
    article.article_id AS id,
    article.creationDate AS creationDate,
    article.publishDate AS publishDate, 
    article.is_tmp AS is_tmp, 
    articledef.title AS title, 
    articledef.body AS body, 
    articledef.articledef_id AS articledefId, 
    language.prefix AS langPrefix
FROM ams.article AS article
    LEFT JOIN ams.articledef AS articledef ON article.article_id = articledef.article_id
    LEFT JOIN ams.language AS language ON articledef.language_id = language.language_id
WHERE language.prefix =  'en' AND article.article_id =  '1'
