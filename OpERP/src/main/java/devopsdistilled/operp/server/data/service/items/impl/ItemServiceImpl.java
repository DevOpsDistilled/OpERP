package devopsdistilled.operp.server.data.service.items.impl;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.repo.items.ItemRepository;
import devopsdistilled.operp.server.data.service.impl.AbstractEntityService;
import devopsdistilled.operp.server.data.service.items.ItemService;

@Service
public class ItemServiceImpl extends AbstractEntityService<Item, Long>
		implements ItemService {

	private static final long serialVersionUID = 7578267584162733059L;

	@Inject
	private ItemRepository itemRepository;

	@Override
	protected JpaRepository<Item, Long> getRepo() {
		return itemRepository;
	}

	@Override
	public boolean isProductBrandPairExists(String productName, String brandName) {
		return false;
	}

	@Override
	public boolean isItemNameExists(String itemName) {
		return false;
	}

}
