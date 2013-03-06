package org.amm.ams.service.implementation;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDefDao;
import org.amm.ams.domain.Category;
import org.amm.ams.domain.CategoryDef;
import org.amm.ams.domain.Language;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDefServiceTest {

	@Mock
	private CategoryDefDao categoriesDefDao;

	@Before
	public void setUp() {
		
		categoriesDefDao = mock(CategoryDefDao.class); //here is the actual mocking call
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCategoriesDefService() {
		assertEquals(true, true);
	}

	@Test
	public void testFindAll() {
		List<CategoryDef> all = new LinkedList<CategoryDef>();
		all.add(new CategoryDef(1l, "John", new Language(), new Category()));
		all.add(new CategoryDef(2l, "Jane", new Language(), new Category()));

		// MOCK ALERT: return mocked result set on find
		when(categoriesDefDao.findAll()).thenReturn(all);

		// MOCK ALERT: verify the method was called
		//verify(categoriesDefDao).findAll();
	}
	
}
