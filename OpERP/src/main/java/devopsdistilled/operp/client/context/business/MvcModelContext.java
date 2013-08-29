package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.purchases.panes.models.ListPurchasePaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDescRowPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchaseDetailsPaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.PurchasePaneModel;
import devopsdistilled.operp.client.business.purchases.panes.models.impl.ListPurchasePaneModelImpl;
import devopsdistilled.operp.client.business.purchases.panes.models.impl.PurchaseDescPaneModelImpl;
import devopsdistilled.operp.client.business.purchases.panes.models.impl.PurchaseDescRowPaneModelImpl;
import devopsdistilled.operp.client.business.purchases.panes.models.impl.PurchaseDetailsPaneModelImpl;
import devopsdistilled.operp.client.business.purchases.panes.models.impl.PurchasePaneModelImpl;
import devopsdistilled.operp.client.business.sales.panes.models.ListSalePaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescRowPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDetailsPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SalePaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.impl.ListSalePaneModelImpl;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SaleDescPaneModelImpl;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SaleDescRowPaneModelImpl;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SaleDetailsPaneModelImpl;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SalePaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public SalePaneModel salePaneModel() {
		return new SalePaneModelImpl();
	}

	@Bean
	public SaleDescPaneModel saleDescPaneModel() {
		return new SaleDescPaneModelImpl();
	}

	@Bean
	public SaleDescRowPaneModel saleDescRowPaneModel() {
		return new SaleDescRowPaneModelImpl();
	}

	@Bean
	public PurchasePaneModel purchasePaneModel() {
		return new PurchasePaneModelImpl();
	}

	@Bean
	public PurchaseDescPaneModel purchaseDescPaneModel() {
		return new PurchaseDescPaneModelImpl();
	}

	@Bean
	public PurchaseDescRowPaneModel purchaseDescRowPaneModel() {
		return new PurchaseDescRowPaneModelImpl();
	}

	@Bean
	public SaleDetailsPaneModel saleDetailsPaneModel() {
		return new SaleDetailsPaneModelImpl();
	}

	@Bean
	public PurchaseDetailsPaneModel purchaseDetailsPaneModel() {
		return new PurchaseDetailsPaneModelImpl();
	}

	@Bean
	public ListSalePaneModel listSalePaneModel() {
		return new ListSalePaneModelImpl();
	}

	@Bean
	public ListPurchasePaneModel listPurchasePaneModel() {
		return new ListPurchasePaneModelImpl();
	}
}
