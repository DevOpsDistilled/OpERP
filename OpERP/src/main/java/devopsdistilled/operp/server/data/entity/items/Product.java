package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = -3781064523477859914L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	private String productName;

	@OneToMany(mappedBy = "product")
	private List<Item> items;

	@ManyToMany
	private List<Category> categories;
}
