package devopsdistilled.operp.server.data.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Stock {
	private Item item;
	private Long quantity;
	private BigDecimal unitPrice;
	private String unit;
}
