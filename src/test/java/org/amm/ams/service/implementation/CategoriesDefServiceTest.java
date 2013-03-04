package org.amm.ams.service.implementation;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.amm.ams.dao.interfaces.CategoriesDefDao;
import org.amm.ams.domain.Categories;
import org.amm.ams.domain.CategoriesDef;
import org.amm.ams.domain.Languages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoriesDefServiceTest {

	@Mock
	private CategoriesDefDao categoriesDefDao;

	@Before
	public void setUp() {
		
		categoriesDefDao = mock(CategoriesDefDao.class); //here is the actual mocking call
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCategoriesDefServiceImpl() {
		assertEquals(true, true);
	}

	@Test
	public void testFindAll() {
		List<CategoriesDef> all = new LinkedList<CategoriesDef>();
		all.add(new CategoriesDef(1l, "John", new Languages(), new Categories()));
		all.add(new CategoriesDef(2l, "Jane", new Languages(), new Categories()));

		// MOCK ALERT: return mocked result set on find
		when(categoriesDefDao.findAll()).thenReturn(all);

		// MOCK ALERT: verify the method was called
		verify(categoriesDefDao).findAll();
	}
}
