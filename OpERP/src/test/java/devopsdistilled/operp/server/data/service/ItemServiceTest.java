package devopsdistilled.operp.server.data.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.context.JpaContext;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.service.items.BrandService;
import devopsdistilled.operp.server.data.service.items.ItemService;
import devopsdistilled.operp.server.data.service.items.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaContext.class })
public class ItemServiceTest {

	@Inject
	private ItemService itemService;

	@Inject
	private BrandService brandService;

	@Inject
	private ProductService productService;

	private Item item;

	private Product product;

	private Brand brand;

	@Before
	public void setUp() throws Exception {
		item = new Item();
		brand = new Brand();
		product = new Product();

		assertNotNull(itemService);
		assertNotNull(brandService);
		assertNotNull(productService);
	}

	@Test
	@Transactional
	public void testSaveAndUpdateModel() {

		// This test won't run if Unique constraints are set in Item Entity.
		// Unique Constraints were removed to test this Test.

		product.setProductName("Test Product");
		product = productService.save(product);
		assertNotNull(product.getProductId());

		Product dbProduct = productService.findOne(product.getProductId());
		assertNotNull(dbProduct);
		assertThat(new Integer(0), is(dbProduct.compareTo(product)));

		brand.setBrandName("Test Brand");
		brand = brandService.save(brand);
		assertNotNull(brand.getBrandID());

		Brand dbBrand = brandService.findOne(brand.getBrandID());
		assertNotNull(dbBrand);
		assertThat(new Integer(0), is(dbBrand.compareTo(brand)));

		// productService.getRepo().detach(product);

		Product detProduct = new Product();
		detProduct.setProductId(product.getProductId());
		detProduct.setProductName(product.getProductName());
		// To test if save() is successful even with detached product
		item.setProduct(detProduct);
		item.setBrand(brand);

		item = itemService.save(item);
		assertNotNull(item);
		assertNotNull(item.getItemId());

	}
}
