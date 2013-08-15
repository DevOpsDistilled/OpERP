package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.panes.controllers.CreateVendorPaneController;
import devopsdistilled.operp.client.party.panes.controllers.impl.CreateVendorPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public CreateVendorPaneController createVendorPaneController() {
		return new CreateVendorPaneControllerImpl();
	}
}