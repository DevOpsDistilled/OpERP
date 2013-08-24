package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
