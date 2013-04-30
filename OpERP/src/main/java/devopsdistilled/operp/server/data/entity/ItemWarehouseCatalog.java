package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemWarehouseCatalog implements Serializable {
	
	@Id
	private Long itemWarehouseCatalogId;
	private Item item;
	private Warehouse warehouse;
}
