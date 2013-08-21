package devopsdistilled.operp.server.data.entity.business;

import devopsdistilled.operp.server.data.entity.items.Item;

public class PurchaseDescRowId extends BusinessDescRowId<PurchaseDesc> {

	private static final long serialVersionUID = 5848330595492080342L;

	public PurchaseDescRowId() {
		super();
	}

	public PurchaseDescRowId(PurchaseDesc businessDesc, Item item) {
		super(businessDesc, item);
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof BusinessDescRowId)
				&& businessDesc.equals(((BusinessDescRowId<?>) o)
						.getBusinessDesc()) && item == ((BusinessDescRowId<?>) o)
					.getItem());
	}

	@Override
	public int hashCode() {
		return businessDesc.hashCode() + item.hashCode();
	}

}
