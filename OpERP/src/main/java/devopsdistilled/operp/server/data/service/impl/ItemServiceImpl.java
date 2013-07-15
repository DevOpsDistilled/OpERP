package devopsdistilled.operp.server.data.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.repo.ItemRepository;
import devopsdistilled.operp.server.data.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	private static final long serialVersionUID = 7578267584162733059L;

	@Inject
	private ItemRepository itemRepository;

	@Override
	public Item createItem() {
		return null;
	}
}
