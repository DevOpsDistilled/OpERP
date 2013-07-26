package devopsdistilled.operp.server.data.repo;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.context.AppTestContext;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.items.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestContext.class)
@Transactional
public class ProductRepositoryTest {
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */

	@Inject
	ProductRepository productRepository;

	Product testProduct;

	@Before
	public void setUp() throws Exception {
		/*
		 * JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(
		 * entityManager); productRepository = jpaRepositoryFactory
		 * .getRepository(ProductRepository.class);
		 */
		testProduct = new Product();
		testProduct.setProductName("Test Product");

		assertNotNull(productRepository);
	}

	@Test
	public void testSave() {
		testProduct = productRepository.save(testProduct);
		Assert.assertEquals(testProduct,
				productRepository.findOne(testProduct.getProductId()));
	}

	@Test
	public void testFindByProductName() {
		Product savedProduct = productRepository.save(testProduct);
		List<Product> returnedProducts = productRepository
				.findByProductName("Test Product");
		assertNotNull(returnedProducts);
		System.out.println(returnedProducts.size());
		Assert.assertEquals(1, returnedProducts.size());
		Assert.assertThat(
				"Must have saved productName",
				savedProduct.getProductName(),
				CoreMatchers.is(returnedProducts.get(
						returnedProducts.size() - 1).getProductName()));
	}

	@Test
	public void testSaveCustom() {
		/*
		 * Product fromSave = productRepository.save(testProduct); Product
		 * fromSaveCustom = productRepository.saveCustom(testProduct);
		 * Assert.assertThat("save and saveCustom must return same object",
		 * fromSave, CoreMatchers.is(fromSaveCustom));
		 */
	}
}
