package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.items.Item;

@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = 6110051890442579005L;

	@Id
	@OneToOne
	private Item item;
	private Long quantity;
	private BigDecimal unitPrice;
	private String unit;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}
