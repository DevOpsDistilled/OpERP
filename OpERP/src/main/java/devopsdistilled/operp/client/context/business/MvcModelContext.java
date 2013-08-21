package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.sales.panes.models.SalePaneModel;
import devopsdistilled.operp.client.business.sales.panes.models.impl.SalePaneModelImpl;

@Configuration
public class MvcModelContext {

	@Bean
	public SalePaneModel salePaneModel() {
		return new SalePaneModelImpl();
	}
}
