package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
public class BusinessDescRow extends Entiti<Long> {

	private static final long serialVersionUID = 9140270277994676490L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long descRowId;

	@OneToOne
	private Item item;
	private Double rate;
	private Long quantity;
	private Double amount;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public Long id() {
		return descRowId;
	}

	@Override
	public String toString() {
		return new String(getQuantity().toString() + " "
				+ getItem().getItemName() + " at " + getRate().toString());
	}
}
