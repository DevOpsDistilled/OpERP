package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescPane;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescRowPane;
import devopsdistilled.operp.client.business.purchases.panes.PurchasePane;
import devopsdistilled.operp.client.business.sales.panes.SaleDescPane;
import devopsdistilled.operp.client.business.sales.panes.SaleDescRowPane;
import devopsdistilled.operp.client.business.sales.panes.SalePane;

@Configuration
public class MvcViewContext {

	@Bean
	public SalePane salePane() {
		return new SalePane();
	}

	@Bean
	public SaleDescPane saleDescPane() {
		return new SaleDescPane();
	}

	@Bean
	public SaleDescRowPane saleDescRowPane() {
		return new SaleDescRowPane();
	}

	@Bean
	public PurchasePane purchasePane() {
		return new PurchasePane();
	}

	@Bean
	public PurchaseDescPane purchaseDescPane() {
		return new PurchaseDescPane();
	}

	@Bean
	public PurchaseDescRowPane purchaseDescRowPane() {
		return new PurchaseDescRowPane();
	}
}
