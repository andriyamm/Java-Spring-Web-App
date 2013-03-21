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