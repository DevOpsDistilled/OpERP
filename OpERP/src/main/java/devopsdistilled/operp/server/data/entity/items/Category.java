package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = -3809686715120885998L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;

	@ManyToMany(mappedBy = "categories")
	private List<Product> products;
}
