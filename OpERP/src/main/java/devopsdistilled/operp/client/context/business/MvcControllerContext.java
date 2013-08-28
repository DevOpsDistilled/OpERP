package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.purchases.panes.controllers.ListPurchasePaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescPaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDescRowPaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchaseDetailsPaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.PurchasePaneController;
import devopsdistilled.operp.client.business.purchases.panes.controllers.impl.ListPurchasePaneControllerImpl;
import devopsdistilled.operp.client.business.purchases.panes.controllers.impl.PurchaseDescPaneControllerImpl;
import devopsdistilled.operp.client.business.purchases.panes.controllers.impl.PurchaseDescRowPaneControllerImpl;
import devopsdistilled.operp.client.business.purchases.panes.controllers.impl.PurchaseDetailsPaneControllerImpl;
import devopsdistilled.operp.client.business.purchases.panes.controllers.impl.PurchasePaneControllerImpl;
import devopsdistilled.operp.client.business.sales.panes.controllers.ListSalePaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDetailsPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.ListSalePaneControllerImpl;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SaleDescPaneControllerImpl;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SaleDescRowPaneControllerImpl;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SaleDetailsPaneControllerImpl;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SalePaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public SalePaneController salePaneController() {
		return new SalePaneControllerImpl();
	}

	@Bean
	public SaleDescPaneController saleDescPaneController() {
		return new SaleDescPaneControllerImpl();
	}

	@Bean
	public SaleDescRowPaneController saleDescRowPaneController() {
		return new SaleDescRowPaneControllerImpl();
	}

	@Bean
	public PurchasePaneController purchasePaneController() {
		return new PurchasePaneControllerImpl();
	}

	@Bean
	public PurchaseDescPaneController purchaseDescPaneController() {
		return new PurchaseDescPaneControllerImpl();
	}

	@Bean
	public PurchaseDescRowPaneController purchaseDescRowPaneController() {
		return new PurchaseDescRowPaneControllerImpl();
	}

	@Bean
	public SaleDetailsPaneController saleDetailsPaneController() {
		return new SaleDetailsPaneControllerImpl();
	}

	@Bean
	public PurchaseDetailsPaneController purchaseDetailsPaneController() {
		return new PurchaseDetailsPaneControllerImpl();
	}

	@Bean
	public ListSalePaneController listSalePaneController() {
		return new ListSalePaneControllerImpl();
	}

	@Bean
	public ListPurchasePaneController listPurchasePaneController() {
		return new ListPurchasePaneControllerImpl();
	}

}