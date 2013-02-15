package devopsdistilled.operp.server.service;

import devopsdistilled.operp.server.model.Item;

public interface ItemService extends GenericService<Item, Long> {
    public void create(String name);
}
