select *
from category as c left join categorydef as cd on c.category_id = cd.category_id
where cd.language_id = 1