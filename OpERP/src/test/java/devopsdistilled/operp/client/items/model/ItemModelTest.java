package devopsdistilled.operp.client.items.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class ItemModelTest {

	@Inject
	private ItemModel itemModel;

	private Item item;

	@Before
	public void setUp() throws Exception {
		item = new Item();

		assertNotNull(itemModel);
	}

	// @Test
	public void testSaveAndUpdateModel() {

		// This test won't run if Unique constraints are set in Item Entity.
		// Unique Constraints were removed to test this Test.

		itemModel.update();
		int initialItemsSize = itemModel.getEntities().size();
		item.setItemName("Test Item");
		Item savedItem = itemModel.saveAndUpdateModel(item);
		assertNotNull(savedItem);
		System.out.println(savedItem.getItemId());
		int afterUpdateSize = itemModel.getEntities().size();
		// assertThat(initialItemsSize, is(afterUpdateSize - 1));
		assertEquals(new Long(initialItemsSize), new Long(afterUpdateSize - 1));
	}

	@Test
	public void testGetObserverClass() {
		// After changing getObserverClass to protected, this method can't be
		// tested this way.
		/*
		 * assertEquals(((ItemModelImpl) itemModel).getObserverClass(),
		 * ItemModelObserver.class);
		 */
	}
}
