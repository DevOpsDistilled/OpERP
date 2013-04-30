package devopsdistilled.operp.server.data.entity;

import javax.persistence.Entity;

@Entity
public class StockKeeper {
	private Item item;
	private Warehouse warehouse;
	private Long quantity;
}
