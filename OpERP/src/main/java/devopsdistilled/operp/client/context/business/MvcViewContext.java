package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.sales.panes.SalePane;

@Configuration
public class MvcViewContext {

	@Bean
	public SalePane salePane() {
		return new SalePane();
	}
}
