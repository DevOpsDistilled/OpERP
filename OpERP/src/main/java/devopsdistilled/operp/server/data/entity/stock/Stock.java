package devopsdistilled.operp.server.data.entity.stock;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "itemId",
		"warehouseId" }))
public class Stock extends Entiti<Long> {

	private static final long serialVersionUID = -7397395555201558401L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;

	private Long quantity;

	@ManyToOne
	@JoinColumn(name = "itemId")
	private Item item;

	@ManyToOne
	@JoinColumn(name = "warehouseId")
	private Warehouse warehouse;

	@OneToMany(mappedBy = "stock")
	private List<StockKeeper> stockKeepers;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

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

	public List<StockKeeper> getStockKeepers() {
		return stockKeepers;
	}

	public void setStockKeepers(List<StockKeeper> stockKeepers) {
		this.stockKeepers = stockKeepers;
	}

	@Override
	public Long id() {
		return getStockId();
	}

	@Override
	public String toString() {
		return new String(getItem().getItemName() + " In "
				+ getWarehouse().getWarehouseName());
	}

}
