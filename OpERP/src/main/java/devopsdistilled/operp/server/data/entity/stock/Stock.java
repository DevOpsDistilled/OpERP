package devopsdistilled.operp.server.data.entity.stock;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = 6110051890442579005L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockId;
	private Long quantity;

	@OneToOne
	private Item item;
	
	@ManyToOne
	private Warehouse warehouse;
	
	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}
