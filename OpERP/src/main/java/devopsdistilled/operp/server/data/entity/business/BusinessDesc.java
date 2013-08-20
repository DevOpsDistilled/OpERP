package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public abstract class BusinessDesc extends Entiti<Long> {

	private static final long serialVersionUID = 7790361115068372068L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long descId;

	private Double discountAmount;

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
