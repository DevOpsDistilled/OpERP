package devopsdistilled.operp.server.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;

@Repository("ItemService")
public class ItemServiceImpl implements ItemService {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Item createItem(String name) {
	Item item = new Item();
	item.setId(34);
	item.setName("Test Item");
	em.persist(item);
	return item;
    }

}
