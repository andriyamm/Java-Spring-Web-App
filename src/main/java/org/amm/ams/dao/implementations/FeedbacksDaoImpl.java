package org.amm.ams.dao.implementations;

import org.amm.ams.domain.Feedbacks;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbacksDaoImpl extends HibernateDao<Feedbacks> {

	public FeedbacksDaoImpl(Class<Feedbacks> persistentClass) {
		super(persistentClass);
	}
	
	public FeedbacksDaoImpl() {
		super(Feedbacks.class);
	}

}
