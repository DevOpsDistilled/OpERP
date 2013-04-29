package devopsdistilled.operp.server.data.repo;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppContext.class)
@Transactional
public class ItemRepositoryTest {

	@Inject
	private ItemRepository itemRepository;
	private Item item;

	@Before
	public void setUp() throws Exception {
		item = new Item();
		item.setName("Test Item");
	}

	@Test
	public void testSave() {
		item = itemRepository.save(item);
		Assert.assertEquals(item, itemRepository.findOne(item.getId()));
	}

}
