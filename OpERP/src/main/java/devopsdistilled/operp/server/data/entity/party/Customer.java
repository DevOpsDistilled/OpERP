package devopsdistilled.operp.server.data.entity.party;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import devopsdistilled.operp.server.data.entity.account.Receivable;
import devopsdistilled.operp.server.data.entity.account.ReceivableAccount;
import devopsdistilled.operp.server.data.entity.business.Sale;

@Entity
public class Customer extends Party<ReceivableAccount> implements Receivable {

	private static final long serialVersionUID = 1504040341006393665L;

	@OneToMany(mappedBy = "party")
	private List<Sale> sales;

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

}
