package devopsdistilled.operp.server.data.entity;

import javax.persistence.Entity;

@Entity
public class Product {
	private Long productID;
	private String productName;
	private Category category;
}
