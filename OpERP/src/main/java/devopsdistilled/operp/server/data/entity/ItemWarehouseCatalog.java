package devopsdistilled.operp.server.data.entity;

import javax.persistence.Entity;

@Entity
public class ItemWarehouseCatalog {
	private Long itemWarehouseCatalogId;
	private Item item;
	private Warehouse warehouse;
}
