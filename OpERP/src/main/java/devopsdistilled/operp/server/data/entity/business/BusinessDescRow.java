package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.items.Item;
import devopsdistilled.operp.server.data.entity.stock.Warehouse;

@MappedSuperclass
public abstract class BusinessDescRow<D extends BusinessDesc<?, ?>> extends
		Entiti<Long> {

	private static final long serialVersionUID = 9140270277994676490L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long businessDescRowId;

	@ManyToOne
	@JoinColumn(name = "businessDescId")
	protected D businessDesc;

	@OneToOne
	@JoinColumn(name = "itemId")
	protected Item item;

	@OneToOne
	@JoinColumn(name = "warehouseId")
	protected Warehouse warehouse;

	private Double rate = 0.0;
	private Long quantity = 0L;
	private Double amount = 0.0;

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

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
		setAmount(getRate() * getQuantity());
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
		setAmount(getRate() * getQuantity());
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setBusinessDesc(D businessDesc) {
		this.businessDesc = businessDesc;
	}

	@Override
	public Long id() {
		return businessDescRowId;
	}

	@Override
	public String toString() {
		return new String(getQuantity().toString() + " "
				+ getItem().getItemName() + " at " + getRate().toString());
	}

}