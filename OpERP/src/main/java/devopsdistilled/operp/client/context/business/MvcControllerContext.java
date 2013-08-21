package devopsdistilled.operp.client.context.business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.business.sales.panes.controllers.SalePaneController;
import devopsdistilled.operp.client.business.sales.panes.controllers.impl.SalePaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public SalePaneController salePaneController() {
		return new SalePaneControllerImpl();
	}
}