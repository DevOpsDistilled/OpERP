package devopsdistilled.operp.server.data.entity.business;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public abstract class BusinessDesc extends Entiti<Long> {

	private static final long serialVersionUID = 7790361115068372068L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long descId;

	@OneToMany
	private final List<BusinessDescRow> descRows = new LinkedList<>();

	public List<BusinessDescRow> getDescRows() {
		return descRows;
	}

	private Double discountAmount;

	private Double TotalAmount;

	public Long getDescId() {
		return descId;
	}

	public void setDescId(Long descId) {
		this.descId = descId;
	}

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

	@Override
	public Long id() {
		return getDescId();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
