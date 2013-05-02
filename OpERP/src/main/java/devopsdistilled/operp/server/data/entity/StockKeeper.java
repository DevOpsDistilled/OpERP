package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StockKeeper implements Serializable {

	private static final long serialVersionUID = 7096369854036054036L;

	@Id
	@OneToOne
	private ItemWarehouseCatalog itemWarehouseCatalog;
	private Long quantity;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
