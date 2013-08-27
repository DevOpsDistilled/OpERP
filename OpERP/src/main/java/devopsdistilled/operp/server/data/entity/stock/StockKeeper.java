package devopsdistilled.operp.server.data.entity.stock;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
public class StockKeeper extends Entiti<Long> {

	private static final long serialVersionUID = 6110042579005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockKeeperId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stockUpdateDate;

	@ManyToOne
	private Stock stock;

	private Long quantity;

	private String note;

	@OneToOne
	@JoinColumn(name = "transferStockKeeperId")
	private StockKeeper transferStockKeeper;

	public Long getStockKeeperId() {
		return stockKeeperId;
	}

	public void setStockKeeperId(Long stockKeeperId) {
		this.stockKeeperId = stockKeeperId;
	}

	public Date getStockUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(Date stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public StockKeeper getTransferStockKeeper() {
		return transferStockKeeper;
	}

	public void setTransferStockKeeper(StockKeeper transferStockKeeper) {
		this.transferStockKeeper = transferStockKeeper;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Item getItem() {
		return getStock().getItem();
	}

	public Warehouse getWarehouse() {
		return getStock().getWarehouse();
	}

	@Override
	public Long id() {
		return getStockKeeperId();
	}

	@Override
	public String toString() {
		return new String(getQuantity() + " " + getStock().toString());
	}

}
