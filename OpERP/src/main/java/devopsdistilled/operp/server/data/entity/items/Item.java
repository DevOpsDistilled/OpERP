package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

}
