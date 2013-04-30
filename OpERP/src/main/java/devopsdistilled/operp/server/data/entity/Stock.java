package devopsdistilled.operp.server.data.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stock {
	@Id
	private Item item;
	private Long quantity;
	private BigDecimal unitPrice;
	private String unit;
}
