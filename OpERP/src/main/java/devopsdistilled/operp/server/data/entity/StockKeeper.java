package devopsdistilled.operp.server.data.entity;

import javax.persistence.Entity;

@Entity
public class StockKeeper {

	private ItemWarehouseCatalog itemWarehouseCatalog;
	private Long quantity;
}
