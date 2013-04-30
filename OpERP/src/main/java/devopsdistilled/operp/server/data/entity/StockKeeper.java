package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockKeeper implements Serializable{
	@Id
	private ItemWarehouseCatalog itemWarehouseCatalog;
	private Long quantity;
}
