package devopsdistilled.operp.server.data.entity.account;

import javax.persistence.Entity;

@Entity
public class ReceivedTransaction extends Transaction<ReceivableAccount> {

	private static final long serialVersionUID = -9082401297374506703L;

}
