package org.amm.ams.dao.implementations;

import org.amm.ams.dao.interfaces.FindableDaoCriteria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public class HibernateJpaDaoCriteria<T> extends HibernateJpaDao<T> implements
		FindableDaoCriteria<T> {

	@Override
	public Long getRowCount() {

		Session session = (Session) getEntityManager().getDelegate();

		Criteria criteria = session.createCriteria(getPersistentClass());
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();

		return count;
	}
}
