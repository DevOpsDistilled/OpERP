package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class Category extends Entiti implements Serializable {

	private static final long serialVersionUID = -3809686715120885998L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;

	@Column(unique = true)
	private String categoryName;

	@ManyToMany(mappedBy = "categories")
	private List<Product> products;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
