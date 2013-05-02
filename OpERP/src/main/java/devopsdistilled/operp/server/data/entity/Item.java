package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1137602696634935018L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@ManyToOne
	private Product product;

	@ManyToOne
	private Brand brand;

	@OneToOne(mappedBy = "item")
	private Stock stock;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
