package devopsdistilled.operp.client.items.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import devopsdistilled.operp.client.context.AppContext;
import devopsdistilled.operp.client.items.models.BrandModel;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.client.items.models.ProductModel;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.server.data.entity.items.Brand;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.items.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppContext.class })
public class EditItemPaneControllerTest {

	@Inject
	private EditItemPaneController editItemPaneController;

	@Inject
	private ItemModel itemModel;

	@Inject
	private ProductModel productModel;

	@Inject
	private BrandModel brandModel;

	private Item item;
	private Product product;
	private Brand brand;
	private Object obj;

	@Before
	public void setUp() throws Exception {

		item = new Item();
		obj = new Object();
		product = new Product();
		brand = new Brand();

		assertNotNull(itemModel);
		assertNotNull(editItemPaneController);
	}

	@Test
	public void test() {
		assertNotNull(editItemPaneController);
	}

	//@Test
	public void testEditItem() {

		// This test doesn't work.
		// item.setItemId(20L);
		item.setItemName(obj.toString());
		item.setPrice(435.90);
		brand = brandModel.saveAndUpdateModel(brand);
		item.setBrand(brand);
		product = productModel.saveAndUpdateModel(product);
		item.setProduct(product);
		Item savedItem = itemModel.saveAndUpdateModel(item);
		item.setProduct(new Product());
		item.setItemName(new Object().toString());
		Item changedProductItem = itemModel.saveAndUpdateModel(item);

		assertThat(savedItem.getItemId(), is(changedProductItem.getItemId()));
	}

}
