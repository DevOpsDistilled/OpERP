package devopsdistilled.operp.server.data.entity.business;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.party.Party;

@MappedSuperclass
public abstract class Business<P extends Party<?>, D extends BusinessDesc<?, ?>>
		extends Entiti<Long> {

	private static final long serialVersionUID = -7075903053081563240L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long businessId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private Double amount = 0.0;

	@ManyToOne
	protected P party;

	@OneToOne(mappedBy = "business")
	protected D businessDesc;

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public P getParty() {
		return party;
	}

	public void setParty(P party) {
		this.party = party;
	}

	public D getBusinessDesc() {
		return businessDesc;
	}

	public void setBusinessDesc(D businessDesc) {
		this.businessDesc = businessDesc;
	}

	@Override
	public Long id() {
		return getBusinessId();
	}

	@Override
	public String toString() {

		return new String(getBusinessId() + ": " + getDate() + ": "
				+ getAmount().toString());
	}

}
