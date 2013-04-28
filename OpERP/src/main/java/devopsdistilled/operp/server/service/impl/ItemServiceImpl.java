package devopsdistilled.operp.server.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;

@Repository("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Item createItem(String name) {
	Item item = new Item();
	item.setName(name);
	em.persist(item);
	return item;
    }

}
