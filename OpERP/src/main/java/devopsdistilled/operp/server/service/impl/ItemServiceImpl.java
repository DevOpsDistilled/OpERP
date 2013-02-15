package devopsdistilled.operp.server.service.impl;

import org.springframework.stereotype.Service;

import devopsdistilled.operp.server.dao.GenericDao;
import devopsdistilled.operp.server.dao.ItemDao;
import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item, Long> implements
	ItemService {

    private ItemDao dao;

    public void setDao(ItemDao dao) {
	this.dao = dao;
    }

    @Override
    protected GenericDao<Item, Long> getDao() {
	return dao;
    }

    @Override
    public void create(String name) {
	Item item = new Item();
	item.setName(name);
	getDao().save(item);
    }

}
