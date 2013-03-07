package org.amm.ams.dao.implementation;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.LinkedList;
import java.util.List;

import org.amm.ams.dao.interfaces.CategoryDefDao;
import org.amm.ams.domain.Category;
import org.amm.ams.domain.CategoryDef;
import org.amm.ams.domain.Language;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CategoryDefDaoTest {

	@Mock
	private CategoryDefDao categoriesDefDao;
	
	@Before
	public void setUp() throws Exception {
		categoriesDefDao = mock(CategoryDefDao.class);
	}

	@After
	public void tearDown() throws Exception {
		 Mockito.reset(categoriesDefDao);
	}

	@Test
	public void testCategoriesDefDao() {
		assertEquals(true, true);
	}
	
	//@Test
	public List<CategoryDef> testFind(String langPrefix){
		
		
		
		return null;
	}
	
	/*@Test
	public void testFindAll() {
		List<CategoryDef> all = new LinkedList<CategoryDef>();
		all.add(new CategoryDef(1l, "John", new Language(), new Category()));
		all.add(new CategoryDef(2l, "Jane", new Language(), new Category()));

		// MOCK ALERT: return mocked result set on find
		when(categoriesDefDao.findAll()).thenReturn(all);

		// MOCK ALERT: verify the method was called
		verify(categoriesDefDao).findAll();
	}*/
}
