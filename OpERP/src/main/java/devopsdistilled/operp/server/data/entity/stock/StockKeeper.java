package devopsdistilled.operp.server.data.entity.stock;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class StockKeeper implements Serializable {

	private static final long serialVersionUID = 7096369854036054036L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private StockKeeper stockKeeperId;
	private Long quantity;
	private Date date;

	@OneToOne
	private Stock stock;

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
