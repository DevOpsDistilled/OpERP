package devopsdistilled.operp.server.data.entity.items;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "productId",
		"brandId" }))
public class Item extends Entiti<Long> {

	private static final long serialVersionUID = 1137602696634935018L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Column(unique = true)
	private String itemName;

	private Double price;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private Product product;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "brandId")
	private Brand brand;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	@Override
	public Long id() {
		return getItemId();
	}

	@Override
	public String toString() {
		return getItemName();
	}

}
