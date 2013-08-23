package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.purchases.models.PurchaseModel;
import devopsdistilled.operp.client.business.purchases.models.impl.PurchaseModelImpl;
import devopsdistilled.operp.client.business.sales.models.SaleModel;
import devopsdistilled.operp.client.business.sales.models.impl.SaleModelImpl;

@Configuration
public class EntityModelContext {

	@Bean
	public SaleModel saleModel() {
		return new SaleModelImpl();
	}

	@Bean
	public PurchaseModel purchaseModel() {
		return new PurchaseModelImpl();
	}
}
