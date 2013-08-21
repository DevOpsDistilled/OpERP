package devopsdistilled.operp.server.data.entity.business;

import java.util.LinkedList;
import java.util.List;

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
	protected Long businessId;

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	@OneToOne(mappedBy = "businessDesc")
	protected B business;

	@OneToMany(mappedBy = "businessDesc")
	protected final List<DR> descRows = new LinkedList<>();

	public List<DR> getDescRows() {
		return descRows;
	}

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

	public B getBusiness() {
		return business;
	}

	public void setBusiness(B business) {
		this.business = business;
	}

	@Override
	public Long id() {
		return getBusinessId();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
