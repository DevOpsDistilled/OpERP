package devopsdistilled.operp.server.data.entity.items;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class Product extends Entiti<Long> {

	private static final long serialVersionUID = -3781064523477859914L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	@Column(unique = true)
	private String productName;

	@OneToMany(mappedBy = "product")
	private List<Item> items;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "ProductCategory")
	private List<Category> categories;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return getProductName();
	}

	@Override
	public Long id() {
		return getProductId();
	}
}
