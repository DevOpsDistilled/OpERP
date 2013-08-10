package devopsdistilled.operp.server.data.entity.stock;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
public class Stock extends Entiti<Long> {

	private static final long serialVersionUID = 6110042579005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;
	private Long quantity;
	private Date date;

	@ManyToOne
	// (cascade=CascadeType.ALL)
	@JoinColumn(name = "itemId")
	private Item item;

	@ManyToOne
	// (cascade=CascadeType.ALL)
	@JoinColumn(name = "warehouseId")
	private Warehouse warehouse;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Long id() {
		return stockId;
	}

	@Override
	public String toString() {
		return new String(getQuantity().toString() + " " + getItem() + " -> "
				+ getWarehouse());
	}

}
