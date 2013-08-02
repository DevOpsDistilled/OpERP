package devopsdistilled.operp.server.data.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.service.items.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppContext.class })
public class CategoryServiceTest {

	@Inject
	private CategoryService categoryService;

	private Category category;

	@Before
	public void setUp() {
		category = new Category();

		assertNotNull(category);
		assertNotNull(categoryService);
	}

}
