package devopsdistilled.operp.server.data.repo;

import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;
import devopsdistilled.operp.server.data.repo.items.BrandRepository;
import devopsdistilled.operp.server.data.repo.items.ItemRepository;
import devopsdistilled.operp.server.data.repo.items.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppContext.class })
public class ItemRepositoryTest {

	@Inject
	private ItemRepository itemRepository;

	@Inject
	private ProductRepository productRepository;

	@Inject
	private BrandRepository brandRepository;

	private Item item;
	private Product product;
	private Brand brand;

	@Before
	public void setUp() throws Exception {
		item = new Item();
		product = new Product();
		brand = new Brand();
		Assert.assertNotNull(itemRepository);
		Assert.assertNotNull(productRepository);
		Assert.assertNotNull(brandRepository);
	}

	@Test
	public void testFindByProductNameAndBrandName() {
		product.setProductName("Product One");
		brand.setBrandName("Brand One");
		product = productRepository.saveAndFlush(product);
		brand = brandRepository.saveAndFlush(brand);
		item.setItemName("Item One");
		item.setProduct(product);
		item.setBrand(brand);
		item = itemRepository.saveAndFlush(item);
		Item returnedItem = itemRepository
				.findByProductAndBrand(product, brand);

		Assert.assertThat(item, is(returnedItem));
	}

	@Test
	public void testSave() {
		item.setItemName("Test Item");
		Item savedItem = itemRepository.save(item);
		Assert.assertThat(item.getItemName(), is(savedItem.getItemName()));
	}

}
