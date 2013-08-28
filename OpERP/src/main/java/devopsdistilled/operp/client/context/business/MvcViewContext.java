package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.purchases.panes.ListPurchasePane;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescPane;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDescRowPane;
import devopsdistilled.operp.client.business.purchases.panes.PurchaseDetailsPane;
import devopsdistilled.operp.client.business.purchases.panes.PurchasePane;
import devopsdistilled.operp.client.business.sales.panes.ListSalePane;
import devopsdistilled.operp.client.business.sales.panes.SaleDescPane;
import devopsdistilled.operp.client.business.sales.panes.SaleDescRowPane;
import devopsdistilled.operp.client.business.sales.panes.SaleDetailsPane;
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

	@Bean
	public SaleDetailsPane saleDetailsPane() {
		return new SaleDetailsPane();
	}

	@Bean
	public PurchaseDetailsPane purchaseDetailsPane() {
		return new PurchaseDetailsPane();
	}

	@Bean
	public ListSalePane listSalePane() {
		return new ListSalePane();
	}

	@Bean
	public ListPurchasePane listPurchasePane() {
		return new ListPurchasePane();
	}

}
