package devopsdistilled.operp.server.data.entity.party;

import javax.persistence.Entity;

import devopsdistilled.operp.server.data.entity.account.Payable;
import devopsdistilled.operp.server.data.entity.account.PayableAccount;

@Entity
public class Vendor extends Party<PayableAccount> implements Payable {

	private static final long serialVersionUID = 1438740246885453097L;

}
