package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.Entity;
import javax.persistence.IdClass;

@Entity
@IdClass(PurchaseDescRowId.class)
public class PurchaseDescRow extends BusinessDescRow<PurchaseDesc> {

	private static final long serialVersionUID = -7576094559879111898L;

}
