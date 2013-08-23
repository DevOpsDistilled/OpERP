package devopsdistilled.operp.client.business.sales.models.observers;

import java.util.List;

import devopsdistilled.operp.client.abstracts.EntityModelObserver;
import devopsdistilled.operp.server.data.entity.business.Sale;

public interface SaleModelObserver extends EntityModelObserver {

	public void updateSales(List<Sale> sales);

}
