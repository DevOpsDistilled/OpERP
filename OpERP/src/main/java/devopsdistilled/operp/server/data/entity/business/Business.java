package devopsdistilled.operp.server.data.entity.business;

import java.util.Date;

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
	@OneToOne
	protected D businessDesc;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private Double amount = 0.0;

	@ManyToOne
	protected P party;

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
		return getBusinessDesc().getBusinessId();
	}

	@Override
	public String toString() {

		return new String(id() + ": " + getDate() + ": "
				+ getAmount().toString());
	}

}
