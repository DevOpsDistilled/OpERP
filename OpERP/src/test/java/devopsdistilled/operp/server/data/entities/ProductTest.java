package devopsdistilled.operp.server.data.entities;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.context.JpaH2TestContext;
import devopsdistilled.operp.server.data.repo.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaH2TestContext.class)
@Transactional
public class ProductTest {

	@Inject
	private ProductRepository productRepository;

	@Test
	public void test() {
		Assert.assertNotNull(productRepository);
		
	}

}
