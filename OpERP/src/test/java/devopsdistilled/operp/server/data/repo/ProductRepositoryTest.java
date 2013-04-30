package devopsdistilled.operp.server.data.repo;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.context.AppTestContext;
import devopsdistilled.operp.server.data.entity.Product;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestContext.class)
@Transactional
public class ProductRepositoryTest {
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */

	@Inject
	ProductRepository productRepository;

	@Before
	public void setUp() throws Exception {
		/*
		 * JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(
		 * entityManager); productRepository = jpaRepositoryFactory
		 * .getRepository(ProductRepository.class);
		 */

		assertNotNull(productRepository);
	}

	@Test
	public void testSave() {
		Product testProduct = new Product();
		testProduct.setProductName("Test Product");
		testProduct = productRepository.save(testProduct);
		Assert.assertEquals(testProduct,
				productRepository.findOne(testProduct.getProductId()));
	}

}
