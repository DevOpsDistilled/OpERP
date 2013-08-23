package devopsdistilled.operp.server.data.entity.business;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public abstract class BusinessDesc<B extends Business<?, ?>, DR extends BusinessDescRow<?>>
		extends Entiti<Long> {

	private static final long serialVersionUID = 7790361115068372068L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long businessDescId;

	@OneToOne(mappedBy = "businessDesc")
	protected B business;

	@OneToMany(mappedBy = "businessDesc", cascade = CascadeType.ALL)
	protected List<DR> descRows = new LinkedList<>();

	private Double discountAmount;

	private Double TotalAmount;

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		TotalAmount = totalAmount;
	}

	public List<DR> getDescRows() {
		return descRows;
	}

	public void setDescRows(List<DR> descRows) {
		this.descRows = descRows;
	}

	@Override
	public Long id() {
		return businessDescId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
