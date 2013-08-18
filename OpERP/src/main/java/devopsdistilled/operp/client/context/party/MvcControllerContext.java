package devopsdistilled.operp.client.context.party;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.party.panes.controllers.ListVendorPaneController;
import devopsdistilled.operp.client.party.panes.controllers.VendorPaneController;
import devopsdistilled.operp.client.party.panes.controllers.impl.ListVendorPaneControllerImpl;
import devopsdistilled.operp.client.party.panes.controllers.impl.VendorPaneControllerImpl;

@Configuration
public class MvcControllerContext {

	@Bean
	public VendorPaneController vendorPaneController() {
		return new VendorPaneControllerImpl();
	}

	@Bean
	public ListVendorPaneController listVendorPaneController() {
		return new ListVendorPaneControllerImpl();
	}
}