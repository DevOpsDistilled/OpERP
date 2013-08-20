package devopsdistilled.operp.server.data.entity.party;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.account.Receivable;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;
import devopsdistilled.operp.server.data.entity.business.Sale;

@Entity
public class Customer extends Party implements Receivable {

	private static final long serialVersionUID = 1504040341006393665L;

	@OneToOne(cascade = CascadeType.ALL)
	private ReceivableAccount account;

	@OneToMany(mappedBy = "party")
	private List<Sale> sales;

	public ReceivableAccount getAccount() {
		return account;
	}

	public void setAccount(ReceivableAccount account) {
		this.account = account;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

}
