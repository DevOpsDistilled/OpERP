package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {
	@Id
	private Long itemId;
	private Product product;
	private Brand brand;
}
