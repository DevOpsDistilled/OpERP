package devopsdistilled.operp.client.items.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import devopsdistilled.operp.client.context.AppContext;
import devopsdistilled.operp.client.items.models.ItemModel;
import devopsdistilled.operp.server.data.entity.items.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppContext.class })
public class ItemControllerTest {

	@Inject
	private ItemController itemController;

	@Inject
	private ItemModel itemModel;

	private Item item;

	@Before
	public void setUp() throws Exception {

		item = new Item();

		assertNotNull(itemModel);
		assertNotNull(itemController);
	}

	@Test
	public void testDeleteItem() {
		/*
		 * For this test to run, Unique constraints in Item Entity should be
		 * removed.
		 */

		item = itemModel.saveAndUpdateModel(item); // this works fine; Tested

		int beforeDeleteCount = itemModel.getEntities().size();
		itemController.delete(item);
		int afterDeleteCount = itemModel.getEntities().size();
		assertThat(beforeDeleteCount, is(afterDeleteCount + 1));

		Item returnedItem = itemModel.getService().findOne(item.getItemId());
		assertNull(returnedItem);

	}
}
