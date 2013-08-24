package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.sales.panes.models.SaleDescPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SaleDescRowPaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.SalePaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SaleDescPaneModelImpl;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SaleDescRowPaneModelImpl;
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
}
