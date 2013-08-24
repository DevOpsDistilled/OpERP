package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.purchases.controllers.PurchaseController;
import devopsdistilled.operp.client.business.purchases.controllers.impl.PurchaseControllerImpl;
import devopsdistilled.operp.client.business.sales.controllers.SaleController;
import devopsdistilled.operp.client.business.sales.controllers.impl.SaleControllerImpl;

@Configuration
public class EntityControllerContext {

	@Bean
	public SaleController saleController() {
		return new SaleControllerImpl();
	}

	@Bean
	public PurchaseController purchaseController() {
		return new PurchaseControllerImpl();
	}
}
