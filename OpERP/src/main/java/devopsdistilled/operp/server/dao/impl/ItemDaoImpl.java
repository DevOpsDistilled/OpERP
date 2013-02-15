package devopsdistilled.operp.server.dao.impl;

import org.springframework.stereotype.Repository;

import devopsdistilled.operp.server.dao.ItemDao;
import devopsdistilled.operp.server.model.Item;

@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item, Long> implements ItemDao {

    @Override
    protected Class<Item> getEntityClass() {
	return Item.class;
    }

}
