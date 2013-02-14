package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Comments;
import org.springframework.stereotype.Repository;

@Repository
public class CommentsDaoImpl extends HibernateDao<Comments> {

	public CommentsDaoImpl(Class<Comments> persistentClass) {
		super(persistentClass);
	}
	
	public CommentsDaoImpl() {
		super(Comments.class);
	}

}
