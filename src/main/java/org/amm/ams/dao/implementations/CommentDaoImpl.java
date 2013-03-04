package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl extends HibernateJpaDao<Comment> {

	public CommentDaoImpl(Class<Comment> persistentClass) {
		super(persistentClass);
	}

	public CommentDaoImpl() {
		super(Comment.class);
	}

}
