package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SaleDescRowPaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SaleDescPaneControllerImpl;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SaleDescRowPaneControllerImpl;
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
}