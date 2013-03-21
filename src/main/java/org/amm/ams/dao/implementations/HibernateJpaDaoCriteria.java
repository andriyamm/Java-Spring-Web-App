package org.amm.ams.dao.implementations;

import java.util.LinkedList;
import java.util.List;

import org.amm.ams.dao.interfaces.FindableDaoCriteria;
import org.amm.ams.dto.ArticleDto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateJpaDaoCriteria<T> extends HibernateJpaDao<T> implements
		FindableDaoCriteria<T> {

	public HibernateJpaDaoCriteria(final Class<T> persistentClass) {
		super(persistentClass);
	}

	@Override
	public Long getRowCount() {

		Criteria criteria = getCriteria();
		criteria.setProjection(Projections.rowCount());
		Long count = (Long) criteria.uniqueResult();

		return count;
	}

	@Override
	public List<T> findByParameter(String fieldName, Object value) {
		return findByCriterions(Restrictions.eq(fieldName, value));
	}

	@Override
	public List<T> findByCriterions(final Criterion... criterions) {

		Criteria criteria = getCriteria();

		int nullCriterionsCount = 0;
		for (Criterion criterion : criterions) {
			if (criterion != null) {
				criteria.add(criterion);
			} else {
				nullCriterionsCount++;
			}
		}

		List<T> entities;
		entities = processCriteria(criteria, nullCriterionsCount, criterions);

		return entities;
	}

	@Override
	public List<T> findByOneOfCriterions(final Criterion... criterions) {

		Criteria criteria = getCriteria();

		int nullCriterionsCount = 0;
		Disjunction disjunction = Restrictions.disjunction();
		for (Criterion criterion : criterions) {
			if (criterion != null) {
				disjunction.add(criterion);
			} else {
				nullCriterionsCount++;
			}
		}

		criteria.add(disjunction);

		List<T> entities;
		entities = processCriteria(criteria, nullCriterionsCount, criterions);

		return entities;
	}

	@SuppressWarnings("unchecked")
	private List<T> processCriteria(final Criteria criteria,
			final int nullCriterions, final Criterion... criterions) {

		List<T> entities;
		if (nullCriterions == criterions.length && nullCriterions != 0) {
			entities = new LinkedList<T>();
		} else {
			entities = criteria.list();
		}
		return entities;
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	protected Criteria getCriteria() {
		Session session = (Session) getEntityManager().getDelegate();
		return session.createCriteria(getPersistentClass());
	}

	protected Criteria getCriteria(Class<ArticleDto> class1 ) {
		Session session = (Session) getEntityManager().getDelegate();
		return session.createCriteria(class1);
	}
}
